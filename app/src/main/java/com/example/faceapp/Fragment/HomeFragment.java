package com.example.faceapp.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faceapp.Adapter.AdapterPost;
import com.example.faceapp.Adapter.AdapterStory;
import com.example.faceapp.Model.ModelPost;
import com.example.faceapp.Model.ModelStory;
import com.example.faceapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public HomeFragment() {
    }
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView storiesRV =view.findViewById(R.id.list);
        RecyclerView postsRV = view.findViewById(R.id.postsr);
        ArrayList<ModelPost> mPosts = new ArrayList<>();
        ArrayList<ModelStory> stories = new ArrayList<>();
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p1"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p2"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p3"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p4"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p5"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p6"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p3"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p5"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p1"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p2"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p3"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p5"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", false, "p3"));
        stories.add(new ModelStory("Ahmed Ibrahim", "man", true, "p4"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p6"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p6"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p6"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p6"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p6"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p2"));
        mPosts.add(new ModelPost("p1"));
        mPosts.add(new ModelPost("p5"));
        mPosts.add(new ModelPost("p3"));
        mPosts.add(new ModelPost("p4"));
        mPosts.add(new ModelPost("p6"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager linearPos = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        storiesRV.setLayoutManager(linearLayoutManager);
        postsRV.setLayoutManager(linearPos);
        AdapterPost adapterPost = new AdapterPost(mPosts);
        AdapterStory adapterStory = new AdapterStory(stories);
        storiesRV.setAdapter(adapterStory);
        postsRV.setAdapter(adapterPost);
        return view;

    }
}