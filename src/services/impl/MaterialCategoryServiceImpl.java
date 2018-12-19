/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import dataclasses.DesignationDto;
import dataclasses.MaterialCategoryDto;
import java.sql.ResultSet;
import java.util.Vector;
import services.interfaces.MaterialCategoryService;
import utils.DBHelper;

/**
 *
 * @author shinu.k
 */
public class MaterialCategoryServiceImpl implements MaterialCategoryService {

    public MaterialCategoryServiceImpl() {
        DBHelper.connectToDb();
    }

    @Override
    public Vector<MaterialCategoryDto> getCategories() {
        Vector<MaterialCategoryDto> materialCategoryDtos = new Vector<>();
        ResultSet designationSet = DBHelper.readDataFromDb("select * from materialcategory");
        if (designationSet != null) {
            try {
                while (designationSet.next()) {
                    MaterialCategoryDto categoryDto = new MaterialCategoryDto();
                    categoryDto.setId(designationSet.getInt("ID"));
                    categoryDto.setCategory(designationSet.getString("Category"));
                    materialCategoryDtos.add(categoryDto);
                }
            } catch (Exception ex) {

            }
        }
        return materialCategoryDtos;
    }

    @Override
    public Vector<String> getCategories(Vector<MaterialCategoryDto> categoryDtos) {
        Vector<String> categories = new Vector<>();
        for (int i = 0; i < categoryDtos.size(); i++) {
            categories.add(categoryDtos.get(i).getCategory());
        }
        return categories;
    }

}
