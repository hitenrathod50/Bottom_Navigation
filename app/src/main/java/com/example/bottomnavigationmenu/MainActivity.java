package com.example.bottomnavigationmenu;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frag;
    EditText text;
    BottomNavigationView bV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag = findViewById(R.id.frameLayout);
        bV = findViewById(R.id.bottomMenu);
        setFragmentToScreen(new Frag_1(),0);
        bV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.home){
                    setFragmentToScreen(new Frag_1(),1);
                } else if (id==R.id.search_places) {
                    setFragmentToScreen(new Frag_2(MainActivity.this),1);
                }
                else if (id==R.id.plan_trip) {
                    setFragmentToScreen(new Frag_3(MainActivity.this),1);
                }
                else if (id==R.id.reviews) {
                    setFragmentToScreen(new Frag_4(MainActivity.this),1);
                }
                else {
                    setFragmentToScreen(new Frag_5(MainActivity.this),1);
                }

                return true;
            }
        });
    }

    private void setFragmentToScreen(Fragment fragment, int flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag == 0){
            ft.add(R.id.frameLayout,fragment);
        } else if (flag == 1) {
            Bundle b = new Bundle();
            b.putString("Name","ChadarMod");
            fragment.setArguments(b);
            ft.replace(R.id.frameLayout,fragment);
        }
        ft.commit();
    }
}