package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView firstNumber;
    TextView sign;
    TextView secondNumber;
    TextView eq;
    TextView result;

    String[] history = new String[5];

    Button zero;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    Button clear;
    Button equals;

    Button transition;

    String act;
    boolean fnum;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act = "";
        fnum = true;

        ArrayAdapter<String> mathHistory = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, history);
        mathHistory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spHistory = (Spinner) findViewById(R.id.spHistory);
        spHistory.setAdapter(mathHistory);

        firstNumber = findViewById(R.id.firstNumber);
        sign = findViewById(R.id.sign);
        secondNumber = findViewById(R.id.secondNumber);
        eq = findViewById(R.id.eq);
        result = findViewById(R.id.result);

        firstNumber.setOnClickListener(this);
        secondNumber.setOnClickListener(this);

        firstNumber.setText("");
        secondNumber.setText("");

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
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        equals = findViewById(R.id.equals);
        transition = findViewById(R.id.transition);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        equals.setOnClickListener(this);
        transition.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.firstNumber:
                fnum = true;
                break;
            case R.id.secondNumber:
                fnum = false;
                break;
            case R.id.transition:
                Intent intent = new Intent(this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.zero:
            case R.id.one:
            case R.id.two:
            case R.id.three:
            case R.id.four:
            case R.id.five:
            case R.id.six:
            case R.id.seven:
            case R.id.eight:
            case R.id.nine:
                Button button = (Button) view;
                String numText;
                if (fnum) {
                    numText = firstNumber.getText().toString();
                    numText += button.getText().toString();
                    firstNumber.setText(numText);
                } else {
                    numText = secondNumber.getText().toString();
                    numText += button.getText().toString();
                    secondNumber.setText(numText);
                }
                break;
            case R.id.plus:
            case R.id.minus:
            case R.id.multiply:
            case R.id.divide:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                sign.setText(act);
                fnum = false;

                break;
            case R.id.clear:
                firstNumber.setText("");
                secondNumber.setText("");
                result.setText("");
                sign.setText("");
                eq.setText("");
                fnum = true;
                break;
            case R.id.equals:
               String checkFirst = firstNumber.getText().toString();
               String checkSecond = secondNumber.getText().toString();
                if (checkFirst.equals("")) firstNumber.setText("0");
                if (checkSecond.equals("")) secondNumber.setText("0");
                float num1 = Float.valueOf(firstNumber.getText().toString());
                float num2 = Float.valueOf(secondNumber.getText().toString());
                float res = 0;

                if (act.equals("+"))
                {
                    res = num1 + num2;
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("-"))
                {
                    res = num1 - num2;
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("*"))
                {
                    res = num1 * num2;
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("/"))
                {
                    res = num1 / num2;
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }

                for (int i = 3; i >= 0; i--)
                {
                    history[i+1] = history[i];
                }
                history[0] = String.valueOf(res);
                break;
        }
    }
}