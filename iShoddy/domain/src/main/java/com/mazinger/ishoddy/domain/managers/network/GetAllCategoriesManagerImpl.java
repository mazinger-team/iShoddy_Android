package com.mazinger.ishoddy.domain.managers.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mazinger.domain.R;
import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.jsonparser.CategoriesJsonParser;

import java.lang.ref.WeakReference;
import java.util.List;

public class GetAllCategoriesManagerImpl implements NetworkManager
{
    WeakReference<Context> weakContext;

    public GetAllCategoriesManagerImpl(Context context)
    {
        weakContext = new WeakReference<Context>(context);
    }

    @Override
    public void getActivitiesFromServer(@NonNull final GetAllCategoriesManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion)
    {
        String url = weakContext.get().getString(R.string.ENDPOINT_CATEGORIES);
        RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        StringRequest request = new StringRequest(
                url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        CategoriesJsonParser parser = new CategoriesJsonParser();
                        List<CategoryEntity> entities = parser.parser(response);

                        if (completion != null) {
                            completion.completion(entities);
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






























