package com.paymaster.pdf.Utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
public class PdfGeneratorUtil {

    @Autowired
    private TemplateEngine templateEngine;

    public void createPdf(String templateName, Map<String, Object> map,String pdfFileName) throws Exception {
        try {
            log.info("START PDF CREATED");
            final String TMP_DIR = new File("src//main//resources//static//PayMaster").getAbsolutePath();
            final String Custom_UUID = UUID.randomUUID().toString();

            Context context = new Context();
            context.setVariables(map);
            String htmlContent = templateEngine.process(templateName, context);
            log.info("PDF FILE NAME {}",Custom_UUID+"_" + pdfFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(TMP_DIR+"/"+Custom_UUID+"_" + pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(fileOutputStream, false);
            renderer.finishPDF();

        }catch (Exception e){
            log.info("Exception while PDF Generator {}",e.getCause().getCause().getLocalizedMessage());
            throw new Exception(e);
        }

    }
}
