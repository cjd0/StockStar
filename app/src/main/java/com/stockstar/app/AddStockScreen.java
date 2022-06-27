package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class AddStockScreen extends AppCompatActivity {

    private Spinner locationDropdown;
    private Button inputButton;
    //Default string array for Spinner dropdown list in input
    //This is to avoid user errors in manual entry
    // TODO: create add/remove methods for this array
    // TODO: add non-selectable hint to array
    private String[] locationArray = new String[]{"Cupboard",
            "Fridge", "Freezer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock_screen);

        //assign UI elements
        locationDropdown = (Spinner)findViewById(R.id.spGroceryLocation);
        inputButton = (Button)findViewById(R.id.btnInputStock);

        //create adapter for spinner dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, locationArray);
        //assign adapter to spinner
        locationDropdown.setAdapter(adapter);
    }

}