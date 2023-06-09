/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.AdminController;
import dao.NhanVienDAO;
import java.awt.Color;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.QLNV.DoiMatKhau;
import view.QLTB.TraCuuTB;
import view.QLPH.TraCuuPH;

/**
 *
 * @author Admin
 */
public class AdminPanel extends javax.swing.JPanel {
    private MainFrame mf;
    private NVPanel nvPanel;
    private TKPanel tkPanel;
    private TraCuuTB tbPanel;
    private TraCuuPH phPanel;
    
    public AdminPanel(MainFrame mf) {
        initComponents();
        
        this.mf = mf;
        jlbUserName.setText(new NhanVienDAO().get(mf.getUserName()).getTen());
        refreshAll();
        AdminController ctrl = new AdminController(this);
    }
    
    public void refreshAll(){
        try {
            LoadingDialog ld = new LoadingDialog(this.mf, "Đang xử lí");
            new Thread(()->{
                ld.setVisible(true);
            }).start();
            CountDownLatch latch = new CountDownLatch(4);
            new Thread(()->{
                nvPanel = new NVPanel(this);
                latch.countDown();
            }).start();
            
            new Thread(()->{
                tkPanel = new TKPanel();
                latch.countDown();
            }).start();
            
            new Thread(()->{
                tbPanel = new TraCuuTB();
                latch.countDown();
            }).start();
            
            new Thread(()->{
                phPanel = new TraCuuPH();
                latch.countDown();
            }).start();
            latch.await();
            ld.setVisible(false);
        } catch (InterruptedException ex) {
            Logger.getLogger(AdminPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMenuList = new javax.swing.JPanel();
        jpnLogOut = new javax.swing.JPanel();
        jlbLogOut = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jlbUserName = new javax.swing.JLabel();
        jlbAvatar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpnThongKePM = new javax.swing.JPanel();
        jlbThongKePM = new javax.swing.JLabel();
        jpnThongKeTB = new javax.swing.JPanel();
        jlbThongKeTB = new javax.swing.JLabel();
        jpnThongKePH = new javax.swing.JPanel();
        jlbThongKePH = new javax.swing.JLabel();
        jpnMainView = new javax.swing.JPanel();

        setBackground(new java.awt.Color(153, 255, 153));

        jpnMenuList.setBackground(new java.awt.Color(43, 52, 103));

        jpnLogOut.setBackground(new java.awt.Color(43, 52, 103));

        jlbLogOut.setFont(new java.awt.Font("Montserrat SemiBold", 1, 12)); // NOI18N
        jlbLogOut.setForeground(new java.awt.Color(255, 255, 255));
        jlbLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbLogOut.setText("Log out");
        jlbLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbLogOutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jpnLogOutLayout = new javax.swing.GroupLayout(jpnLogOut);
        jpnLogOut.setLayout(jpnLogOutLayout);
        jpnLogOutLayout.setHorizontalGroup(
            jpnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnLogOutLayout.setVerticalGroup(
            jpnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jpnNhanVien.setBackground(new java.awt.Color(43, 52, 103));
        jpnNhanVien.setName(""); // NOI18N
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(105, 60));

        jlbNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account-multiple-custom.png"))); // NOI18N
        jlbNhanVien.setText("Nhân viên");
        jlbNhanVien.setToolTipText("");
        jlbNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbNhanVien.setName("NhanVien"); // NOI18N
        jlbNhanVien.setPreferredSize(new java.awt.Dimension(105, 32));

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jlbUserName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbUserName.setForeground(new java.awt.Color(255, 255, 255));
        jlbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbUserName.setText("Admin");
        jlbUserName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbUserNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbUserNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbUserNameMouseExited(evt);
            }
        });

        jlbAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account-card-custom.png"))); // NOI18N

        jpnThongKePM.setBackground(new java.awt.Color(43, 52, 103));
        jpnThongKePM.setPreferredSize(new java.awt.Dimension(105, 60));

        jlbThongKePM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbThongKePM.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKePM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKePM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/text-custom.png"))); // NOI18N
        jlbThongKePM.setText("Thống kê mượn");
        jlbThongKePM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThongKePM.setName("ThongKe"); // NOI18N
        jlbThongKePM.setPreferredSize(new java.awt.Dimension(141, 30));

        javax.swing.GroupLayout jpnThongKePMLayout = new javax.swing.GroupLayout(jpnThongKePM);
        jpnThongKePM.setLayout(jpnThongKePMLayout);
        jpnThongKePMLayout.setHorizontalGroup(
            jpnThongKePMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jpnThongKePMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jlbThongKePM, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
        );
        jpnThongKePMLayout.setVerticalGroup(
            jpnThongKePMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jpnThongKePMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jlbThongKePM, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
        );

        jpnThongKeTB.setBackground(new java.awt.Color(43, 52, 103));
        jpnThongKeTB.setPreferredSize(new java.awt.Dimension(0, 60));

        jlbThongKeTB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbThongKeTB.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKeTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKeTB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devices-custom.png"))); // NOI18N
        jlbThongKeTB.setText("Thống kê thiết bị");
        jlbThongKeTB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThongKeTB.setName("ThietBi"); // NOI18N

        javax.swing.GroupLayout jpnThongKeTBLayout = new javax.swing.GroupLayout(jpnThongKeTB);
        jpnThongKeTB.setLayout(jpnThongKeTBLayout);
        jpnThongKeTBLayout.setHorizontalGroup(
            jpnThongKeTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKeTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnThongKeTBLayout.setVerticalGroup(
            jpnThongKeTBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKeTB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnThongKePH.setBackground(new java.awt.Color(43, 52, 103));
        jpnThongKePH.setPreferredSize(new java.awt.Dimension(100, 60));

        jlbThongKePH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jlbThongKePH.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKePH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKePH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/google-classroom-custom.png"))); // NOI18N
        jlbThongKePH.setText("Thống kê phòng");
        jlbThongKePH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThongKePH.setName("PhongHoc"); // NOI18N

        javax.swing.GroupLayout jpnThongKePHLayout = new javax.swing.GroupLayout(jpnThongKePH);
        jpnThongKePH.setLayout(jpnThongKePHLayout);
        jpnThongKePHLayout.setHorizontalGroup(
            jpnThongKePHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKePH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnThongKePHLayout.setVerticalGroup(
            jpnThongKePHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKePH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuListLayout = new javax.swing.GroupLayout(jpnMenuList);
        jpnMenuList.setLayout(jpnMenuListLayout);
        jpnMenuListLayout.setHorizontalGroup(
            jpnMenuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addComponent(jpnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnThongKePM, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addComponent(jpnThongKeTB, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addComponent(jpnThongKePH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
            .addGroup(jpnMenuListLayout.createSequentialGroup()
                .addGroup(jpnMenuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jpnMenuListLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jlbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jlbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenuListLayout.setVerticalGroup(
            jpnMenuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuListLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnThongKePM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnThongKeTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnThongKePH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jpnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnMainViewLayout = new javax.swing.GroupLayout(jpnMainView);
        jpnMainView.setLayout(jpnMainViewLayout);
        jpnMainViewLayout.setHorizontalGroup(
            jpnMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 589, Short.MAX_VALUE)
        );
        jpnMainViewLayout.setVerticalGroup(
            jpnMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnMenuList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenuList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbUserNameMouseClicked
        new DoiMatKhau(mf,mf.getUserName()).setVisible(true);
    }//GEN-LAST:event_jlbUserNameMouseClicked

    private void jlbUserNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbUserNameMouseEntered
        jlbUserName.setFont(new java.awt.Font("Arial", 1, 18));
    }//GEN-LAST:event_jlbUserNameMouseEntered

    private void jlbUserNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbUserNameMouseExited
        jlbUserName.setFont(new java.awt.Font("Arial", 1, 16));
    }//GEN-LAST:event_jlbUserNameMouseExited

    private void jlbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLogOutMouseClicked
        mf.logout();
    }//GEN-LAST:event_jlbLogOutMouseClicked

    private void jlbLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLogOutMouseEntered
        jpnLogOut.setBackground(new Color(43,64,103));
    }//GEN-LAST:event_jlbLogOutMouseEntered

    private void jlbLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbLogOutMouseExited
        jpnLogOut.setBackground(new Color(43,52,103));
    }//GEN-LAST:event_jlbLogOutMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbAvatar;
    private javax.swing.JLabel jlbLogOut;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbThongKePH;
    private javax.swing.JLabel jlbThongKePM;
    private javax.swing.JLabel jlbThongKeTB;
    private javax.swing.JLabel jlbUserName;
    private javax.swing.JPanel jpnLogOut;
    private javax.swing.JPanel jpnMainView;
    private javax.swing.JPanel jpnMenuList;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnThongKePH;
    private javax.swing.JPanel jpnThongKePM;
    private javax.swing.JPanel jpnThongKeTB;
    // End of variables declaration//GEN-END:variables

    public MainFrame getMf() {
        return mf;
    }

    public JLabel getJlbNhanVien() {
        return jlbNhanVien;
    }
    
    public JPanel getJpnNhanVien() {
        return jpnNhanVien;
    }
    
    public JLabel getJlbThongKePM() {
        return jlbThongKePM;
    }
    
    public JPanel getJpnThongKePM() {
        return jpnThongKePM;
    }
    
    public JLabel getJlbUserName() {
        return jlbUserName;
    }

    public JPanel getJpnMainView() {
        return jpnMainView;
    }

    public JLabel getJlbThongKePH() {
        return jlbThongKePH;
    }

    public JLabel getJlbThongKeTB() {
        return jlbThongKeTB;
    }

    public JPanel getJpnThongKePH() {
        return jpnThongKePH;
    }

    public JPanel getJpnThongKeTB() {
        return jpnThongKeTB;
    }
    
    public NVPanel getNvPanel() {
        return nvPanel;
    }

    public TKPanel getTkPanel() {
        return tkPanel;
    }

    public TraCuuTB getTbPanel() {
        return tbPanel;
    }
    
    public TraCuuPH getPhPanel(){
        return phPanel;
    }
    
    

}
