package com.example.faceapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.faceapp.Adapter.AdapterVideo;
import com.example.faceapp.Model.ModelPost;
import com.example.faceapp.Model.ModelVideoStory;
import com.example.faceapp.R;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VideoFragment() {
    }

    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_video, container, false);
        RecyclerView video =view.findViewById(R.id.view_video);
        ArrayList<ModelVideoStory> videos = new ArrayList<>();
        videos.add(new ModelVideoStory());
        videos.add(new ModelVideoStory());
        videos.add(new ModelVideoStory());
        videos.add(new ModelVideoStory());
        LinearLayoutManager linear = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        video.setLayoutManager(linear);
        AdapterVideo adapter =new AdapterVideo(videos);
        video.setAdapter(adapter);
        return view;
    }
}