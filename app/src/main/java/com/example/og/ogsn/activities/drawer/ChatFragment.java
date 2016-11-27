package com.example.og.ogsn.activities.drawer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.og.ogsn.R;
import com.example.og.ogsn.classes.Message;
import com.example.og.ogsn.utils.SocketSingleton;
import com.example.og.ogsn.utils.Vars;

import java.util.ArrayList;

/**
 * Created by og on 11/10/16.
 */

public class ChatFragment extends Fragment {
    Button sendBtn;
    TextView textView;
    EditText messageEditText;
    RecyclerView recyclerView;
    String friendId;
    ArrayList messages;
    ChatAdapter adapter;
    LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chat_layout, container, false);
        sendBtn = (Button) view.findViewById(R.id.sendButton);
        messageEditText = (EditText) view.findViewById(R.id.sendEditText);
        recyclerView = (RecyclerView) view.findViewById(R.id.chat_recycler_view);
        friendId = getArguments().getString("id");
        if(messages==null)
            messages = new ArrayList<>();

        adapter = new ChatAdapter(getActivity(), messages);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messages.add(new Message(Vars.id, messageEditText.getText().toString(), "me"));
                adapter.notifyItemInserted(messages.size());
                recyclerView.scrollToPosition(messages.size() - 1);
                SocketSingleton.sendMessage(friendId, messageEditText.getText().toString());
                messageEditText.setText("");
            }
        });
        SocketSingleton.receiveMessage(friendId, messages, adapter, recyclerView, getActivity());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}