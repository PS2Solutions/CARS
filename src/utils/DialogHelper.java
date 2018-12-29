/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author shinu.k
 */
public class DialogHelper {

    public static void showErrorMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfoMessage(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String showInputDialog(Component parentComponent, String title, String message) {
        return JOptionPane.showInputDialog(parentComponent, message, title, 1);
    }

    public static int showQuestionDialog(Component parentComponent, String title, String message) {
        return showQuestionDialog(parentComponent, message, title, 1);
    }
    
    public static int showQuestionDialog(Component parentComponent, String title, String message, int optionType) {
        return JOptionPane.showConfirmDialog(parentComponent, message, title, optionType);
    }
}
