package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private String solutionText;
    private String inputText;
    private Button backspace;
    private Button clear;
    private Button plusMinus;
    private Button percent;
    private Button exponent;
    private Button divide;
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button multiply;
    private Button minus;
    private Button plus;
    private Button decimal;
    private Button equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //displayText = findViewById(R.id.displayText);
        displayText.setShowSoftInputOnFocus(false);

        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.displayText).equals(displayText.getText().toString())) {
                    displayText.setText("");
                }
            }
        });
    }
    //⌫ √x ÷ × x²
}