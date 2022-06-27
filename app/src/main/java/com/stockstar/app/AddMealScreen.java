package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddMealScreen extends AppCompatActivity {

    //UI variables
    private EditText mealNameText, ingredientText;
    private TextView mealIngredientsList;
    private Button addIngredientButton, submitMealButton;

    //functional variables
    private List<String> ingredientArray = new ArrayList<String>();

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
        //if user input present, add current ingredient to String array
        if (!TextUtils.isEmpty(ingredientText.getText().toString())) {

            //create variable
            String ingredient = ingredientText.getText().toString();

            //handle trailing spaces often caused by Android keyboards
            ingredient = ingredient.trim();

            //add ingredient to ArrayList
            ingredientArray.add(ingredient);

            //update TextView list
            mealIngredientsList.setText(ingredientArray.toString());

            //empty ingredient EditText for next input
            ingredientText.setText("");
        }
    }

    public void submitMeal() {
        //SQL code here
    }


}