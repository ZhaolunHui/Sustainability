package com.example.myapplication.navigation.ui.tips;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

public class TipsFragment extends Fragment {

    private TipsViewModel tipsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tipsViewModel =
                ViewModelProviders.of(this).get(TipsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tips, container, false);
        final TextView textView = root.findViewById(R.id.text_tips);
        tipsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        // using intent to switch pages from fragment to activity
        Button moreInfo_btn = root.findViewById(R.id.moreInfo_btn);

        moreInfo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Calculator.class);
                startActivity(intent);
            }
        });

        // The following button control the play of the YouTube video
        Button youtube_btn = root.findViewById(R.id.youtube_btn);

        youtube_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Youtube.class);
                startActivity(intent);
            }
        });

        return root;
    }
}