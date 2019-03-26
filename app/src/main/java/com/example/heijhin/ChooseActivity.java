package com.example.heijhin;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ChooseActivity extends AppCompatActivity {
    ImageView switcherTop;
    ImageView switcherBot;
    private TypedArray standardGallery, wujiGallery;
    int i;

    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        standardGallery = getResources().obtainTypedArray(R.array.standard_gallery);
        wujiGallery = getResources().obtainTypedArray(R.array.wuji_gallery);
        switcherTop = (ImageView)findViewById(R.id.choose_image_view_1);
        switcherBot = (ImageView)findViewById(R.id.choose_image_view_2);
        initializeImage(switcherTop,standardGallery);
        initializeImage(switcherBot,wujiGallery);


        switcherTop.setClickable(true);
        switcherTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchStandardGalleryIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(launchStandardGalleryIntent);
            }
        });


        switcherBot.setClickable(true);
        switcherBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchWujiGalleryIntent = new Intent(getApplicationContext(), WujiGalleryActivity.class);
                startActivity(launchWujiGalleryIntent);
            }
        });

    }

    public void nextImageForward(View view){
        int viewID = view.getId();
        switch (viewID){
            //TODO Implement the correct method for going through images
            case R.id.choose_top_right_button:{

                    if(i == standardGallery.length()){
                        Toast.makeText(this,"End of the Gallery",Toast.LENGTH_LONG).show();

                    }else{
                        i++;
                        switcherTop.setBackgroundResource(standardGallery.getResourceId(i,0));
                        switcherTop.invalidate();
                    }
                    break;
            }
            case R.id.choose_bot_right_button:{

                    if(i == wujiGallery.length()){
                        Toast.makeText(this,"End of the Gallery",Toast.LENGTH_LONG).show();
                    }else{
                        i++;
                        switcherBot.setBackgroundResource(wujiGallery.getResourceId(i,0));
                        switcherBot.invalidate();

                    }

            }
        }
    }

    public void nextImageBackward(View view){
        int viewID = view.getId();
        switch (viewID){
            //TODO Implement the correct method for going through images
            case R.id.choose_top_left_button:{

                    if(i == 0){
                        Toast.makeText(this,"Beginning of the Gallery",Toast.LENGTH_LONG).show();

                    }else{
                        i--;
                        switcherTop.setBackgroundResource(standardGallery.getResourceId(i,0));
                        switcherTop.invalidate();
                    }

                break;
            }
            case R.id.choose_bot_left_button:{

                    if(i == 0){
                        Toast.makeText(this,"Beginning of the Gallery",Toast.LENGTH_LONG).show();
                    }else{
                        i--;
                        switcherBot.setBackgroundResource(wujiGallery.getResourceId(i,0));
                        switcherBot.invalidate();

                }
            }
        }
    }

    public void initializeImage(ImageView view, TypedArray array){
        view.setBackgroundResource(array.getResourceId(0,0));
    }
}



