package com.example.message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class nama2 extends AppCompatActivity {

    TextInputEditText nama2;

    public static final String USER = "nama2";

    public RecyclerView mrecyclerview;
    public RecyclerAdaptor recyclerAdaptor;

    final ArrayList<Message> texts = Message_store.getInstance().chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama2);

        nama2=(TextInputEditText)findViewById(R.id.nama2);
        nama2.setHint("nama2");

        recyclerAdaptor = new RecyclerAdaptor(texts,USER);

        mrecyclerview = (RecyclerView)findViewById(R.id.nama2r);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerview.setAdapter(recyclerAdaptor);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_example,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.change:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void nama2send(View view) {
        if(nama2.getText().toString().length()!=0) {
            String msg = nama2.getText().toString();
            nama2.setText("");
            nama2.setHint("Type A message");
            texts.add(new Message(msg,"nama2"));
            recyclerAdaptor = new RecyclerAdaptor(texts,USER);
            mrecyclerview.setAdapter(recyclerAdaptor);

        }

    }

}