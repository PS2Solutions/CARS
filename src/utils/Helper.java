/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.json.JSONException;

/**
 *
 * @author shinu.k
 */
public class Helper {

    /**
     * For getting information from file.
     *
     *
     * @param path path to file.
     * @param name file name.
     * @return content of file.
     */
    public static String readDataFromFile(String path, String name) {
        StringBuilder fileContent = new StringBuilder();
        File inFile = new File(path + name);
        FileReader ins = null;
        try {
            ins = new FileReader(inFile);
            int ch;
            while ((ch = ins.read()) != -1) {
                fileContent.append((char) ch);
            }
        } catch (Exception e) {
            fileContent.toString();
        } finally {
            try {
                ins.close();
            } catch (Exception e) {
                fileContent.toString();
            }
        }
        return fileContent.toString();
    }

    public static void logError(String className, JSONException ex) {
        Logger.getLogger(className).log(Level.SEVERE, null, ex);
    }

    public static void writeDataToFile(String path, String content) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
            outStream.writeUTF(content);
            outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getPropertyValue(String key) {
        return java.util.ResourceBundle.getBundle("appResources/Strings").getString(key);
    }

    public static JDatePickerImpl getDatePicker() {
        JDatePickerImpl datePicker;
        UtilDateModel model = new UtilDateModel();
//        LocalDate now = LocalDate.now();
//	model.setDate(now.getYear(), now.getMonthValue(), now.getDayOfMonth()); 
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        return datePicker;
    }

    /**
     * To export data to excel file.
     *
     * @param table
     * @param file
     * @throws IOException
     */
    public static boolean exportTableToExcel(JTable table, File file) throws IOException {
        boolean isExcelExported = false;
        FileWriter out = null;
        try {
            TableModel model = table.getModel();
            out = new FileWriter(file);
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
