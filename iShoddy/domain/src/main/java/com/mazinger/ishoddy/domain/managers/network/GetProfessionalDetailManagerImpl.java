package com.mazinger.ishoddy.domain.managers.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;
import com.mazinger.domain.R;
import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.entities.GetProfessionalDetailResponseType;
import com.mazinger.ishoddy.domain.managers.jsonparser.CategoriesJsonParser;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class GetProfessionalDetailManagerImpl implements  GetProfessionalDetailManager{


    WeakReference<Context> weakContext;

    public GetProfessionalDetailManagerImpl(Context context)
    {
        weakContext = new WeakReference<Context>(context);
    }

    //@Override
    public void getProfessionalDetail(@NonNull final GetProfessionalDetailManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion)
    {
        String url = weakContext.get().getString(R.string.ENDPOINT_PROFESIONAL_DETAIL);
        RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        GetProfessionalDetailResponseType detailResponse = new GsonBuilder().create().fromJson(response, GetProfessionalDetailResponseType.class);

                        if (completion != null) {
                            completion.completion(detailResponse);
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
