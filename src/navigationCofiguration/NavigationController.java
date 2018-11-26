/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationCofiguration;

import java.util.Vector;
import javax.swing.JFrame;
import utils.KeyValuePair;
import views.DashboardScreen;
import views.LaborScreen;

/**
 *
 * @author shinu.k
 */
public class NavigationController {
    public static void navigateToScreen(String key,JFrame baseScreen,Vector<KeyValuePair> params){
        switch(key){
            case NavigationConstants.DASHBOARD:
                DashboardScreen dashboardScreen = new DashboardScreen();
                dashboardScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.LABOR:
                LaborScreen laborScreen = new LaborScreen();
                laborScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            }
    }
}
