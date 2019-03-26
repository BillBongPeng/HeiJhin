package com.example.heijhin;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ContactUsActivity extends FragmentActivity {

    private String usNumber = "7036883047";
    private String cnNumber = "123456789";
    private static int PERMISSION_CALL = 0;
    private String[] email = {"yipeng0207@gmail.com"};
    private EditText subjectEmail, bodyEmail;
    private TextView mailUsHeading, callUsHeading, activityHeading;
    private ImageButton chinaCall, usCall;
    private Button sendMail;
    Switch emailSwitch;
    MailFragment mailFragment;
    boolean bool = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        activityHeading = (TextView)findViewById(R.id.contact_heading);
        //subjectEmail = (EditText)findViewById(R.id.contact_email_subject_edit_text);
        //bodyEmail = (EditText)findViewById(R.id.contact_email_body_edit_text);
        //sendMail = (Button)findViewById(R.id.contact_email_send_email);
        mailUsHeading = (TextView)findViewById(R.id.contact_mail_heading);
        callUsHeading = (TextView)findViewById(R.id.contact_call_heading);
        chinaCall = (ImageButton) findViewById(R.id.contact_cn_call);
        usCall = (ImageButton) findViewById(R.id.contact_us_call);
        emailSwitch = (Switch) findViewById(R.id.toggle_email_fragment);
        mailFragment = new MailFragment();
    }



    public void openFragment(View view){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations()
            if(bool){
                fragmentTransaction.remove(mailFragment);
            }else{
                fragmentTransaction.add(R.id.fragment_container, mailFragment);
            }
            bool = !bool;
            fragmentTransaction.commit();
    }


    @SuppressLint("MissingPermission")
    public void callNumber(View view) {
        int viewID = view.getId();
        Intent callNumber = new Intent(Intent.ACTION_CALL);

        switch (viewID) {
            case R.id.contact_us_call: {
                callNumber.setData(Uri.parse("tel:" + usNumber));
                checkCallPermissions();
                startActivity(callNumber);
                break;
            }
            case R.id.contact_cn_call: {
                callNumber.setData(Uri.parse("tel:" + cnNumber));
                checkCallPermissions();
                startActivity(callNumber);

            }
        }

    }
    /*
    public void sendEmailMethod(View view){
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.setType("message/rfc822");
        sendEmail.putExtra(Intent.EXTRA_EMAIL,email);
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, subjectEmail.getText().toString());
        sendEmail.putExtra(Intent.EXTRA_TEXT, bodyEmail.getText().toString());
        try{
            startActivity(Intent.createChooser(sendEmail,"Send email..."));
        }catch (android.content.ActivityNotFoundException e){
            Toast.makeText(this,"No Mail Client Found", Toast.LENGTH_SHORT).show();
        }
    }
    */
    void checkCallPermissions(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        }else{
            Toast.makeText(this,"Grant us Call Permission!", Toast.LENGTH_LONG).show();
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                    Toast.makeText(this,"We need this to complete your call!", Toast.LENGTH_LONG);
                    }else{
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},PERMISSION_CALL);
                }
            }else {
                Toast.makeText(this,"Thanks, Permission Check Passed!",Toast.LENGTH_LONG).show();
            }
        }
    }

}
