/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dataclasses.ContractDto;
import dataclasses.CustomerDto;
import dataclasses.DailyWageDto;
import dataclasses.ExtraPurchaseDetails;
import dataclasses.QuotationDetailsDto;
import dataclasses.QuotationMasterDto;
import dataclasses.RegistrationDto;
import java.io.File;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.impl.LaborServiceImpl;
import services.impl.MaterialServiceImpl;

/**
 *
 * @author sreenath
 */
public class ReportGenerator {

    private static final String COMPANY_NAME = "$#$CompanyName$#$";
    private static final String OWNER_NAME = "$#$OwnerName$#$";
    private static final String OWNER_PHONE = "$#$OwnerPhone$#$";
    private static final String COMPANY_LOGO_PATH = "$#$CompanyLogoPath$#$";
    private static final String CUSTOMER_NAME = "$#$CustomerName$#$";
    private static final String CUSTO_COMPANY_NAME = "$#$CustomerCompanyName$#$";
    private static final String CUSTOMER_ADDRESS1 = "$#$Address1$#$";
    private static final String CUSTOMER_ADDRESS2 = "$#$Address2$#$";
    private static final String CUSTOMER_PHONE = "$#$CustomerPhone$#$";
    private static final String QUOTATION_REFERENCE = "$#$QuotationReference$#$";
    private static final String QUOT_DATE = "$#$QuotDate$#$";
    private static final String QUOT_TYPE = "$#$QuotType$#$";
    private static final String QUOT_MATERIALS = "$#$QuotMaterials$#$";

    private static final String SITE_REFERENCE = "$#$SiteReference$#$";
    private static final String CLOSURE_START_DATE = "$#$ClosureStartDate$#$";
    private static final String CLOSURE_END_DATE = "$#$ClosureEndDate$#$";
    private static final String CLOSURE_MATERIALS = "$#$ClosureMaterials$#$";
    private static final String CLOSURE_LABOR_WAGES = "$#$ClosureLaborWages$#$";
    private static final String CLOSURE_ADD_PURCHASES = "$#$ClosureAdditionalPurchases$#$";
    private static final String CLOSURE_AP_TOTAL = "$#$ClosureAPTotal$#$";
    private static final String CLOSURE_TOTAL_COST = "$#$ClosureTotalCost$#$";

    private static final String MATERIALS_TEMPLATE = "<tr><td>%x</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>";
    private static final String EMPTY_MATERIALS_TEMPLATE = "<tr><td></td><td>NIL</td><td></td><td></td><td></td></tr>";

    private static final String DAILY_WAGE_TEMPLATE = "<tr><td>%x</td><td>%s</td><td>%.2f</td></tr>";
    private static final String EMPTY_DAILY_WAGE_TEMPLATE = "<tr><td></td><td>NIL</td><td></td></tr>";
    
    private static final String ADD_PURCHASES_TEMPLATE = "<tr><td>%x</td><td>%s</td><td>%s</td><td>%x</td><td>%.2f</td></tr>";
    private static final String EMPTY_ADD_PURCHASES_TEMPLATE = "<tr><td></td><td>NIL</td><td></td><td></td><td></td></tr>";

