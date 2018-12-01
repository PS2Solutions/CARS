/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sreenath
 */
public class FileHandler {

    final static String BASE_DIRECTORY = "c:/cars/";

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
}
