package view;

import dao.DAO;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.QLPM.ThongKeCTPhieuMuon;

public class TKPanel extends javax.swing.JPanel {
    private int quyen;
    public TKPanel(int quyen) {
        initComponents();
        this.quyen = quyen;
        refresh();
    }

    public void refresh() {
        Calendar cal = Calendar.getInstance();
        jdcEnd.setDate(cal.getTime());
        cal.add(Calendar.YEAR, -1);
        jdcStart.setDate(cal.getTime());
        jtfTimKiem.setText("");
        jcbDangMuon.setSelected(true);
        jcbDaTra.setSelected(true);
        jcbQuaHan.setSelected(true);
        filterRows();
    }

    public void tableInit(String dateStart, String dateEnd) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            String sql = "Exec sp_GetPHIEUMUON '" + dateStart + "', '" + dateEnd + "'";

            ResultSet rs = DAO.executeSelectSp(sql);

            DefaultTableModel tbModel = (DefaultTableModel) jtbPhieuMuon.getModel();
            tbModel.setRowCount(0);

            while (rs.next()) {
                boolean isOutOfDate = isQuaHan(rs.getTimestamp("HAN"));
                tbModel.addRow(new Object[]{rs.getString("MAPM"),
                    rs.getString("MAPHONG"),
                    getThietBiMuon(rs.getString("MAPM")),
                    rs.getString("TEN"),
                    fmt.format(rs.getTimestamp("THOIDIEMLAP")),
                    fmt.format(rs.getTimestamp("HAN")),
                    (rs.getInt("TRANGTHAI") == 6 ? (isOutOfDate ? "Quá hạn" : "Đang mượn") : "Đã trả")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public boolean isQuaHan(Timestamp han) {
        Date today = new Date();
        Timestamp currentTime = new Timestamp(today.getTime());
        return (currentTime.compareTo(han) > 0);
    }

    public void setTrangThaiCheck() {
        trangThaiCheck = "";
        if (jcbDangMuon.isSelected()) {
            trangThaiCheck += "Đang mượn";
        }
        if (jcbDaTra.isSelected()) {
            trangThaiCheck += "Đã trả";
        }
        if (jcbQuaHan.isSelected()) {
            trangThaiCheck += "Quá hạn";
        }
    }

    public String getThietBiMuon(String mapm) throws SQLException {
        String s = "";
        String sql = "Select DISTINCT THIETBI.MATB, TENLOAI "
                + "FROM CTPHIEUMUON inner join THIETBI on CTPHIEUMUON.MATB = THIETBI.MATB "
                + "inner join LOAITHIETBI on THIETBI.MALOAI = LOAITHIETBI.MALOAI "
                + "Where MAPM = '" + mapm + "'";
        Map<String, Integer> ct_thietBi = new HashMap<>();
        ResultSet rs = DAO.executeSelectSp(sql);
        while (rs.next()) {
            if (!ct_thietBi.containsKey(rs.getString("TENLOAI"))) {
                ct_thietBi.put(rs.getString("TENLOAI"), 1);
            } else {
                int val = ct_thietBi.get(rs.getString("TENLOAI")) + 1;
                ct_thietBi.put(rs.getString("TENLOAI"), val);
            }
        }
        int count = 0;
        for (String x : ct_thietBi.keySet()) {
            s += (count != 0 ? ", " : "") + ct_thietBi.get(x) + " " + x;
            count++;
        }
        return s;
    }

    public void filterRows() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStart = formatter.format(jdcStart.getDate()) + " 00:00";
        String dateEnd = formatter.format(jdcEnd.getDate()) + " 23:59";
        tableInit(dateStart, dateEnd);
        DefaultTableModel model = (DefaultTableModel) jtbPhieuMuon.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            boolean shouldRemove = true;

            if (trangThaiCheck.contains(model.getValueAt(i, 6).toString())) {
                for (int j = 0; j < 3; j++) {
                    String value = model.getValueAt(i, j).toString();

                    if (value.contains(jtfTimKiem.getText())) {
                        shouldRemove = false;
                        break;
                    }
                }
            }

            if (shouldRemove) {
                model.removeRow(i);
            }
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnHeader = new javax.swing.JPanel();
        jLabel1_timkiem = new javax.swing.JLabel();
        jtfTimKiem = new javax.swing.JTextField();
        jdcStart = new com.toedter.calendar.JDateChooser();
        jdcEnd = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jcbDangMuon = new javax.swing.JCheckBox();
        jcbDaTra = new javax.swing.JCheckBox();
        jcbQuaHan = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPhieuMuon = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 102));

        jpnHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1_timkiem.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1_timkiem.setText("Tìm kiếm");

        jtfTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTimKiemFocusLost(evt);
            }
        });
        jtfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTimKiemKeyReleased(evt);
            }
        });

        jdcStart.setDateFormatString("dd - MM - yyyy");
        jdcStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcStartPropertyChange(evt);
            }
        });

        jdcEnd.setDateFormatString("dd - MM - yyyy");
        jdcEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcEndPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("đến");

        jcbDangMuon.setSelected(true);
        jcbDangMuon.setText("Đang mượn");
        jcbDangMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDangMuonMouseClicked(evt);
            }
        });

        jcbDaTra.setSelected(true);
        jcbDaTra.setText("Đã trả");
        jcbDaTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDaTraMouseClicked(evt);
            }
        });

        jcbQuaHan.setSelected(true);
        jcbQuaHan.setText("Quá hạn");
        jcbQuaHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbQuaHanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnHeaderLayout = new javax.swing.GroupLayout(jpnHeader);
        jpnHeader.setLayout(jpnHeaderLayout);
        jpnHeaderLayout.setHorizontalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHeaderLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jdcStart, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(jdcEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jcbDangMuon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDaTra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbQuaHan)
                .addGap(95, 95, 95)
                .addGroup(jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1_timkiem)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );
        jpnHeaderLayout.setVerticalGroup(
            jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1_timkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbDangMuon)
                        .addComponent(jcbDaTra)
                        .addComponent(jcbQuaHan))
                    .addGroup(jpnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jdcStart, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jdcEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jtbPhieuMuon.setAutoCreateRowSorter(true);
        jtbPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Phiếu mượn", "Phòng", "Thiết bị", "Nhân viên", "Thời điểm lập", "Hạn trả", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbPhieuMuon.setRowHeight(30);
        jtbPhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbPhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbPhieuMuon);
        if (jtbPhieuMuon.getColumnModel().getColumnCount() > 0) {
            jtbPhieuMuon.getColumnModel().getColumn(0).setPreferredWidth(60);
            jtbPhieuMuon.getColumnModel().getColumn(1).setPreferredWidth(50);
            jtbPhieuMuon.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jdcStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcStartPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            filterRows();
        }
    }//GEN-LAST:event_jdcStartPropertyChange

    private void jtfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimKiemKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            filterRows();
        }
    }//GEN-LAST:event_jtfTimKiemKeyReleased

    private void jtfTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTimKiemFocusLost
        filterRows();
    }//GEN-LAST:event_jtfTimKiemFocusLost

    private void jcbDangMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDangMuonMouseClicked
        setTrangThaiCheck();
        filterRows();
    }//GEN-LAST:event_jcbDangMuonMouseClicked

    private void jcbDaTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDaTraMouseClicked
        setTrangThaiCheck();
        filterRows();
    }//GEN-LAST:event_jcbDaTraMouseClicked

    private void jcbQuaHanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbQuaHanMouseClicked
        setTrangThaiCheck();
        filterRows();
    }//GEN-LAST:event_jcbQuaHanMouseClicked

    private void jdcEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcEndPropertyChange
        if ("date".equals(evt.getPropertyName())) {
            filterRows();
        }
    }//GEN-LAST:event_jdcEndPropertyChange

    private void jtbPhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbPhieuMuonMouseClicked
        if(evt.getClickCount() == 2 && jtbPhieuMuon.getSelectedRow() != -1){
            int index = jtbPhieuMuon.getSelectedRow();
            new ThongKeCTPhieuMuon(this,jtbPhieuMuon.getValueAt(index, 0).toString(), jtbPhieuMuon.getValueAt(index, 6).toString()).setVisible(true);
        }
    }//GEN-LAST:event_jtbPhieuMuonMouseClicked

    private String trangThaiCheck = "Đang mượn Đã trả Quá hạn";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_timkiem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbDaTra;
    private javax.swing.JCheckBox jcbDangMuon;
    private javax.swing.JCheckBox jcbQuaHan;
    private com.toedter.calendar.JDateChooser jdcEnd;
    private com.toedter.calendar.JDateChooser jdcStart;
    private javax.swing.JPanel jpnHeader;
    private javax.swing.JTable jtbPhieuMuon;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables
    public int getQuyen(){
        return this.quyen;
    }
}
