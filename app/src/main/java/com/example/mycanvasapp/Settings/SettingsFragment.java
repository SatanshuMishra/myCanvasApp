package com.example.mycanvasapp.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycanvasapp.R;

public class SettingsFragment extends Fragment {

    ImageView imageView_profilePicture;
    TextView textView_name;
    TextView textView_contact;
    TextView textView_status;
    Button button_editProfile;
    TextView textView_appearance;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        imageView_profilePicture = view.findViewById(R.id.imageView_profilePicture);
        textView_name = view.findViewById(R.id.textView_name);
        textView_contact = view.findViewById(R.id.textView_contact);
        textView_status = view.findViewById(R.id.textView_status);
        button_editProfile = view.findViewById(R.id.button_editProfile);
        textView_appearance = view.findViewById(R.id.textView_appearance);

        button_editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });

        textView_appearance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAppearanceActivity();
            }
        });

        return view;
    }

    public void openEditProfileActivity() {
        Intent openEditProfile = new Intent(getActivity(), EditProfileActivity.class);
        startActivity(openEditProfile);
    }

    public void openAppearanceActivity() {
        Intent openAppearance = new Intent(getActivity(), AppearanceActivity.class);
        startActivity(openAppearance);

    }
}