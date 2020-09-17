package com.example.sendtext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;
    String st;
    EditText et;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    tv=findViewById(R.id.textView);
    st=getIntent().getExtras().getString("Value");
    tv.setText(st);



    et=findViewById(R.id.editText);
    et.setText(st);

    btn=findViewById(R.id.button1);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(SecondActivity.this,thirdactivity.class);
            st=et.getText().toString();
            i.putExtra("Value",st);
            startActivity(i);

        }
    });

    }
}
