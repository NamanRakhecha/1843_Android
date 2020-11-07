package com.example.jsonassign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    Button data;
    public static MaterialTextView fetchdata;
    public static  MaterialTextView totalSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data= (Button) findViewById(R.id.data);
        fetchdata = (MaterialTextView) findViewById(R.id.dataview);
        SortData sortData = new SortData();
        sortData.execute();
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),SortData.totalsalary.toString(),Toast.LENGTH_LONG).show();

            }
        });
    }
}