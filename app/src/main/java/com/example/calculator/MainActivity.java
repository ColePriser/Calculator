package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private StringBuilder currentText = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.displayText);
    }

    public void calculatorPressButton(View view) {
        Button tempButton = (Button) view;
        String input = tempButton.getText().toString();
        switch (input) {
            case "⌫":
                if (currentText.toString().equals("can't divide by zero")) {
                    currentText.setLength(0);
                } else if (currentText.toString().equals("error")) {
                    currentText.setLength(0);
                } else {
                    currentText.setLength(currentText.length() - 1);
                }
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
            case "√":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    String newText = Double.toString(Math.sqrt(Double.parseDouble(currentText.toString())));
                    currentText.setLength(0);
                    currentText = new StringBuilder(newText);
                    String[] decimal = currentText.toString().split("\\.");
                    if (decimal.length > 1) {
                        if (decimal[1].equals("0")) {
                            currentText = new StringBuilder(decimal[0]);
                        }
                    }
                }
                break;
            case "^":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    currentText.append("^");
                }
                break;
            case "÷":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    currentText.append("/");
                }
                break;
            case "x":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    currentText.append("*");
                }
                break;
            case "ー":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    currentText.append("ー");
                }
                break;
            case "+":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                    currentText.append("+");
                }
                break;
            case "=":
                if (lastCharIsNotOperator()) {
                    SolveCurrentInput();
                }
                break;
            case ".":
                boolean hasOperation = false;
                int operationIndex = -1;
                boolean hasDecimalBeforeOperation = false;
                boolean hasDecimalAfterOperation = false;
                for (int x = 0; x < currentText.length(); x++) {
                    char[] operations = {'+', 'ー', '*', '/', '^'};
                    for (int y = 0; y < 5; y++) {
                        if (currentText.charAt(x) == operations[y]) {
                            operationIndex = y;
                            hasOperation = true;
                            break;
                        }
                    }
                }
                if (!hasOperation) {
                    for (int x = 0; x < currentText.length(); x++) {
                        if (currentText.charAt(x) == '.') {
                            hasDecimalBeforeOperation = true;
                            break;
                        }
                    }
                }
                else {
                    for (int x = operationIndex; x < currentText.length(); x++) {
                        if (currentText.charAt(x) == '.') {
                            hasDecimalAfterOperation = true;
                            break;
                        }
                    }
                }
                if (!hasOperation && !hasDecimalBeforeOperation) {
                    currentText.append(".");
                }
                else if (hasOperation && !hasDecimalAfterOperation) {
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
            String[] currentNumber = currentText.toString().split("\\+");
            boolean exception = false;
            double sumOfCurrent = 0.0;
            try {
                sumOfCurrent = Double.parseDouble(currentNumber[0]) + Double.parseDouble(currentNumber[1]);
            } catch (Exception e) {
                exception = true;
            }
            currentText.setLength(0);
            if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(sumOfCurrent));
            }
        }
        else if (currentText.toString().split("ー").length == 2) {
            String[] currentNumber = currentText.toString().split("ー");
            boolean exception = false;
            double subtractOfCurrent = 0.0;
            try {
                subtractOfCurrent = Double.parseDouble(currentNumber[0]) - Double.parseDouble(currentNumber[1]);
            } catch (Exception e) {
                exception = true;
            }
            currentText.setLength(0);
            if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(subtractOfCurrent));
            }
        }
        else if (currentText.toString().split("\\*").length == 2) {
            String[] currentNumber = currentText.toString().split("\\*");
            boolean exception = false;
            double multiplyOfCurrent = 0.0;
            try {
                multiplyOfCurrent = Double.parseDouble(currentNumber[0]) * Double.parseDouble(currentNumber[1]);
            } catch (Exception e) {
                exception = true;
            }
            currentText.setLength(0);
            if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(multiplyOfCurrent));
            }
        }
        else if (currentText.toString().split("/").length == 2) {
            String[] currentNumber = currentText.toString().split("/");
            boolean exception = false;
            double divisionOfCurrent = 0.0;
            try {
                divisionOfCurrent = Double.parseDouble(currentNumber[0]) / Double.parseDouble(currentNumber[1]);
            } catch (ArithmeticException e) {
                exception = true;
            }
            currentText.setLength(0);
            if (Double.parseDouble(currentNumber[1]) == 0) {
                currentText = new StringBuilder("can't divide by zero");
            } else if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(divisionOfCurrent));
            }
        }
        else if (currentText.toString().split("\\^").length == 2) {
            String[] currentNumber = currentText.toString().split("\\^");
            boolean exception = false;
            double exponentOfCurrent = 0.0;
            try {
                exponentOfCurrent = Math.pow(Double.parseDouble(currentNumber[0]), Double.parseDouble(currentNumber[1]));
            } catch (Exception e) {
                exception = true;
            }
            currentText.setLength(0);
            if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(exponentOfCurrent));
            }
        }
        String[] decimal = currentText.toString().split("\\.");
        if (decimal.length > 1) {
            if (decimal[1].equals("0")) {
                currentText = new StringBuilder(decimal[0]);
            }
        }
        displayText.setText(currentText.toString());
    }

    public boolean lastCharIsNotOperator () {
        char[] operations = {'+', 'ー', '*', '/', '^'};
        for (int x = 0; x < 5; x++) {
            if (currentText.charAt(currentText.length() - 1) == operations[x]) {
                return false;
            }
        }
        return true;
    }
}