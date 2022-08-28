package mk.ukim.finki.dnick.learningsystem.service.implementation;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.EmailSenderService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    @Autowired
    private final JavaMailSender mailSender;


    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String toEmail, String subject, String body, User user, double floodS,
                          double fireS, double earthS, double total){

//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//        mimeMessageHelper.setFrom("disastersapp@gmail.com");
//        mimeMessageHelper.setTo("anageorgieska@gmail.com");
//        mimeMessageHelper.setText(body);
//        mimeMessageHelper.setSubject(subject);
//
//        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
//        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
//                fileSystemResource);
//
//        mailSender.send(mimeMessage);
//        System.out.println("Mail sent successfully...");



        String smtpHost = "smtp.gmail.com"; //replace this with a valid host
        int smtpPort = 587; //replace this with a valid port

        Properties properties = new Properties();
//        properties.put("mail.smtp.host", smtpHost);
//        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.debug", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "disastersapp@gmail.com", "zdjwwfvsylqtcphe");// Specify the Username and the PassWord
                    }
                });

        ByteArrayOutputStream outputStream = null;

        try {
            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(body);

            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(outputStream,  user,  floodS,
             fireS,  earthS,  total);
            byte[] bytes = outputStream.toByteArray();

            //construct the pdf body part
            DataSource dataSource = (DataSource) new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler((javax.activation.DataSource) dataSource));
            pdfBodyPart.setFileName("certificate.pdf");

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress("disastersapp@gmail.com");
            InternetAddress iaRecipient = new InternetAddress(user.getUsername());

            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
            mimeMessage.setContent(mimeMultipart);

            //send off the email
            Transport.send(mimeMessage);

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if(null != outputStream) {
                try { outputStream.close(); outputStream = null; }
                catch(Exception ex) { }
            }
        }

    }


    public void writePdf(OutputStream outputStream, User user, double floodS,
                         double fireS, double earthS, double total) throws Exception {

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(20);
        Color c=new Color(120,53,161);
        font.setColor(c);

        Paragraph p = new Paragraph("CERTIFICATE", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());
        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setSize(12);
        font.setColor(Color.BLACK);

        p = new Paragraph(currentDateTime, font);
        p.setAlignment(Paragraph.ALIGN_RIGHT);
        p.setSpacingBefore(10);
        p.setSpacingAfter(10);

        document.add(p);


        String quote="\"We cannot stop natural disasters but we can arm ourselves with knowledge: so many lives wouldn't have to be lost if there was enough disaster preparedness.\"";

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setStyle(Font.ITALIC);
        font.setSize(12);
        font.setColor(c);

        p = new Paragraph(quote, font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        p.setSpacingBefore(10);

        document.add(p);


        String author="-Carl Sagan";

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setStyle(Font.ITALIC);
        font.setSize(12);
        c=new Color(215,163,247);
        font.setColor(c);

        p = new Paragraph(author, font);
        p.setAlignment(Paragraph.ALIGN_LEFT);
        p.setSpacingAfter(10);

        document.add(p);


        String pres="This certificate is proudly presented to ";

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setStyle(Font.NORMAL);
        font.setSize(12);
        c=Color.BLACK;
        font.setColor(c);

        p = new Paragraph(pres, font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        p.setSpacingAfter(10);
        p.setSpacingBefore(10);

        document.add(p);
        String nameAndSurname= user.getName() + " " + user.getSurname();

        font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setStyle(Font.ITALIC);
        font.setSize(18);
        c=Color.BLACK;
        font.setColor(c);

        p = new Paragraph(nameAndSurname, font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        p.setSpacingAfter(10);
        p.setSpacingBefore(10);

        document.add(p);
        String person="person above has completed disaster courses in excellence.";

        font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setStyle(Font.NORMAL);
        font.setSize(12);
        c=Color.BLACK;
        font.setColor(c);

        p = new Paragraph(person, font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        p.setSpacingAfter(20);
        p.setSpacingBefore(10);

        document.add(p);


        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {6f, 6f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table,  floodS,
         fireS,  earthS,  total);

        document.add(table);

        document.close();
    }
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(new Color(120,53,161));
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);


        cell.setPhrase(new Phrase("Course", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Result", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table, double floodS,
                                double fireS, double earthS, double total) {
        table.addCell("Flood disaster");
        table.addCell(String.valueOf(floodS)+ "%");
        table.addCell("Fire disaster");
        table.addCell(String.valueOf(fireS)+ "%");
        table.addCell("Earthquake");
        table.addCell(String.valueOf(earthS)+ "%");
        table.addCell("Total:");
        table.addCell(String.valueOf(total) + "%");
    }


    public void sendEmailWithAttachment(String toEmail,
                                        String body,
                                        String subject,
                                        String attachment) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("disastersapp@gmail.com");
        mimeMessageHelper.setTo("anageorgieska@gmail.com");
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
                fileSystemResource);

        mailSender.send(mimeMessage);
        System.out.println("Mail sent successfully...");

    }
}
