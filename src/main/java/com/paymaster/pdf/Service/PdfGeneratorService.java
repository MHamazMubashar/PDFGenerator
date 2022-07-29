package com.paymaster.pdf.Service;

import com.paymaster.pdf.Utils.PdfGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PdfGeneratorService {

    @Autowired
    private PdfGeneratorUtil pdfGeneratorUtil;

    public void createPDF() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("name","MasterPdf");
        data.put("pages",50);
        pdfGeneratorUtil.createPdf("payMasterPdf",data,"Aggrement.pdf");
    }
}
