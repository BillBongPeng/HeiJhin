package com.example.heijhin;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "art_table")
public class Art{

    //Descriptors
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "art_title")
    private String artTitle;
    @NonNull
    @ColumnInfo(name = "art_info")
    private String artInfo;
    @NonNull
    @ColumnInfo(name = "artist")
    private String artist;
    @NonNull
    @ColumnInfo(name = "year")
    private int year;
    @NonNull
    @ColumnInfo(name = "imageNum")
    private int imageNum;

    //Constructor
    public Art(String artTitle, String artInfo, String artist, int year, int imageNum){
        this.artTitle = artTitle;
        this.artInfo = artInfo;
        this.artist = artist;
        this.year = year;
        this.imageNum = imageNum;
    }


    //Get Methods
    public String getArtTitle(){return this.artTitle;}
    public String getArtInfo(){return this.artInfo;}
    public String getArtist(){return this.artist;}
    public int getYear(){return this.year;}
    public int getImageNum() {return this.imageNum;}
}

