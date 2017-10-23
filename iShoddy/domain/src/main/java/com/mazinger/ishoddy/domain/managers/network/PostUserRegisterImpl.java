package com.mazinger.ishoddy.domain.managers.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class PostUserRegisterImpl implements NetworkPostManager {


    WeakReference<Context> weakContext;
    JSONObject jsonResponse;

    public PostUserRegisterImpl(Context context) {
        weakContext = new WeakReference<Context>(context);
    }

    @Override
    public void execute(@NonNull final PostRegisterUserInteractorCompletion completion,
                        @NonNull final JSONObject jsonRegister,
                        @Nullable final ManagerErrorCompletion errorCompletion) {

        String url = "http://ec2-54-202-209-58.us-west-2.compute.amazonaws.com/api/v1/user/user";
        // String url = weakContext.get().getString(R.string.shops_url);

        final RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        final JsonRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonRegister,                           // pares clave-valor para petición POST
                new Response.Listener<JSONObject>() {   // manejo resultados
                    @Override
                    public void onResponse(JSONObject response) {

                        jsonResponse = response;
                        completion.completion(jsonResponse);

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
