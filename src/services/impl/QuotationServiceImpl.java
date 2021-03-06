/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.ComboContentDto;
import dataclasses.CustomerDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationDetailsDto;
import dataclasses.QuotationMasterDto;
import dataclasses.QuotationTypeDto;
import dataclasses.ReportContentDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.QuotationService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author shinu.k
 */
public class QuotationServiceImpl implements QuotationService {

    @Override
    public Map< String, MaterialDto> getMaterials(int quotationType) {
        Map< String, MaterialDto> materials = new HashMap< String, MaterialDto>();
        ResultSet materialSet = DBHelper.readDataFromDb("select ID, Name, Code from materials where QuotationTypeID=" + quotationType);
        if (materialSet != null) {
            try {
                while (materialSet.next()) {
                    MaterialDto dto = new MaterialDto();
                    dto.setId(materialSet.getInt("ID"));
                    dto.setMaterialName(materialSet.getString("Name"));

                    materials.put(materialSet.getString("Code"), dto);
                }
            } catch (Exception ex) {

            }
        }

        return materials;
    }

    @Override
    public Vector<CustomerDto> getCustomers() {
        Vector<CustomerDto> cds = new Vector<>();

        ResultSet customerSet = DBHelper.readDataFromDb("select ID, Name, CompanyName, Address1, Address2, ContactNo from customers");

        if (customerSet != null) {
            try {
                while (customerSet.next()) {
                    CustomerDto cd = new CustomerDto();
                    cd.setId(customerSet.getInt("ID"));
                    cd.setName(customerSet.getString("Name"));
                    cd.setCompanyName(customerSet.getString("CompanyName"));
                    cd.setAddress1(customerSet.getString("Address1"));
                    cd.setAddress2(customerSet.getString("Address2"));
                    cd.setPhoneNumber(customerSet.getString("ContactNo"));

                    cds.add(cd);
                }
            } catch (Exception ex) {

            }
        }

        return cds;
    }

    @Override
    public Vector<QuotationTypeDto> getQuotationType() {
        Vector<QuotationTypeDto> quotationTypeDtos = new Vector<>();
        ResultSet quotationTypeSet = DBHelper.readDataFromDb("select * from quotationtypes");
        if (quotationTypeSet != null) {
            try {
                while (quotationTypeSet.next()) {
                    QuotationTypeDto quotationTypeDto = new QuotationTypeDto();
                    quotationTypeDto.setTypeId(quotationTypeSet.getInt("ID"));
                    quotationTypeDto.setType(quotationTypeSet.getString("Type"));
                    quotationTypeDtos.add(quotationTypeDto);
                }
            } catch (Exception ex) {

            }
        }
        return quotationTypeDtos;
    }

    @Override
    public Vector<String> getCustomers(Vector<CustomerDto> customersDtos) {
        Vector<String> designations = new Vector<>();
        for (int i = 0; i < customersDtos.size(); i++) {
            designations.add(customersDtos.get(i).getName().trim() + " ( " + customersDtos.get(i).getCompanyName() + " )");
        }
        return designations;
    }

    @Override
    public Vector<String> getQuotationType(Vector<QuotationTypeDto> quotationTypeDtos) {

        Vector<String> designations = new Vector<>();
        for (int i = 0; i < quotationTypeDtos.size(); i++) {
            designations.add(quotationTypeDtos.get(i).getType());
        }
        return designations;
    }

    @Override
    public boolean saveQuotation(QuotationMasterDto masterDto) {
        boolean response = false;

        int quoteID = updateQuotationDetails(masterDto);

        if (quoteID > 0) {
            masterDto.setId(quoteID);
            response = updateMaterials(masterDto);
        }

        return response;
    }

