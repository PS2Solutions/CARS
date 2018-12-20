/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.LaborDto;
import dataclasses.MaterialCategoryDto;
import dataclasses.MaterialDto;
import dataclasses.QuotationTypeDto;
import dataclasses.ReportContentDto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.interfaces.MaterialService;
import utils.DBHelper;
import utils.Helper;

/**
 *
 * @author sreenath
 */
public class MaterialServiceImpl implements MaterialService {

    public MaterialServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public ReportContentDto getMaterialDetails(List<MaterialDto> materialDtos) {
        ReportContentDto contentDto = new ReportContentDto();
        Vector<Vector> rowData = new Vector<Vector>();
        for (MaterialDto materialDto : materialDtos) {
            Vector<String> row = new Vector<>();

            row.add(materialDto.getMaterialCode());
            row.add(materialDto.getMaterialName());
            row.add(Double.toString(materialDto.getPerPointRate()));
            row.add(materialDto.getQuotationType());
            row.add(materialDto.getBrand());
            row.add(materialDto.getCategory());
            row.add(Long.toString(materialDto.getWarrentyPeriod()));
            row.add(materialDto.getStatus() ? "Yes" : "No");
            rowData.add(row);
        }

        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Material code");
        columnNames.addElement("Material name");
        columnNames.addElement("Point rate");
        columnNames.addElement("Quotation type");
        columnNames.addElement("Brand");
        columnNames.addElement("Category");
        columnNames.addElement("Warrenty period");
        columnNames.addElement("Active");
        contentDto.setRowData(rowData);
        contentDto.setColumnNames(columnNames);
        return contentDto;
    }

    @Override
    public String saveMaterial(MaterialDto materialDto) {
        String response = null;
        try {
            try (
                    CallableStatement statement = DBHelper.getDbConnection().prepareCall(
                            "{call  UpdateMaterialDetails ( ?, ?, ?,?,?,?,?,?,?,?,?,?,?)}");) {
                statement.registerOutParameter(13, Types.VARCHAR);

                statement.setInt(1, materialDto.getId());
                statement.setString(2, materialDto.getMaterialName());
                statement.setString(3, materialDto.getMaterialCode());
                statement.setString(4, materialDto.getRemark());
                statement.setDouble(5, materialDto.getPerPointRate());
                statement.setString(6, materialDto.getBrand());
                statement.setLong(7, materialDto.getWarrentyPeriod());
                statement.setBoolean(8, materialDto.isWarrentyEligibility());
                statement.setBoolean(9, materialDto.getStatus());
                statement.setInt(10, materialDto.getQuoteTypeId());
                statement.setInt(11, materialDto.getCategoryId());
                statement.setString(12, materialDto.getImagePath());
                ResultSet resultSet = statement.executeQuery();//sql response
                response = (String) statement.getObject(13, String.class);// out value
                return response;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<MaterialDto> getMaterials() {
        List<MaterialDto> materialDtos = new ArrayList<MaterialDto>();
        ResultSet resultSet = DBHelper.readDataFromDb("Select * from materials");
        if (resultSet != null) {
            prepareMaterialsDetails(resultSet, materialDtos);
        }
        return materialDtos;
    }

    private void prepareMaterialsDetails(ResultSet resultSet, List<MaterialDto> materialDtos) {
        try {
            while (resultSet.next()) {
                MaterialDto dto = new MaterialDto();
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String code = resultSet.getString("Code");
                String remark = resultSet.getString("Remark");
                double perpointRate = resultSet.getDouble("PerpointRate");
                String brand = resultSet.getString("Brand");
                int warrantyPeriod = resultSet.getInt("WarrantyPeriod");
                Boolean warrantyEligibility = resultSet.getBoolean("WarrantyEligibility");
                Boolean status = resultSet.getBoolean("Status");
                String lastEdit = resultSet.getString("LastEdit");
                int quotationTypeID = resultSet.getInt("QuotationTypeID");
                int categoryID = resultSet.getInt("CategoryID");
                String image = resultSet.getString("ImagePath");

                dto.setId(id);
                dto.setMaterialCode(code);
                dto.setMaterialName(name);
                dto.setPerPointRate(perpointRate);
                dto.setBrand(brand);
                dto.setWarrentyPeriod(warrantyPeriod);
                dto.setWarrentyEligibility(warrantyEligibility);
                dto.setStatus(status);
                dto.setQuoteTypeId(quotationTypeID);
                dto.setQuotationType(getQuotationType(quotationTypeID));
                dto.setCategoryId(categoryID);
                dto.setCategory(getCategory(categoryID));
                dto.setRemark(remark);
                String imagePath = (image == null ? "" : image);
                /*dto.setImagePath(imagePath);
                dto.setLastEdit(Helper.getFormattedDate(lastEdit));*/
                materialDtos.add(dto);

            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getQuotationType(int quotationTypeID) {
        String type = "";
        Vector<QuotationTypeDto> dtos = (new QuotationServiceImpl()).getQuotationType();
        for (QuotationTypeDto dto : dtos) {
            if (dto.getTypeId() == quotationTypeID) {
                type = dto.getType();
                break;
            }
        }
        return type;
    }

    private String getCategory(int categoryID) {
        String type = "";
        Vector<MaterialCategoryDto> dtos = (new MaterialCategoryServiceImpl()).getCategories();
        for (MaterialCategoryDto dto : dtos) {
            if (dto.getId() == categoryID) {
                type = dto.getCategory();
                break;
            }
        }
        return type;
    }

}
