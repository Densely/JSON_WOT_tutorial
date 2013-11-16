package com.densely.jsonwottutorial;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Densely
 * Date: 16.11.13
 * Time: 22:53
 * To change this template use File | Settings | File Templates.
 */
public class Api {

    public static final String SEARCH_URL = "http://api.worldoftanks.ru/2.0/account/list/?application_id=171745d21f7f98fd8878771da1000a31&search=";
    private RequestQueue mQueue;

    private OnPlayerSearchListener mListener;
    public Api(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void searchPlayer(String name) {


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, SEARCH_URL + name, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {

                ArrayList<String> players = new ArrayList<String>();

                try {
                    JSONArray data = json.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject name = data.getJSONObject(i);

                        String n = name.getString("nickname");
                        players.add(n);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mListener.onPlayerSearch(players);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.getMessage());
            }
        }
        );

        mQueue.add(jsonObjectRequest);

    }

    public void setOnPlayerChangeListener(OnPlayerSearchListener listener){
        mListener = listener;

    }


}