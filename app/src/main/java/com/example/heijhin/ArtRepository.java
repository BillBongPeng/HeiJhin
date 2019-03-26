package com.example.heijhin;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ArtRepository {
    private ArtDao mArtDao;
    private LiveData<List<Art>> mAllArt;

    ArtRepository(Application application){
        ArtDatabase database = ArtDatabase.getDatabase(application);
        mArtDao = database.artDao();
        mAllArt = mArtDao.getNumberedArtTitle();
    }

    LiveData<List<Art>> getAllArt(){
        return mAllArt;
    }

    public void insert (Art art){
        new insertAsyncTask(mArtDao).execute(art);
    }

    private static class insertAsyncTask extends AsyncTask<Art, Void, Void>{
        private ArtDao mAsyncTaskDao;

        insertAsyncTask(ArtDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Art... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;

        }
    }
}
