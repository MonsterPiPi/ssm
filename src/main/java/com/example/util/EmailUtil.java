package com.example.util;

import org.junit.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * Created by LiQian_Nice on 2018/3/1
 */
public class EmailUtil {


    public static boolean sendTextEmail(String userMail,String title,String message) {
        boolean flag=false;
        //
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // 参考QQ邮箱帮助中心
        mailSender.setHost("smtp.qq.com"); // QQ邮箱smtp发送服务器地址
        //mailSender.setPort(465); // QQ这个端口不可用
        mailSender.setPort(587);// 端口号
        mailSender.setUsername("51103942@qq.com"); // 使用你自己的账号
        mailSender.setPassword("jtmoybnwknrnbjha"); // 授权码-发短信获取
        // 邮件信息
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("51103942@qq.com"); // 发件人邮箱
        msg.setTo(userMail); // 收件人邮箱
        msg.setSubject(title); // 标题
        msg.setText(message); // 文本信息
        try {
            mailSender.send(msg);
            flag=true;
            System.out.println("邮件发送成功!"); // 没有报错就是好消息 :-)
            return flag;
        } catch (MailException ex) {
            System.err.println("发送失败:" + ex.getMessage());
        }
        return flag;
    }

    public static void main(String[] agrs){
        EmailUtil.sendTextEmail("51103942@qq.com","2","2");
    }
}
