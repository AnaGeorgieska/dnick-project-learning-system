package mk.ukim.finki.dnick.learningsystem.model;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CertificatePDFExporter {
    private User user;

    private double floodSuccess;
    private double fireSuccess;
    private double earthquakeSuccess;
    private double totalSuccess;

    public CertificatePDFExporter(User user, double floodSuccess, double fireSuccess, double earthquakeSuccess, double totalSuccess) {
        this.user=user;
        this.floodSuccess=floodSuccess;
        this.fireSuccess=fireSuccess;
        this.earthquakeSuccess=earthquakeSuccess;
        this.totalSuccess=totalSuccess;
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

    private void writeTableData(PdfPTable table) {
        table.addCell("Flood disaster");
        table.addCell(String.valueOf(floodSuccess)+ "%");
        table.addCell("Fire disaster");
        table.addCell(String.valueOf(fireSuccess)+ "%");
        table.addCell("Earthquake");
        table.addCell(String.valueOf(earthquakeSuccess)+ "%");
        table.addCell("Total:");
        table.addCell(String.valueOf(totalSuccess) + "%");
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

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
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
