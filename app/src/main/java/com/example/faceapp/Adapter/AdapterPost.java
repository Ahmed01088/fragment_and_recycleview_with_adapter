package com.example.faceapp.Adapter;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.faceapp.Activity.PersonActivity;
import com.example.faceapp.Model.ModelPost;
import com.example.faceapp.R;

import java.util.ArrayList;

public class AdapterPost extends RecyclerView.Adapter<AdapterPost.ViewHolder>  {
    ArrayList<ModelPost> posts;

    public AdapterPost(ArrayList<ModelPost> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.IconPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PersonActivity.class);
                holder.itemView.getContext().startActivity(intent);
            }
        });


        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(posts.get(position).getPicPost(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.picture);
        holder.sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "send...", Toast.LENGTH_SHORT).show();
                holder.edit.setText("");
            }
        });
        holder.like.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {


                int count=Integer.parseInt(holder.counter.getText().toString());
//                if(count>=3001){
//                    holder.counter.setText(String.format("%d", count - 1));
//
//                }else{
                    holder.counter.setText(String.format("%d", count + 1));
//
//                }

            }
        });
        holder.like.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                holder.layout.setVisibility(View.VISIBLE);
                return false;
            }
        });
        holder.fblike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_like,0,0,0);
                holder.layout.setVisibility(View.GONE);
                holder.like.setText("Like");
                holder.like.setTextColor(Color.parseColor("#03A9F4"));
            }
        });
        holder.fblove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_love,0,0,0);
                holder.like.setText("Love");
                holder.like.setTextColor(Color.RED);
                holder.layout.setVisibility(View.GONE);
            }
        });
        holder.fbwow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wow,0,0,0);
                holder.like.setText("Wow");
                holder.like.setTextColor(Color.parseColor("#FFEB3B"));
                holder.layout.setVisibility(View.GONE);
            }
        });
        holder.fbsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_sad,0,0,0);
                holder.like.setText("Sad");
                holder.like.setTextColor(Color.parseColor("#FFEB3B"));
                holder.layout.setVisibility(View.GONE);
            }
        });
        holder.fbangry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_angry,0,0,0);
                holder.like.setText("Angry");
                holder.like.setTextColor(Color.parseColor("#FFA500"));

                holder.layout.setVisibility(View.GONE);
            }
        });
        holder.fbhah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.like.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_haha,0,0,0);
                holder.like.setTextColor(Color.parseColor("#FFEB3B"));
                holder.like.setText("Haha");
                holder.layout.setVisibility(View.GONE);
            }
        });

        holder.option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(v.getContext(), holder.option);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.options, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @SuppressLint("NonConstantResourceId")
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.block:
                                Toast.makeText(v.getContext(), "You blocked this person", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.hide:
                                Toast.makeText(v.getContext(), "You hide this post" , Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.cancel:
                                Toast.makeText(v.getContext(), "canceled" , Toast.LENGTH_SHORT).show();
                                return true;
                        }
                     return true;
                    }
                });
                popupMenu.show();
            }
        });
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.edit.requestFocus();

            }
        });
        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext());
                builder.setMessage("Are you sure you want to delete this post?");
                builder.setIcon(R.drawable.wrong);
                builder.setTitle("Wrong Message !!");
                builder.setCancelable(false);
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "Deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView picture,IconPostImage,sendComment;
        TextView close,like,counter,option,comment;
        EditText edit;
        LinearLayout layout;
        ImageView fbsad,fbhah,fbangry,fbwow,fblove,fblike;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture=itemView.findViewById(R.id.postImage);
            layout=itemView.findViewById(R.id.show_reac);
            IconPostImage=itemView.findViewById(R.id.IconPostImage);
            close=itemView.findViewById(R.id.close);
            like=itemView.findViewById(R.id.like);
            counter=itemView.findViewById(R.id.counter);
            option=itemView.findViewById(R.id.optionBtn);
            comment=itemView.findViewById(R.id.comment);
            edit=itemView.findViewById(R.id.edittext);
            sendComment=itemView.findViewById(R.id.sendComment);
            fbsad=itemView.findViewById(R.id.fbsad);
            fbhah=itemView.findViewById(R.id.fbhaha);
            fbangry=itemView.findViewById(R.id.fbangry);
            fbwow=itemView.findViewById(R.id.fbwow);
            fblike=itemView.findViewById(R.id.fblike);
            fblove=itemView.findViewById(R.id.fblove);


        }
    }

}
