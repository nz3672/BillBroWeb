package ku.ac.th.billbroweb.service;


import ku.ac.th.billbroweb.model.Crewmate;
import ku.ac.th.billbroweb.model.HistoryPay;
import ku.ac.th.billbroweb.model.TaskParty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class EmailService {
    private JavaMailSender mailSender ;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sent(TaskParty taskParty, Crewmate crewmate, HistoryPay historyPay) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("sarunyasiripirom@gmail.com");
        mailSender.setPassword("iyxfkjdqciuypqal");

        Properties prop = mailSender.getJavaMailProperties();
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        prop.setProperty("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.debug", "true");

        System.out.println(mailSender);
        String body = "Hi!! "+crewmate.getCm_name()+" it's time to pay off my dear friend's debt. \n"+
                "This is an automatic message.\n" +
                "Do not panic, this is your payout record.\n"+
                "Date : " + taskParty.getT_date()+ "\n" +
                "Restaurant : " + taskParty.getT_res()+ "\n" +
                "Amount to pay : " + crewmate.getCm_per_price()+ "\n" +
                "Paid : " + historyPay.getHp_payed();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply@baeldung.com");
        simpleMailMessage.setTo(crewmate.getCm_email());
        simpleMailMessage.setSubject("Email From BillBro");
        simpleMailMessage.setText(body);
        mailSender.send(simpleMailMessage);
    }

}