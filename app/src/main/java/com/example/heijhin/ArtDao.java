package com.example.heijhin;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

//Map java method call to an SQL query

@Dao
public interface ArtDao {

    @Query("SELECT * from art_table ORDER BY art_title ASC")
    LiveData<List<Art>> getNumberedArtTitle();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Art art);

    @Query("DELETE FROM art_table")
    void deleteAll();
}
