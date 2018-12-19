/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shinu.k
 */
public class UploadHelperDto {
    List<String> columnValues;

    public UploadHelperDto() {
        columnValues = new ArrayList<>();
    }

    public List<String> getColumnValues() {
        return columnValues;
    }

    public void setColumnValues(List<String> columnValues) {
        this.columnValues = columnValues;
    }
    
}
