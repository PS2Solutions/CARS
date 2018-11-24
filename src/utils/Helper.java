/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import cars.CARS;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    
    public static String getPropertyValue(String key){
       return  java.util.ResourceBundle.getBundle("appResources/Strings").getString(key);
    }
}
