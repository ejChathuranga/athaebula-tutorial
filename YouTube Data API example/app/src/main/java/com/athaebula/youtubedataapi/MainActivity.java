package com.athaebula.youtubedataapi;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new YoutubeSearchAsyncTask(this).execute();

    }

    static class YoutubeSearchAsyncTask extends AsyncTask<Void, Void, String> {

        private WeakReference<Context> context;
        YoutubeSearchAsyncTask(Context context) {
            this.context = new WeakReference<Context>(context);
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestQueue queue = Volley.newRequestQueue(context.get());
            String url = "https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=UCrM1_toI5TsDYP1ZgeP91fw&&key=AIzaSyDqgGyphoBN9cEjtYSZipuZi_gaVLdAims";

            JsonObjectRequest objectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject res) {
                            Log.d(TAG, "onResponse: " + res);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }
            );
            queue.add(objectRequest);
            return null;
        }
    }
}
