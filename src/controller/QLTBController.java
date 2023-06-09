package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.QLTB.ThemTB;
import view.TBPanel;
import dao.ThietBiDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ThietBi;
import view.NhanVienPanel;
import view.QLTB.XoaSuaTB;

public class QLTBController {

    private TBPanel root;

    public QLTBController(TBPanel root) {
        this.root = root;
        setEvent();
    }

    public void setEvent() {
        root.getJtbThietBi().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && root.getJtbThietBi().getSelectedRow() != -1) {
                    String ma = (String) root.getJtbThietBi().getValueAt(root.getJtbThietBi().getSelectedRow(), 0);
                    ThietBi tb = new ThietBiDAO().getThietBi(ma);
                    if(tb.getMaTrangThai() == 2)
                        JOptionPane.showMessageDialog(root, "Thiết bị đang mượn, tạm thời không thể chỉnh sửa");
                    else
                        new XoaSuaTB(root, tb).setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        root.getJlbTim().addMouseListener(new ButtonAnimation(root.getJlbTim(), root.getJpnTim()));
        root.getJlbThem().addMouseListener(new ButtonAnimation(root.getJlbThem(), root.getJpnThem()));

        root.getJcbRemote().addActionListener(new CheckLoaiAction());
        root.getJcbMicro().addActionListener(new CheckLoaiAction());
        root.getJcbHDMI().addActionListener(new CheckLoaiAction());
        root.getJcbDayMicro().addActionListener(new CheckLoaiAction());
        root.getJcbDayTypeC().addActionListener(new CheckLoaiAction());
        root.getJcbChiaKhoa().addActionListener(new CheckLoaiAction());
        root.getJcbTatCa().addActionListener(new CheckLoaiAction());
        
        root.getJcbDangMuon().addActionListener(new CheckTrangThaiAction());
        root.getJcbHong().addActionListener(new CheckTrangThaiAction());
        root.getJcbSanSang().addActionListener(new CheckTrangThaiAction());
    }

    class ButtonAnimation implements MouseListener {

        private JLabel jlb;
        private JPanel jpn;

        public ButtonAnimation() {
        }

        public ButtonAnimation(JLabel jtf, JPanel jpn) {
            this.jlb = jtf;
            this.jpn = jpn;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(QLTBController.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch (this.jlb.getName()) {
                case "Tim":
                    new Thread(() -> {
                        root.timKiem();
                    }).start();
                    break;
                case "ThemThietBi":
                    new ThemTB(root).setVisible(true);
                    break;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            this.jpn.setBackground(new Color(204, 204, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            this.jpn.setBackground(new Color(153, 204, 255));
        }
    }

    class CheckLoaiAction implements ActionListener {

        public CheckLoaiAction() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox jcb = (JCheckBox) e.getSource();
            if (jcb.getText().equals("Tất cả")) {
                if (jcb.isSelected()) {
                    root.getJcbRemote().setSelected(true);
                    root.getJcbMicro().setSelected(true);
                    root.getJcbHDMI().setSelected(true);
                    root.getJcbDayMicro().setSelected(true);
                    root.getJcbDayTypeC().setSelected(true);
                    root.getJcbChiaKhoa().setSelected(true);
                    root.setDsCheckLoai();
                } else {

                    root.getJcbRemote().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbRemote().getText());

                    root.getJcbMicro().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbMicro().getText());

                    root.getJcbHDMI().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbHDMI().getText());

                    root.getJcbDayMicro().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbDayMicro().getText());

                    root.getJcbDayTypeC().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbDayTypeC().getText());

                    root.getJcbChiaKhoa().setSelected(false);
                    root.getDsCheckLoai().remove(root.getJcbChiaKhoa().getText());

                }
            } else {
                if (jcb.isSelected()) {
                    root.getDsCheckLoai().add(jcb.getText());
                } else {
                    root.getDsCheckLoai().remove(jcb.getText());
                }
            }
        }

    }

    class CheckTrangThaiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox a = (JCheckBox) e.getSource();
            if (a.isSelected()) {
                root.getDsCheckTrangThai().add(a.getText());
            } else {
                root.getDsCheckTrangThai().remove(a.getText());
            }
        }

    }
}
