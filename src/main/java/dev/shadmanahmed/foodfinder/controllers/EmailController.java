package dev.shadmanahmed.foodfinder.controllers;

import dev.shadmanahmed.foodfinder.model.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


@RestController
public class EmailController {

    @Value("${mailtrap_username}")
    private String username;
    @Value("${mailtrap_password}")
    private String password;

    @RequestMapping(value="/send", method= RequestMethod.POST)
    public String sendEmail(@RequestBody Email emailmessage) throws AddressException, MessagingException, IOException {
        sendmail(emailmessage);
        return "Email sent successfully";
    }

    private void sendmail (Email emailmessage) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo_address()));
        msg.setSubject(emailmessage.getSubject());
        msg.setContent(emailmessage.getBody(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailmessage.getBody(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("/Users/shadman/Desktop/Screen Shot 2020-12-31 at 3.20.15 PM.png");
//
//        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);

        Transport.send(msg);

    }

}
