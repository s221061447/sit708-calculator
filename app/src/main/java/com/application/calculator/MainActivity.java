package com.application.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    TextView answer;
    EditText valueOne;
    EditText valueTwo;
    Button addButton;
    Button subtractButton;

    Double numberOne;
    Double numberTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = findViewById(R.id.answer);
        valueOne = findViewById(R.id.valueOne);
        valueTwo = findViewById(R.id.valueTwo);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);

        addButton.setOnClickListener(view -> {
            numberOne = getDouble(valueOne.getText().toString());
            numberTwo = getDouble(valueTwo.getText().toString());
            if (numberOne == null) {
                Toast.makeText(MainActivity.this, "Invalid first number!", Toast.LENGTH_LONG).show();
                return;
            } else if (numberTwo == null) {
                Toast.makeText(MainActivity.this, "Invalid second number!", Toast.LENGTH_LONG).show();
                return;
            } else {
                answer.setText(MessageFormat.format("Answer: {0}", (numberOne + numberTwo)));
            }
        });

        subtractButton.setOnClickListener(view -> {
            numberOne = getDouble(valueOne.getText().toString());
            numberTwo = getDouble(valueTwo.getText().toString());
            if (numberOne == null) {
                Toast.makeText(MainActivity.this, "Invalid first number!", Toast.LENGTH_LONG).show();
                return;
            } else if (numberTwo == null) {
                Toast.makeText(MainActivity.this, "Invalid second number!", Toast.LENGTH_LONG).show();
                return;
            } else {
                answer.setText(MessageFormat.format("Answer: {0}", (numberOne - numberTwo)));
            }
        });

    }

    private Double getDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch(NumberFormatException e) {
            return null;
        }
    }

}