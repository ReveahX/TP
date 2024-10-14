package com.example.tptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseIngredientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ingredients);

        CheckBox saladCheckBox = findViewById(R.id.saladCheckBox);
        CheckBox tomatoCheckBox = findViewById(R.id.tomatoCheckBox);
        CheckBox onionCheckBox = findViewById(R.id.onionCheckBox);

        Button nextButton = findViewById(R.id.summaryButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder ingredients = new StringBuilder();
                if (saladCheckBox.isChecked()) ingredients.append("Salad ");
                if (tomatoCheckBox.isChecked()) ingredients.append("Tomato ");
                if (onionCheckBox.isChecked()) ingredients.append("Onion ");

                String mealType = getIntent().getStringExtra("MEAL_TYPE");

                // Pass the selected meal and ingredients to the ChooseSauceActivity
                Intent intent = new Intent(ChooseIngredientsActivity.this, ChooseSauceActivity.class);
                intent.putExtra("MEAL_TYPE", mealType);
                intent.putExtra("INGREDIENTS", ingredients.toString());
                startActivity(intent);
            }
        });
    }
}
