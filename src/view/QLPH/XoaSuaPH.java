package view.QLPH;

import dao.DAO;
import dao.PhongHocDAO;
import dao.TaiKhoanDAO;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PhongHoc;
import model.TaiKhoan;
import view.LoadingDialog;
import view.NhanVienPanel;
import view.PHPanel;
import view.TBPanel;
import view.TCPanel;
import view.TKPanel;

/**
 *
 * @author Admin
 */
public class XoaSuaPH extends javax.swing.JFrame {

    private PHPanel pr;
    private PhongHoc ph;

    public XoaSuaPH(PHPanel pr, PhongHoc ph) {
        initComponents();
        setLocationRelativeTo(null);
        this.pr = pr;
        this.ph = ph;
        jtfPhong.setText(ph.getMaPhong());
        if (ph.getMaTrangThai() == 4) {
            JOptionPane.showMessageDialog(this, "Phòng đang mượn, tạm thời không thể chỉnh sửa");
            this.dispose();
        } else if (ph.getMaTrangThai() == 3) {
            jrbSanSang.setSelected(true);
        } else {
            jrbBaoTri.setSelected(true);
        }
    }

    public void sua() {
        if (!jtfPhong.getText().matches("^[A-Za-z0-9]{4}$")) {
            JOptionPane.showMessageDialog(this, "Tên phòng không hợp lệ\nVui lòng theo định dạng 4 kí tự, không kí tự đặc biệt và khoảng trống");
            return;
        }
        int trangThai = jrbSanSang.isSelected() ? 3 : 5;
        PhongHoc a = new PhongHoc(jtfPhong.getText().toUpperCase().trim(), trangThai);
        String sql = "Update PHONGHOC "
                + "set MAPHONG = '" + jtfPhong.getText().toUpperCase().trim() + "'"
                + ", TRANGTHAI = " + trangThai + " "
                + "Where MAPHONG = '" + ph.getMaPhong() + "'";
        try {
            DAO.executeUpdateSp(sql);
            LoadingDialog ld = new LoadingDialog(this, "Đang xử lí");
            new Thread(() -> {
                ld.setVisible(true);
            }).start();
            CountDownLatch latch = new CountDownLatch(4);
            try {
                Thread t1 = new Thread(() -> {
                    this.pr.getPr().getTbPanel().filterRows();
                    latch.countDown();
                });
                Thread t2 = new Thread(() -> {
                    this.pr.getPr().getPhPanel().filterRows();
                    latch.countDown();
                });
                Thread t3 = new Thread(() -> {
                    this.pr.getPr().getTcPanel().filter();
                    latch.countDown();
                });
                Thread t4 = new Thread(() -> {
                    TaiKhoan tk = new TaiKhoanDAO().get(this.pr.getPr().getUserName());
                    this.pr.getPr().getTkPanel().filterRows();
                    latch.countDown();
                });
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                latch.await();
            } catch (InterruptedException ex) {
                Logger.getLogger(NhanVienPanel.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ld.setVisible(false);
            }
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại mã phòng");
        }
    }

    public void xoa() {
        if (new PhongHocDAO().getPhongHoc(ph.getMaPhong()) == null) {
            JOptionPane.showMessageDialog(this, "Phòng học không tồn tại");
        } else if (!ph.getMapLoai_ThietBi().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Trong phòng còn thiết bị");
        } else if (JOptionPane.showConfirmDialog(this, "Xác nhận xóa phòng " + ph.getMaPhong(), "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (new PhongHocDAO().delete(ph)) {
                new Thread(() -> {
                    pr.filterRows();
                }).start();
                new Thread(() -> {
                    pr.getPr().getTcPanel().filter();
                }).start();
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpnBackground = new javax.swing.JPanel();
        jrbSanSang = new javax.swing.JRadioButton();
        jrbBaoTri = new javax.swing.JRadioButton();
        jlbMaPhong = new javax.swing.JLabel();
        jbtnCapNhat = new javax.swing.JButton();
        jbtnXoa = new javax.swing.JButton();
        jtfPhong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cập nhật phòng");
        setAlwaysOnTop(true);

        jpnBackground.setBackground(new java.awt.Color(255, 255, 255));
        jpnBackground.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup1.add(jrbSanSang);
        jrbSanSang.setText("Sẵn sàng");

        buttonGroup1.add(jrbBaoTri);
        jrbBaoTri.setText("Bảo trì");

        jlbMaPhong.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jlbMaPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbMaPhong.setText("Phòng");

        jbtnCapNhat.setBackground(new java.awt.Color(204, 255, 204));
        jbtnCapNhat.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbtnCapNhat.setText("Cập nhật");
        jbtnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCapNhatActionPerformed(evt);
            }
        });

        jbtnXoa.setBackground(new java.awt.Color(255, 204, 204));
        jbtnXoa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbtnXoa.setText("Xóa");
        jbtnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXoaActionPerformed(evt);
            }
        });

        jtfPhong.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jpnBackgroundLayout = new javax.swing.GroupLayout(jpnBackground);
        jpnBackground.setLayout(jpnBackgroundLayout);
        jpnBackgroundLayout.setHorizontalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jlbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPhong)
                    .addGroup(jpnBackgroundLayout.createSequentialGroup()
                        .addComponent(jrbSanSang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jrbBaoTri, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jpnBackgroundLayout.setVerticalGroup(
            jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBackgroundLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jlbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbBaoTri)
                    .addComponent(jrbSanSang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jbtnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCapNhatActionPerformed
        sua();
    }//GEN-LAST:event_jbtnCapNhatActionPerformed

    private void jbtnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXoaActionPerformed
        xoa();
    }//GEN-LAST:event_jbtnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jbtnCapNhat;
    private javax.swing.JButton jbtnXoa;
    private javax.swing.JLabel jlbMaPhong;
    private javax.swing.JPanel jpnBackground;
    private javax.swing.JRadioButton jrbBaoTri;
    private javax.swing.JRadioButton jrbSanSang;
    private javax.swing.JTextField jtfPhong;
    // End of variables declaration//GEN-END:variables
}
