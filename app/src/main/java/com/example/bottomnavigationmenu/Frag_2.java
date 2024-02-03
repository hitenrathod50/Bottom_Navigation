package com.example.bottomnavigationmenu;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Frag_2 extends Fragment {

    Context context;
    String s;
    Button toastName;


    public Frag_2(Context c) {
        context = c;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        s = getArguments().getString("Name");
        return inflater.inflate(R.layout.fragment_frag_2, container, false);
    }

    public void toastName(View v){
        Toast.makeText(context, "Name is "+s, Toast.LENGTH_SHORT).show();
    }
}