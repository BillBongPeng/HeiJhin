package com.example.heijhin;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Art> mArtData;
    private ArtAdapter mArtAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int gridColumnCount = 1;
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mArtData = new ArrayList<>();
        mArtAdapter = new ArtAdapter(this, mArtData);
        mRecyclerView.setAdapter(mArtAdapter);
        initializedata();

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback((ItemTouchHelper.UP|ItemTouchHelper.DOWN),(ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT)) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                final int fromPosition = viewHolder.getAdapterPosition();
                final int toPosition = target.getAdapterPosition();
                Collections.swap(mArtData,fromPosition,toPosition);
                mArtAdapter.notifyItemMoved(fromPosition,toPosition);
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mArtData.remove(viewHolder.getAdapterPosition());
                mArtAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }

            /*//helper methods for dragging and swiping
            @Override
            public boolean isLongPressDragEnabled(){
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled(){
                return true;
            }*/
        });
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }


    private void initializedata(){
        String[] artTitles = getResources().getStringArray(R.array.art_title_standard);
        String[] artInfo = getResources().getStringArray(R.array.art_info);
        String[] artistName = getResources().getStringArray(R.array.artist_name);
        int[] artYear = getResources().getIntArray(R.array.art_year);
        TypedArray artImages = getResources().obtainTypedArray(R.array.standard_gallery);

        mArtData.clear();

        for(int i = 0; i<artTitles.length; i++){
            mArtData.add(new Art(artTitles[i], artInfo[i], artistName[0], artYear[i], artImages.getResourceId(i,0)));
        }
        artImages.recycle();

        mArtAdapter.notifyDataSetChanged();
    }

    public void resetArt(View view){initializedata();}

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("title", mArtData);
    }

}
