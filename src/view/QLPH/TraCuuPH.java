
package view.QLPH;

import dao.PhongHocDAO;
import dao.TrangThaiDAO;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import model.PhongHoc;
import model.ThietBi;
import model.TrangThai;


public class TraCuuPH extends javax.swing.JPanel {
    
    private ArrayList<String> dsCheckTrangThai;
    public TraCuuPH() {
        initComponents();
        dsCheckTrangThai = new ArrayList<>();
        for(TrangThai x : new PhongHocDAO().getTrangThaiPhongHoc()){
            dsCheckTrangThai.add(x.getTen());
        }
        if(dsCheckTrangThai.size() == 3){
            jcbSanSang.setText(dsCheckTrangThai.get(0));
            jcbDangMuon.setText(dsCheckTrangThai.get(1));
            jcbBaoTri.setText(dsCheckTrangThai.get(2));
        }
        refreshTable();
    }

    public void refreshTable(){
        DefaultTableModel model = (DefaultTableModel) jtbPhongHoc.getModel();
        model.setRowCount(0);
        for(PhongHoc x : new PhongHocDAO().getAll()){
            String ct = "";
            Map<String,ArrayList<ThietBi>> tmp = x.getMapLoai_ThietBi();
            for(String loai : tmp.keySet()){
                ct += tmp.get(loai).size() + " " + loai + ", ";
            }
            model.addRow(new Object[]{x.getMaPhong(),ct,new TrangThaiDAO().getTenTrangThai(x.getMaTrangThai())});
        }
    }
    
    public void setDsCheckTrangThai(){
        dsCheckTrangThai = new ArrayList<>();
        if(jcbBaoTri.isSelected()){
            dsCheckTrangThai.add(jcbBaoTri.getText());
        }
        if(jcbDangMuon.isSelected()){
            dsCheckTrangThai.add(jcbDangMuon.getText());
        }
        if(jcbSanSang.isSelected()){
            dsCheckTrangThai.add(jcbSanSang.getText());
        }
    }
   
    
    public void filterRow(){
        
        DefaultTableModel tbModel = (DefaultTableModel) jtbPhongHoc.getModel();
        refreshTable();
        for(int i = tbModel.getRowCount() - 1; i>=0 ; i--){
            if(!dsCheckTrangThai.contains(jtbPhongHoc.getValueAt(i, 2).toString())){
                tbModel.removeRow(i);
            }
            else if(!jtbPhongHoc.getValueAt(i, 0).toString().contains(jtfTimPhong.getText().toUpperCase())){
                tbModel.removeRow(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbPhongHoc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jtfTimPhong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jcbBaoTri = new javax.swing.JCheckBox();
        jcbDangMuon = new javax.swing.JCheckBox();
        jcbSanSang = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jbtnTim = new javax.swing.JButton();

        jtbPhongHoc.setAutoCreateRowSorter(true);
        jtbPhongHoc.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jtbPhongHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã phòng", "Thiết bị", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbPhongHoc.setRowHeight(30);
        jScrollPane1.setViewportView(jtbPhongHoc);

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setText("Phòng");

        jcbBaoTri.setSelected(true);
        jcbBaoTri.setText("Bảo trì");
        jcbBaoTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbBaoTriMouseClicked(evt);
            }
        });

        jcbDangMuon.setSelected(true);
        jcbDangMuon.setText("Đang mượn");
        jcbDangMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDangMuonMouseClicked(evt);
            }
        });

        jcbSanSang.setSelected(true);
        jcbSanSang.setText("Sẵn sàng");
        jcbSanSang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbSanSangMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbSanSang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbDangMuon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbBaoTri)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbBaoTri)
                    .addComponent(jcbDangMuon)
                    .addComponent(jcbSanSang))
                .addGap(6, 6, 6))
        );

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Trạng thái");

        jbtnTim.setBackground(new java.awt.Color(204, 204, 204));
        jbtnTim.setText("Tìm");
        jbtnTim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jtfTimPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jbtnTim))
                    .addComponent(jLabel4))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTimPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTimActionPerformed
        filterRow();
    }//GEN-LAST:event_jbtnTimActionPerformed

    private void jcbBaoTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbBaoTriMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbBaoTriMouseClicked

    private void jcbDangMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDangMuonMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbDangMuonMouseClicked

    private void jcbSanSangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbSanSangMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbSanSangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnTim;
    private javax.swing.JCheckBox jcbBaoTri;
    private javax.swing.JCheckBox jcbDangMuon;
    private javax.swing.JCheckBox jcbSanSang;
    private javax.swing.JTable jtbPhongHoc;
    private javax.swing.JTextField jtfTimPhong;
    // End of variables declaration//GEN-END:variables
}
