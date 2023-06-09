package view;

import controller.QLTBController;
import java.util.ArrayList;
import model.ThietBi;
import dao.ThietBiDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TBPanel extends javax.swing.JPanel {

    private NhanVienPanel pr;
    private ArrayList<String> dsCheckLoai;
    private ArrayList<String> dsCheckTrangThai;

    public TBPanel(NhanVienPanel parent) {
        initComponents();
        this.pr = parent;
        refresh();
        setDsCheckLoai();
        setDsCheckTrangThai();
        QLTBController ctrl = new QLTBController(this);
    }

    public void refresh() {
        try {
            Thread t = new Thread(() -> {
                DefaultTableModel tbModel = (DefaultTableModel) jtbThietBi.getModel();
                tbModel.setRowCount(0);
                for (ThietBi x1 : new ThietBiDAO().getAll()) {
                    tbModel.addRow(new Object[]{x1.getMa(), x1.getTen(), x1.getTenLoai(), x1.getPhong(), x1.getTenTrangThai()});
                }
            });

            t.start();

            jcbRemote.setSelected(true);
            jcbMicro.setSelected(true);
            jcbHDMI.setSelected(true);
            jcbDayMicro.setSelected(true);
            jcbDayTypeC.setSelected(true);
            jcbChiaKhoa.setSelected(true);
            jcbTatCa.setSelected(true);
            setDsCheckLoai();

            jcbSanSang.setSelected(true);
            jcbDangMuon.setSelected(true);
            jcbHong.setSelected(true);
            setDsCheckTrangThai();

            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TBPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDsCheckLoai() {
        dsCheckLoai = new ArrayList<>();
        if (jcbRemote.isSelected()) {
            dsCheckLoai.add(jcbRemote.getText());
        }
        if (jcbMicro.isSelected()) {
            dsCheckLoai.add(jcbMicro.getText());
        }
        if (jcbHDMI.isSelected()) {
            dsCheckLoai.add(jcbHDMI.getText());
        }
        if (jcbDayMicro.isSelected()) {
            dsCheckLoai.add(jcbDayMicro.getText());
        }
        if (jcbDayTypeC.isSelected()) {
            dsCheckLoai.add(jcbDayTypeC.getText());
        }
        if (jcbChiaKhoa.isSelected()) {
            dsCheckLoai.add(jcbChiaKhoa.getText());
        }
    }

    public void setDsCheckTrangThai() {
        dsCheckTrangThai = new ArrayList<>();
        if (jcbSanSang.isSelected()) {
            dsCheckTrangThai.add(jcbSanSang.getText());
        }
        if (jcbDangMuon.isSelected()) {
            dsCheckTrangThai.add(jcbDangMuon.getText());
        }
        if (jcbHong.isSelected()) {
            dsCheckTrangThai.add(jcbHong.getText());
        }
    }

    public void timKiem() {
        DefaultTableModel tbModel = (DefaultTableModel) jtbThietBi.getModel();
        tbModel.setRowCount(0);
        ArrayList<ThietBi> result = new ArrayList<>();
        // Lọc phòng, loại và trạng thái
        String phong = jtfTimPhong.getText().toUpperCase().trim();
        for (ThietBi x1 : new ThietBiDAO().getAll()) {
            if (phong.length() != 0) {
                if (x1.getPhong() != null && !x1.getPhong().contains(phong)) {
                    continue;
                }
            }
            if (!dsCheckLoai.isEmpty() && checkLoc(x1)) {
                result.add(x1);
            }
        }
        // Lọc tên
        String s = jtfTimTen.getText().toLowerCase();
        if (s.length() == 0) {
            for (ThietBi x2 : result) {
                tbModel.addRow(new Object[]{x2.getMa(), x2.getTen(), x2.getTenLoai(), x2.getPhong(), x2.getTenTrangThai()});
            }
        } else {
            for (ThietBi x3 : result) {
                if (x3.getTen().toLowerCase().contains(s)) {
                    tbModel.addRow(new Object[]{x3.getMa(), x3.getTen(), x3.getTenLoai(), x3.getPhong(), x3.getTenTrangThai()});
                }
            }
        }
    }

    public boolean checkLoc(ThietBi x) {
        boolean matchLoai;
        boolean matchTrangThai;
        matchLoai = dsCheckLoai.contains(x.getTenLoai());
        matchTrangThai = dsCheckTrangThai.contains(x.getTenTrangThai());
        return matchLoai && matchTrangThai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbThietBi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jtfTimTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jcbHDMI = new javax.swing.JCheckBox();
        jcbDayTypeC = new javax.swing.JCheckBox();
        jcbMicro = new javax.swing.JCheckBox();
        jcbDayMicro = new javax.swing.JCheckBox();
        jcbChiaKhoa = new javax.swing.JCheckBox();
        jcbRemote = new javax.swing.JCheckBox();
        jcbTatCa = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jcbSanSang = new javax.swing.JCheckBox();
        jcbHong = new javax.swing.JCheckBox();
        jcbDangMuon = new javax.swing.JCheckBox();
        jpnTim = new javax.swing.JPanel();
        jlbTim = new javax.swing.JLabel();
        jpnThem = new javax.swing.JPanel();
        jlbThem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTimPhong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jtbThietBi.setAutoCreateRowSorter(true);
        jtbThietBi.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jtbThietBi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Loại", "Phòng", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbThietBi.setToolTipText("");
        jtbThietBi.setAlignmentX(2.0F);
        jtbThietBi.setGridColor(new java.awt.Color(255, 255, 255));
        jtbThietBi.setRowHeight(30);
        jtbThietBi.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jtbThietBi.setShowGrid(false);
        jtbThietBi.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(jtbThietBi);
        if (jtbThietBi.getColumnModel().getColumnCount() > 0) {
            jtbThietBi.getColumnModel().getColumn(0).setPreferredWidth(5);
            jtbThietBi.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jtfTimTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfTimTen.setVerifyInputWhenFocusTarget(false);
        jtfTimTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfTimTenKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Tên");

        jcbHDMI.setSelected(true);
        jcbHDMI.setText("Dây HDMI");

        jcbDayTypeC.setSelected(true);
        jcbDayTypeC.setText("Dây TypeC");

        jcbMicro.setSelected(true);
        jcbMicro.setText("Micro");

        jcbDayMicro.setSelected(true);
        jcbDayMicro.setText("Dây micro");

        jcbChiaKhoa.setSelected(true);
        jcbChiaKhoa.setText("Chìa khóa");

        jcbRemote.setSelected(true);
        jcbRemote.setText("Remote");

        jcbTatCa.setSelected(true);
        jcbTatCa.setText("Tất cả");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbRemote)
                        .addGap(24, 24, 24)
                        .addComponent(jcbMicro))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbHDMI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbDayTypeC)))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jcbDayMicro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbTatCa))
                    .addComponent(jcbChiaKhoa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbHDMI)
                    .addComponent(jcbDayTypeC)
                    .addComponent(jcbTatCa)
                    .addComponent(jcbDayMicro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMicro)
                    .addComponent(jcbChiaKhoa)
                    .addComponent(jcbRemote))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcbSanSang.setSelected(true);
        jcbSanSang.setText("Sẵn sàng");

        jcbHong.setSelected(true);
        jcbHong.setText("Hỏng");

        jcbDangMuon.setSelected(true);
        jcbDangMuon.setText("Đang mượn");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbDangMuon)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jcbSanSang)
                        .addGap(12, 12, 12)
                        .addComponent(jcbHong)))
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSanSang)
                    .addComponent(jcbHong))
                .addGap(12, 12, 12)
                .addComponent(jcbDangMuon)
                .addGap(12, 12, 12))
        );

        jpnTim.setBackground(new java.awt.Color(220, 204, 204));

        jlbTim.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbTim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/search.png"))); // NOI18N
        jlbTim.setToolTipText("Tìm");
        jlbTim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbTim.setName("Tim"); // NOI18N

        javax.swing.GroupLayout jpnTimLayout = new javax.swing.GroupLayout(jpnTim);
        jpnTim.setLayout(jpnTimLayout);
        jpnTimLayout.setHorizontalGroup(
            jpnTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );
        jpnTimLayout.setVerticalGroup(
            jpnTimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnThem.setBackground(new java.awt.Color(153, 204, 255));

        jlbThem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThem.setText("Thêm");
        jlbThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThem.setName("ThemThietBi"); // NOI18N

        javax.swing.GroupLayout jpnThemLayout = new javax.swing.GroupLayout(jpnThem);
        jpnThem.setLayout(jpnThemLayout);
        jpnThemLayout.setHorizontalGroup(
            jpnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        jpnThemLayout.setVerticalGroup(
            jpnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Loại");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Trạng thái");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Phòng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfTimTen, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addComponent(jtfTimPhong))
                    .addComponent(jLabel4))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtfTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTimPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnTim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfTimTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTimTenKeyPressed
