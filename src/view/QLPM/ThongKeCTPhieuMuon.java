/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.QLPM;

import dao.DAO;
import javax.swing.table.DefaultTableModel;
import view.TKPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThongKeCTPhieuMuon extends javax.swing.JFrame {

    public ThongKeCTPhieuMuon(TKPanel root, String maPM, boolean isQuaHan) {
        initComponents();
        setLocationRelativeTo(null);
        this.root = root;
        this.maPM = maPM;
        this.quaHan = isQuaHan;
        try {
            initTable();
            setLabels();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(root, "Lỗi lấy thông tin");
        }
    }

    public void initTable() throws SQLException {
        DefaultTableModel tbModel = (DefaultTableModel) jtbCTPhieuMuon.getModel();
        tbModel.setRowCount(0);
        String sql = "Exec sp_GetCTPhieuMuon '" + maPM + "'";

        ResultSet rs = DAO.executeSelectSp(sql);
        while (rs.next()) {
            tbModel.addRow(new Object[]{rs.getString("MATB"),
                rs.getString("TENTB"),
                rs.getString("MSSV"),
                rs.getString("TENSV"),
                rs.getString("SDT"),
                (rs.getInt("TRANGTHAI") == 6 ? (quaHan ? "Quá hạn" : "Đang mượn") : "Đã trả")});
        }

    }

    public void setLabels() throws SQLException {
        String sql = "Select NHANVIEN.MANV, NHANVIEN.TEN, MAPHONG, THOIDIEMLAP, HAN "
                + "From PHIEUMUON inner join NHANVIEN on PHIEUMUON.MANV = NHANVIEN.MANV "
                + "Where MAPM = '" + maPM + "'";
        ResultSet rs = DAO.executeSelectSp(sql);
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm dd-MM-yyyy");
        if (rs.next()) {
            jlbMaPM.setText(maPM);
            jlbPhong.setText(rs.getString("MAPHONG"));
            jlbMaNV.setText(rs.getString("MANV"));
            jlbTenNV.setText(rs.getString("TEN"));
            jlbNgayLap.setText(fmt.format(rs.getTimestamp("THOIDIEMLAP")));
            jlbHanTra.setText(fmt.format(rs.getTimestamp("HAN")));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCTPhieuMuon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlbPhong = new javax.swing.JLabel();
        jlbMaNV = new javax.swing.JLabel();
        jlbTenNV = new javax.swing.JLabel();
        jlbNgayLap = new javax.swing.JLabel();
        jlbHanTra = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbMaPM = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin phiếu mượn");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jtbCTPhieuMuon.setAutoCreateRowSorter(true);
        jtbCTPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thiết bị", "Tên thiết bị", "MSSV", "Tên sinh viên", "SĐT", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCTPhieuMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtbCTPhieuMuon.setRowHeight(30);
        jScrollPane1.setViewportView(jtbCTPhieuMuon);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Phòng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Mã nhân viên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Lập:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Hạn:");

        jlbPhong.setText("Mã phòng");

        jlbMaNV.setText("MãNV");

        jlbTenNV.setText("TenNV");

        jlbNgayLap.setText("NgayLap");

        jlbHanTra.setText("HanTra");

        jPanel2.setBackground(new java.awt.Color(102, 255, 204));

        jlbMaPM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbMaPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbMaPM.setText("MAPM");
        jlbMaPM.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaPM, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbMaPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbPhong)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTenNV)
                    .addComponent(jlbMaNV))
                .addGap(158, 158, 158)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbHanTra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbNgayLap)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jlbPhong)
                    .addComponent(jlbMaNV)
                    .addComponent(jlbNgayLap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jlbTenNV)
                    .addComponent(jlbHanTra))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private TKPanel root;
    private String maPM;
    private boolean quaHan;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbHanTra;
    private javax.swing.JLabel jlbMaNV;
    private javax.swing.JLabel jlbMaPM;
    private javax.swing.JLabel jlbNgayLap;
    private javax.swing.JLabel jlbPhong;
    private javax.swing.JLabel jlbTenNV;
    private javax.swing.JTable jtbCTPhieuMuon;
    // End of variables declaration//GEN-END:variables
}