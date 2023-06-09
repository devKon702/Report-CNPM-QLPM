
package controller;
import dao.TrangThaiDAO;
import dao.PhongHocDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.PhongHoc;
import view.PHPanel;
import view.QLPH.XoaSuaPH;

public class QLPHController {
    private PHPanel root;

    public QLPHController(PHPanel root) {
        this.root = root;
        setEvent();
    }
    
    public void setEvent(){
        ActionListener checkBoxCtrl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox jcb = (JCheckBox) e.getSource();
                if(jcb.isSelected()){
                    root.getCheckTrangThai().add(jcb.getText());
                }
                else 
                    for(String x : root.getCheckTrangThai()){
                        if(x.equals(jcb.getText())){
                            root.getCheckTrangThai().remove(x);
                            break;
                        }
                        
                    }
            }
        };
        root.getJcb1().addActionListener(checkBoxCtrl);
        root.getJcb2().addActionListener(checkBoxCtrl);
        root.getJcb3().addActionListener(checkBoxCtrl);
        
        root.getJtbPhongHoc().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && root.getJtbPhongHoc().getSelectedRow() != -1){
                    String maPhong = (String)root.getJtbPhongHoc().getValueAt(root.getJtbPhongHoc().getSelectedRow(), 0);
                    PhongHoc ph = new PhongHocDAO().getPhongHoc(maPhong);
                    if(new TrangThaiDAO().getTenTrangThai(ph.getMaTrangThai()).equals("Đang mượn")){
                        JOptionPane.showMessageDialog(root, "Phòng học đang được mượn");
                    }
                    else{
                        new XoaSuaPH(root,ph).setVisible(true);
                    }
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
    }
}