    private int updateQuotationDetails(QuotationMasterDto masterDto) {
        int quoteID = 0;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call UpdateQuotationDetails(?,?,?,?,?,?,?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(13, Types.VARCHAR);

                statement.setInt(1, masterDto.getId());
                statement.setString(2, masterDto.getTitle());
                statement.setString(3, masterDto.getReferenceNo());
                statement.setInt(4, masterDto.getCustomerId());
                statement.setDouble(5, masterDto.getAmount());
                statement.setInt(6, 0);
                statement.setString(7, masterDto.getAddress1());
                statement.setString(8, masterDto.getAddress2());
                statement.setInt(9, masterDto.getTypeId());
                statement.setInt(10, 0);
                statement.setDouble(11, masterDto.getAmount());
                statement.setDate(12, masterDto.getCreatedDate());
                statement.executeQuery();//sql response

                quoteID = statement.getObject(13, Integer.class);// out value
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return quoteID;
    }

    public boolean updateMaterials(QuotationMasterDto masterDto) {
        String response = null;

        if (deleteMaterials(masterDto.getId())) {
            try {
                try (
                        CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                                "{call UpdateQuotMaterialDetails(?,?,?,?,?)}");) {
                    // statement.registerOutParameter(6, Types.VARCHAR);

                    for (QuotationDetailsDto detailsDtos : masterDto.getDetailsDtos()) {
                        statement.setInt(1, masterDto.getId());
                        statement.setInt(2, detailsDtos.getMaterialId());
                        statement.setDouble(3, detailsDtos.getUnitRate());
                        statement.setInt(4, detailsDtos.getQuantity());
                        statement.setDouble(5, detailsDtos.getAmount());

                        statement.addBatch();
                    }
                    statement.executeBatch();

                    //response = (String) statement.getObject(6, String.class);// out value
                }
            } catch (SQLException ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;//(response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success")));
    }

    private boolean deleteMaterials(int quoteID) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call DeleteQuotMaterialDetails(?,?)}");) {
                statement.registerOutParameter(2, Types.VARCHAR);

                statement.setInt(1, quoteID);
                statement.executeQuery();//sql response

                response = (String) statement.getObject(2, String.class);// out value
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (response != null && response.equalsIgnoreCase(Helper.getPropertyValue("Success")));
    }

