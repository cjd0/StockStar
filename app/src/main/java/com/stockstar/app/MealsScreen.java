package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MealsScreen extends AppCompatActivity {

    private Button addMealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_screen);

        //UI assignments
        addMealButton = (Button)findViewById(R.id.btnAddMeal);

        //set UI actions
        addMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddMealScreen();
            }
        });
    }

    //UI methods
    public void openAddMealScreen() {
        Intent intent = new Intent(this, AddMealScreen.class);
        startActivity(intent);
    }

}