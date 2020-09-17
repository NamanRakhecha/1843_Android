package com.example.sendtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et;
    String st;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        et=findViewById(R.id.edittext);
        Intent i= getIntent();
        String st1=getIntent().getStringExtra("Value");
        tv=findViewById(R.id.textView3);
        tv.setText(st1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                st=et.getText().toString();
                i.putExtra("Value",st);
                startActivity(i);

            }
        });

}

}



