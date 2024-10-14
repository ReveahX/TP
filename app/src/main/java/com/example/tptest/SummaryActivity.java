package com.example.tptest;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        TextView summaryTextView = findViewById(R.id.summaryTextView);

        String mealType = getIntent().getStringExtra("MEAL_TYPE");
        String ingredients = getIntent().getStringExtra("INGREDIENTS");
        String drinks = getIntent().getStringExtra("DRINKS");

        String summary = "You ordered a " + mealType + " with: " + ingredients +
                "\nDrinks: " + drinks;
        summaryTextView.setText(summary);
    }
}
