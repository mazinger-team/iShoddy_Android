package com.mazinger.ishoddy.domain.managers.network.Professionals;

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
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;
import com.mazinger.ishoddy.domain.managers.jsonparser.CategoriesJsonParser;
import com.mazinger.ishoddy.domain.managers.jsonparser.PaginationDataJsonParser;
import com.mazinger.ishoddy.domain.managers.jsonparser.ProfessionalsJsonParser;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;

import java.lang.ref.WeakReference;
import java.util.List;

public class GetAllAllProfessionalsManagerImpl implements GetAllProfessionalManager {
    private WeakReference<Context> weakContext;
    private Boolean indParameters = false;
    private String urlProfessionals = "";

    public GetAllAllProfessionalsManagerImpl(Context context) {
        weakContext = new WeakReference<Context>(context);
    }

    @Override
    public void getAllProfessionalFromServer(String filter, String order, String fields, Integer page, @NonNull final GetAllProfessionalsManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion) {
        RequestQueue queue = Volley.newRequestQueue(weakContext.get());

        urlProfessionals = weakContext.get().getString(R.string.ENDPOINT_PROFESSIONALS);
        indParameters = false;

        /* The filter is set */
        if (filter != null) {
            urlProfessionals = urlProfessionals +"?"+filter;
            indParameters = true;
        }

        /* The order is established */
        if (order != null) {
            if (!indParameters) {
                urlProfessionals = urlProfessionals +"?";
                indParameters = true;
            } else {
                urlProfessionals = urlProfessionals +"&";
            }
            urlProfessionals = urlProfessionals +"order="+order;
        }

        /* Paging is set */
        if (fields != null) {
            if (!indParameters) {
                urlProfessionals = urlProfessionals +"?";
                indParameters = true;
            } else {
                urlProfessionals = urlProfessionals +"&";
            }
            urlProfessionals = urlProfessionals +"fields="+fields;
        }

        /* Paging index is set */
        if (page != 0) {
            if (!indParameters) {
                urlProfessionals = urlProfessionals + "?";
                indParameters = true;
            } else {
                urlProfessionals = urlProfessionals + "&";
            }
            urlProfessionals = urlProfessionals + "page=" + page;
        }

        StringRequest request = new StringRequest(
                urlProfessionals,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ProfessionalsJsonParser professionalParser = new ProfessionalsJsonParser();
                        List<ProfessionalsEntity> professionalsEntities = professionalParser.parser(response);

                        PaginationDataJsonParser paginationDataJsonParser = new PaginationDataJsonParser();
                        PaginationDataEntity paginationDataEntities = paginationDataJsonParser.parser(response);

                        if (completion != null) {
                            completion.completion(professionalsEntities, paginationDataEntities);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (errorCompletion != null) {
                            errorCompletion.onError(error.getMessage());
                        }
                    }
                }
        );
        queue.add(request);
    }
}
