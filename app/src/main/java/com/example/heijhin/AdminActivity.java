package com.example.heijhin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    TextView mUpdatePassword, mUpdateArtist, mUpdateEmail, mUpdateNumber;
    UpdateFragment mUpdatePasswordFragment, mUpdateArtistFragment, mUpdateEmailFragment, mUpdateNumberFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initializeViews();
    }

    void initializeViews(){
        mUpdatePassword = findViewById(R.id.admin_password_update_text_view);
        mUpdatePasswordFragment = new UpdateFragment();
        mUpdateEmail = findViewById(R.id.admin_update_contact_text_view);
        mUpdateEmailFragment = new UpdateFragment();
        mUpdateNumber = findViewById(R.id.admin_update_contact_number_text_view);
        mUpdateNumberFragment = new UpdateFragment();
        mUpdateArtist = findViewById(R.id.admin_update_artist_profile_text_view);
        mUpdateArtistFragment = new UpdateFragment();

    }
}
