package com.example.faceapp.Adapter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.faceapp.Model.ModelVideoStory;
import com.example.faceapp.R;

import java.util.ArrayList;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.ViewHolder> {
    ArrayList<ModelVideoStory> stories;

    public AdapterVideo(ArrayList<ModelVideoStory> stories) {
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String path = "android.resource://" +holder.itemView.getContext().getPackageName() + "/" + R.raw.v4;
        holder.video.setVideoURI(Uri.parse(path));
        holder.video.start();              }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        VideoView video;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            video=itemView.findViewById(R.id.videoView);
        }
    }
}