    @Override
    public QuotationMasterDto getQuotation(String referenceNo) {
        try {
            ResultSet set = DBHelper.readDataFromDb("select ID, QuotationTypeID from quotations where ReferenceNo='" + referenceNo + "'");
            if (set != null && set.next()) {

                int quotID = set.getInt("ID");

                QuotationMasterDto dto = new QuotationMasterDto();
                dto.setTypeId(set.getInt("QuotationTypeID"));
                List<QuotationDetailsDto> detailsDtos = new ArrayList<QuotationDetailsDto>();

                ResultSet resultSet = DBHelper.readDataFromDb("select * from quotationdetails where QuotationID=" + quotID);
                if (resultSet != null) {
                    while (resultSet.next()) {
                        QuotationDetailsDto detailsDto = new QuotationDetailsDto();
                        detailsDto.setMaterialId(resultSet.getInt("MaterialID"));
                        detailsDto.setUnitRate(resultSet.getInt("UnitRate"));
                        detailsDto.setQuantity(resultSet.getInt("Quantity"));
                        detailsDto.setAmount(resultSet.getDouble("Amount"));

                        detailsDtos.add(detailsDto);
                    }
                    resultSet.close();

                    for (QuotationDetailsDto detailsDto : detailsDtos) {
                        ResultSet materialSet = DBHelper.readDataFromDb("select Name, Code from materials where ID=" + detailsDto.getMaterialId());
                        if (materialSet != null && materialSet.next()) {
                            detailsDto.setMaterialCode(materialSet.getString("Code"));
                            detailsDto.setMaterialName(materialSet.getString("Name"));
                        }
                    }

                    dto.setDetailsDtos(detailsDtos);
                    return dto;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuotationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public ReportContentDto getQuotationRefs() {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        
        ResultSet set = DBHelper.readDataFromDb("select ReferenceNo, Title from quotations where ContractID = 0");
        if (set != null) {
            try {
                while (set.next()) {
                    Vector<String> row = new Vector<>();
                    row.add(set.getString("Title"));
                    row.add(set.getString("ReferenceNo"));
                    rowData.add(row);
                }
                
                Vector<String> columnNames = new Vector<String>();
                columnNames.addElement("Title");
                columnNames.addElement("Quotation Ref#");
        
                contentDto.setRowData(rowData);
                contentDto.setColumnNames(columnNames);
            } catch (Exception ex) {

            }
        }

        return contentDto;
    }

    public int updateQuotation(String quotationRef, int contractId) {
        int result = DBHelper.updateDataToDb("Update quotations set ContractID = " + contractId + " where ReferenceNo = '" + quotationRef + "'");
        return result;
    }

    public Vector<ComboContentDto> getQuotationNames() {
        String query = "SELECT ID, Title FROM `quotations` WHERE ContractID = 0";
        Vector<ComboContentDto> quotations = new Vector<>();

        ResultSet resultSet = DBHelper.readDataFromDb(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    ComboContentDto ccd = new ComboContentDto();
                    int id = resultSet.getInt("ID");
                    String title = resultSet.getString("Title");
                    ccd.setId(id);
                    ccd.setName(title);
                    quotations.add(ccd);
                }

            } catch (Exception ex) {
                Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return quotations;
    }

    @Override
    public Vector<String> getQuotationNames(Vector<ComboContentDto> comboContentDtos) {
        Vector<String> quoteDtos = new Vector<>();
        for (ComboContentDto ccd : comboContentDtos) {
            quoteDtos.add(ccd.getName());
        }
        return quoteDtos;
    }

    public int getCustomerId(int contractId) {
        ResultSet set = DBHelper.readDataFromDb("select CustomerID from quotations where ContractID=" + contractId);

        try {
            if (set != null && set.next()) {
                return set.getInt("CustomerID");
            }
        } catch (Exception ex) {

        }
        return 0;
    }

    @Override
    public QuotationMasterDto getQuotation(int contractId) {
        ResultSet set = DBHelper.readDataFromDb("select ID, Address1, Address2, Title, CustomerID, QuotationTypeID from quotations where ContractID=" + contractId);

        QuotationMasterDto dto = new QuotationMasterDto();

        try {
            if (set != null && set.next()) {
                dto.setId(set.getInt("ID"));
                dto.setAddress1(set.getString("Address1"));
                dto.setAddress2(set.getString("Address2"));
                dto.setTitle(set.getString("Title"));
                dto.setCustomerId(set.getInt("CustomerID"));
                dto.setTypeId(set.getInt("QuotationTypeID"));

                return dto;
            }
        } catch (Exception ex) {

        }

        dto.setId(0);
        dto.setAddress1("");
        dto.setAddress2("");
        dto.setTitle("");
        dto.setCustomerId(0);
        dto.setTypeId(0);
        return dto;
    }

    @Override
    public List<QuotationDetailsDto> getQuotationDetails(int quotationId) {
        List<QuotationDetailsDto> detailsDtos = new ArrayList<QuotationDetailsDto>();

        try {
            ResultSet resultSet = DBHelper.readDataFromDb("select * from quotationdetails where QuotationID=" + quotationId);
            if (resultSet != null) {
                while (resultSet.next()) {
                    QuotationDetailsDto detailsDto = new QuotationDetailsDto();
                    detailsDto.setMaterialId(resultSet.getInt("MaterialID"));
                    detailsDto.setUnitRate(resultSet.getInt("UnitRate"));
                    detailsDto.setQuantity(resultSet.getInt("Quantity"));
                    detailsDto.setAmount(resultSet.getDouble("Amount"));

                    detailsDtos.add(detailsDto);
                }

                resultSet.close();

                for (QuotationDetailsDto detailsDto : detailsDtos) {
                    ResultSet materialSet = DBHelper.readDataFromDb("select Name, Code from materials where ID=" + detailsDto.getMaterialId());
                    if (materialSet != null && materialSet.next()) {
                        detailsDto.setMaterialCode(materialSet.getString("Code"));
                        detailsDto.setMaterialName(materialSet.getString("Name"));
                    }
                }

                return detailsDtos;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public int getQuotationType(int quotationId) {
        try {
            ResultSet set = DBHelper.readDataFromDb("select QuotationTypeID from quotations where ID=" + quotationId);

            if (set != null && set.next()) {
                return set.getInt("QuotationTypeID");
            }
        } catch (Exception ex) {

        }

        return 0;
    }

    @Override
    public String getQuotationTitle(int quotationId) {
        try {
            ResultSet set = DBHelper.readDataFromDb("select Title from quotations where ID=" + quotationId);

            if (set != null && set.next()) {
                return set.getString("Title");
            }
        } catch (Exception ex) {

        }

        return "";
    }
}
