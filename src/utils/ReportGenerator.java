/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dataclasses.CustomerDto;
import dataclasses.QuotationDetailsDto;
import dataclasses.QuotationMasterDto;
import dataclasses.RegistrationDto;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sreenath
 */
public class ReportGenerator {
    private static final String QUOT_HEADER         = "$#$QuotHeader$#$";
    private static final String COMPANY_NAME        = "$#$CompanyName$#$";
    private static final String OWNER_NAME          = "$#$OwnerName$#$";
    private static final String OWNER_PHONE         = "$#$OwnerPhone$#$";
    private static final String COMPANY_LOGO_PATH   = "$#$CompanyLogoPath$#$";
    private static final String CUSTOMER_NAME       = "$#$CustomerName$#$";
    private static final String CUSTO_COMPANY_NAME  = "$#$CustomerCompanyName$#$";
    private static final String CUSTOMER_ADDRESS1   = "$#$Address1$#$";
    private static final String CUSTOMER_ADDRESS2   = "$#$Address2$#$";
    private static final String CUSTOMER_PHONE      = "$#$CustomerPhone$#$";
    private static final String QUOTATION_REFERENCE = "$#$QuotationReference$#$";
    private static final String QUOT_DATE           = "$#$QuotDate$#$";
    private static final String QUOT_TYPE           = "$#$QuotType$#$";
    private static final String QUOT_MATERIALS      = "$#$QuotMaterials$#$";
    
    private static final String QUOT_MATERIALS_TEMPLATE = "<tr><td>%x</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
    
    
    public static String generateQuotationReport(QuotationMasterDto quotDto, RegistrationDto regDto, CustomerDto customerDto, String quotType) {
        try {
            String output = Constants.QUOTATION_REPORT_PATH + quotDto.getReferenceNo() + ".pdf";
            
            String content = new String(Files.readAllBytes(new File(Constants.PRINT_TEMPLATE_PATH + "QuotationTemplate.html").toPath()));
            
            content = content.replace(QUOT_HEADER, quotDto.getTitle());
            
            content = content.replace(COMPANY_NAME, regDto.getCompanyName());
            content = content.replace(OWNER_NAME, regDto.getName());
            content = content.replace(OWNER_PHONE, regDto.getPhoneNumber());
            
            content = content.replace(COMPANY_LOGO_PATH, regDto.getCompanyLogo());
            
            content = content.replace(CUSTOMER_NAME, customerDto.getName());
            content = content.replace(CUSTO_COMPANY_NAME, customerDto.getCompanyName());
            content = content.replace(CUSTOMER_ADDRESS1, customerDto.getAddress1());
            content = content.replace(CUSTOMER_ADDRESS2, customerDto.getAddress2());
            content = content.replace(CUSTOMER_PHONE, customerDto.getPhoneNumber());
            
            content = content.replace(QUOTATION_REFERENCE, quotDto.getReferenceNo());
            //content = content.replace(QUOT_DATE, quotDto.getCreatedDate().toString());

            content = content.replace(QUOT_TYPE, quotType);
            
            StringBuffer buffer = new StringBuffer();
            int index = 1;
            for(QuotationDetailsDto detailsDto : quotDto.getDetailsDtos()) {
                buffer.append(String.format(QUOT_MATERIALS_TEMPLATE, index++, detailsDto.getMaterialName(), detailsDto.getUnitRate(), detailsDto.getQuantity(), detailsDto.getAmount()));
            }
            
            if(buffer.length() > 0) {
                content = content.replace(QUOT_MATERIALS, buffer.toString());
            }
            
            if(FileHandler.WriteToPdfFile(output, content)){
                return output;
            }
        } catch (Exception ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}


/* try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            
            document.addPage(page);
            document.save(Constants.QUOTATION_REPORT_PATH + dto.getReferenceNo() + ".pdf");
            document.close();
            } catch (IOException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
            }*/