package com.example.heijhin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    ImageView artistImageView1, artistImageView2;
    TextView artistName1, artistInfo1 , artistName2, artistInfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        artistImageView1 = (ImageView)findViewById(R.id.artist_picture1);
        artistName1 = (TextView)findViewById(R.id.artist_name1);
        artistInfo1 = (TextView)findViewById(R.id.artist_info1);
        artistImageView2 = (ImageView)findViewById(R.id.artist_picture2);
        artistName2 = (TextView)findViewById(R.id.artist_name2);
        artistInfo2 = (TextView)findViewById(R.id.artist_info2);
    }
}
