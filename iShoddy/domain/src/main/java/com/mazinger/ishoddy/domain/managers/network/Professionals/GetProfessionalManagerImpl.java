package com.mazinger.ishoddy.domain.managers.network.Professionals;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.Professional.GetProfessionalResponseType;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;

import java.lang.ref.WeakReference;

public class GetProfessionalManagerImpl implements  GetProfessionalManager{


    WeakReference<Context> weakContext;

    public GetProfessionalManagerImpl(Context context)
    {
        weakContext = new WeakReference<Context>(context);
    }

    //@Override
    public void getProfessional(@NonNull final GetProfessionalManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion)
    {
        String url = weakContext.get().getString(Integer.parseInt("http://ec2-54-202-209-58.us-west-2.compute.amazonaws.com/api/v1/professionals"));
        RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        GetProfessionalResponseType professionalResponse = new GsonBuilder().create().fromJson(response, GetProfessionalResponseType.class);

                        if (completion != null) {
                            completion.completion(professionalResponse);
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        if (errorCompletion != null)
                        {
                            errorCompletion.onError(error.getMessage());
                        }
                    }
                }
        );
        queue.add(request);
    }
}
