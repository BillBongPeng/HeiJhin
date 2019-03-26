package com.example.heijhin;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ArtViewHolder> {
    private ArrayList<Art> mArtData;
    private Context mContext;
    private ImageView mArtImage;



    private Art getArt(ArrayList<Art> mArtData){
        Art mArt = mArtData.get(0);
        return mArt;
    }

    ArtAdapter(Context context, ArrayList<Art> artData){
        //mInflater = LayoutInflater.from(context);
        this.mArtData = artData;
        this.mContext = context;

    }


    @NonNull
    @Override
    public ArtAdapter.ArtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ArtViewHolder(LayoutInflater.from(mContext).inflate(R.layout.card_list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ArtAdapter.ArtViewHolder holder, int position) {
        Art currentArt = mArtData.get(position);
        holder.bindTo(currentArt);
    }

    @Override
    public int getItemCount() {
        return mArtData.size();
    }

    class ArtViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mArtTitle;
        private TextView mArtistName;

        public ArtViewHolder(View itemView) {
            super(itemView);
            mArtTitle = itemView.findViewById(R.id.artTitle);
            mArtistName = itemView.findViewById(R.id.artistName);
            mArtImage = itemView.findViewById(R.id.artImage);

            itemView.setOnClickListener(this);
        }

        void bindTo(Art currentArt){
            mArtTitle.setText(currentArt.getArtTitle());
            mArtistName.setText(currentArt.getArtist());
            Glide.with(mContext).load(currentArt.getImageNum()).into(mArtImage);
        }

        @Override
        public void onClick(View v) {
            Art currentArt = mArtData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentArt.getArtTitle());
            detailIntent.putExtra("name",currentArt.getArtist());
            detailIntent.putExtra("info",currentArt.getArtInfo());
            detailIntent.putExtra("image_resource", currentArt.getImageNum());
            mContext.startActivity(detailIntent);
        }
    }
}
