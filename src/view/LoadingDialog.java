package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class LoadingDialog extends JDialog {
    private static final long serialVersionUID = 1L;
    private final JProgressBar progressBar;

    public LoadingDialog(JFrame parent, String title) {
//        setTitle(title);
        super(parent, title);

        // Tạo label hiển thị tiêu đề
        JLabel label = new JLabel("Vui lòng chờ.....");
        label.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Tạo progress bar
        progressBar = new JProgressBar(0, 100);
        
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(true);

        // Tạo panel chứa label và progress bar
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(progressBar, BorderLayout.CENTER);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Thiết lập kích thước cho dialog
        setPreferredSize(new Dimension(300, 100));

        // Thêm panel vào dialog
        setContentPane(panel);

        // Khởi tạo dialog với kích thước và vị trí mặc định
        pack();
        setLocationRelativeTo(parent);
    }
}
