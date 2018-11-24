/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationCofiguration;

import java.util.Vector;
import javax.swing.JFrame;
import utils.KeyValuePair;
import views.MainScreen;

/**
 *
 * @author shinu.k
 */
public class NavigationController {
    public static void navigateToScreen(String key,JFrame baseScreen,Vector<KeyValuePair> params){
        switch(key){
            case NavigationConstants.DASHBOARD:
                MainScreen mainScreen =new MainScreen();
                mainScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
                
        }
    }
}
