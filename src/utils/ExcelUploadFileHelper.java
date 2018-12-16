/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author shinu.k
 */
public class ExcelUploadFileHelper {
    public enum FileType {
	CUSTOMER,
	LABOR;
    }
    public static String getIdentityColumn(FileType fileType) {
        switch(fileType) {
            case CUSTOMER:
                return "";
            case LABOR:
                return "";
        }
        return "";
    }
    public static String getTableName(FileType fileType) {
        switch(fileType) {
            case CUSTOMER:
                return "";
            case LABOR:
                return "";
        }
        return "";
    }
    
}
