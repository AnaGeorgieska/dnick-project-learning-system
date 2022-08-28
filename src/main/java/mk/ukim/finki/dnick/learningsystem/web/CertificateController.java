package mk.ukim.finki.dnick.learningsystem.web;

import com.lowagie.text.DocumentException;
import mk.ukim.finki.dnick.learningsystem.model.CertificatePDFExporter;
import mk.ukim.finki.dnick.learningsystem.model.User;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.SuccessService;
import mk.ukim.finki.dnick.learningsystem.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private UserService userService;

    @Autowired
    private SuccessService successService;

    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletRequest request, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Certificate_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        String username = request.getRemoteUser();
        User user = userService.findById(username);
        System.out.println(user.toString());

        CertificatePDFExporter exporter = new CertificatePDFExporter(user, successService.calculateFloodTestSuccess(username),
                successService.calculateFireTestSuccess(username), successService.calculateEarthquakeTestSuccess(username),
                successService.calculateTotalSuccess(username));
        exporter.export(response);

    }
}
