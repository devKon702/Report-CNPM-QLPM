package view.QLTB;

import dao.LoaiDAO;
import dao.PhongHocDAO;
import dao.ThietBiDAO;
import javax.swing.JOptionPane;
import model.ThietBi;
import view.TBPanel;

public class ThemTB extends javax.swing.JFrame {

    private TBPanel pr;

    public ThemTB(TBPanel pr) {
        initComponents();
        this.pr = pr;
        this.setLocationRelativeTo(null);
    }
//    public void setEvent(){   
//        jlbThem.addMouseListener(new MouseListener(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                String loai = (String)jcbLoai.getSelectedItem();
//                String ten = jtfTen.getText();
//                String phong = jtfPhong.getText().toUpperCase().trim();
//                String error = "";
//                if(ten.length() == 0) error+="Tên không được bỏ trống\n";
//                if(phong.length() != 0 && new PhongHocDAO().getPhongHoc(phong) == null) error+="Không tìm thấy phòng học";
//                if(!error.equals("")){
//                    JOptionPane.showMessageDialog(jpnThemThietBi, error);
//                }
//                else{
//                    if(new ThietBiDAO().insert(new ThietBi(null, ten, new LoaiDAO().getMaLoai(loai), phong.length()==0?null:phong, 1))){
//                        JOptionPane.showMessageDialog(jpnThemThietBi, "Thêm thành công");
//                        new Thread(() -> {
//                            pr.filterRows();// Làm mới màn hình hiển thị hiện tại
//                        }).start();
//                        new Thread(() -> {
//                            pr.getPr().getPhPanel().initTable();
//                        }).start();
//                    }
//                    else JOptionPane.showMessageDialog(jpnThemThietBi, "Lỗi thêm thiết bị");
//                }
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                jpnThem.setBackground(new Color(227,204,255));
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                jpnThem.setBackground(new Color(204,204,255));
//            }
//        });
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jpnThemThietBi = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jcbLoai = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jtfPhong = new javax.swing.JTextField();
        jbtnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm thiết bị");
        setAlwaysOnTop(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel1.setText("Tên");

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel2.setText("Loại");

        jLabel4.setFont(new java.awt.Font("Montserrat Medium", 1, 12)); // NOI18N
        jLabel4.setText("Phòng");

        jbtnThem.setBackground(new java.awt.Color(204, 204, 255));
        jbtnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbtnThem.setText("THÊM");
        jbtnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnThemThietBiLayout = new javax.swing.GroupLayout(jpnThemThietBi);
        jpnThemThietBi.setLayout(jpnThemThietBiLayout);
        jpnThemThietBiLayout.setHorizontalGroup(
            jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThemThietBiLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThemThietBiLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jcbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jpnThemThietBiLayout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtfPhong))
                        .addGroup(jpnThemThietBiLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(jbtnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnThemThietBiLayout.setVerticalGroup(
            jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnThemThietBiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jpnThemThietBiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jpnThemThietBiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        for(String x : new LoaiDAO().getTenLoai()){
            jcbLoai.addItem(x);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnThemThietBi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnThemThietBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnThemActionPerformed
        String loai = (String) jcbLoai.getSelectedItem();
        String ten = jtfTen.getText().trim();
        String phong = jtfPhong.getText().toUpperCase().trim();

        if (ten.length() > 50) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên dưới 50 kí tự");
            return;
        }
        if (ten.matches("[^A-Za-z0-9 ]")) {
            JOptionPane.showMessageDialog(this, "Tên thiết bị không chứa kí tự đặc biệt");
            return;
        }
        if (phong.length() != 0 && new PhongHocDAO().getPhongHoc(phong) == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy phòng");
            return;
        }

        if (new ThietBiDAO().insert(new ThietBi(null, ten, new LoaiDAO().getMaLoai(loai), phong.length() == 0 ? null : phong, 1))) {
            JOptionPane.showMessageDialog(jpnThemThietBi, "Thêm thành công");
            new Thread(() -> {
                pr.filterRows();// Làm mới màn hình hiển thị hiện tại
            }).start();
            new Thread(() -> {
                pr.getPr().getPhPanel().filterRows();
            }).start();
        } else {
            JOptionPane.showMessageDialog(jpnThemThietBi, "Lỗi thêm thiết bị");
        }

    }//GEN-LAST:event_jbtnThemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtnThem;
    private javax.swing.JComboBox<String> jcbLoai;
    private javax.swing.JPanel jpnThemThietBi;
    private javax.swing.JTextField jtfPhong;
    private javax.swing.JTextField jtfTen;
    // End of variables declaration//GEN-END:variables
}
