package com.example.myapplication.navigation.ui.contact;

import android.content.Intent;
import android.net.Uri;
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

public class ContactFragment extends Fragment {

    private ContactViewModel contactViewModel;
    Button gmail;
    Button web;
    Button phone;
    Button message;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        final TextView textView = root.findViewById(R.id.text_contact);
        contactViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        gmail = root.findViewById(R.id.button4);
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://mail.google.com/");
                Intent i = new Intent();
                i.setData(uri);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        web = root.findViewById(R.id.button9);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.google.com/");
                Intent i = new Intent();
                i.setData(uri);
                i.setAction(Intent.ACTION_VIEW);
                startActivity(i);
            }
        });

        phone = root.findViewById(R.id.button7);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:(01)7167777");
                Intent i = new Intent();
                i.setData(uri);
                i.setAction(Intent.ACTION_DIAL);
                startActivity(i);
            }
        });

        message = root.findViewById(R.id.button6);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:(01)7167777");
                Intent i = new Intent();
                i.setData(uri);
                i.putExtra("sms_body", "Say Your Word!");
                i.setAction(Intent.ACTION_SENDTO);
                startActivity(i);
            }
        });
        return root;
    }
}