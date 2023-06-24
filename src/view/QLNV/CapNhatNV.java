/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.QLNV;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import java.util.Calendar;
import java.util.Random;
import javax.swing.JOptionPane;
import model.InputValidator;
import model.NhanVien;
import model.StringNormalizer;
import model.TaiKhoan;
import view.NVPanel;

/**
 *
 * @author Admin
 */
public class CapNhatNV extends javax.swing.JFrame {

    private NVPanel root;
    private NhanVien nv;
    private TaiKhoan tk;

    public CapNhatNV(NhanVien nv, NVPanel root) {
        initComponents();
        this.setLocationRelativeTo(null);

        this.root = root;
        this.nv = nv;
        this.tk = new TaiKhoanDAO().get(nv.getMa());
        if (this.tk == null) {
            jbtnReset.setEnabled(false);
            jbtnCapNhatTaiKhoan.setEnabled(false);
            jrbAdmin.setEnabled(false);
            jrbNhanVien.setEnabled(false);
            jrbKhoa.setEnabled(false);
        }
        jtfMa.setText(nv.getMa());
        jtfTen.setText(nv.getTen());
        jtfCCCD.setText(nv.getCccd());
        jtfLamViec.setText(nv.getNgayLam() + (nv.getNgayNghi() == null ? "" : " đến " + nv.getNgayNghi()));
        jtfEmail.setText(nv.getEmail());
        jtfSDT.setText(nv.getSdt());

        if (nv.getNgayNghi() != null) {
            jtfTen.setEnabled(false);
            jtfCCCD.setEnabled(false);
            jtfEmail.setEnabled(false);
            jtfSDT.setEnabled(false);
            jbtnNghi.setText("Vào làm");
            jbtnReset.setEnabled(false);
            jbtnCapNhatTaiKhoan.setEnabled(false);
            jbtnCapNhat.setEnabled(false);
            jbtnXoa.setEnabled(true);

            jrbNhanVien.setEnabled(false);
            jrbKhoa.setEnabled(false);
            jrbAdmin.setEnabled(false);
        }

        switch (tk.getQuyen()) {
            case 1:
                jrbAdmin.setSelected(true);
                break;
            case 2:
                jrbNhanVien.setSelected(true);
                break;
            case 0:
                jrbKhoa.setSelected(true);
                break;
        }

    }

    public void capNhat() {
        String ten = jtfTen.getText().trim();
        ten = StringNormalizer.normalizeString(ten);
        String cccd = jtfCCCD.getText().trim();
        String sdt = jtfSDT.getText().trim();
        String email = jtfEmail.getText().trim();

        String error = "";
        if (ten.length() == 0 || !InputValidator.validateFullName(ten)) {
            error += "Tên đang trống hoặc chứa số, kí tự đặc biệt\n";
        }
        if(ten.length() >= 50){
            error += "Tên không được quá 50 kí tự\n";
        }
        if (!InputValidator.validateIdentityCard(cccd)) {
            error += "CCCD chỉ bao gồm 10 hoặc 12 kí tự số\n";
        }
        else if(!nv.getCccd().equals(cccd) && new NhanVienDAO().getNhanVien_CCCD(cccd) != null){
            JOptionPane.showMessageDialog(this, "Trùng CCCD");
            return;
        }
        if (!InputValidator.validateEmail(email)) {
            error += "Email theo định dạng xxx@gmail.com\n";
        }
        if (!InputValidator.validatePhoneNumber(sdt)) {
            error += "Số điện thoại phải là chuỗi 10 số, bắt đầu là 0";
        }
        if (error.length() != 0) {
            JOptionPane.showMessageDialog(this, error);
        } else {
            int opt = JOptionPane.showConfirmDialog(this, "Xác nhận thay đổi thông tin nhân viên", "", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                if (new NhanVienDAO().update(new NhanVien(nv.getMa(), ten, cccd, sdt, email, nv.getNgayLam(), nv.getNgayNghi()))) {
                    root.filterRows();
                    root.getPr().getTkPanel().filterRows();
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Thất bại, kiểm tra lại thông tin");
                }
            }
        }
    }

    public void capNhatTaiKhoan() {
        int quyen;
        if (jrbAdmin.isSelected()) {
            quyen = 1;
        } else if (jrbNhanVien.isSelected()) {
            quyen = 2;
        } else {
            quyen = 0;
        }

        if (quyen != tk.getQuyen()) {
            tk.setQuyen(quyen);
            if (new TaiKhoanDAO().update(tk)) {
                root.refresh();
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thất bại");
            }
        }
    }

