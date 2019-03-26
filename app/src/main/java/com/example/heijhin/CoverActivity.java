package com.example.heijhin;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.Locale;

public class CoverActivity extends AppCompatActivity {
    ImageView backgroundImageView;
    TextView mTitleTextView;
    ScrollView mScrollView;
    TextView mTextView, mChineseLabel, mEnglishLabel;
    Switch mLanguageSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);
        mTitleTextView = findViewById(R.id.cover_title);
        mScrollView = findViewById(R.id.cover_scroll);
        mTextView = findViewById(R.id.cover_subHeading);
        // Method using animations for the GIF display
        backgroundImageView = findViewById(R.id.image_view_animation);
        backgroundImageView.setImageDrawable(getResources().getDrawable(R.drawable.cover_animation));
        AnimationDrawable progressAnimation = (AnimationDrawable) backgroundImageView.getDrawable();
        progressAnimation.start();
        mLanguageSwitch = findViewById(R.id.language_switch);
        mChineseLabel = findViewById(R.id.switch_label_chinese);
        mEnglishLabel = findViewById(R.id.switch_label_english);


        //TODO Button is too small, customize a better UI
        //Using Glide to load the GIF
        /*
        backgroundImageView = findViewById(R.id.image_view_animation);
                Glide.with(this)
                .load("/assets/sparkling.gif")
                .asGif()
                .placeholder(R.drawable.sparkling)
                .crossFade()
                .into(backgroundImageView);
                */
    }

    public void launchChooseActivity(View view) {
        Intent launchChooseActivityIntent = new Intent(this, ChooseActivity.class);
        startActivity(launchChooseActivityIntent);
    }

    public void launchAboutUsActivity(View view){
        Intent launchAboutUsActivityIntent = new Intent(this, AboutUsActivity.class);
        startActivity(launchAboutUsActivityIntent);
    }

    public void launchContactUsActivity(View view){
        Intent launchContactUsActivityIntent = new Intent(this, ContactUsActivity.class);
        startActivity(launchContactUsActivityIntent);
    }

    //As the activity refreshes, the state of the switch is refreshed as well.
    public void changeLang(View view){
        boolean bool = mLanguageSwitch.isChecked();
        Intent refresh = new Intent(this, CoverActivity.class);
        if(bool){
            changeLanguage("en");
            //startActivity(refresh);
            finish();
        }else {
            changeLanguage("cn");
            //startActivity(refresh);
            finish();
        }
    }
    /*
    public void setLocale(String lang){
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, CoverActivity.class);
        startActivity(refresh);
        finish();
    }
    */
    public void changeLanguage(String language){
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }
}
