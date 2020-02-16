package com.example.myapplication.navigation.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import java.util.Random;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private TextView typedata;
    private TextView timedata;
    private String typetext;
    private String timetext;

    Random JsonData = new Random();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        timedata = root.findViewById(R.id.timedata);
        typedata = root.findViewById(R.id.typedata);

        String[] recyclingType = new String[]{"", "BALLYFERMOT", "COLLINS AVENUE", "COOLOCK", "EAMONN CEANT", "GRANGE GORMAN", "MARLBOROUGH LANE", "RATHMINES ", "WINDMILL ROAD"};
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, recyclingType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner typespinner = root.findViewById(R.id.typespinner);

        typespinner.setAdapter(typeAdapter);
        typespinner.setSelection(0, true);

        String[] time = new String[]{"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, time);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner timespinner = root.findViewById(R.id.timespinner);
        timespinner.setAdapter(timeAdapter);
        timespinner.setSelection(0, true);
        typespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String json = String.valueOf((JsonData.nextInt(20000) % (10001) + 10000));
                typetext = typespinner.getSelectedItem().toString();
                typedata.setText(typetext + " has " + json + "kg Dry Garbage ");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        timespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                timetext = (String) timespinner.getSelectedItem();
                timedata.setText("on " + timetext);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return root;
    }
}