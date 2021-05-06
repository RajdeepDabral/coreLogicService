package dabral.rajdeep.CoreLogicService.Service.Impl;

import dabral.rajdeep.CoreLogicService.Service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class EmailServiceImpl implements EmailService {
    @Value("${email.host}")
    String host ;
    public Boolean sendEmail(String subject , String message , String to){
        Boolean flag=false;
        String from = "noreply.rajdeepProject@gmail.com";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noreply.rajdeepProject@gmail.com","noreply@rajdeep.1997");
            }
        });

        MimeMessage m  = new MimeMessage(session);
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO , new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            flag=true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}