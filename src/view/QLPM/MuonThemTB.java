package view.QLPM;

import dao.DAO;
import database.DatabaseHelper;
import database.PhieuMuon;
import database.SinhVien;
import database.ThietBi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.InputValidator;
import view.LoadingDialog;
import view.TCPanel;

/**
 *
 * @author henry
 */
public class MuonThemTB extends javax.swing.JFrame {

    /**
     * Creates new form Them_TB
     */
    public MuonThemTB(TCPanel root) {
        initComponents();
        this.root = root;
        this.tentk = root.getTk();
        this.jlbMaPM.setText(PhieuMuon.laymapm(root.getPhongHocLabel()));
        refresh();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12_mssv = new javax.swing.JLabel();
        jtfMSSV = new javax.swing.JTextField();
        jLabel13_sdt = new javax.swing.JLabel();
        jtfSDT = new javax.swing.JTextField();
        jbtnCapNhat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCTPhieuMuon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3_name_pm = new javax.swing.JLabel();
        jLabel4_mssv_pm = new javax.swing.JLabel();
        jLabel5_tg_muon = new javax.swing.JLabel();
        jLabel6_tg_tra = new javax.swing.JLabel();
        jlbTenSv = new javax.swing.JLabel();
        jlbMSSV = new javax.swing.JLabel();
        jlbNgayMuon = new javax.swing.JLabel();
        jlbHan = new javax.swing.JLabel();
        jLabel15_sdt_pm = new javax.swing.JLabel();
        jlbSDT = new javax.swing.JLabel();
        jLabel17_email_pm = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jLabel_tt = new javax.swing.JLabel();
        jlbMaPM = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlbPhongHoc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlabel_micro = new javax.swing.JLabel();
        jlabel_Remote = new javax.swing.JLabel();
        jlabel_TypeC = new javax.swing.JLabel();
        jlabel_HDMI = new javax.swing.JLabel();
        jbtnMuon = new javax.swing.JButton();
        jPanel_MICRO = new javax.swing.JPanel();
        jPanel_REMOTE = new javax.swing.JPanel();
        jPanel_HDMI = new javax.swing.JPanel();
        jlabel_daymicro = new javax.swing.JLabel();
        jlabel_key = new javax.swing.JLabel();
        jPanel_KEY = new javax.swing.JPanel();
        jPanel_TYPEC = new javax.swing.JPanel();
        jPanel_DAYMICRO = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin phiếu mượn");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12_mssv.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel12_mssv.setText("MSSV");

        jtfMSSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMSSVActionPerformed(evt);
            }
        });

        jLabel13_sdt.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel13_sdt.setText("SĐT");

        jtfSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSDTActionPerformed(evt);
            }
        });

        jbtnCapNhat.setBackground(new java.awt.Color(153, 204, 255));
        jbtnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtnCapNhat.setText("Cập nhật");
        jbtnCapNhat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCapNhatActionPerformed(evt);
            }
        });

        jtbCTPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Thiết bị", "MSSV", "Tên", "Email", "SĐT", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCTPhieuMuon.setRowHeight(30);
        jScrollPane1.setViewportView(jtbCTPhieuMuon);
        if (jtbCTPhieuMuon.getColumnModel().getColumnCount() > 0) {
            jtbCTPhieuMuon.getColumnModel().getColumn(2).setPreferredWidth(100);
            jtbCTPhieuMuon.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel12_mssv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13_sdt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jbtnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13_sdt)
                    .addComponent(jLabel12_mssv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3_name_pm.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3_name_pm.setText("Tên:");

        jLabel4_mssv_pm.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel4_mssv_pm.setText("MSSV:");

        jLabel5_tg_muon.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel5_tg_muon.setText("Lập:");

        jLabel6_tg_tra.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel6_tg_tra.setText("Hạn trả:");

        jlbTenSv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbTenSv.setText("ten");

        jlbMSSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbMSSV.setText("mssv");

        jlbNgayMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbNgayMuon.setText("tgmuon");

        jlbHan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbHan.setText("han");

        jLabel15_sdt_pm.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel15_sdt_pm.setText("SĐT:");

        jlbSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbSDT.setText("sdt");
        jlbSDT.setToolTipText("");

        jLabel17_email_pm.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel17_email_pm.setText("Email:");

        jlbEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbEmail.setText("email");

        jLabel_tt.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel_tt.setForeground(new java.awt.Color(255, 0, 0));

        jlbMaPM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbMaPM.setText("MAPM");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setText("Phiếu mượn:");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel3.setText("Phòng:");

        jlbPhongHoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlbPhongHoc.setText("MAPH");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_tt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbMaPM, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5_tg_muon)
                            .addComponent(jLabel6_tg_tra)
                            .addComponent(jLabel17_email_pm)
                            .addComponent(jLabel3)
                            .addComponent(jLabel3_name_pm)
                            .addComponent(jLabel4_mssv_pm)
                            .addComponent(jLabel15_sdt_pm))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbPhongHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbMSSV, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlbTenSv, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jlbNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlbMaPM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlbPhongHoc))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_name_pm)
                    .addComponent(jlbTenSv))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4_mssv_pm)
                    .addComponent(jlbMSSV))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15_sdt_pm)
                    .addComponent(jlbSDT))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17_email_pm)
                    .addComponent(jlbEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5_tg_muon)
                    .addComponent(jlbNgayMuon))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6_tg_tra)
                    .addComponent(jlbHan))
                .addGap(18, 18, 18)
                .addComponent(jLabel_tt, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jlabel_micro.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_micro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/keyboard_voice.png"))); // NOI18N
        jlabel_micro.setText("Micro");

        jlabel_Remote.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_Remote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/remote_gen.png"))); // NOI18N
        jlabel_Remote.setText("Remote");

        jlabel_TypeC.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_TypeC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/usb.png"))); // NOI18N
        jlabel_TypeC.setText("Cáp TypeC");

        jlabel_HDMI.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_HDMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/settings_input_hdmi.png"))); // NOI18N
        jlabel_HDMI.setText("Cáp HDMI");

        jbtnMuon.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jbtnMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/done_outline.png"))); // NOI18N
        jbtnMuon.setText("Mượn");
        jbtnMuon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMuonActionPerformed(evt);
            }
        });

        jPanel_MICRO.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_MICROLayout = new javax.swing.GroupLayout(jPanel_MICRO);
        jPanel_MICRO.setLayout(jPanel_MICROLayout);
        jPanel_MICROLayout.setHorizontalGroup(
            jPanel_MICROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        jPanel_MICROLayout.setVerticalGroup(
            jPanel_MICROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_REMOTE.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_REMOTELayout = new javax.swing.GroupLayout(jPanel_REMOTE);
        jPanel_REMOTE.setLayout(jPanel_REMOTELayout);
        jPanel_REMOTELayout.setHorizontalGroup(
            jPanel_REMOTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel_REMOTELayout.setVerticalGroup(
            jPanel_REMOTELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_HDMI.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_HDMILayout = new javax.swing.GroupLayout(jPanel_HDMI);
        jPanel_HDMI.setLayout(jPanel_HDMILayout);
        jPanel_HDMILayout.setHorizontalGroup(
            jPanel_HDMILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel_HDMILayout.setVerticalGroup(
            jPanel_HDMILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jlabel_daymicro.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_daymicro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/keyboard_voice.png"))); // NOI18N
        jlabel_daymicro.setText("Dây micro");

        jlabel_key.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jlabel_key.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictrue/keyboard_voice.png"))); // NOI18N
        jlabel_key.setText("Chìa khóa");

        jPanel_KEY.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_KEYLayout = new javax.swing.GroupLayout(jPanel_KEY);
        jPanel_KEY.setLayout(jPanel_KEYLayout);
        jPanel_KEYLayout.setHorizontalGroup(
            jPanel_KEYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel_KEYLayout.setVerticalGroup(
            jPanel_KEYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_TYPEC.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_TYPECLayout = new javax.swing.GroupLayout(jPanel_TYPEC);
        jPanel_TYPEC.setLayout(jPanel_TYPECLayout);
        jPanel_TYPECLayout.setHorizontalGroup(
            jPanel_TYPECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        jPanel_TYPECLayout.setVerticalGroup(
            jPanel_TYPECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel_DAYMICRO.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel_DAYMICROLayout = new javax.swing.GroupLayout(jPanel_DAYMICRO);
        jPanel_DAYMICRO.setLayout(jPanel_DAYMICROLayout);
        jPanel_DAYMICROLayout.setHorizontalGroup(
            jPanel_DAYMICROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel_DAYMICROLayout.setVerticalGroup(
            jPanel_DAYMICROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_HDMI)
                    .addComponent(jPanel_HDMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_daymicro)
                    .addComponent(jPanel_DAYMICRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel_KEY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_key, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabel_micro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel_MICRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jlabel_Remote)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_REMOTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlabel_TypeC)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel_TYPEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(jbtnMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlabel_Remote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel_REMOTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jlabel_TypeC)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jbtnMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel_TYPEC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel_micro)
                            .addComponent(jlabel_key))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_KEY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_MICRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel_daymicro)
                            .addComponent(jlabel_HDMI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_HDMI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_DAYMICRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        jPanel_MICRO.setLayout(new BoxLayout(jPanel_MICRO, BoxLayout.Y_AXIS));
        jPanel_REMOTE.setLayout(new BoxLayout(jPanel_REMOTE, BoxLayout.Y_AXIS));
        jPanel_HDMI.setLayout(new BoxLayout(jPanel_HDMI, BoxLayout.Y_AXIS));
        jPanel_KEY.setLayout(new BoxLayout(jPanel_KEY, BoxLayout.Y_AXIS));
        jPanel_TYPEC.setLayout(new BoxLayout(jPanel_TYPEC, BoxLayout.Y_AXIS));
        jPanel_DAYMICRO.setLayout(new BoxLayout(jPanel_DAYMICRO, BoxLayout.Y_AXIS));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void refresh() {
        PhieuMuon pm = PhieuMuon.getPhieuMuon(jlbMaPM.getText());
        if (pm == null) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy thông tin phiếu mượn");
            return;
        }
        jlbPhongHoc.setText(pm.getMAPHONG());
        jlbTenSv.setText("");
        jlbMSSV.setText("");
        jlbEmail.setText("");
        jlbSDT.setText("");
        jlbNgayMuon.setText(pm.getTHOIDIEMLAP());
        jlbHan.setText(pm.getHAN());

        themThietBi();
        initTable();
    }
    private void jtfMSSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMSSVActionPerformed
        String sc = evt.getActionCommand();
        setmssv(sc);
    }//GEN-LAST:event_jtfMSSVActionPerformed

    private void jtfSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSDTActionPerformed
        String sc = evt.getActionCommand();
    }//GEN-LAST:event_jtfSDTActionPerformed

    private void jbtnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCapNhatActionPerformed
        String name = "";
        jtfMSSV.setText(jtfMSSV.getText().toUpperCase().trim());
        jtfSDT.setText(jtfSDT.getText().trim());
        
        if (jtfMSSV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin sinh viên");
            return;
        }
        SinhVien sv = SinhVien.getSinhVien(jtfMSSV.getText());
        if (sv == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin sinh viên");
            return;
        }
        if(jtfSDT.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Vui lòng điền số điện thoại");
            return;
        }
        if (!InputValidator.validatePhoneNumber(jtfSDT.getText())) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ, phải là chuỗi gồm 0 và 9 kí tự số liền kề");
            return;
        }
        setname(sv.getTEN());
        setmssv(sv.getMSSV());
        setsdt(jtfSDT.getText());
        setemail(sv.getEMAIL());
    }//GEN-LAST:event_jbtnCapNhatActionPerformed
    public void initTable() {
        String sql = "Exec sp_getCTPHIEUMUON '" + jlbMaPM.getText() + "'";
        DefaultTableModel tbModel = (DefaultTableModel) jtbCTPhieuMuon.getModel();
        tbModel.setRowCount(0);
        ResultSet rs = DAO.executeSelectSp(sql);
        try {

            while (rs.next()) {
                tbModel.addRow(new Object[]{rs.getString("TENTB"),
                    rs.getString("MSSV"),
                    rs.getString("TENSV"),
                    rs.getString("EMAIL"),
                    rs.getString("SDT"),
                    (rs.getInt("TRANGTHAI") == 6 ? "Đang mượn" : "Đã trả")});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy thông tin chi tiết phiếu mượn");
            return;
        }
    }

    public void themThietBi() {
        jPanel_DAYMICRO.removeAll();
        jPanel_HDMI.removeAll();
        jPanel_KEY.removeAll();
        jPanel_MICRO.removeAll();
        jPanel_REMOTE.removeAll();
        jPanel_TYPEC.removeAll();
        themHDMI();
        themMicro();
        themKey();
        themRemote();
        themTypec();
        themDayMicro();
    }

    public void themHDMI() {
        Jcheckbox_HDMI = new ArrayList<>();
        String maloai = "HDMI";
        List<ThietBi> lists = new ArrayList<>();

        lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
        lists.addAll(ThietBi.getThietBiChung(maloai));

        int count = 0;
        for (ThietBi a : lists) {
            if (count < 5) {

                if (a.getTRANG_THAI().equals("1")) {
                    JCheckBox n = new JCheckBox();
                    n.setText(a.getMATB());
                    Jcheckbox_HDMI.add(n);
                    jPanel_HDMI.add(n);
                    count++;
                }
            }
        }
        jPanel_HDMI.revalidate();
        jPanel_HDMI.repaint();
    }

    public void themDayMicro() {
        Jcheckbox_DAYMR = new ArrayList<>();

        String maloai = "DMC";
        List<ThietBi> lists = new ArrayList<>();
        try {
            lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
            lists.addAll(ThietBi.getThietBiChung(maloai));
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the data from the database: " + e.getMessage());
            return;
        }
        int count = 0;
        for (ThietBi a : lists) {
            if (count < 5) {

                if (a.getTRANG_THAI().equals("1")) {
                    JCheckBox n = new JCheckBox();
                    n.setText(a.getMATB());
                    Jcheckbox_DAYMR.add(n);
                    jPanel_DAYMICRO.add(n);
                    count++;
                }
            }
        }
        jPanel_DAYMICRO.revalidate();
        jPanel_DAYMICRO.repaint();
    }

    public void themKey() {
        Jcheckbox_KEY = new ArrayList<>();

        String maloai = "KEY";
        List<ThietBi> lists = new ArrayList<>();
        try {
            lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the data from the database: " + e.getMessage());
            return;
        }

        int count = 0;
        for (ThietBi a : lists) {
            if (count == 5) {
                break;
            }
            if (a.getTRANG_THAI().equals("1")) {
                JCheckBox n = new JCheckBox();
                n.setText(a.getMATB());
                n.setSelected(true);
                Jcheckbox_KEY.add(n);
                jPanel_KEY.add(n);
                count++;
            }
        }
        jPanel_KEY.revalidate();
        jPanel_KEY.repaint();
    }

    public void themMicro() {
        Jcheckbox_MICRO = new ArrayList<>();

        String maloai = "MR";
        List<ThietBi> lists = new ArrayList<>();
        try {
            lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the data from the database: " + e.getMessage());
            return;
        }
        int count = 0;
        for (ThietBi a : lists) {
            if (count == 5) {
                break;
            }
            if (a.getTRANG_THAI().equals("1")) {
                JCheckBox n = new JCheckBox();
                n.setText(a.getMATB());
                Jcheckbox_MICRO.add(n);
                jPanel_MICRO.add(n);
                count++;
            }
        }
        jPanel_MICRO.revalidate();
        jPanel_MICRO.repaint();
    }

    public void themRemote() {
        Jcheckbox_REMOTE = new ArrayList<>();

        String maloai = "RM";
        List<ThietBi> lists = new ArrayList<>();
        try {
            lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the data from the database: " + e.getMessage());
            return;
        }
        int count = 0;
        for (ThietBi a : lists) {
            if (count == 5) {
                break;
            }
            if (a.getTRANG_THAI().equals("1")) {
                JCheckBox n = new JCheckBox();
                n.setText(a.getMATB());
                Jcheckbox_REMOTE.add(n);
                jPanel_REMOTE.add(n);
                count++;
            }
        }
        jPanel_REMOTE.revalidate();
        jPanel_REMOTE.repaint();

    }

    public void themTypec() {
        Jcheckbox_TYPEC = new ArrayList<>();

        String maloai = "TYPEC";
        List<ThietBi> lists = new ArrayList<>();
        try {
            lists.addAll(ThietBi.getThietBi(jlbPhongHoc.getText(), maloai));
            lists.addAll(ThietBi.getThietBiChung(maloai));
        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the data from the database: " + e.getMessage());
            return;
        }
        int count = 0;
        for (ThietBi a : lists) {
            if (count <= 5) {
                count++;
                if (a.getTRANG_THAI().equals("1")) {
                    JCheckBox n = new JCheckBox();
                    n.setText(a.getMATB());
                    Jcheckbox_TYPEC.add(n);
                    jPanel_TYPEC.add(n);
                }
            }
        }
        jPanel_TYPEC.revalidate();
        jPanel_TYPEC.repaint();
    }

    public List<String> getSelectedDevice() {
        List<String> list = new ArrayList<>();

        for (JCheckBox a : Jcheckbox_HDMI) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }

        for (JCheckBox a : Jcheckbox_MICRO) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }

        for (JCheckBox a : Jcheckbox_KEY) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }

        for (JCheckBox a : Jcheckbox_REMOTE) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }
        for (JCheckBox a : Jcheckbox_TYPEC) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }
        for (JCheckBox a : Jcheckbox_DAYMR) {

            if (a.isSelected()) {
                list.add(a.getText());
            }
        }

        return list;
    }

    public void sethan(String sc) {
        this.jlbHan.setText(sc);
    }

    public void setname(String sc) {
        this.jlbTenSv.setText(sc);
    }

    public void setmssv(String sc) {
        this.jlbMSSV.setText(sc);
        String email = jlbMSSV.getText();
    }

    public void setsdt(String sc) {
        this.jlbSDT.setText(sc);
    }

    public void setemail(String email) {
        this.jlbEmail.setText(email);
    }

    public void setmapm(String str) {
        this.jlbMaPM.setText(str);
    }

    public void addPhieuMuon() throws SQLException {
        List<String> tb = getSelectedDevice();
        for (String tbb : tb) {
            addCTPhieuMuon(tbb, jlbMaPM.getText());
        }
    }

    public void addCTPhieuMuon(String MaTB, String MaPM) throws SQLException {
        PreparedStatement stmt;
        Connection conn;
        String Mssv = jlbMSSV.getText();

        conn = DatabaseHelper.getConnection();
        String MaTrangThai = "6";
        String Sdt = jlbSDT.getText();
        // Tạo câu lệnh SQL INSERT
        String sql = "INSERT INTO CTPHIEUMUON (MAPM, MATB, TRANGTHAI, MSSV, SDT) VALUES (?, ?, ?, ?, ?)";
        // Tạo đối tượng PreparedStatement để thực hiện câu lệnh SQL
        stmt = conn.prepareStatement(sql);

        // Thiết lập giá trị cho các tham số của câu lệnh SQL INSERT
        stmt.setString(1, MaPM);
        stmt.setString(2, MaTB);
        stmt.setString(3, MaTrangThai);
        stmt.setString(4, Mssv);
        stmt.setString(5, Sdt);

        // Thực hiện câu lệnh SQL INSERT
        stmt.executeUpdate();
        stmt.close();
        conn.close();

    }
    private void jbtnMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMuonActionPerformed
        if (jlbMSSV.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa điền thông tin");
        } else if (getSelectedDevice().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn thiết bị để mượn");
        } else {
            int confirmed = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn xác nhận mượn",
                    "Xác nhận yêu cầu",
                    JOptionPane.YES_NO_OPTION);

            if (confirmed == JOptionPane.YES_OPTION) {
                try {
                    addPhieuMuon();
                    LoadingDialog ld = new LoadingDialog(this, "Đang cập nhật");
                    new Thread(()->{
                        ld.setVisible(true);
                    }).start();
                    themThietBi();
                    initTable();
                    root.getPr().getTbPanel().filterRows();
                    root.getPr().getTkPanel().filterRows();
                    ld.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Mượn thêm thành công");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi mượn thêm " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jbtnMuonActionPerformed
    
    private TCPanel root;
    private String mapm;
    private String maphong;
    private final String tentk;
    private List<JCheckBox> Jcheckbox_HDMI;
    private List<JCheckBox> Jcheckbox_REMOTE;
    private List<JCheckBox> Jcheckbox_TYPEC;
    private List<JCheckBox> Jcheckbox_MICRO;
    private List<JCheckBox> Jcheckbox_DAYMR;
    private List<JCheckBox> Jcheckbox_KEY;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12_mssv;
    private javax.swing.JLabel jLabel13_sdt;
    private javax.swing.JLabel jLabel15_sdt_pm;
    private javax.swing.JLabel jLabel17_email_pm;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel3_name_pm;
    private javax.swing.JLabel jLabel4_mssv_pm;
    private javax.swing.JLabel jLabel5_tg_muon;
    private javax.swing.JLabel jLabel6_tg_tra;
    private javax.swing.JLabel jLabel_tt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel_DAYMICRO;
    private javax.swing.JPanel jPanel_HDMI;
    private javax.swing.JPanel jPanel_KEY;
    private javax.swing.JPanel jPanel_MICRO;
    private javax.swing.JPanel jPanel_REMOTE;
    private javax.swing.JPanel jPanel_TYPEC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCapNhat;
    private javax.swing.JButton jbtnMuon;
    private javax.swing.JLabel jlabel_HDMI;
    private javax.swing.JLabel jlabel_Remote;
    private javax.swing.JLabel jlabel_TypeC;
    private javax.swing.JLabel jlabel_daymicro;
    private javax.swing.JLabel jlabel_key;
    private javax.swing.JLabel jlabel_micro;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbHan;
    private javax.swing.JLabel jlbMSSV;
    private javax.swing.JLabel jlbMaPM;
    private javax.swing.JLabel jlbNgayMuon;
    private javax.swing.JLabel jlbPhongHoc;
    private javax.swing.JLabel jlbSDT;
    private javax.swing.JLabel jlbTenSv;
    private javax.swing.JTable jtbCTPhieuMuon;
    private javax.swing.JTextField jtfMSSV;
    private javax.swing.JTextField jtfSDT;
    // End of variables declaration//GEN-END:variables
}
