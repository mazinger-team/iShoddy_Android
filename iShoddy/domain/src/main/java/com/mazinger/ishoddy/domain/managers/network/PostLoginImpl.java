package com.mazinger.ishoddy.domain.managers.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.mazinger.domain.R;
import com.mazinger.ishoddy.domain.managers.entities.LoginEntity;
import com.mazinger.ishoddy.domain.managers.jsonparser.LoginResponseJsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class PostLoginImpl implements NetworkPostManager {

    WeakReference<Context> weakContext;

    public PostLoginImpl(Context context) {
        weakContext = new WeakReference<Context>(context);
    }


    @Override
    public void postDataToServer(@NonNull final PostManagerCompletion completion,
                                 @NonNull final JSONObject jsonLogin,
                                 @Nullable final ManagerErrorCompletion errorCompletion) {

        String url = weakContext.get().getString(R.string.url_login);

        final RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        final JsonRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonLogin,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        String token = "";
                        final String id;
                        final JSONObject jsonResponse;

                        // Last response in result
                        // LoginResponseJsonParser parser = new LoginResponseJsonParser();
                        // LoginEntity entity = parser.parser(response.toString());

                        // Capturamos el token de header y lo añadimos a response
                        // Todo: captures Token from Header
                        try {
                            response.put("token", token);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.d("iShoddy", "response.toString() =" + response.toString());


                        if (completion != null) {
                            completion.completion(response);
                        }

                    }
                },
                new Response.ErrorListener() {          // manejo de error
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("iShoddy", error.toString());

                        // error.networkResponse.statusCode

                        if (errorCompletion != null) {
                            errorCompletion.onError(error.getMessage());
                        }
                    }

                }
        );

        queue.add(jsonRequest);




    }
}
