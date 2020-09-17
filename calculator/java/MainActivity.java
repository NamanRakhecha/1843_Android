package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnadd,btnsub,btnmul,btndiv,btneql,btndot;
    Button btnclr;
    boolean add, sub, mul, div,decimal;
    TextView edt1;

    double input1 = 0, input2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn0 = (Button)findViewById(R.id.btn0);
        btnadd = (Button)findViewById(R.id.btnadd);
        btnsub = (Button)findViewById(R.id.btnsub);
        btnmul = (Button)findViewById(R.id.btnmul);
        btndiv = (Button)findViewById(R.id.btndiv);
        btneql = (Button)findViewById(R.id.btneql);
        btnclr = (Button)findViewById(R.id.btnclr);
        btndot = (Button)findViewById(R.id.btndot);

        edt1 = (TextView)findViewById(R.id.display);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText(edt1.getText() + "0");
            }
        });

        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt1.setText("");
                input1=0.0;
                input2=0.0;
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decimal){
                    //dontn
                }
                else{
                    edt1.setText(edt1.getText()+".");
                    decimal = true;
                }
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1.getText().length()!= 0){
                    input1 = Float.parseFloat(edt1.getText() + "");
                    add=true;
                    decimal=false;
                    edt1.setText(null);
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1.getText().length()!= 0){
                    input1 = Float.parseFloat(edt1.getText() + "");
                    sub=true;
                    decimal=false;
                    edt1.setText(null);
                }
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1.getText().length()!= 0){
                    input1 = Float.parseFloat(edt1.getText() + "");
                    mul=true;
                    decimal=false;
                    edt1.setText(null);
                }
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt1.getText().length()!= 0){
                    input1 = Float.parseFloat(edt1.getText() + "");
                    div=true;
                    decimal=false;
                    edt1.setText(null);
                }
            }
        });

        btneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add||sub||mul||div) {
                    if (edt1.getText() == "") {
                        input2 = 0;
                    } else {
                        input2 = Float.parseFloat(edt1.getText() + "");
                    }
                }
                if(add){
                    edt1.setText(input1 + input2 + "");
                    add=false;
                }

                if(sub){
                    edt1.setText(input1 - input2 + "");
                    sub=false;
                }

                if(mul){
                    edt1.setText(input1 * input2 + "");
                    mul=false;
                }

                if(div){
                    if(input2!=0){
                        edt1.setText(input1 / input2 + "");
                        div=false;
                    }
                }
            }
        });
    }
}
