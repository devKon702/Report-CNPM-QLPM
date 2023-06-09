
package cnpm;

//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.UIManager;
import view.MainFrame;




public class CNPM {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :  javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
            
            MainFrame a = new MainFrame();
            a.setVisible(true);
//               NewJFrame a = new NewJFrame();
               
    }
    
}
