package com.example.faceapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.faceapp.Activity.PersonActivity;
import com.example.faceapp.Model.ModelStory;
import com.example.faceapp.R;

import java.util.ArrayList;

public class AdapterStory extends RecyclerView.Adapter<AdapterStory.ViewHolder> {
    ArrayList<ModelStory> stories;

    public AdapterStory(ArrayList<ModelStory> stories) {
        this.stories = stories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(stories.get(position).getName());
        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PersonActivity.class);
                holder.itemView.getContext().startActivity(intent);
                }
        });
        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(stories.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.picture);
        int bgSt = holder.itemView.getContext().getResources()
                .getIdentifier(stories.get(position).getBgPic(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(bgSt)
                .into(holder.backgroundState);
        boolean state=stories.get(position).isOnline();
        if(state){
            holder.online.setImageResource(R.drawable.circle);
//            holder.online.setVisibility(View.VISIBLE);

        }else{
            holder.online.setImageResource(R.drawable.circle_offline);
//            holder.online.setVisibility(View.GONE);

        }

    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picture,online;
        ImageView backgroundState;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture=itemView.findViewById(R.id.iconpost);
            online=itemView.findViewById(R.id.state);
            name=itemView.findViewById(R.id.name);
            backgroundState=itemView.findViewById(R.id.story);
        }
    }
}
