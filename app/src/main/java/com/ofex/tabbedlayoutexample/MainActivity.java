package com.ofex.tabbedlayoutexample;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button materialTabLayout = findViewById(R.id.materialTabLayout);
        materialTabLayout.setVisibility(View.VISIBLE);
        materialTabLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialTabLayout.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction;
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MaterialTabLayoutFragment());
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}