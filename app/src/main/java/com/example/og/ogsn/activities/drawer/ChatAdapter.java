package com.example.og.ogsn.activities.drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.og.ogsn.R;
import com.example.og.ogsn.classes.Friend;
import com.example.og.ogsn.classes.Message;
import com.example.og.ogsn.utils.Vars;

import java.util.List;

/**
 * Created by og on 11/27/16.
 */


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {


    private Context mContext;
    private List<Message> messagesList;

    public ChatAdapter(Context mContext, List<Message> messagesList) {
        this.mContext = mContext;
        this.messagesList = messagesList;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView ;
        // left or right
        if (viewType == 0) {
            // self message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_item_self, parent, false);
        } else {
            // others message
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.chat_item_other, parent, false);
        }


        return new ChatViewHolder(itemView);
    }
    @Override
    public int getItemViewType(int position) {
        Message message = messagesList.get(position);
        if (message.getId().toString().equals(Vars.id)) {
            return 0;
        }

        return 1;
    }
    @Override
    public void onBindViewHolder(final ChatViewHolder holder, int position) {
        Message message = messagesList.get(position);
        holder.message.setText(message.getText());


        holder.timestamp.setText(message.getUsername());

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView message, timestamp;

        public ChatViewHolder(View view) {
            super(view);
            message = (TextView) view.findViewById(R.id.message);
            timestamp = (TextView) view.findViewById(R.id.timestamp);

        }
    }

}