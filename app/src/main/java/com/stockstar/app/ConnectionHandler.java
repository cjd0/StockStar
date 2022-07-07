package com.stockstar.app;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

public class ConnectionHandler {

    private static String password;

    //for connecting the app to the back-end Azure MySQL database

    public Connection Connect() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection = null;
        String connectionURL;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://tm470project.database.windows.net:1433;DatabaseName=tm470;user=chris.doyle@tm470project;password=" + password + ";encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;ssl=request;";
            connection = DriverManager.getConnection(connectionURL);
        }
        catch (Exception ex) {
            Log.d("Error", ex.getMessage());
        }
        return connection;
    }

    //setting Database password from user input in MainActivity
    public void SetPassword(String s) {
        password = s;
    }
}
