package com.example.tptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String selectedMealType; // Variable to store selected meal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mealTypeSpinner = findViewById(R.id.mealTypeSpinner);
        Button continueButton = findViewById(R.id.continueButton);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meal_types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mealTypeSpinner.setAdapter(adapter);

        // Set a listener for the Spinner
        mealTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedMealType = parent.getItemAtPosition(position).toString(); // Get selected item
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing here
            }
        });

        // Set a click listener for the continue button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pass the selected meal type to the next activity
                startChooseIngredientsActivity(selectedMealType);
            }
        });
    }

    private void startChooseIngredientsActivity(String mealType) {
        Intent intent = new Intent(MainActivity.this, ChooseIngredientsActivity.class);
        intent.putExtra("MEAL_TYPE", mealType);
        startActivity(intent);
    }
}
