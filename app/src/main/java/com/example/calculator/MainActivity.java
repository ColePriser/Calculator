package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private String solutionText;
    private StringBuilder currentText = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = findViewById(R.id.displayText);
        Button backspace = findViewById(R.id.backspace);
        Button clear = findViewById(R.id.clear);
        Button plusMinus = findViewById(R.id.plusMinus);
        Button percent = findViewById(R.id.percent);
        Button exponent = findViewById(R.id.exponent);
        Button divide = findViewById(R.id.divide);
        Button zero = findViewById(R.id.zero);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button multiply = findViewById(R.id.multiply);
        Button minus = findViewById(R.id.minus);
        Button plus = findViewById(R.id.plus);
        Button decimal = findViewById(R.id.decimal);
        Button equals = findViewById(R.id.equals);
    }

    public void calculatorPressButton(View view) {
        Button tempButton = (Button) view;
        String input = tempButton.getText().toString();
        switch (input) {
            case "⌫":
                currentText.setLength(currentText.length() - 1);
                break;
            case "AC":
                currentText.setLength(0);
                break;
            case "+/-":
                if (currentText.toString().charAt(0) == '-') {
                    currentText.deleteCharAt(0);
                } else {
                    currentText.insert(0, "-");
                }
                break;
            case "%":
                if (currentText.charAt(currentText.length() - 1) != '%') {
                    SolveCurrentInput();
                    currentText.append("%");
                }
                break;
            case "^":
                if (currentText.charAt(currentText.length() - 1) != '^') {
                    SolveCurrentInput();
                    currentText.append("^");
                }
                break;
            case "÷":
                if (currentText.charAt(currentText.length() - 1) != '/') {
                    SolveCurrentInput();
                    currentText.append("/");
                }
                break;
            case "x":
                if (currentText.charAt(currentText.length() - 1) != '*') {
                    SolveCurrentInput();
                    currentText.append("*");
                }
                break;
            case "-":
                if (currentText.charAt(currentText.length() - 1) != '-') {
                    SolveCurrentInput();
                    currentText.append("-");
                }
                break;
            case "+":
                if (currentText.charAt(currentText.length() - 1) != '+') {
                    SolveCurrentInput();
                    currentText.append("+");
                }
                break;
            case "=":
                SolveCurrentInput();
                solutionText = currentText.toString();
                break;
            case ".":
                boolean hasDecimal = false;
                for (int x = 0; x < currentText.length(); x++) {
                    if (currentText.charAt(x) == '.') {
                        hasDecimal = true;
                        break;
                    }
                }
                if (!hasDecimal) {
                    currentText.append(".");
                }
                break;
            default:
                currentText.append(input);
        }
        displayText.setText(currentText.toString());
    }

    public void SolveCurrentInput() {
        if (currentText.toString().split("\\+").length == 2) {
            String currentNumber[] = currentText.toString().split("\\+");
            double sumOfCurrent = Double.parseDouble(currentNumber[0]) + Double.parseDouble(currentNumber[1]);
            currentText.setLength(0);
            currentText = new StringBuilder(Double.toString(sumOfCurrent));
        }
        displayText.setText(currentText.toString());
    }
    //⌫ √x ÷ × x²
}