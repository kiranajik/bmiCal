package com.kiranajik.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView condition,your_bmi,age,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        condition=findViewById(R.id.condition);
        your_bmi=findViewById(R.id.your_bmi);
        age=findViewById(R.id.age);
        category=findViewById(R.id.category);

        Intent intent = getIntent();
        float bmi=intent.getFloatExtra("BMI",0);
        float Bmi=Math.round(bmi*100)/(float)100;
        int agefinal = intent.getIntExtra("age",0);
        your_bmi.setText(String.valueOf(Bmi));
        age.setText(String.valueOf(agefinal));


        TextView category = findViewById(R.id.category);
        Category category1 = new Category();
        category.setText(category1.getCategory(Bmi));


        TextView condition = findViewById(R.id.condition);
        Condition condition1 = new Condition();
        condition.setText(condition1.getCategory(Bmi));

        Button recalculate = findViewById(R.id.recalculate);
        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

}


