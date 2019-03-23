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
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email.trim()).matches();
    }

    public static String getMysqlFormattedDate(String text) {
        if (text != null && text.trim().length() > 0) {
            String[] date = text.split("-");
            String mySqlFormattedDate = date[2] + "-" + date[1] + "-" + date[0] + " 00:00:00";
            return mySqlFormattedDate;
        } else {
            return null;
        }
    }

    public static String getFormattedDate(String text) {
        if (text != null && text.trim().length() > 0) {
//            String date = text.split(" ")[0];
            String[] date = (text.split(" ")[0]).split("-");
            String mySqlFormattedDate = date[2] + "-" + date[1] + "-" + date[0];
            return mySqlFormattedDate;
        } else {
            return null;
        }
    }

    public static String getReferenceNo(int type) {
        DBHelper.connectToDb();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String year = dateTimeFormatter.format(LocalDate.now()).toString().split("-")[0].trim();
        int currentIndex = getCurrentIndex(type);

        String formattedIntex = year + getFormattedIndex(currentIndex);
        switch (type) {
            case Constants.QUOTE:
                formattedIntex = "Q" + formattedIntex;
                break;
            case Constants.CONTRACT:
                formattedIntex = "C" + formattedIntex;
                break;
            case Constants.AGREMENT:
                formattedIntex = "A" + formattedIntex;
                break;
        }
        return formattedIntex;
    }

    private static int getCurrentIndex(int type) {
        int currentIndex = 0;
        ResultSet resultset = null;
        switch (type) {
            case Constants.QUOTE:
                resultset = DBHelper.readDataFromDb("Select QuotationIndex from configuration");
                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            currentIndex = resultset.getInt("QuotationIndex");
                        }
                    } catch (Exception ex) {

                    }
                }
                break;
            case Constants.CONTRACT:
                resultset = DBHelper.readDataFromDb("Select ContractIndex  from configuration");
                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            currentIndex = resultset.getInt("ContractIndex");
                        }
                    } catch (Exception ex) {

                    }
                }
                break;
            case Constants.AGREMENT:
                resultset = DBHelper.readDataFromDb("Select ContractIndex  from configuration");
                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            currentIndex = resultset.getInt("ContractIndex");
                        }
                    } catch (Exception ex) {

                    }
                }
                break;
        }
        return currentIndex;
    }

    public static boolean updateReferenceNo(int type) {
        int currentIndex = 0;
        boolean result = false;
        ResultSet resultset = null;
        switch (type) {
            case Constants.QUOTE:
                resultset = DBHelper.readDataFromDb("Select QuotationIndex from configuration");
                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            currentIndex = resultset.getInt("QuotationIndex");
                        }
                        currentIndex += 1;
                        DBHelper.updateDataToDb("Update configuration set QuotationIndex = " + currentIndex);
                        result = true;
                    } catch (Exception ex) {
                        result = false;
                    }
                }
                break;
            case Constants.CONTRACT:
                resultset = DBHelper.readDataFromDb("Select ContractIndex  from configuration");
                if (resultset != null) {
                    try {
                        while (resultset.next()) {
                            currentIndex = resultset.getInt("ContractIndex");
                        }
                        currentIndex += 1;
                        DBHelper.updateDataToDb("Update configuration set ContractIndex = " + currentIndex);
                        result = true;
                    } catch (Exception ex) {
                        result = false;
                    }
                }
                break;
        }
        return result;
    }

    private static String getFormattedIndex(int currentIndex) {
        String formattedIndex = "" + (currentIndex + 1);
        int count = 5 - formattedIndex.length();
        for (; count > 0; count--) {
            formattedIndex = "0" + formattedIndex;
        }
        return formattedIndex;
    }
    
    public static String getCurrentMysqlFormattedDate() {
        return getMysqlFormattedDate(getCurrentDate());
    }
    
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }
    
    public static String getDays(String startDate, String endDate) {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Date date2 = dateFormat2.parse(endDate);
            Date date1 = dateFormat1.parse(startDate);
            
            long diff = TimeUnit.DAYS.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
            
            return Long.toString(diff);
        } catch (Exception e) {
            String msg= e.getMessage();
        }
        
        return "";
    }
}
