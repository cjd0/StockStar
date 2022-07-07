package com.stockstar.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class MainActivity extends AppCompatActivity {

    private Button stockButton, mealsButton, menuButton, settingsButton;
    private ConnectionHandler conHandler = new ConnectionHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign buttons
        stockButton = (Button)findViewById(R.id.btnStock);
        mealsButton = (Button)findViewById(R.id.btnMeals);
        menuButton = (Button)findViewById(R.id.btnMenu);
        settingsButton = (Button)findViewById(R.id.btnSettings);

        //Set button actions
        stockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStockScreen();
            }
        });
        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMealsScreen();
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMenuScreen();
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettingsScreen();
            }
        });

        //create AlertDialog to accept user input for database password
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText userInput = new EditText(this);

        //set user input field to password type for security
        userInput.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        userInput.setTransformationMethod(PasswordTransformationMethod.getInstance());

        alert.setTitle("Welcome to StockStar").setMessage("Please enter password").setView(userInput);

        //create linear layout to contain UI for alert
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(userInput);

        //set alert
        alert.setView(layout);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                conHandler.SetPassword(userInput.getText().toString());

            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.create().show();

    }

    //methods for menu navigation upon button click
    public void openStockScreen() {
        Intent intent = new Intent(this, StockScreen.class);
        startActivity(intent);
    }
    public void openMealsScreen() {
        Intent intent = new Intent(this, MealsScreen.class);
        startActivity(intent);
    }
    public void openMenuScreen() {
        Intent intent = new Intent(this, MenuScreen.class);
        startActivity(intent);
    }
    public void openSettingsScreen() {
        Intent intent = new Intent(this, SettingsScreen.class);
        startActivity(intent);
    }
}