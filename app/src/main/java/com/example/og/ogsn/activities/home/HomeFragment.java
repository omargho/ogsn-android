package com.example.og.ogsn.activities.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.og.ogsn.R;
import com.example.og.ogsn.classes.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by og on 11/10/16.
 */

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Post> albumList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        albumList.add(new Post("fd", "afqsf", "fsfq", "fsqfqs"));
        albumList.add(new Post("fd", "afqsf", "fsfq", "fsqfqs"));
        albumList.add(new Post("fd", "afqsf", "fsfq", "fsqfqs"));
        albumList.add(new Post("fd", "afqsf", "fsfq", "fsqfqs"));
        albumList.add(new Post("fd", "afqsf", "fsfq", "fsqfqs"));
        adapter = new PostsAdapter(getActivity(), albumList);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}