/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dataclasses.UploadHelperDto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author sreenath
 */
public class FileHandler {

    final static String BASE_DIRECTORY = "c:/cars/";
    public static final String EXCEL_EXPORT_PATH = "c:/cars/Reports/";

    public static String getCopiedFilePath(File selectedFile) {
        try {
            String name = selectedFile.getName();
            String destination = BASE_DIRECTORY + name;

            CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
            };

            Path path = Files.copy(selectedFile.toPath(), new File(destination).toPath(), options);
            return destination;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File showFileChooser(String description, List<String> extensions) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile = null;
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(description, extensions.get(0), extensions.get(1)));
        chooser.setAcceptAllFileFilterUsed(false);

        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
        }
        return selectedFile;
    }

    public static  List<UploadHelperDto> getExcelData(File file) {
        List<UploadHelperDto> uploadHelperDtos  = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                UploadHelperDto helperDto = new UploadHelperDto();
               for (Cell cell : row) {                   
                   helperDto.getColumnValues().add(cell.getStringCellValue());
                }
               uploadHelperDtos.add(helperDto);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uploadHelperDtos;
    }

    /**
     * To export data to excel file.
     *
     * @param table
     * @param file
     * @throws IOException
     */
    public static boolean exportTableToExcel(JTable table, String name) throws IOException {
        boolean isExcelExported = false;
        FileWriter out = null;
        File file = new File(EXCEL_EXPORT_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            TableModel model = table.getModel();
            out = new FileWriter(EXCEL_EXPORT_PATH + name);
            for (int i = 0; i < model.getColumnCount(); i++) {
                out.write(model.getColumnName(i) + "\t");
            }
            out.write("\n");
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    out.write(model.getValueAt(i, j).toString() + "\t");
                }
                out.write("\n");
            }
            isExcelExported = true;
        } catch (Exception e) {
            isExcelExported = false;
        } finally {
            out.close();
        }
        return isExcelExported;
    }

    private static String getColumnNames(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        String column = "";
        for (Row row : sheet) {
            for (Cell cell : row) {
                column += (column.length() > 0 ? "," + cell.getStringCellValue() : cell.getStringCellValue());
            }
            break;
        }
        return column;
    }

    private static String getColValue(String colType, Cell cell) {
        switch (colType) {
            case "NUMERIC":
                return cell.getStringCellValue();
            case "STRING":
                return "'" + cell.getStringCellValue() + "'";
            default:
                return "";
        }
    }

}
