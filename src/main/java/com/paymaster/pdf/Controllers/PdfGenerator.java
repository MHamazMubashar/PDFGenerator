package com.paymaster.pdf.Controllers;

import com.paymaster.pdf.Service.PdfGeneratorService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/pdf")
public class PdfGenerator {
    @Autowired
    private PdfGeneratorService pdfGeneratorService;


    @PostMapping(value={"/"})
    public ResponseEntity<Response> uploadAWB() throws Exception {
        pdfGeneratorService.createPDF();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
