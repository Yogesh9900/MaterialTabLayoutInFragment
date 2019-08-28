package com.ofex.tabbedlayoutexample;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;


public class MaterialTabLayoutFragment extends Fragment {

Button btnNext, btnPrevious, btnAddVehicle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_material_tab_layout, container, false);


        btnPrevious = view.findViewById(R.id.btn_previous);
        btnNext = view.findViewById(R.id.btn_next);
        btnAddVehicle = view.findViewById(R.id.add);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getActivity(), Objects.requireNonNull(getActivity()).getSupportFragmentManager());
        NonSwipeableViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);


        final TabLayout tabs = (TabLayout) view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        LinearLayout tabStrip = ((LinearLayout)tabs.getChildAt(0));
        for(int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPrevious.setVisibility(View.VISIBLE);
                btnAddVehicle.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.GONE);
                Objects.requireNonNull(tabs.getTabAt(1)).select();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPrevious.setVisibility(View.GONE);
                btnNext.setVisibility(View.VISIBLE);
                btnAddVehicle.setVisibility(View.GONE);
                Objects.requireNonNull(tabs.getTabAt(0)).select();
            }
        });

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

}
