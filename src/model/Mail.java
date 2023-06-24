package model;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail {
    
    public static String userMail = "nnk070dev@gmail.com";
    public static String passWord = "ampdvhevxfarostq";

    public static void sendPasswordToEmail(String emailAddress, String text) throws MessagingException {

        String host = "smtp.gmail.com";
        String port = "587";
        // Thiết lập thông tin email người gửi: userMail, password

        // Thiết lập thông tin người nhận email
        String toEmail = emailAddress;

        // Thiết lập tiêu đề và nội dung email
        String subject = "Password Recovery";
        String body = text;

        // Thiết lập cấu hình kết nối đến email server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Tạo đối tượng Session để kết nối đến email server
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userMail, passWord);
            }
        });

        // Tạo đối tượng Message để gửi email
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userMail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        // Gửi email
        Transport.send(message);
        System.out.println("Gửi mail thành công");
    }

    public static void sendMessageOutOfDate(String emailAddress, ArrayList<String> tb, String phong, String han) throws AddressException, MessagingException {
        // Thông tin tài khoản email: userMail, passWord

        // Thông tin người nhận
        String toEmail = emailAddress;

        // Cấu hình kết nối SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo đối tượng Session để gửi email
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userMail, passWord);
            }
        });

        // Tạo đối tượng Message để cấu hình nội dung email
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userMail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Thông báo về phiếu mượn quá hạn");

        // Cấu hình nội dung email
        String content = "Chào bạn,\n\n";
        content += "Hiện bạn đang có một phiếu mượn quá hạn (" + han + ") chưa hoàn tất việc hoàn trả:"
                + "\nPhòng: " + phong
                + "\nCác thiết bị bao gồm: ";
        for(String x : tb){
            content+= x+", ";
        }
        content += "\nVui lòng nhanh chóng hoàn tất việc hoàn trả các thiết bị này cho phòng CSVC";
        content += "\nNếu bạn đã trả và vẫn nhận được email này, vui lòng liên hệ với phòng CSVC để giải quyết vấn đề này.\n\n";
        content += "Trân trọng,\n";
        content += "[Phòng Cơ Sở Vật Chất]";
        content += "Học Viện Công Nghệ Bưu Chính Viễn Thông cơ sở TPHCM";

        message.setText(content);

        // Gửi email
        Transport.send(message);
        System.out.println("Gửi mail thành công");
    }
    
    public static void setEmail(String email){
        userMail = email;
    }
    public static void setMailPassword(String pass){
        passWord = pass;
    }
}
