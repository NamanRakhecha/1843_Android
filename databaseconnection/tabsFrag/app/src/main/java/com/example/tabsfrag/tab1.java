package com.example.tabsfrag;


import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1 extends Fragment {

Button uploadbtn ,viewbtn;
    TextInputEditText test , email ,phone,password,re_password;

    SQLiteDatabase myDB;

    dbHelper db;

    public tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        TextInputEditText nameinput;
        uploadbtn = (Button) view.findViewById(R.id.uploadbtn);
        viewbtn = (Button) view.findViewById(R.id.viewbtn);

         test= view.findViewById(R.id.name);
         email= view.findViewById(R.id.mail);
         phone= view.findViewById(R.id.phone);
         password= view.findViewById(R.id.password);
         re_password= view.findViewById(R.id.re_password);

         db = new dbHelper(getContext());

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = test.getText().toString();
                String mail= email.getText().toString();
               String no= phone.getText().toString();
              String pass=  password.getText().toString();
               String repass= re_password.getText().toString();

               Boolean checkinsertdata = db.insertinfo(name,mail,no,pass,repass);
               if(checkinsertdata==true){
                    Toast.makeText(getContext(),"inserted value", Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getContext(),"Could no insert value", Toast.LENGTH_SHORT).show();
               }


            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(getContext(),"no Entry in Database",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("name"+res.getString(0)+"\n");
                    buffer.append("no"+res.getString(1)+"\n");
                    buffer.append("email"+res.getString(2)+"\n");
                    buffer.append("pass"+res.getString(3)+"\n");
                    buffer.append("re-pass"+res.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("User Info");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

        nameinput= (TextInputEditText) view.findViewById(R.id.name);
        return view;


    }


}