//        String s = (jtfTimTen.getText().length()==0?jtfTimTen.getText():jtfTimTen.getText().trim());
//        System.out.println(s);
//        if(s.length() != 0){
//
//            tbModel.setRowCount(0);
//            for(ThietBi tb : dsThietBi){
//                if(tb.getTen().contains(s)){
//                    tbModel.addRow(new Object[]{tb.getMa(),tb.getTen(),tb.getTenLoai(),tb.getTrangThai()});
//                }
//            }
//        }
//        else{
//            tbModel.setRowCount(0);
//            refresh();
//        }
    }//GEN-LAST:event_jtfTimTenKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jcbChiaKhoa;
    private javax.swing.JCheckBox jcbDangMuon;
    private javax.swing.JCheckBox jcbDayMicro;
    private javax.swing.JCheckBox jcbDayTypeC;
    private javax.swing.JCheckBox jcbHDMI;
    private javax.swing.JCheckBox jcbHong;
    private javax.swing.JCheckBox jcbMicro;
    private javax.swing.JCheckBox jcbRemote;
    private javax.swing.JCheckBox jcbSanSang;
    private javax.swing.JCheckBox jcbTatCa;
    private javax.swing.JLabel jlbThem;
    private javax.swing.JLabel jlbTim;
    private javax.swing.JPanel jpnThem;
    private javax.swing.JPanel jpnTim;
    private javax.swing.JTable jtbThietBi;
    private javax.swing.JTextField jtfTimPhong;
    private javax.swing.JTextField jtfTimTen;
    // End of variables declaration//GEN-END:variables

    public NhanVienPanel getPr() {
        return pr;
    }

    public ArrayList<String> getDsCheckLoai() {
        return dsCheckLoai;
    }

    public ArrayList<String> getDsCheckTrangThai() {
        return dsCheckTrangThai;
    }

    public JTable getJtbThietBi() {
        return jtbThietBi;
    }

    public JCheckBox getJcbChiaKhoa() {
        return jcbChiaKhoa;
    }

    public JCheckBox getJcbDangMuon() {
        return jcbDangMuon;
    }

    public JCheckBox getJcbDayMicro() {
        return jcbDayMicro;
    }

    public JCheckBox getJcbDayTypeC() {
        return jcbDayTypeC;
    }

    public JCheckBox getJcbHDMI() {
        return jcbHDMI;
    }

    public JCheckBox getJcbHong() {
        return jcbHong;
    }

    public JCheckBox getJcbMicro() {
        return jcbMicro;
    }

    public JCheckBox getJcbSanSang() {
        return jcbSanSang;
    }

    public JCheckBox getJcbRemote() {
        return jcbRemote;
    }

    public JCheckBox getJcbTatCa() {
        return jcbTatCa;
    }

    public JLabel getJlbThem() {
        return jlbThem;
    }

    public JLabel getJlbTim() {
        return jlbTim;
    }

    public JPanel getJpnThem() {
        return jpnThem;
    }

    public JPanel getJpnTim() {
        return jpnTim;
    }

    public JTextField getJtfTimTen() {
        return jtfTimTen;
    }

}
