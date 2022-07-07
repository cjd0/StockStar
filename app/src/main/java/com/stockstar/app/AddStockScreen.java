package com.stockstar.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class AddStockScreen extends AppCompatActivity {

    private Spinner locationDropdown;
    private Button inputButton;
    private static TextView inputFeedback;
    private EditText nameText, amountText, expDateText;
    private ConnectionHandler conHandler = new ConnectionHandler();

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
        locationDropdown = (Spinner) findViewById(R.id.spGroceryLocation);
        inputButton = (Button) findViewById(R.id.btnInputStock);
        inputFeedback = (TextView) findViewById(R.id.tvInputFeedback);
        nameText = (EditText) findViewById(R.id.etMealName);
        amountText = (EditText) findViewById(R.id.etGroceryAmount);
        expDateText = (EditText) findViewById(R.id.etExpiryDate);

        //set UI actions
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddStock();
            }
        });

        //create adapter for spinner dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, locationArray);
        //assign adapter to spinner
        locationDropdown.setAdapter(adapter);
    }


    public void AddStock() {

        //create variables for SQL statement
        String name = nameText.getText().toString();
        String amount = amountText.getText().toString();
        String expDate = expDateText.getText().toString();
        String location = locationDropdown.getSelectedItem().toString();

        //check all fields are filled
        if (!name.isEmpty() && !amount.isEmpty() && !expDate.isEmpty()) {
            //set UI feedback
            inputFeedback.setText("Attempting to submit...");

            try {
                //connect and add to table
                if (conHandler.Connect() != null) {

                    //SQL statement concatenated for ease of reading
                    String query = "INSERT INTO Groceries(item_name, amount, exp_date, location)"
                            .concat(" VALUES('" + name + "', " + amount + ", '" + expDate + "', '" + location + "');");

                    //execute statement
                    conHandler.Connect().createStatement().executeUpdate(query);

                    //set UI feedback
                    inputFeedback.setText("Item added successfully.");
                }
            }
            catch (Exception ex) {
                Log.e("Error: ", ex.getMessage());
            }
        }
        else {
            inputFeedback.setText("Please fill all fields before submitting.");
        }
    }
}