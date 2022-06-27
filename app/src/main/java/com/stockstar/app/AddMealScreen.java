package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddMealScreen extends AppCompatActivity {

    //UI variables
    private EditText mealNameText, ingredientText;
    private TextView mealIngredientsList;
    private Button addIngredientButton, submitMealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal_screen);

        //UI assignments
        mealNameText = (EditText)findViewById(R.id.etMealName);
        ingredientText = (EditText)findViewById(R.id.etIngredient);
        mealIngredientsList = (TextView)findViewById(R.id.tvMealArray);
        addIngredientButton = (Button)findViewById(R.id.btnAddIngredient);
        submitMealButton = (Button)findViewById(R.id.btnInputMeal);

        //set UI actions
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIngredient();
            }
        });

        submitMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitMeal();
            }
        });
    }

    //UI methods
    public void addIngredient() {

    }

    public void submitMeal() {
        //SQL code here
    }
}