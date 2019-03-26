package com.example.heijhin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    TextView mLogInLabel, mGuestLabel;
    EditText mAccountEditText;
    Button mLogInButton, mSudoLogInButton;
    String password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mLogInLabel = (TextView)findViewById(R.id.log_in_textView_log_in_label);
        mGuestLabel = (TextView)findViewById(R.id.log_in_textView_guest_label);
        mAccountEditText = (EditText)findViewById(R.id.log_in_editText);
        mSudoLogInButton = (Button)findViewById(R.id.log_in_sudo_button);
        mLogInButton = (Button)findViewById(R.id.log_in_button);
    }

    public void checkLogInSequence(View view){
        Intent launchAdminActivity = new Intent(this, AdminActivity.class);
        String enteredText = mAccountEditText.getText().toString();
        if(enteredText.equals(password)){
            startActivity(launchAdminActivity);
        }else{
            Toast.makeText(this,"The entered password does not match!",Toast.LENGTH_LONG).show();
        }
    }


    public void continueAsGuest(View view) {
        Intent launchCoverActivity = new Intent(this, CoverActivity.class);
        startActivity(launchCoverActivity);
    }
}
