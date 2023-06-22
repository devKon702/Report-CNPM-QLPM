/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.QLPH;

import dao.PhongHocDAO;
import javax.swing.JOptionPane;
import model.PhongHoc;
import view.PHPanel;

/**
 *
 * @author Admin
 */
public class ThemPH extends javax.swing.JFrame {

    private PHPanel pr;

    public ThemPH(PHPanel pr) {
        initComponents();
        this.pr = pr;
        this.setLocationRelativeTo(null);
    }

    public void them() {
        String s = jtfMaPhong.getText().toUpperCase();
        if (!s.matches("^[A-Za-z0-9]{1,4}$")) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền mã phòng có từ 4 kí tự trở xuống, không chứa kí tự đặc biệt và khoảng trống");
            return;
        }
        if (new PhongHocDAO().insert(new PhongHoc(s, 3))) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pr.filterRows();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pr.getPr().getTcPanel().filter();
                }
            }).start();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Đã tồn tại phòng");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfMaPhong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm phòng");
        setAlwaysOnTop(true);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Mã phòng");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfMaPhong)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        them();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfMaPhong;
    // End of variables declaration//GEN-END:variables
}
