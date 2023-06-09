
package model;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu {
    private String name;
    private JLabel jlabel;
    private JPanel jpanel;

    public Menu(String name, JLabel jlabel, JPanel jpanel){
        this.name = name;
        this.jlabel = jlabel;
        this.jpanel = jpanel;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JLabel getJlabel() {
        return jlabel;
    }


    public void setJlabel(JLabel jlabel) {
        this.jlabel = jlabel;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }
    
    
}
