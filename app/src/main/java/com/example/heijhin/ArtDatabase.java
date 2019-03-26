package com.example.heijhin;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Art.class}, version = 1, exportSchema = false)
public abstract class ArtDatabase extends RoomDatabase {

    public abstract ArtDao artDao();

    private static ArtDatabase INSTANCE;

    static ArtDatabase getDatabase(){
        if(INSTANCE == null){
            synchronized (ArtDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ArtDatabase.class, "art_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(databaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback databaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{

        private final ArtDao artDao;
        String artTitles[];
        String artInfo[];
        String artist[];
        int year[];
        int imageNum[];

        PopulateDbAsync (ArtDatabase db){
            artDao = db.artDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            artDao.deleteAll();
            for( int i = 0; i<= artTitles.length - 1; i++){
                ArtDatabase artDatabase = new Art(artTitles[i], artInfo[i], artist[i], year[i], imageNum[i]);
                artDao.insert(artDatabase);
            }
            return null;
        }
    }
}
