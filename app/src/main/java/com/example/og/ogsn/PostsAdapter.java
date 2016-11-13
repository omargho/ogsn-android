package com.example.og.ogsn;

/**
 * Created by og on 11/8/16.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.og.ogsn.classes.Post;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Post> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
          //  count = (TextView) view.findViewById(R.id.count);
            //thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public PostsAdapter(Context mContext, List<Post> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Post album = albumList.get(position);
      //  holder.title.setText("jhh");
        //holder.count.setText(5 + " songs");

        // loading album cover using Glide library
       // Glide.with(mContext).load(album.getPostImgUrl()).into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}