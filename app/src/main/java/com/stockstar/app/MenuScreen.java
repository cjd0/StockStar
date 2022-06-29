package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuScreen extends AppCompatActivity {

    private TextView menuDisplay;
    private Button openModifyMenuScreen, openShoppingListScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        //UI assignments
        menuDisplay = (TextView)findViewById(R.id.tvMenuDisplay);
        openModifyMenuScreen = (Button)findViewById(R.id.btnModifyMenu);
        openShoppingListScreen = (Button)findViewById(R.id.btnShoppingList);

        //set UI actions
        openModifyMenuScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModifyMenuScreen();
            }
        });
        openShoppingListScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShoppingListScreen();
            }
        });
    }

    //UI methods
    public void openModifyMenuScreen() {
        Intent intent = new Intent(this, ModifyMenuScreen.class);
        startActivity(intent);
    }

    public void openShoppingListScreen() {
        Intent intent = new Intent(this, ShoppingListScreen.class);
        startActivity(intent);
    }

    public void modifyShoppingList(String[] meals) {
        //TODO: add code here to be called from ShoppingListScreen and build menu in menuDisplay
    }

}