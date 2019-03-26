package com.example.heijhin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MailFragment extends Fragment implements View.OnClickListener {

    EditText subjectEditText, bodyEditText;
    Button sendMailButton;
    private String[] email = {"yipeng0207@gmail.com"};


    public MailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mail, container, false);
        EditText subjectEditText = (EditText) view.findViewById(R.id.frag_contact_email_subject_edit_text);
        EditText bodyEditText = (EditText) view.findViewById(R.id.frag_contact_email_body_edit_text);
        Button sendMail = (Button) view.findViewById(R.id.frag_contact_email_send_email);
        sendMail.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }



    public void sendEmailMethod(View view){
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.setType("message/rfc822");
        sendEmail.putExtra(Intent.EXTRA_EMAIL,email);
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, subjectEditText.getText().toString());
        sendEmail.putExtra(Intent.EXTRA_TEXT, bodyEditText.getText().toString());
        try{
            startActivity(Intent.createChooser(sendEmail,"Send email..."));
        }catch (android.content.ActivityNotFoundException e){
            Toast.makeText(getContext(),"No Mail Client Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        sendEmailMethod(view);
    }
}
