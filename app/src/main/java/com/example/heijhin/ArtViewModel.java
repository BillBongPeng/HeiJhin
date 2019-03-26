package com.example.heijhin;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ArtViewModel extends AndroidViewModel {

    private ArtRepository artRepository;
    private LiveData<List<Art>> mAllArt;

    public ArtViewModel (Application application){
        super(application);
        artRepository = new ArtRepository(application);
        mAllArt = artRepository.getAllArt();
    }

    LiveData<List<Art>> getAllArt(){return mAllArt;}

    public void insert(Art art){artRepository.insert(art);}
}
