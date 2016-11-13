package com.example.og.ogsn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dd.processbutton.iml.ActionProcessButton;
import com.example.og.ogsn.utils.Vars;
import com.example.og.ogsn.utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Get a RequestQueue
        RequestQueue queue = VolleySingleton.getInstance(getApplicationContext()).
                getRequestQueue();

        final EditText editEmail = (EditText) findViewById(R.id.editEmail);
        final EditText editPassword = (EditText) findViewById(R.id.editPassword);


        final ActionProcessButton btnSignIn = (ActionProcessButton) findViewById(R.id.btnSignIn);
        btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSignIn.setEnabled(false);
                editEmail.setEnabled(false);
                editPassword.setEnabled(false);
                btnSignIn.setProgress(1);

                String url = "http://192.168.1.6:3000/user/login";
                try {
                    JSONObject jsonBody = new JSONObject();
                    jsonBody.put("username", editEmail.getText().toString());
                    jsonBody.put("password", editPassword.getText().toString());

                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, jsonBody,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    btnSignIn.setProgress(100);
                                    String token=null,id=null;
                                    try {
                                        token=response.getString("token");
                                        id=response.getString("id");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                                    Vars.token=token;
                                    Vars.id=id;
                                    startActivity(intent);
                                    finish();

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            btnSignIn.setProgress(-1);
                            btnSignIn.setEnabled(true);
                            editEmail.setEnabled(true);
                            editPassword.setEnabled(true);
                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                    VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjReq);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
