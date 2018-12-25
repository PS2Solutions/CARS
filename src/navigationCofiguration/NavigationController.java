/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationCofiguration;

import java.util.Vector;
import javax.swing.JFrame;
import utils.Arguments;
import utils.KeyValuePair;
import views.ContractScreen;
import views.CustomerScreen;
import views.DashboardScreen;
import views.LaborScreen;
import views.LaborWageScreen;
import views.MaterialScreen;
import views.QuotationScreen;
import views.RegistrationScreen;
import views.ReportScreen;

/**
 *
 * @author shinu.k
 */
public class NavigationController {

    public static void navigateToScreen(String key, JFrame baseScreen) {
        navigateToScreen(key, baseScreen, null);
    }

    public static void navigateToScreen(String key, JFrame baseScreen, Arguments arguments) {
        switch (key) {
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
            case NavigationConstants.QUOTATION:
                QuotationScreen quotationScreen = new QuotationScreen();
                quotationScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.REGISTER:
                RegistrationScreen registrationScreen = new RegistrationScreen(arguments);
                registrationScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.CUSTOMER:
                CustomerScreen customerScreen = new CustomerScreen();
                customerScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.MATERIAL:
                MaterialScreen materialScreen = new MaterialScreen();
                materialScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.CONTRACT:
                ContractScreen contractScreen = new ContractScreen();
                contractScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.REPORT:
                ReportScreen reportScreen = new ReportScreen();
                reportScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
            case NavigationConstants.DAILY_WAGE_SCREEN:
                LaborWageScreen laborWageScreen = new LaborWageScreen();
                laborWageScreen.setVisible(true);
                baseScreen.setVisible(false);
                break;
        }
    }
}
