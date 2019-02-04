package javamail;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class ReceptDemo {

    //收件人地址
    public static String recipientAddress = "354793818@qq.com";
    //收件人账户名
    public static String recipientAccount = "354793818";
    //收件人账户密码
    public static String recipientPassword = "ppivoimibbupcafc";

    public static void main(String[] args) throws Exception {
        //1、连接邮件服务器的参数配置
        Properties props = new Properties();
        //设置传输协议
        props.setProperty("mail.store.protocol", "pop3");
        //设置收件人的POP3服务器
        props.setProperty("mail.pop3.host", "pop.qq.com");

        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        props.setProperty("mail.pop3.auth", "true");
        //2、创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getInstance(props);

        //设置调试信息在控制台打印出来
        //session.setDebug(true);

        Store store = session.getStore("pop3");
        //连接收件人POP3服务器
        store.connect("pop.qq.com", recipientAccount, recipientPassword);
        //获得用户的邮件账户，注意通过pop3协议获取某个邮件夹的名称只能为inbox
        Folder folder = store.getFolder("inbox");
        //设置对邮件账户的访问权限
        folder.open(Folder.READ_WRITE);

        //得到邮件账户的所有邮件信息
        Message[] messages = folder.getMessages();
        for(int i = 0 ; i < messages.length ; i++){
            //获得邮件主题
            String subject = messages[i].getSubject();
            //获得邮件发件人
            Address[] from = messages[i].getFrom();
            //获取邮件内容（包含邮件内容的html代码）

            if (messages[i].getContent() instanceof String) {
                System.out.println((messages[i].getContent()));
            } else if (messages[i].getContent() instanceof MimeMultipart) {
                System.out.println("附件");
            }


        }

        //关闭邮件夹对象
        folder.close(true);
        //关闭连接对象
        store.close();
    }
}
