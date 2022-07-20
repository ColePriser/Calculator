package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private String solutionText;
    private StringBuilder currentText;
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

        displayText = findViewById(R.id.displayText);
        backspace = findViewById(R.id.backspace);
        clear = findViewById(R.id.clear);
        plusMinus = findViewById(R.id.plusMinus);
        percent = findViewById(R.id.percent);
        exponent = findViewById(R.id.exponent);
        divide = findViewById(R.id.divide);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        decimal = findViewById(R.id.decimal);
        equals = findViewById(R.id.equals);
    }

    public void calculatorPressButton(View view) {
        Button tempButton = (Button) view;
        String input = tempButton.getText().toString();
        switch (input) {
            case "del":
                currentText.setLength(currentText.length() - 1);
                break;
            case "AC":
                currentText.setLength(0);
                break;
            case "+/-":
                currentText.append("-");
                break;
            case "%":
                SolveCurrentInput();
                currentText.append("%");
                break;
            case "^":
                SolveCurrentInput();
                currentText.append("^");
                break;
            case "÷":
                SolveCurrentInput();
                currentText.append("/");
                break;
            case "x":
                SolveCurrentInput();
                currentText.append("*");
                break;
            case "-":
                SolveCurrentInput();
                currentText.append("-");
                break;
            case "+":
                SolveCurrentInput();
                currentText.append("+");
                break;
            case "=":
                SolveCurrentInput();
                solutionText = currentText.toString();
                break;
            default:
                if (currentText == null) {
                    currentText.setLength(0);
                }
        }

    }

    public void SolveCurrentInput() {

    }
    //⌫ √x ÷ × x²
}