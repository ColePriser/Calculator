package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class represents the Main Activity for this Calculator.
 * It is the only activity that will be used. It opens that calculator,
 * implements the actions of clicking a button, computes what the user inputs,
 * and presents the result back onto the display.
 *
 * @author Cole Priser
 * @version July 24 2022
 */

public class MainActivity extends AppCompatActivity {

    private TextView displayText; //result of calculation and current input shown
    private StringBuilder currentText = new StringBuilder(); //user inputs are checked for validity

    /**
     * Method responsible for creating the main activity.
     *
     * @param savedInstanceState The state of the main activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.displayText);
    }

    /**
     * Method to see what button is clicked and append the
     * text accordingly. Display is calculated based on if an
     * operation is clicked.
     *
     * @param view Represents the button that is clicked
     */
    public void calculatorPressButton(View view) {
        //
        Button tempButton = (Button) view;
        String input = tempButton.getText().toString();
        switch (input) {
            case "⌫":
                if (currentText.toString().equals("error")) {
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

                    //Error handling if taking square root of negative number
                    if (Double.parseDouble(currentText.toString()) < 0) {
                        currentText = new StringBuilder("error");
                    } else {

                        //Calculate square root and set it to current text
                        String newText = Double.toString(Math.sqrt(Double.parseDouble(currentText.toString())));
                        currentText.setLength(0);
                        currentText = new StringBuilder(newText);

                        //Removes decimal if it is unneeded
                        String[] decimal = currentText.toString().split("\\.");
                        if (decimal.length > 1) {
                            if (decimal[1].equals("0")) {
                                currentText = new StringBuilder(decimal[0]);
                            }
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
                //Making sure each separate number has only one decimal place
                boolean hasOperation = false;
                int operationIndex = -1;
                boolean hasDecimalBeforeOperation = false;
                boolean hasDecimalAfterOperation = false;

                //Checks to see if the current text contains an operation
                for (int x = 0; x < currentText.length(); x++) {
                    char[] operations = {'+', 'ー', '*', '/', '^'};
                    for (int y = 0; y < 5; y++) {
                        if (currentText.charAt(x) == operations[y]) {
                            operationIndex = x;
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
                } else {
                    for (int x = operationIndex; x < currentText.length(); x++) {
                        if (currentText.charAt(x) == '.') {
                            hasDecimalAfterOperation = true;
                            break;
                        }
                    }
                }

                /* If the current text has no operation, then it can
                only have one decimal. If the current text does have
                an operation, then it can only have one decimal
                before and one decimal after the operation. */
                if (!hasOperation && !hasDecimalBeforeOperation) {
                    currentText.append(".");
                } else if (hasOperation && !hasDecimalAfterOperation) {
                    currentText.append(".");
                }
                break;
            default:
                //Any number button clicked adds the number to the end of current text
                currentText.append(input);
        }
        //The display at top of screen is set to the current text we have been editing
        displayText.setText(currentText.toString());
    }

    /**
     * Method to calculate the expression in the display.
     * This method is called when an operation is clicked.
     */
    public void SolveCurrentInput() {
        //Addition operation
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
        //Subtraction operation
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
        //Multiplication operation
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
        //Division operation
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
                currentText = new StringBuilder("error");
            } else if (exception) {
                currentText = new StringBuilder("error");
            } else {
                currentText = new StringBuilder(Double.toString(divisionOfCurrent));
            }
        }
        //Exponent operation
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
        //Removes decimal if it is unneeded
        String[] decimal = currentText.toString().split("\\.");
        if (decimal.length > 1) {
            if (decimal[1].equals("0")) {
                currentText = new StringBuilder(decimal[0]);
            }
        }
        //The display at top of screen is set to the current text we have been editing
        displayText.setText(currentText.toString());
    }

    /**
     * Method to check if the last character in the display is an operator.
     * Used when appending text to the display.
     */
    public boolean lastCharIsNotOperator() {
        char[] operations = {'+', 'ー', '*', '/', '^'};
        for (int x = 0; x < 5; x++) {
            if (currentText.charAt(currentText.length() - 1) == operations[x]) {
                return false;
            }
        }
        return true;
    }
}