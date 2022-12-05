package com.example.mycanvasapp.Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mycanvasapp.R;
import com.example.mycanvasapp.StudentView.StudentView;

public class EditProfileActivity extends AppCompatActivity {

    ImageView imageView_editProfilePicture;
    EditText editText_editName;
    EditText editText_editContact;
    EditText editText_editStatus;

    Button button_doneEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        imageView_editProfilePicture = (ImageView) findViewById(R.id.imageView_editProfilePicture);
        editText_editName = (EditText) findViewById(R.id.editText_editName);
        editText_editContact = (EditText) findViewById(R.id.editText_editContact);
        editText_editStatus = (EditText) findViewById(R.id.editText_editStatus);
        button_doneEditProfile = (Button) findViewById(R.id.button_doneEditProfile);

//        imageView_editProfilePicture.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openGalleryActivity();
//            }
//        });

        button_doneEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingsActivity();
            }
        });
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, StudentView.class);
        Bundle bundle = new Bundle();

        bundle.putString("name", editText_editName.getText().toString());
        bundle.putString("contact", editText_editContact.getText().toString());
        bundle.putString("status", editText_editStatus.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}