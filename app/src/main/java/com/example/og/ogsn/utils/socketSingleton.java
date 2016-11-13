package com.example.og.ogsn.utils;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by og on 11/10/16.
 */

public class socketSingleton {
    private static socketSingleton mSingletonSocket;
    private static Socket mSocket;
    private static String tokenn;

    private socketSingleton(String url) {
        try {
            mSocket = IO.socket(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static synchronized socketSingleton getInstance(String url) {
        if (mSingletonSocket == null) {
            mSingletonSocket = new socketSingleton(url);
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

    public static void sendMessage(String to, String msg) {
        mSocket.emit("privateMessage", Vars.id +","+ to +","+ msg);

    }



}
