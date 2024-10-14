package com.example.tptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseDrinkActivity extends AppCompatActivity {

    private String selectedDrink; // To store the selected drink

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_drink);

        Spinner drinkSpinner = findViewById(R.id.drinkSpinner);
        Button summaryButton = findViewById(R.id.summaryButton);

        // Create an ArrayAdapter for the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.drinks_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinkSpinner.setAdapter(adapter);

        // Set listener for spinner selection
        drinkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDrink = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing here
            }
        });

        // Set listener for the "Go to Summary" button
        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mealType = getIntent().getStringExtra("MEAL_TYPE");
                String ingredients = getIntent().getStringExtra("INGREDIENTS");

                // Pass the meal, ingredients, and selected drink to the SummaryActivity
                Intent intent = new Intent(ChooseDrinkActivity.this, SummaryActivity.class);
                intent.putExtra("MEAL_TYPE", mealType);
                intent.putExtra("INGREDIENTS", ingredients);
                intent.putExtra("DRINKS", selectedDrink);
                startActivity(intent);
            }
        });
    }
}
