
package view;

import java.util.concurrent.CountDownLatch;
import controller.NhanVienController;
import dao.NhanVienDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Menu;
import view.QLNV.DoiMatKhau;


public class NhanVienPanel extends javax.swing.JPanel {

    private MainFrame mf;
    private String userName;

    private TBPanel tbPanel;
    private PHPanel phPanel;
    private TCPanel tcPanel;
    private TKPanel tkPanel;

    public NhanVienPanel(MainFrame mf) {
        initComponents();
        
        this.mf = mf;
        this.userName = mf.getUserName();
        this.jlbUserName.setText(new NhanVienDAO().get(userName).getTen());
        refreshAll();
        NhanVienController ctrl = new NhanVienController(this, jpnMainView, setMenu());
    }

    public ArrayList<Menu> setMenu() {
        ArrayList<Menu> list = new ArrayList<>();
        list.add(new Menu("TrangChu", jlbTrangChu, jpnMenu1));
        list.add(new Menu("ThietBi", jlbThietBi, jpnMenu2));
        list.add(new Menu("PhongHoc", jlbPhongHoc, jpnMenu3));
        list.add(new Menu("ThongKe", jlbThongKeMuon, jpnMenu4));
        return list;
    }

    public void refreshAll() {
        LoadingDialog ld = new LoadingDialog(this.mf, "Đang xử lí");
        new Thread(()->{
            ld.setVisible(true);
        }).start();
        CountDownLatch latch = new CountDownLatch(4);
        try {
            Thread t1 = new Thread(() -> {
                tbPanel = new TBPanel(this);
                latch.countDown();
            });
            Thread t2 = new Thread(() -> {
                phPanel = new PHPanel(this);
                latch.countDown();
            });
            Thread t3 = new Thread(() -> {
                tcPanel = new TCPanel(this);
                latch.countDown();
            });
            Thread t4 = new Thread(() -> {
                tkPanel = new TKPanel();
                latch.countDown();
            });
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            
            latch.await();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(NhanVienPanel.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ld.setVisible(false);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnBackground = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnLogOut = new javax.swing.JPanel();
        jlbLogOut = new javax.swing.JLabel();
        jpnMenu1 = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnMenu2 = new javax.swing.JPanel();
        jlbThietBi = new javax.swing.JLabel();
        jpnMenu3 = new javax.swing.JPanel();
        jlbPhongHoc = new javax.swing.JLabel();
        jpnMenu4 = new javax.swing.JPanel();
        jlbThongKeMuon = new javax.swing.JLabel();
        jlbUserName = new javax.swing.JLabel();
        jlbUserIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpnMainView = new javax.swing.JPanel();

        setFocusCycleRoot(true);

        jpnBackground.setBackground(new java.awt.Color(235, 69, 95));

        jpnMenu.setBackground(new java.awt.Color(43, 52, 103));

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

        jpnMenu1.setBackground(new java.awt.Color(43, 52, 103));
        jpnMenu1.setPreferredSize(new java.awt.Dimension(105, 60));

        jlbTrangChu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        jlbTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account-multiple-custom.png"))); // NOI18N
        jlbTrangChu.setText("  Trang chủ");
        jlbTrangChu.setToolTipText("");
        jlbTrangChu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbTrangChu.setName("TrangChu"); // NOI18N
        jlbTrangChu.setPreferredSize(new java.awt.Dimension(105, 32));

        javax.swing.GroupLayout jpnMenu1Layout = new javax.swing.GroupLayout(jpnMenu1);
        jpnMenu1.setLayout(jpnMenu1Layout);
        jpnMenu1Layout.setHorizontalGroup(
            jpnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenu1Layout.setVerticalGroup(
            jpnMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnMenu2.setBackground(new java.awt.Color(43, 52, 103));
        jpnMenu2.setPreferredSize(new java.awt.Dimension(108, 60));

        jlbThietBi.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        jlbThietBi.setForeground(new java.awt.Color(255, 255, 255));
        jlbThietBi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThietBi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devices-custom.png"))); // NOI18N
        jlbThietBi.setText("   Thiết bị");
        jlbThietBi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThietBi.setName("ThietBi"); // NOI18N

        javax.swing.GroupLayout jpnMenu2Layout = new javax.swing.GroupLayout(jpnMenu2);
        jpnMenu2.setLayout(jpnMenu2Layout);
        jpnMenu2Layout.setHorizontalGroup(
            jpnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThietBi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenu2Layout.setVerticalGroup(
            jpnMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnMenu3.setBackground(new java.awt.Color(43, 52, 103));
        jpnMenu3.setMinimumSize(new java.awt.Dimension(100, 60));
        jpnMenu3.setPreferredSize(new java.awt.Dimension(108, 60));

        jlbPhongHoc.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        jlbPhongHoc.setForeground(new java.awt.Color(255, 255, 255));
        jlbPhongHoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhongHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/google-classroom-custom.png"))); // NOI18N
        jlbPhongHoc.setText("  Phòng học");
        jlbPhongHoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbPhongHoc.setName("PhongHoc"); // NOI18N

        javax.swing.GroupLayout jpnMenu3Layout = new javax.swing.GroupLayout(jpnMenu3);
        jpnMenu3.setLayout(jpnMenu3Layout);
        jpnMenu3Layout.setHorizontalGroup(
            jpnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPhongHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenu3Layout.setVerticalGroup(
            jpnMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbPhongHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jpnMenu4.setBackground(new java.awt.Color(43, 52, 103));
        jpnMenu4.setPreferredSize(new java.awt.Dimension(108, 60));

        jlbThongKeMuon.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        jlbThongKeMuon.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKeMuon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbThongKeMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/notebook-edit-outline-custom.png"))); // NOI18N
        jlbThongKeMuon.setText("Thống kê mượn");
        jlbThongKeMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbThongKeMuon.setName("ThongKe"); // NOI18N

        javax.swing.GroupLayout jpnMenu4Layout = new javax.swing.GroupLayout(jpnMenu4);
        jpnMenu4.setLayout(jpnMenu4Layout);
        jpnMenu4Layout.setHorizontalGroup(
            jpnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKeMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenu4Layout.setVerticalGroup(
            jpnMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKeMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jlbUserName.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbUserName.setForeground(new java.awt.Color(255, 255, 255));
        jlbUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbUserName.setText("User Name");
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

        jlbUserIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account-card-custom.png"))); // NOI18N

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(jpnMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(jpnMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(jpnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jlbUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addComponent(jlbUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jlbUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(jpnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnMainViewLayout = new javax.swing.GroupLayout(jpnMainView);
        jpnMainView.setLayout(jpnMainViewLayout);
        jpnMainViewLayout.setHorizontalGroup(
            jpnMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        jpnMainViewLayout.setVerticalGroup(
            jpnMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBackgroundLayout.setVerticalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnMainView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlbUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbUserNameMouseClicked
        new DoiMatKhau(mf, userName).setVisible(true);
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
    private javax.swing.JLabel jlbLogOut;
    private javax.swing.JLabel jlbPhongHoc;
    private javax.swing.JLabel jlbThietBi;
    private javax.swing.JLabel jlbThongKeMuon;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JLabel jlbUserIcon;
    private javax.swing.JLabel jlbUserName;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JPanel jpnLogOut;
    private javax.swing.JPanel jpnMainView;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnMenu1;
    private javax.swing.JPanel jpnMenu2;
    private javax.swing.JPanel jpnMenu3;
    private javax.swing.JPanel jpnMenu4;
    // End of variables declaration//GEN-END:variables

    public JFrame getMainFrame() {
        return mf;
    }

    public TBPanel getTbPanel() {
        return tbPanel;
    }

    public PHPanel getPhPanel() {
        return phPanel;
    }

    public TCPanel getTcPanel() {
        return tcPanel;
    }

    public TKPanel getTkPanel() {
        return tkPanel;
    }
    
    public String getUserName() {
        return userName;
    }

    public JLabel getJlbUserName() {
        return jlbUserName;
    }

}
