package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button stockButton, mealsButton, menuButton, settingsButton;

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