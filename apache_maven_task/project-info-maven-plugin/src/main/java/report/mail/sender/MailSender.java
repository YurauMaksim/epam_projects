package report.mail.sender;

import constants.Constants;
import exceptions.ReportNotFoundException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
    public void sendMail(final String username, final String password, final String theme) throws ReportNotFoundException {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(username)
            );

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();


            File f = new File(Constants.REPORT_PATH);
            attachmentPart.attachFile(f);

            textPart.setText(Constants.EMPTY_STRING);
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);
            message.setSubject(theme + Constants.INSTALL_CONDITION);
            message.setContent(multipart);
            Transport.send(message);

        }catch (IOException e){
            e.printStackTrace();
        }
        catch (MessagingException e) {
            if(e.getNextException().getCause().equals(new FileNotFoundException()))
                throw new ReportNotFoundException();
            else
                e.printStackTrace();
        }

    }
}

