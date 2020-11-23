package com.example.tabsfrag;

import androidx.annotation.NonNull;;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;


import com.google.android.material.textview.MaterialTextView;



public class MainActivity extends AppCompatActivity {
    public static final String sendMessage="com.example.materialapp";

    profile name= new profile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayShowTitleEnabled(false);

        ViewPager vpager = findViewById(R.id.viewpager);
        vpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        TabLayout tab= findViewById(R.id.tablayout);
        tab.setupWithViewPager(vpager);
    }
    public class ViewPagerAdapter extends FragmentPagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new tab1(); //ChildFragment1 at position 0
                case 1:
                    return new tab2(); //ChildFragment2 at position 1


            }
            return null; //does not happen
        }

        @Override
        public int getCount() {
            return 2; //three fragments
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = getItem(position).getClass().getName();
            return title.subSequence(title.lastIndexOf(".") + 1, title.length());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.ok:
                TextInputEditText test= findViewById(R.id.name);
                test.setText(name.name);


                MaterialTextView test2= findViewById(R.id.nametxt);
                test2.setText(test.getText().toString());

                TextInputEditText email= findViewById(R.id.mail);
                email.setText(name.email);

                TextInputEditText phone= findViewById(R.id.phone);
                phone.setText(name.phone);

                TextInputEditText password= findViewById(R.id.password);
                password.setText(name.password);

                TextInputEditText re_password= findViewById(R.id.re_password);
                re_password.setText(name.re_password);

        }
        return super.onOptionsItemSelected(item);
    }



}