/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.MaterialDto;
import dataclasses.ReportContentDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import services.interfaces.MaterialService;
import utils.DBHelper;

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
        for(MaterialDto materialDto : materialDtos) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MaterialDto> getMaterials() {
        List<MaterialDto> customerDtos = new ArrayList<MaterialDto>();
        for (int i=0 ; i<100 ; i++) {
            MaterialDto dto = new MaterialDto();
            dto.setId(i);
            dto.setMaterialCode("MaterialCode-" + i);
            dto.setMaterialName("Material Name " + i);
            dto.setPerPointRate(i);
            dto.setBrand("brand " + i);
            dto.setWarrentyPeriod(i);
            dto.setWarrentyEligibility((i % 2) == 0);
            dto.setStatus((i % 2) == 0);
            dto.setQuoteTypeId(i);
            dto.setCategoryId(i);
            dto.setRemark("remark " + i);
     
            customerDtos.add(dto);
        }
        return customerDtos;
    }
    
}
