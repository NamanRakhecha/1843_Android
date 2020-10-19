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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextInputEditText nama;

    public static final String USER = "nama";

    public RecyclerView mrecyclerview;
    public RecyclerAdaptor recyclerAdaptor;

    final ArrayList<Message> texts = Message_store.getInstance().chats;
    List<String> message;
    List<String> sentby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = new ArrayList<>();
        sentby = new ArrayList<>();
        recyclerAdaptor = new RecyclerAdaptor(texts,USER);
        mrecyclerview = (RecyclerView)findViewById(R.id.namar);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mrecyclerview.setAdapter(recyclerAdaptor);
        nama=(TextInputEditText)findViewById(R.id.nama);
        nama.setHint("nama");
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
                Intent i = new Intent(this,nama2.class);
                startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    public void send(View view) {
        if(nama.getText().toString().length()!=0) {
            String msg_tom = nama.getText().toString();
            texts.add(new Message(msg_tom,"nama"));
            nama.setText("");
            nama.setHint("Type A message");
            recyclerAdaptor = new RecyclerAdaptor(texts,USER);
            mrecyclerview.setAdapter(recyclerAdaptor);
        }
    }

}