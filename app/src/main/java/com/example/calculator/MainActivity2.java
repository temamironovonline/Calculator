package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    TextView firstNumber;
    TextView sign;
    TextView secondNumber;
    TextView eq;
    TextView result;

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
    Button expon;
    Button root;
    Button sin;
    Button cos;
    Button clear;
    Button equals;

    Button transition;

    String act;
    boolean fnum;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        act = "";
        fnum = true;

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
        expon = findViewById(R.id.expon);
        root = findViewById(R.id.root);
        sin = findViewById(R.id.sin);
        cos = findViewById(R.id.cos);
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
        expon.setOnClickListener(this);
        root.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
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
                Intent intent = new Intent(this, MainActivity.class);
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
            case R.id.expon:
            case R.id.root:
            case R.id.sin:
            case R.id.cos:
                Button button1 = (Button) view;
                act = button1.getText().toString();
                sign.setText(act);
                if (act.equals("^"))
                {
                    secondNumber.setVisibility(View.VISIBLE);
                    fnum = false;
                }
                if (act.equals("√"))
                {
                    secondNumber.setVisibility(View.VISIBLE);
                    fnum = false;
                }
                if (act.equals("sin")) fnum = true;
                if (act.equals("cos")) fnum = true;
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
                double num1 = Double.valueOf(firstNumber.getText().toString());
                double num2 = Double.valueOf(secondNumber.getText().toString());
                double res;

                if (act.equals("^"))
                {
                    res = Math.pow(num1, num2);
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("√"))
                {
                    res = Math.pow(num1, 1/num2);
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("sin"))
                {
                    res = Math.sin(Math.toRadians(num1));
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                if (act.equals("cos"))
                {
                    res = Math.cos(Math.toRadians(num1));
                    result.setText(String.valueOf(res));
                    eq.setText("=");
                }
                break;
        }
    }
}