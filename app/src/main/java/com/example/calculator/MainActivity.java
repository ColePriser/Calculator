package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = findViewById(R.id.input);
        displayText.setShowSoftInputOnFocus(false);

        displayText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getString(R.string.display).equals(displayText.getText().toString())) {
                    displayText.setText("");
                }
            }
        });
    }

    public void zeroButton(View view) {

    }

    public void oneButton(View view) {

    }

    public void twoButton(View view) {

    }

    public void threeButton(View view) {

    }

    public void fourButton(View view) {

    }

    public void fiveButton(View view) {

    }

    public void sixButton(View view) {

    }

    public void sevenButton(View view) {

    }

    public void eightButton(View view) {

    }

    public void nineButton(View view) {

    }

    public void plusMinusButton(View view) {

    }

    public void decimalButton(View view) {

    }

    public void equalsButton(View view) {

    }

    public void plusButton(View view) {

    }

    public void minusButton(View view) {

    }

    public void multiplyButton(View view) {

    }

    public void divideButton(View view) {

    }

    public void exponentButton(View view) {

    }

    public void fractionButton(View view) {

    }

    public void percentButton(View view) {

    }

    public void parButton(View view) {

    }

    public void clearButton(View view) {

    }

    public void deleteButton(View view) {

    }
}