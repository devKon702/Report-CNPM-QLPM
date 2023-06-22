package view;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import model.Mail;
import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class DangNhapPanel extends javax.swing.JPanel {

    private MainFrame mf;

    public DangNhapPanel(MainFrame mf) {
        initComponents();
        this.mf = mf;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel1 = new splashscreen.CurvesPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfTaiKhoan = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jpfMatKhau = new javax.swing.JPasswordField();
        jlbQuen = new javax.swing.JLabel();
        jbtnDangNhap = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(43, 43, 43));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 69, 95));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đăng nhập");
        jLabel1.setName("jlbDangNhap"); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/account-card-custom.png"))); // NOI18N
        jLabel2.setName("jlbIconDangNhap"); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 40));

        jtfTaiKhoan.setBackground(new java.awt.Color(43, 43, 43));
        jtfTaiKhoan.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jtfTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        jtfTaiKhoan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfTaiKhoan.setBorder(null);
        jtfTaiKhoan.setCaretColor(new java.awt.Color(255, 255, 255));
        jtfTaiKhoan.setDoubleBuffered(true);
        jtfTaiKhoan.setInheritsPopupMenu(true);
        jtfTaiKhoan.setName("jtfTaiKhoan"); // NOI18N
        jtfTaiKhoan.setSelectionColor(new java.awt.Color(204, 204, 204));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/shield-key-custom.png"))); // NOI18N
        jLabel3.setName("jlbIconDangNhap"); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 40));

        jpfMatKhau.setBackground(new java.awt.Color(43, 43, 43));
        jpfMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        jpfMatKhau.setBorder(null);
        jpfMatKhau.setCaretColor(new java.awt.Color(255, 255, 255));
        jpfMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpfMatKhauKeyReleased(evt);
            }
        });

        jlbQuen.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jlbQuen.setForeground(new java.awt.Color(255, 255, 255));
        jlbQuen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbQuen.setText("Quên mật khẩu");
        jlbQuen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlbQuen.setName("jlbQuen"); // NOI18N
        jlbQuen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbQuenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbQuenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbQuenMouseExited(evt);
            }
        });

        jbtnDangNhap.setBackground(new java.awt.Color(102, 102, 102));
        jbtnDangNhap.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 14)); // NOI18N
        jbtnDangNhap.setForeground(new java.awt.Color(192, 238, 242));
        jbtnDangNhap.setBorder(null);
        jbtnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnDangNhap.setLabel("Đăng nhập");
        jbtnDangNhap.setName("jbtnDangNhap"); // NOI18N
        jbtnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout curvesPanel1Layout = new javax.swing.GroupLayout(curvesPanel1);
        curvesPanel1.setLayout(curvesPanel1Layout);
        curvesPanel1Layout.setHorizontalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel1Layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jtfTaiKhoan))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, curvesPanel1Layout.createSequentialGroup()
                            .addComponent(jlbQuen, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1)
                        .addGroup(curvesPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jpfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        curvesPanel1Layout.setVerticalGroup(
            curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTaiKhoan)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jpfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(curvesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jbtnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(curvesPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbQuen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(curvesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jpfMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpfMatKhauKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new Thread(() -> {
                TaiKhoan tk = new TaiKhoanDAO().get(jtfTaiKhoan.getText());
                if (tk != null && tk.getMk().equals(new String(jpfMatKhau.getPassword()))) {
                    mf.login(tk);
                } else {
                    JOptionPane.showMessageDialog(mf, "Thông tin đăng nhập không đúng");
                }
            }).start();
        }
    }//GEN-LAST:event_jpfMatKhauKeyReleased

    private void jlbQuenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQuenMouseEntered
        jlbQuen.setForeground(new Color(204, 204, 255));
        jlbQuen.setFont(new java.awt.Font("Montserrat Medium", 1, 12));
    }//GEN-LAST:event_jlbQuenMouseEntered

    private void jlbQuenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQuenMouseExited
        jlbQuen.setForeground(new Color(255, 255, 255));
        jlbQuen.setFont(new java.awt.Font("Montserrat Medium", 0, 12));
    }//GEN-LAST:event_jlbQuenMouseExited

    private void jlbQuenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbQuenMouseClicked
        String tenTK = JOptionPane.showInputDialog(this, "Nhập tài khoản", "Cấp lại mật khẩu", JOptionPane.QUESTION_MESSAGE);
        // Kiểm tra tài khoản có tồn tại không
        if (tenTK != null) {
            TaiKhoan tk = new TaiKhoanDAO().get(tenTK);
            if (tk == null) {
                JOptionPane.showMessageDialog(this, "Không tồn tại tài khoản");
                return;
            }
            
            LoadingDialog ld = new LoadingDialog(this.mf, "Đang gửi");
            new Thread(() -> {
                ld.setVisible(true);
            }).start();
            // Gửi mail
            String mail = new NhanVienDAO().get(tenTK).getEmail();
            Random rand = new Random();
            // Tạo random và gửi code đến mail
            String code = "";
            for (int i = 0; i < 6; i++) {
                code += Integer.toString(rand.nextInt(10));
            }
            
            try {
                Mail.sendPasswordToEmail(mail, "Code xác nhận đổi mật khẩu: " + code);
                ld.setVisible(false);
                JOptionPane.showMessageDialog(this, "Đã gửi thành công");
                String tmp = JOptionPane.showInputDialog(this, "Nhập code để reset lại mật khẩu", "Xác nhận", JOptionPane.QUESTION_MESSAGE);
                while (tmp != null) {
                    if (!tmp.equals(code)) {
                        tmp = JOptionPane.showInputDialog(this, "Code không đúng,hãy nhập lại", "Xác nhận", JOptionPane.QUESTION_MESSAGE);
                    } else {
                        tk.setMk(code);
                        new TaiKhoanDAO().update(tk);
                        JOptionPane.showMessageDialog(this, "Mật khẩu mới sẽ là code bạn vừa nhập");
                        break;
                    }
                }
            } catch (MessagingException ex) {
                ld.setVisible(false);
                JOptionPane.showMessageDialog(this, "Gửi mail thất bại");
            }
        }
    }//GEN-LAST:event_jlbQuenMouseClicked

    private void jbtnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDangNhapActionPerformed
        new Thread(() -> {
            TaiKhoan tk = new TaiKhoanDAO().get(jtfTaiKhoan.getText());
            if (tk != null && tk.getMk().equals(new String(jpfMatKhau.getPassword()))) {
                mf.login(tk);
            } else {
                JOptionPane.showMessageDialog(mf, "Thông tin đăng nhập không đúng");
            }
        }).start();
    }//GEN-LAST:event_jbtnDangNhapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private splashscreen.CurvesPanel curvesPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbtnDangNhap;
    private javax.swing.JLabel jlbQuen;
    private javax.swing.JPasswordField jpfMatKhau;
    private javax.swing.JTextField jtfTaiKhoan;
    // End of variables declaration//GEN-END:variables
}
