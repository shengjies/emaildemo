package com.sj.emaildemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    JavaMailSender jms;


    @RequestMapping("/mail")
    public String toMail(){
        try {
            String sender="1305219970@qq.com";   //这个是发送人的邮箱
            String receiver="809268719@qq.com";  //这个是接受人的邮箱
            String title="约翰福音";    //标题
            String text="【约3:16】“　神爱世人，甚至将他的独生子赐给他们，叫一切信他的，不至灭亡，反得永生。";
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            System.out.println("发送者 ---------------------------");
            System.out.println(sender);
            mailMessage.setFrom(sender);
            System.out.println("接收者 ---------------------------");
            System.out.println(receiver);
            mailMessage.setTo(receiver);
            mailMessage.setSubject(title);
            mailMessage.setText(text);
            jms.send(mailMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "成功";
    }
}
