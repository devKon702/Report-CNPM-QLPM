/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view.QLTB;

import dao.ThietBiDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import model.ThietBi;
import view.TBPanel;

/**
 *
 * @author Admin
 */
public class TraCuuTB extends javax.swing.JPanel {

    ArrayList<String> dsCheckLoai;
    ArrayList<String> dsCheckTrangThai;

    public TraCuuTB() {
        initComponents();
        refresh();
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
            jtfTimTen.setText("");
            jtfTimPhong.setText("");

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

    public void refreshTable() {
        DefaultTableModel tbModel = (DefaultTableModel) jtbThietBi.getModel();
        tbModel.setRowCount(0);
        for (ThietBi x1 : new ThietBiDAO().getAll()) {
            tbModel.addRow(new Object[]{x1.getMa(), x1.getTen(), x1.getTenLoai(), x1.getPhong(), x1.getTenTrangThai()});
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

    public void filterRow() {
        refreshTable();
        jtfTimTen.setText(jtfTimTen.getText().trim());
        jtfTimPhong.setText(jtfTimPhong.getText().trim());
        DefaultTableModel tbModel = (DefaultTableModel) jtbThietBi.getModel();
        for (int i = tbModel.getRowCount() - 1; i >= 0; i--) {
            if (!dsCheckTrangThai.contains(tbModel.getValueAt(i, 4).toString())) {
                tbModel.removeRow(i);
            } else if (!dsCheckLoai.contains(tbModel.getValueAt(i, 2).toString())) {
                tbModel.removeRow(i);
            } else if (!tbModel.getValueAt(i, 1).toString().contains(jtfTimTen.getText())) {
                tbModel.removeRow(i);
            } else if (tbModel.getValueAt(i, 3) != null && !tbModel.getValueAt(i, 3).toString().contains(jtfTimPhong.getText().toUpperCase())) {
                tbModel.removeRow(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jcbHDMI = new javax.swing.JCheckBox();
        jcbDayTypeC = new javax.swing.JCheckBox();
        jcbMicro = new javax.swing.JCheckBox();
        jcbDayMicro = new javax.swing.JCheckBox();
        jcbChiaKhoa = new javax.swing.JCheckBox();
        jcbRemote = new javax.swing.JCheckBox();
        jcbTatCa = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jcbSanSang = new javax.swing.JCheckBox();
        jcbHong = new javax.swing.JCheckBox();
        jcbDangMuon = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jbtnTim = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtfTimTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfTimPhong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbThietBi = new javax.swing.JTable();

        jcbHDMI.setSelected(true);
        jcbHDMI.setText("Dây HDMI");
        jcbHDMI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbHDMIMouseClicked(evt);
            }
        });

        jcbDayTypeC.setSelected(true);
        jcbDayTypeC.setText("Dây TypeC");
        jcbDayTypeC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDayTypeCMouseClicked(evt);
            }
        });

        jcbMicro.setSelected(true);
        jcbMicro.setText("Micro");
        jcbMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbMicroMouseClicked(evt);
            }
        });

        jcbDayMicro.setSelected(true);
        jcbDayMicro.setText("Dây micro");
        jcbDayMicro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDayMicroMouseClicked(evt);
            }
        });

        jcbChiaKhoa.setSelected(true);
        jcbChiaKhoa.setText("Chìa khóa");
        jcbChiaKhoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbChiaKhoaMouseClicked(evt);
            }
        });

        jcbRemote.setSelected(true);
        jcbRemote.setText("Remote");
        jcbRemote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbRemoteMouseClicked(evt);
            }
        });

        jcbTatCa.setSelected(true);
        jcbTatCa.setText("Tất cả");
        jcbTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbTatCaMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Loại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
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
                            .addComponent(jcbChiaKhoa))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        jcbSanSang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbSanSangMouseClicked(evt);
            }
        });

        jcbHong.setSelected(true);
        jcbHong.setText("Hỏng");
        jcbHong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbHongMouseClicked(evt);
            }
        });

        jcbDangMuon.setSelected(true);
        jcbDangMuon.setText("Đang mượn");
        jcbDangMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbDangMuonMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Trạng thái");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbDangMuon)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbSanSang))
                        .addGap(12, 12, 12)
                        .addComponent(jcbHong)))
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbSanSang)
                    .addComponent(jcbHong))
                .addGap(12, 12, 12)
                .addComponent(jcbDangMuon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnTim.setBackground(new java.awt.Color(204, 255, 255));
        jbtnTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnTim.setText("Tìm");
        jbtnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTimActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Tên");

        jtfTimTen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfTimTen.setVerifyInputWhenFocusTarget(false);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTimTen, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jtfTimPhong))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTimTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTimPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTimActionPerformed
        filterRow();
    }//GEN-LAST:event_jbtnTimActionPerformed

    private void jcbHongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbHongMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbHongMouseClicked

    private void jcbSanSangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbSanSangMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbSanSangMouseClicked

    private void jcbDangMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDangMuonMouseClicked
        setDsCheckTrangThai();
    }//GEN-LAST:event_jcbDangMuonMouseClicked

    private void jcbTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbTatCaMouseClicked
        JCheckBox jcb = (JCheckBox) evt.getSource();
        if (jcb.isSelected()) {
            jcbRemote.setSelected(true);
            jcbMicro.setSelected(true);
            jcbHDMI.setSelected(true);
            jcbDayMicro.setSelected(true);
            jcbDayTypeC.setSelected(true);
            jcbChiaKhoa.setSelected(true);
        }
        else{
            jcbRemote.setSelected(false);
            jcbMicro.setSelected(false);
            jcbHDMI.setSelected(false);
            jcbDayMicro.setSelected(false);
            jcbDayTypeC.setSelected(false);
            jcbChiaKhoa.setSelected(false);
        }
        setDsCheckLoai();
    }//GEN-LAST:event_jcbTatCaMouseClicked

    private void jcbDayMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDayMicroMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbDayMicroMouseClicked

    private void jcbChiaKhoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbChiaKhoaMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbChiaKhoaMouseClicked

    private void jcbDayTypeCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbDayTypeCMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbDayTypeCMouseClicked

    private void jcbMicroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbMicroMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbMicroMouseClicked

    private void jcbHDMIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbHDMIMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbHDMIMouseClicked

    private void jcbRemoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbRemoteMouseClicked
        setDsCheckLoai();
    }//GEN-LAST:event_jcbRemoteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnTim;
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
    private javax.swing.JTable jtbThietBi;
    private javax.swing.JTextField jtfTimPhong;
    private javax.swing.JTextField jtfTimTen;
    // End of variables declaration//GEN-END:variables
}
