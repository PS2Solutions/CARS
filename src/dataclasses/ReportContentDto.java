/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataclasses;

import java.util.Vector;

/**
 *
 * @author shinu.k
 */
public class ReportContentDto {
    Vector<Vector> rowData;
    Vector<String> columnNames;

    public ReportContentDto() {
        this.rowData = new Vector<>();
        this.columnNames = new Vector<>();
    }

    public Vector<Vector> getRowData() {
        return rowData;
    }

    public void setRowData(Vector<Vector> rowData) {
        this.rowData = rowData;
    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(Vector<String> columnNames) {
        this.columnNames = columnNames;
    }
    
}