    public void resetMatKhau() {
        String pass = randomPassword();
        if (JOptionPane.showConfirmDialog(this, "Xác nhận cấp mật khẩu mới", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            tk.setMk(pass);
            if (new TaiKhoanDAO().update(tk)) {
                JOptionPane.showMessageDialog(this, "Mật khẩu tài khoản: " + pass);
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại");
            }
        }
    }

    public String randomPassword() {
        Random rand = new Random();
        String pass = "";
        for (int i = 0; i < 6; i++) {
            pass += Integer.toString(rand.nextInt(10));
        }
        return pass;
    }

    public void choNghi() {
        if (JOptionPane.showConfirmDialog(this, "Xác nhận cho nghỉ", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (this.tk != null) {
                this.tk.setQuyen(0);
                try {
                    this.nv.setNgayNghi(root.getStringDate(Calendar.getInstance().getTime()));
                    if (root.getDate(nv.getNgayNghi()).compareTo(root.getDate(nv.getNgayLam())) < 0) {
                        JOptionPane.showMessageDialog(this, "Nhân viên chưa làm");
                    }
                    if (new NhanVienDAO().update(nv) && new TaiKhoanDAO().update(tk)) {
                        root.refresh();
                        JOptionPane.showMessageDialog(this, "Đã cho nghỉ thành công");
                        this.dispose();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            }
        }
    }

    public void vaoLam() {
        if (JOptionPane.showConfirmDialog(this, "Xác nhận nhân viên vào làm lại", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.nv.setNgayLam(root.getStringDate(Calendar.getInstance().getTime()));
            this.nv.setNgayNghi(null);
            if (new NhanVienDAO().update(nv)) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                root.refresh();
                this.dispose();
                new CapNhatNV(nv, root).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
            }
        }
    }

    public void xoaNhanVien() {
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa thông tin nhân viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (new NhanVienDAO().delete(nv)) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                root.refresh();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại, nhân viên đã lập phiếu mượn");
            }
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

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jtfMa = new javax.swing.JTextField();
        jtfTen = new javax.swing.JTextField();
        jtfCCCD = new javax.swing.JTextField();
        jtfSDT = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfLamViec = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jbtnCapNhat = new javax.swing.JButton();
        jbtnCapNhatTaiKhoan = new javax.swing.JButton();
        jrbAdmin = new javax.swing.JRadioButton();
        jrbNhanVien = new javax.swing.JRadioButton();
        jrbKhoa = new javax.swing.JRadioButton();
        jbtnNghi = new javax.swing.JButton();
        jbtnReset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jbtnXoa = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtfMa.setEnabled(false);

        jtfLamViec.setEnabled(false);

        jLabel1.setText("Mã");

        jLabel2.setText("Tên");

        jLabel3.setText("CCCD");

        jLabel4.setText("SĐT");

        jLabel5.setText("Email");

        jLabel6.setText("Làm việc");

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Thông tin nhân viên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnCapNhat.setBackground(new java.awt.Color(204, 204, 255));
        jbtnCapNhat.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnCapNhat.setText("Cập nhật");
        jbtnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCapNhatActionPerformed(evt);
            }
        });

        jbtnCapNhatTaiKhoan.setBackground(new java.awt.Color(204, 255, 204));
        jbtnCapNhatTaiKhoan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnCapNhatTaiKhoan.setText("Cập nhật");
        jbtnCapNhatTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCapNhatTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCapNhatTaiKhoanActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbAdmin);
        jrbAdmin.setText("Admin");

        buttonGroup1.add(jrbNhanVien);
        jrbNhanVien.setText("Nhân viên");

        buttonGroup1.add(jrbKhoa);
        jrbKhoa.setText("Khóa");

        jbtnNghi.setBackground(new java.awt.Color(255, 204, 204));
        jbtnNghi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnNghi.setText("Nghỉ làm");
        jbtnNghi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNghiActionPerformed(evt);
            }
        });

        jbtnReset.setBackground(new java.awt.Color(255, 255, 204));
        jbtnReset.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jbtnReset.setText("Reset");
        jbtnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tài khoản");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnXoa.setBackground(new java.awt.Color(255, 102, 102));
        jbtnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnXoa.setText("Xóa");
        jbtnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnXoa.setEnabled(false);
        jbtnXoa.setName("jbtnXoa"); // NOI18N
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTen, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(jtfCCCD)
                            .addComponent(jtfMa))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbNhanVien)
                    .addComponent(jrbAdmin)
                    .addComponent(jrbKhoa))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnNghi)
                .addGap(20, 20, 20)
                .addComponent(jbtnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jbtnCapNhatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnReset)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfLamViec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbAdmin))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jrbNhanVien))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jrbKhoa))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnCapNhatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnNghi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCapNhatActionPerformed
        capNhat();
    }//GEN-LAST:event_jbtnCapNhatActionPerformed

    private void jbtnNghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNghiActionPerformed
        if (nv.getNgayNghi() != null)
            vaoLam();
        else
            choNghi();
    }//GEN-LAST:event_jbtnNghiActionPerformed

    private void jbtnCapNhatTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCapNhatTaiKhoanActionPerformed
        capNhatTaiKhoan();
    }//GEN-LAST:event_jbtnCapNhatTaiKhoanActionPerformed

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        resetMatKhau();
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        xoaNhanVien();
    }//GEN-LAST:event_jbtnXoaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbtnCapNhat;
    private javax.swing.JButton jbtnCapNhatTaiKhoan;
    private javax.swing.JButton jbtnNghi;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JRadioButton jrbAdmin;
    private javax.swing.JRadioButton jrbKhoa;
    private javax.swing.JRadioButton jrbNhanVien;
    private javax.swing.JTextField jtfCCCD;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLamViec;
    private javax.swing.JTextField jtfMa;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTextField jtfTen;
    // End of variables declaration//GEN-END:variables
}
