import java.util.logging.Level;
import java.util.logging.Logger;
import thread.*;
import java.util.*;
import javax.swing.JFrame;
import model.*;
import dao.*;
import java.awt.Frame;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.UIManager;
import model.Mail;
import view.LoadingDialog;
public class test {
    public static void ttt() throws InterruptedException{
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i< 10; i++){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("A");
                }
                
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i< 10; i++){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("B");
                }
                
            }
        });
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
    
    
    public static void main(String args[]) throws InterruptedException, MessagingException {
        
        UIManager.LookAndFeelInfo[] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : lookAndFeelInfos) {
            System.out.println(info.getName());
        
}

        LoadingDialog pg = new LoadingDialog(new JFrame(), "Loading");
        pg.setVisible(true);
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            }
            pg.setVisible(false);
        }).start();
    }
}