    public static String generateQuotationReport(QuotationMasterDto quotDto, RegistrationDto regDto, CustomerDto customerDto, String quotType) {
        try {
            String output = Constants.QUOTATION_REPORT_PATH + quotDto.getReferenceNo() + ".pdf";

            String content = new String(Files.readAllBytes(new File(Constants.PRINT_TEMPLATE_PATH + "QuotationTemplate.html").toPath()));

            content = modifyCompanyDetails(content, regDto);

            content = modifyCustomerDetails(content, customerDto);

            content = content.replace(CUSTOMER_ADDRESS1, quotDto.getAddress1());
            content = content.replace(CUSTOMER_ADDRESS2, quotDto.getAddress2());

            content = content.replace(QUOTATION_REFERENCE, quotDto.getTitle());

            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            content = content.replace(QUOT_DATE, sdf.format(quotDto.getCreatedDate()));

            content = content.replace(QUOT_TYPE, quotType);
            
            content = addMaterialsToQuotation(content, quotDto);

            if (FileHandler.WriteToPdfFile(output, content)) {
                return output;
            }
        } catch (Exception ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static String generateClosureReport(RegistrationDto regDto, ContractDto contractDto, CustomerDto customerDto, List<QuotationDetailsDto> contractMaterials, List<DailyWageDto> dailyWages, List<ExtraPurchaseDetails> extraPurchases, double totalCost, QuotationMasterDto quotationDto) {
        try {
            String output = Constants.CLOSURE_REPORT_PATH + contractDto.getContractRefNo() + ".pdf";

            String content = new String(Files.readAllBytes(new File(Constants.PRINT_TEMPLATE_PATH + "ClosureTemplate.html").toPath()));

            content = modifyCompanyDetails(content, regDto);

            content = modifyCustomerDetails(content, customerDto);

            content = content.replace(CUSTOMER_ADDRESS1, quotationDto.getAddress1());
            content = content.replace(CUSTOMER_ADDRESS2, quotationDto.getAddress2());

            content = modifyDate(content, contractDto, quotationDto);

            content = addMaterialsToClosure(content, contractMaterials);

            content = addDailyWages(content, dailyWages);

            content = addExtraPurchases(content, extraPurchases);

            content = content.replace(CLOSURE_TOTAL_COST, Double.toString(totalCost));

            if (FileHandler.WriteToPdfFile(output, content)) {
                return output;
            }
        } catch (Exception ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private static String modifyCompanyDetails(String content, RegistrationDto regDto) {
        try {
            String companyName = regDto.getCompanyName() == null ? "" : regDto.getCompanyName();
            String name = regDto.getName() == null ? "" : regDto.getName();
            String phoneNumber = regDto.getPhoneNumber() == null ? "" : regDto.getPhoneNumber();
            String companyLogo = regDto.getCompanyLogo() == null ? "" : regDto.getCompanyLogo();
                            
            content = content.replace(COMPANY_NAME, companyName);
            content = content.replace(OWNER_NAME, name);
            content = content.replace(OWNER_PHONE, phoneNumber);
            content = content.replace(COMPANY_LOGO_PATH, companyLogo);
        } catch (Exception e) {
            content = content.replace(COMPANY_NAME, "");
            content = content.replace(OWNER_NAME, "");
            content = content.replace(OWNER_PHONE, "");
            content = content.replace(COMPANY_LOGO_PATH, "");
        }

        return content;
    }

    private static String modifyCustomerDetails(String content, CustomerDto customerDto) {
        try {
            String name = customerDto.getName() == null ? "" : customerDto.getName();
            String companyName = customerDto.getCompanyName() == null ? "" : customerDto.getCompanyName();
            String phoneNumber = customerDto.getPhoneNumber() == null ? "" : customerDto.getPhoneNumber();
            
            content = content.replace(CUSTOMER_NAME, name);
            content = content.replace(CUSTO_COMPANY_NAME, companyName);
            content = content.replace(CUSTOMER_PHONE, phoneNumber);
        } catch (Exception e) {
            content = content.replace(CUSTOMER_NAME, "");
            content = content.replace(CUSTO_COMPANY_NAME, "");
            content = content.replace(CUSTOMER_PHONE, "");
        }

        return content;
    }

    private static String addMaterialsToClosure(String content, List<QuotationDetailsDto> contrctMaterials) {
        StringBuffer buffer = new StringBuffer();
        int index = 1;
        for (QuotationDetailsDto detailsDto : contrctMaterials) {
            buffer.append(String.format(MATERIALS_TEMPLATE, index++, detailsDto.getMaterialName(), detailsDto.getUnitRate(), detailsDto.getQuantity(), detailsDto.getAmount()));
        }

        if (buffer.length() > 0) {
            content = content.replace(CLOSURE_MATERIALS, buffer.toString());
        } else {
            content = content.replace(CLOSURE_MATERIALS, EMPTY_MATERIALS_TEMPLATE);
        }

        return content;
    }

    private static String addMaterialsToQuotation(String content, QuotationMasterDto quotDto) {
        StringBuffer buffer = new StringBuffer();
        int index = 1;
        for (QuotationDetailsDto detailsDto : quotDto.getDetailsDtos()) {
            buffer.append(String.format(MATERIALS_TEMPLATE, index++, detailsDto.getMaterialName(), detailsDto.getUnitRate(), detailsDto.getQuantity(), detailsDto.getAmount()));
        }

        if (buffer.length() > 0) {
            content = content.replace(QUOT_MATERIALS, buffer.toString());
        } else {
            content = content.replace(QUOT_MATERIALS, EMPTY_MATERIALS_TEMPLATE);
        }

        return content;
    }

    private static String modifyDate(String content, ContractDto contractDto, QuotationMasterDto quotationDto) {
        try {
            DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = originalFormat.parse(contractDto.getStartDate());

            content = content.replace(SITE_REFERENCE, quotationDto.getTitle());
            content = content.replace(CLOSURE_START_DATE, targetFormat.format(date));
            content = content.replace(CLOSURE_END_DATE, contractDto.getEndDate());
        } catch (Exception e) {
            content = content.replace(SITE_REFERENCE, "");
            content = content.replace(CLOSURE_START_DATE, "");
            content = content.replace(CLOSURE_END_DATE, "");
        }
        return content;
    }

    private static String addDailyWages(String content, List<DailyWageDto> dailyWages) {
        StringBuffer buffer = new StringBuffer();
        int index = 1;
        for (DailyWageDto dailyWageDto : dailyWages) {
            String laborName = getLaborName(dailyWageDto.getLaborId());
            double totalCost = dailyWageDto.getWage() + dailyWageDto.getTa() + dailyWageDto.getFa();
            buffer.append(String.format(DAILY_WAGE_TEMPLATE, index++, laborName, totalCost));
        }

        if (buffer.length() > 0) {
            content = content.replace(CLOSURE_LABOR_WAGES, buffer.toString());
        } else {
            content = content.replace(CLOSURE_LABOR_WAGES, EMPTY_DAILY_WAGE_TEMPLATE);
        }

        return content;
    }

    private static String addExtraPurchases(String content, List<ExtraPurchaseDetails> extraPurchases) {
        StringBuffer buffer = new StringBuffer();
        int index = 1;
        double totalCost = 0;
        for (ExtraPurchaseDetails details : extraPurchases) {
            String material = getMaterialName(details.getMaterial());
            totalCost += details.getAmount();
            buffer.append(String.format(ADD_PURCHASES_TEMPLATE, index++, material, details.getBillNo(), details.getQuantity(), details.getAmount()));
        }

        if (buffer.length() > 0) {
            content = content.replace(CLOSURE_ADD_PURCHASES, buffer.toString());
        } else {
            content = content.replace(CLOSURE_ADD_PURCHASES, EMPTY_ADD_PURCHASES_TEMPLATE);
        }
        
        content = content.replace(CLOSURE_AP_TOTAL, Double.toString(totalCost));

        return content;
    }

    private static String getLaborName(int laborId) {
        String laborName = new LaborServiceImpl().getLaborName(laborId);
        return laborName;
    }

    private static String getMaterialName(String materialCode) {
        String materialName = new MaterialServiceImpl().getMaterialName(materialCode);
        return materialName;
    }
}
