/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

import org.json.JSONException;
import org.json.JSONObject;
import utils.Constants;
import utils.DialogHelper;
import utils.Helper;
import views.LoginScreen;

/**
 *
 * @author shinu.k
 */
public class CARS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (setupDBCredentials()) {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.show();
        }
    }

    /**
     * For set up DB credentials.     *
     * @return true if DB credentials are right other wise false.
     */
    private static boolean setupDBCredentials() {
        boolean dbConnectionResponse = false;
        try {
            String DBDetails = utils.Helper.readDataFromFile("/home/sreenath/Desktop/", "DBConfig.txt");
            JSONObject jSONObject = new JSONObject(DBDetails);
            Constants.connURL = jSONObject.getString("Connection_URL");
            Constants.dbUser = jSONObject.getString("DBUser");
            Constants.dbPass = jSONObject.getString("DBPassword");
            dbConnectionResponse = true;
        } catch (JSONException ex) {
            Helper.logError(CARS.class.getName(), ex);
            DialogHelper.showErrorMessage("Title", "Credentials missing.");
        }
        return dbConnectionResponse;
    }

}
