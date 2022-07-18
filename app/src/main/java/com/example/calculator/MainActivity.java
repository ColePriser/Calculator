package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText displayText;

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

    private void updateDisplayText(String add) {
        String prev = displayText.getText().toString();
        int index = displayText.getSelectionStart();
        displayText.setText(String.format("%s%s%s", prev.substring(0, index), add, prev.substring(index)));
        displayText.setSelection(index + 1);
    }

    public void zeroButton(View view) {
        updateDisplayText("0");
    }

    public void oneButton(View view) {
        updateDisplayText("1");
    }

    public void twoButton(View view) {
        updateDisplayText("2");
    }

    public void threeButton(View view) {
        updateDisplayText("3");
    }

    public void fourButton(View view) {
        updateDisplayText("4");
    }

    public void fiveButton(View view) {
        updateDisplayText("5");
    }

    public void sixButton(View view) {
        updateDisplayText("6");
    }

    public void sevenButton(View view) {
        updateDisplayText("7");
    }

    public void eightButton(View view) {
        updateDisplayText("8");
    }

    public void nineButton(View view) {
        updateDisplayText("9");
    }

    public void plusMinusButton(View view) {
        updateDisplayText("-");
    }

    public void decimalButton(View view) {
        updateDisplayText(".");
    }

    public void equalsButton(View view) {

    }

    public void plusButton(View view) {
        updateDisplayText("+");
    }

    public void minusButton(View view) {
        updateDisplayText("-");
    }

    public void multiplyButton(View view) {
        updateDisplayText("×");
    }

    public void divideButton(View view) {
        updateDisplayText("÷");
    }

    public void squaredButton(View view) {
        updateDisplayText("^2");
    }

    public void fractionButton(View view) {
    }

    public void percentButton(View view) {
        updateDisplayText("%");
    }

    public void squareRootButton(View view) {
        updateDisplayText("^1/2");
    }

    public void fullClearButton(View view) {
        displayText.setText("");
    }

    public void topClearButton(View view) {

    }

    public void deleteButton(View view) {
        int len = displayText.getText().length();
        int index = displayText.getSelectionStart();
        if (index != 0) {
            if (len != 0) {
                SpannableStringBuilder newDisplay = (SpannableStringBuilder) displayText.getText();
                newDisplay.replace(index - 1, index, "");
                displayText.setText(newDisplay);
                displayText.setSelection(index - 1);
            }
        }

    }
}