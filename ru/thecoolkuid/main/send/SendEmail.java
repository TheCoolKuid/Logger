package ru.thecoolkuid.main.send;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ru.thecoolkuid.main.log.LogWithPrint;
 
public class SendEmail {
 
    private String username;
    private String password;
    private Properties props;
    public SendEmail(String username, String password, boolean Auth, boolean StartTLS, String SMTPHost, int port) {
        this.username = username;
        this.password = password;
 
        props = new Properties();
        props.put("mail.smtp.auth", Auth);
        props.put("mail.smtp.starttls.enable", StartTLS);
        props.put("mail.smtp.host", SMTPHost);
        props.put("mail.smtp.port", port);
    }
    public void send(String subject, String text, String fromEmail, String toEmail, File file, boolean useAttachment){
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
        	Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            if(useAttachment){
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            }
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
   
}