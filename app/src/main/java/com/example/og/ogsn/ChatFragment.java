package com.example.og.ogsn;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.og.ogsn.utils.socketSingleton;

/**
 * Created by og on 11/10/16.
 */

public class ChatFragment extends Fragment {
    Button sendBtn;
    TextView textView;
    EditText idEditText, messageEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chat_layout, container, false);
        sendBtn = (Button) view.findViewById(R.id.sendButton);
        textView = (TextView) view.findViewById(R.id.receivedTextView);
        idEditText = (EditText) view.findViewById(R.id.sendId);
        messageEditText = (EditText) view.findViewById(R.id.sendEditText);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                socketSingleton.sendMessage(idEditText.getText().toString(),messageEditText.getText().toString());
            }
        });
        socketSingleton.receiveMessage(textView,getActivity());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}