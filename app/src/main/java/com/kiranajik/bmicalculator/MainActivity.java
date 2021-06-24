package com.kiranajik.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    float finalHeight;    LinearLayout femaleTile,maleTile,heightGroup;
    TextView femaleIconLabel,maleIconLabel,heightText,age,heightLabel,heightUnit,weight;
    ImageView femaleImg,maleImg,weightAddButton,weightSubtractButton,ageAddButton,ageSubtractButton;
    SeekBar seekBar;
    Button calButton;
    int count_weight = 50,count_age = 19;
    float finalWeight;
    int finalAge;
    char finalGender=' ';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        femaleTile=findViewById(R.id.femaleTile);
        maleTile=findViewById(R.id.maleTile);
        femaleIconLabel=findViewById(R.id.femaleIconLabel);
        maleIconLabel=findViewById(R.id.maleIconLabel);
        femaleImg=findViewById(R.id.femaleIcon);
        maleImg=findViewById(R.id.maleIcon);
        seekBar=findViewById(R.id.seekBar);
        heightText=findViewById(R.id.heightText);
        heightGroup=findViewById(R.id.heightGroup);
        age=findViewById(R.id.age);
        heightLabel=findViewById(R.id.heightLabel);
        weight=findViewById(R.id.weight);
        weightAddButton=findViewById(R.id.weightAddButton);
        weightSubtractButton=findViewById(R.id.weightSubtractButton);
        ageAddButton=findViewById(R.id.ageAddButton);
        ageSubtractButton=findViewById(R.id.ageSubtractButton);
        heightUnit=findViewById(R.id.heightUnit);
        calButton=findViewById(R.id.calButton);

        checkSeekBarStatus();
        checkWeight();
        checkAge();

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });

    }


    public void femaleClick(View v)
    {
        femaleTile.setBackgroundColor(Color.WHITE);
        femaleIconLabel.setTextColor(Color.BLACK);
        femaleImg.setImageResource(R.drawable.fem2);
        maleImg.setImageResource(R.drawable.men3);
        maleTile.setBackgroundResource(R.drawable.rounded_corners);
        maleIconLabel.setTextColor(Color.WHITE);
        finalGender='F';

    }
    public void maleClick(View v)
    {
        maleTile.setBackgroundColor(Color.WHITE);
        maleIconLabel.setTextColor(Color.BLACK);
        maleImg.setImageResource(R.drawable.men2);
        femaleImg.setImageResource(R.drawable.fem3);
        femaleTile.setBackgroundResource(R.drawable.rounded_corners);
        femaleIconLabel.setTextColor(Color.WHITE);
        finalGender='M';
    }
    public void checkSeekBarStatus()
    {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String height = Integer.toString(progress);
                heightText.setText(height);
                finalHeight=(float)(progress)/100;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void checkWeight()
    {
        weightAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_weight<=250) {
                    count_weight++;
                }
                weight.setText(String.valueOf(count_weight));

            }
        });
        weightSubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_weight!=0) {
                    count_weight--;
                }
                weight.setText(String.valueOf(count_weight));

            }
        });

        weightAddButton.setOnLongClickListener(new View.OnLongClickListener() {
            private final Handler mHandler = new Handler();
            private final Runnable incrementRunnable = new Runnable() {
                @Override
                public void run() {
                    mHandler.removeCallbacks(incrementRunnable);
                    if(weightAddButton.isPressed()) {
                        if(count_weight<=250) {
                            count_weight++;
                        }
                        weight.setText(String.valueOf(count_weight));
                        mHandler.postDelayed(incrementRunnable, 100);
                    }
                }
            };

            @Override
            public boolean onLongClick(View view) {
                mHandler.postDelayed(incrementRunnable, 0);
                return true;
            }
        });

        weightSubtractButton.setOnLongClickListener(new View.OnLongClickListener() {
            private final Handler mHandler = new Handler();
            private final Runnable incrementRunnable = new Runnable() {
                @Override
                public void run() {
                    mHandler.removeCallbacks(incrementRunnable);
                    if(weightSubtractButton.isPressed()) {
                        if(count_weight!=0) {
                            count_weight--;
                        }
                        weight.setText(String.valueOf(count_weight));
                        mHandler.postDelayed(incrementRunnable, 100);
                    }
                }
            };

            @Override
            public boolean onLongClick(View view) {
                mHandler.postDelayed(incrementRunnable, 0);
                return true;
            }
        });
    }


    public void checkAge()
    {
        ageAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_age<=130)
                    count_age++;
                age.setText(String.valueOf(count_age));

            }
        });
        ageSubtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count_age!=0)
                    count_age--;
                age.setText(String.valueOf(count_age));

            }
        });

        ageAddButton.setOnLongClickListener(new View.OnLongClickListener() {
            private final Handler mHandler = new Handler();
            private final Runnable incrementRunnable = new Runnable() {
                @Override
                public void run() {
                    mHandler.removeCallbacks(incrementRunnable);
                    if(ageAddButton.isPressed()) {
                        if(count_age<=130) {
                            count_age++;
                        }
                        age.setText(String.valueOf(count_age));
                        mHandler.postDelayed(incrementRunnable, 100);
                    }
                }
            };

            @Override
            public boolean onLongClick(View view) {
                mHandler.postDelayed(incrementRunnable, 0);
                return true;
            }
        });

        ageSubtractButton.setOnLongClickListener(new View.OnLongClickListener() {
            private final Handler mHandler = new Handler();
            private final Runnable incrementRunnable = new Runnable() {
                @Override
                public void run() {
                    mHandler.removeCallbacks(incrementRunnable);
                    if(ageSubtractButton.isPressed()) {
                        if(count_age!=0) {
                            count_age--;
                        }
                        age.setText(String.valueOf(count_age));
                        mHandler.postDelayed(incrementRunnable, 100);
                    }
                }
            };

            @Override
            public boolean onLongClick(View view) {
                mHandler.postDelayed(incrementRunnable, 0);
                return true;
            }
        });
    }



    public void calculateBMI()
    {

        finalWeight= Float.parseFloat(weight.getText().toString());
        finalAge=Integer.parseInt(age.getText().toString());
        if(finalHeight==0)
            Toast.makeText(this, "Height Cannot Be zero", Toast.LENGTH_SHORT).show();
        else if(finalWeight==0)
            Toast.makeText(this, "Weight Cannot Be zero", Toast.LENGTH_SHORT).show();
        else if(finalGender!='M' && finalGender!='F')
            Toast.makeText(this, "Select a Gender", Toast.LENGTH_SHORT).show();
        else if(finalAge==0)
            Toast.makeText(this, "Age  Cannot Be zero", Toast.LENGTH_SHORT).show();
        else
            {
            float BMI = finalWeight / (finalHeight * finalHeight);
            Intent intent = new Intent(MainActivity.this, resultActivity.class);
            intent.putExtra("age", finalAge);
            intent.putExtra("weight", finalWeight);
            intent.putExtra("height", finalHeight);
            intent.putExtra("gender", finalGender);
            intent.putExtra("BMI", BMI);
            startActivity(intent);
        }
    }


}