
package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.AdminPanel;

public class AdminController {
    private AdminPanel root;
    private String choiced;
    
    public AdminController(AdminPanel root){
        this.root = root;
        setEvent();
        
        this.choiced = "NhanVien";
        ChuyenTrang(root.getNvPanel());
        root.getJpnNhanVien().setBackground(new Color(153,255,153));
    }
    
    
    public void setEvent(){
        
        root.getJlbNhanVien().addMouseListener(new ButtonAnimation(root.getJlbNhanVien(),root.getJpnNhanVien()));
        root.getJlbThongKePM().addMouseListener(new ButtonAnimation(root.getJlbThongKePM(),root.getJpnThongKePM()));
        root.getJlbThongKeTB().addMouseListener(new ButtonAnimation(root.getJlbThongKeTB(),root.getJpnThongKeTB()));
        root.getJlbThongKePH().addMouseListener(new ButtonAnimation(root.getJlbThongKePH(),root.getJpnThongKePH()));
    }
    public void ChuyenTrang(JPanel jpn){
        root.getJpnNhanVien().setBackground(new Color(43,52,103));
        root.getJpnThongKePM().setBackground(new Color(43,52,103));
        root.getJpnThongKeTB().setBackground(new Color(43,52,103));
        root.getJpnThongKePH().setBackground(new Color(43,52,103));
        JPanel mv = root.getJpnMainView();
        mv.removeAll();
        mv.setLayout(new BorderLayout());
        mv.add(jpn);
        mv.validate();
        mv.repaint();
    }
    
    class ButtonAnimation implements MouseListener{
        private JLabel jlb;
        private JPanel jpn;
        
        public ButtonAnimation(JLabel jlb, JPanel jpn){
            this.jlb = jlb;
            this.jpn = jpn;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            // Reset menu
            root.getJpnNhanVien().setBackground(new Color(43,52,103));
            choiced = this.jlb.getName();
            switch(choiced){
                case "NhanVien":
                    ChuyenTrang(root.getNvPanel());
                    break;
                case "ThongKe":
                    ChuyenTrang(root.getTkPanel());
                    break;
                case "ThietBi":
                    ChuyenTrang(root.getTbPanel());
                    break;
                case "PhongHoc":
                    ChuyenTrang(root.getPhPanel());
                    break;
                default: break;
            }
            
            this.jpn.setBackground(new Color(153,255,153));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(!this.jlb.getName().equals(choiced)) this.jpn.setBackground(new Color(153,193,153));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(!this.jlb.getName().equals(choiced)) this.jpn.setBackground(new Color(43,64,103));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!this.jlb.getName().equals(choiced)) this.jpn.setBackground(new Color(43,52,103));
        }
        
    }
}
