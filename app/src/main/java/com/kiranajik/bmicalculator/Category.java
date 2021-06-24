package com.kiranajik.bmicalculator;

public class Category {

    public String getCategory (float result) {
        String category;
        if (result < 15) {
            category = "VERY SEVERELY UNDERWEIGHT";
        } else if (result >=15 && result <= 16) {
            category = "SEVERELY UNDERWEIGHT";
        } else if (result >16 && result <= 18.5) {
            category = "UNDERWEIGHT";
        } else if (result >18.5 && result <= 25) {
            category = "NORMAL-HEALTHY WEIGHT";
        } else if (result >25 && result <= 30) {
            category = "OVERWEIGHT";
        } else if (result >30 && result <= 35) {
            category = "MODERATELY OBESE";
        } else if (result >35 && result <= 40) {
            category = "SEVERELY OBESE";
        } else {
            category ="VERY SEVERELY OBESE";
        }
        return category;
    }
}
