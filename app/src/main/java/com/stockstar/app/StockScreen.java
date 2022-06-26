package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StockScreen extends AppCompatActivity {

    private Button addStockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_screen);

        //assign buttons
        addStockButton = findViewById(R.id.btnAddStock);

        //set button listeners
        addStockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openAddStockScreen();}
        });
    }

    public void openAddStockScreen() {
        Intent intent = new Intent(this, AddStockScreen.class);
        startActivity(intent);
    }

}