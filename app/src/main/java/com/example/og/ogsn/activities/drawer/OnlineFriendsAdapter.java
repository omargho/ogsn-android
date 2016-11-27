package com.example.og.ogsn.activities.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.og.ogsn.R;
import com.example.og.ogsn.classes.Friend;

import java.util.List;


public class OnlineFriendsAdapter extends RecyclerView.Adapter<OnlineFriendsAdapter.FriendsViewHolder> {

    private Context mContext;
    private List<Friend> friendList;

    public OnlineFriendsAdapter(Context mContext, List<Friend> friendList) {
        this.mContext = mContext;
        this.friendList = friendList;
    }

    @Override
    public FriendsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_card, parent, false);
        return new FriendsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FriendsViewHolder holder, int position) {
        Friend friend = friendList.get(position);
        holder.name.setText(friend.getName());
        holder.username.setText(friend.getUsername());

        // loading album cover using Glide library
        // Glide.with(mContext).load(album.getImgUrl()).into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public class FriendsViewHolder extends RecyclerView.ViewHolder {
        public TextView name, username;
        public ImageView picture;

        public FriendsViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.friendName);
            username = (TextView) view.findViewById(R.id.friendUsername);
            picture = (ImageView) view.findViewById(R.id.friendPicture);
        }
    }
}