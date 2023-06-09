package view;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import model.TaiKhoan;

public class MainFrame extends javax.swing.JFrame {

    private DangNhapPanel jpnDangNhap;
    private NhanVienPanel jpnNhanVien;
    private AdminPanel jpnAdmin;
    private String userName;

    public MainFrame() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setTitle("Quản lí mượn trả thiết bị tại PTITHCM");
        jpnDangNhap = new DangNhapPanel(this);
        this.jpnRoot.setLayout(new BorderLayout());
        this.jpnRoot.add(jpnDangNhap);
    }

    public void login(TaiKhoan tk) {
        this.userName = tk.getTk();
        switch (tk.getQuyen()) {
            case 0:
                JOptionPane.showMessageDialog(jpnDangNhap, "Tài khoản đã bị khóa");
                break;
            case 1:
                jpnAdmin = new AdminPanel(this);
                jpnRoot.removeAll();
                jpnRoot.setLayout(new BorderLayout());
                jpnRoot.add(jpnAdmin);
                break;
            case 2:
                jpnNhanVien = new NhanVienPanel(this);
                jpnRoot.removeAll();
                jpnRoot.setLayout(new BorderLayout());
                jpnRoot.add(jpnNhanVien);
                break;
            default: JOptionPane.showMessageDialog(jpnDangNhap, "Tài khoản thuộc phân quyền lạ");
        }
        jpnRoot.validate();
        jpnRoot.repaint();
    }

    public void logout() {
        jpnRoot.removeAll();
        jpnNhanVien = null;
        jpnAdmin = null;
        jpnDangNhap = new DangNhapPanel(this);
        jpnRoot.setLayout(new BorderLayout());
        jpnRoot.add(jpnDangNhap);
        jpnRoot.validate();
        jpnRoot.repaint();
    }
    
    public String getUserName() {
        return this.userName;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));
        setFocusCycleRoot(false);

        jpnRoot.setBackground(new java.awt.Color(43, 43, 43));

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpnRoot;
    // End of variables declaration//GEN-END:variables
}
