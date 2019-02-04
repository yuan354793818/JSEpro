package javamail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class JavaMailSenderDemo {

    //发件人地址
    public static String senderAddress = "2748579331@qq.com";
    //收件人地址
    public static String recipientAddress = "354793818@qq.com";
    public static void main(String[] args) throws IOException, MessagingException {


        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\resources\\mail.properties"));

        Session session = Session.getInstance(properties);
        session.setDebug(true);

        Message message = getMessage(session);

        Transport transport = session.getTransport();

        transport.connect("2748579331", "nkzgepxbnzqkdeej");

        transport.sendMessage(message,message.getAllRecipients());

        transport.close();


    }

    public static Message getMessage(Session session) throws MessagingException, IOException {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(senderAddress));

        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));

        message.setSubject("JAVA MAIL TEST","UTF-8");

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.attachFile(new File("C:\\Users\\YJY.DESKTOP-KNFMEQ7\\Desktop\\myblog.sql"));

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);

        //设置邮件正文
        message.setContent(multipart);
        //设置邮件的发送时间,默认立即发送
        message.setSentDate(new Date());


        return message;
    }
}
