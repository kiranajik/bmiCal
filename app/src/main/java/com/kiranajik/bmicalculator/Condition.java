package com.kiranajik.bmicalculator;

public class Condition {
    public String getCategory (float result) {
        String category;
        if (result < 15) {
            category = "SEVERE THINNESS";
        } else if (result >=15 && result <= 16) {
            category = "MODERATE THINNESS";
        } else if (result >16 && result <= 18.5) {
            category = "MILD THINNESS";
        } else if (result >18.5 && result <= 25) {
            category = "NORMAL";
        } else if (result >25 && result <= 30) {
            category = "OVERWEIGHT";
        } else if (result >30 && result <= 35) {
            category = "OBESE CLASS I";
        } else if (result >35 && result <= 40) {
            category = "OBESE CLASS II";
        } else {
            category ="OBESE CLASS III";
        }
        return category;
    }
}
