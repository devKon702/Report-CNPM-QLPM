package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Menu;
import java.awt.Color;
import view.*;

public class NhanVienController {
    private NhanVienPanel root;
    private JPanel mainView;
    private ArrayList<Menu> menu;
    private String choiced;
    public NhanVienController(NhanVienPanel root, JPanel mainView, ArrayList<Menu> menu){
        this.root = root;
        this.mainView = mainView;
        this.menu = menu;
        // Thêm event cho các menu
        for(Menu x: menu){
            x.getJlabel().addMouseListener(new ChooseEvent(x.getName(),x.getJlabel(),x.getJpanel()));
        }
        // Chọn trang chủ làm panel khởi đầu
        this.choiced = "TrangChu";
        ChuyenTrang(root.getTcPanel());
        menu.get(0).getJpanel().setBackground(new Color(235,69,95));
    }
    
    public void ChuyenTrang(JPanel jpn){
        resetMenu();
        mainView.removeAll();
        mainView.setLayout(new BorderLayout());
        mainView.add(jpn);
        mainView.validate();
        mainView.repaint();
    }
    
    public void resetMenu(){
        for(Menu x: menu){
            x.getJpanel().setBackground(new Color(43,52,103));
        }
    }
    
    class ChooseEvent implements MouseListener{
        private String name;
        private JLabel jlb;
        private JPanel jpn;
        public ChooseEvent(String name, JLabel jlb, JPanel jpn){
            this.name = name;
            this.jlb = jlb;
            this.jpn = jpn;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            choiced = this.name;
            switch(choiced){
                case "TrangChu":
                    ChuyenTrang(root.getTcPanel());
                    break;
                case "ThietBi":
                    ChuyenTrang(root.getTbPanel());
                    break;
                case "PhongHoc":
                    ChuyenTrang(root.getPhPanel());
                    break;
                case "ThongKe":
                    ChuyenTrang(root.getTkPanel());
                    break;
                default: break;
            }
            jpn.setBackground(new Color(235,69,95));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(name.equals(choiced)) return;
            this.jpn.setBackground(new Color(0,52,103));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(!this.name.equalsIgnoreCase(choiced)) 
                this.jpn.setBackground(new Color(43,64,103));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!this.name.equalsIgnoreCase(choiced))
                this.jpn.setBackground(new Color(43,52,103));
        }
    }
}
