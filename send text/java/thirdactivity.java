package com.example.sendtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class thirdactivity extends AppCompatActivity {


    EditText et;
    TextView tv;
    String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);

        et=findViewById(R.id.et);
        tv=findViewById(R.id.textView2);
        st=getIntent().getExtras().getString("Value");
        et.setText(st);
        tv.setText(st);
    }

    public void abc(View view) {

        Intent i = new Intent(thirdactivity.this,MainActivity.class);
        st=et.getText().toString();
        i.putExtra("Value",st);
        startActivity(i);


    }
}
