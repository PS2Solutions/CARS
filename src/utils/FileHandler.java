/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/**
 *
 * @author sreenath
 */
public class FileHandler {

    final static String BASE_DIRECTORY = "c:/cars/";
    public static final String EXCEL_EXPORT_PATH = "c:/cars/Reports/";

    public static String getCopiedFilePath() {
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));
            chooser.setAcceptAllFileFilterUsed(false);

            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                String name = selectedFile.getName();
                String destination = BASE_DIRECTORY + name;
                   
                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                }; 
                
                Path path = Files.copy(selectedFile.toPath(), new File(destination).toPath(), options);
                return destination;
            }
        } catch(Exception e) { 
            e.printStackTrace();
        }
        
        return null;
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
            out = new FileWriter(EXCEL_EXPORT_PATH+name);
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
    
}
