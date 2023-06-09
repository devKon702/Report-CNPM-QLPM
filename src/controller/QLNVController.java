
package controller;

import dao.NhanVienDAO;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.NhanVien;
import view.NVPanel;
import view.QLNV.CapNhatNV;
import view.QLNV.ThemNV;
public class QLNVController {
    private NVPanel root;
    public QLNVController(NVPanel root){
        this.root = root;
        setEvent();
    }
    
    public void setEvent(){
        
        root.getJtbNhanVien().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = root.getJtbNhanVien().getSelectedRow();
                if(e.getClickCount() == 2 && index != -1){
                    NhanVien a = new NhanVienDAO().get((String)root.getJtbNhanVien().getValueAt(index, 0));
                    if(a.getMa().equals(root.getPr().getMf().getUserName())){
                        JOptionPane.showMessageDialog(root, "Tài khoản hiện tại");
                    }
                    else
                        new CapNhatNV(a,root).setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
            
        });
        
    }
}
