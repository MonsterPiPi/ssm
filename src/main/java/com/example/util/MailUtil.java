package com.example.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2017/12/31
 * Time : 10:34
 * Talk is cheap. Show me the code.
 */
public class MailUtil {

    /**
     * 发送邮件的方法
     * @param to 给谁发邮件
     * @param code 邮件的激活码
     */
    public static void sendMail(String to,String code) throws GeneralSecurityException, MessagingException {
        String from = "51103942@qq.com";// 发件人电子邮箱
        String host = "smtp.qq.com"; // 指定发送邮件的主机smtp.qq.com(QQ)|smtp.163.com(网易)
        //1.创建连接对象，连接到邮箱服务器
        Properties props=new Properties();
        props.setProperty("mail.smtp.host", host);// 设置邮件服务器
        props.setProperty("mail.smtp.auth", "true");// 打开认证
        //QQ邮箱需要下面这段代码，163邮箱不需要
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);
        // 1.获取默认session对象
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("51103942@qq.com", "jtmoybnwknrnbjha"); // 发件人邮箱账号、授权码
            }
        });
        //2.创建邮件对象
        Message message=new MimeMessage(session);
        //2.1设置发件人
        message.setFrom(new InternetAddress(from));
        //2.2设置收件人
        message.addRecipient(RecipientType.TO, new InternetAddress(to));
        //2.3设置邮件的主题
        message.setSubject("您的注册验证码邮件");
        //2.4设置邮件的正文
        message.setContent("<font color='gray' size='3'>尊敬的用户，您好：<br>请点击以下链接进行激活</font><br><br><br>"+
                "<font  size='3'>" + "http://localhost:8080/MyHotel/login.html"+"</font><br/><br/><br>" +
                "<font color='gray' size='3'>如有疑虑请详询400-069-2886（客服电话）【XXX中心】</font>", "text/html;charset=UTF-8");
        //3发送一封激活邮件
        Transport.send(message);
        System.out.println("邮件成功发送!");
    }


    //测试
    @Test
    public void testSendEmail() throws Exception{
        sendMail("51103942@qq.com",createRandomVcode());
    }
    /**
     * 随机生成6位随机验证码
     * 方法说明
     */
    public static String createRandomVcode(){
        //验证码
        String vcode = "";
        for (int i = 0; i < 6; i++) {
            vcode = vcode + (int)(Math.random() * 9);
        }
        return vcode;
    }
}
