package com.example.heijhin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView mImageView;
    TextView textViewTitle;
    TextView textViewName;
    TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView = (ImageView)findViewById(R.id.detail_image_view);
        textViewTitle = (TextView)findViewById(R.id.detail_art_title);
        textViewName = (TextView)findViewById(R.id.detail_artist_name);
        textViewInfo = (TextView)findViewById(R.id.detail_art_info);

        textViewTitle.setText(getIntent().getStringExtra("title"));
        textViewName.setText(getIntent().getStringExtra("name"));
        textViewInfo.setText(getIntent().getStringExtra("info"));
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0)).into(mImageView);
    }
}
