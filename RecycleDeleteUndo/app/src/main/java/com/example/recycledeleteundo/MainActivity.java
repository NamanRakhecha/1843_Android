package com.example.recycledeleteundo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView RV ;
    ArrayList<model> list;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RV = (RecyclerView) findViewById(R.id.RV);
        populatelist();

        adapter = new Adapter(this, list);
        RV.setAdapter(adapter);
        RV.setItemAnimator(new DefaultItemAnimator());
        RV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
    }

    private void populatelist() {
        list = new ArrayList<>();
        list.add(new model("abc",R.drawable.dark));
        list.add(new model("def",R.drawable.guns));
        list.add(new model("ghi",R.drawable.dark));
        list.add(new model("jkl",R.drawable.guns));
        list.add(new model("mno",R.drawable.dark));
        list.add(new model("pqr",R.drawable.guns));
        list.add(new model("stu",R.drawable.dark));
        list.add(new model("vwx",R.drawable.guns));
        list.add(new model("yz",R.drawable.dark));
        list.add(new model("123",R.drawable.guns));
        list.add(new model("456",R.drawable.dark));
        list.add(new model("789",R.drawable.guns));
        list.add(new model("0+-",R.drawable.dark));
        list.add(new model("#@*",R.drawable.guns));







    }
}