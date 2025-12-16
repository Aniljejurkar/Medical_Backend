package Medical_Coding.service;

import Medical_Coding.model.Lead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${admin.email}")
    private String adminEmail;

    // ✅ Constructor injection
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendLeadNotification(Lead lead) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminEmail);
        message.setSubject("New Lead Received");
        message.setText(
                "New user submitted details:\n\n" +
                        "Email: " + lead.getEmail() + "\n" +
                        "Phone: " + lead.getPhone()
        );

        mailSender.send(message);
    }
}
