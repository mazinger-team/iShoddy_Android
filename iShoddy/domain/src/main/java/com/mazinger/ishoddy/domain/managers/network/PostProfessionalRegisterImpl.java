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
import com.mazinger.domain.R;

import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class PostProfessionalRegisterImpl implements NetworkPostManager {

    WeakReference<Context> weakContext;

    public PostProfessionalRegisterImpl(Context context) {
        weakContext = new WeakReference<Context>(context);
    }


    @Override
    public void postDataToServer(@NonNull final PostManagerCompletion completion,
                                 @NonNull final JSONObject jsonRegister,
                                 @Nullable final ManagerErrorCompletion errorCompletion) {

        String url = weakContext.get().getString(R.string.url_register_professional);

        final RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        final JsonRequest jsonRequest = new JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonRegister,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("iShoddy", "response.toString() =" + response);
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


