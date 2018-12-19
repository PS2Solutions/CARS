/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import dataclasses.DesignationDto;
import dataclasses.MaterialCategoryDto;
import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public interface MaterialCategoryService {

    Vector<MaterialCategoryDto> getCategories();

    Vector<String>  getCategories(Vector<MaterialCategoryDto> categoryDtos);
}
