package com.example.og.ogsn.utils;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.og.ogsn.activities.drawer.ChatAdapter;
import com.example.og.ogsn.classes.Message;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by og on 11/10/16.
 */

public class SocketSingleton {
    private static SocketSingleton mSingletonSocket;
    private static Socket mSocket;
    private static String tokenn;

    private SocketSingleton(String url) {
        try {
            mSocket = IO.socket(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static synchronized SocketSingleton getInstance(String url) {
        if (mSingletonSocket == null) {
            mSingletonSocket = new SocketSingleton(url);
            mSingletonSocket.connect();
        }
        return mSingletonSocket;
    }

    public static void connect() {
        mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                mSocket.emit("id", Vars.id);
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
            }

        });
        mSocket.connect();


    }
/*
    public static void receiveMessage(final TextView textView, final Activity activity) {
        mSocket.on("receivedMessage", new Emitter.Listener() {

            @Override
            public void call(final Object... args) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // This code will always run on the UI thread, therefore is safe to modify UI elements.
                        textView.setText(args[0].toString());




                    }
                });

            }

        });
    }
*/
    public static void sendMessage(String to, String msg) {
        mSocket.emit("privateMessage", Vars.id +","+ to +","+ msg);

    }


    public static void receiveMessage(final String friendId,final ArrayList messages, final ChatAdapter adapter, final RecyclerView recyclerView, final Activity activity) {
        mSocket.on("receivedMessage", new Emitter.Listener() {

            @Override
            public void call(final Object... args) {
                Log.e("receive","received msg");
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        messages.add(new Message(friendId, args[0].toString(), "friend"));
                        adapter.notifyItemInserted(messages.size());
                        recyclerView.scrollToPosition(messages.size()-1);

                    }
                });

            }

        });

    }
}
