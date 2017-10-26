package com.mazinger.ishoddy.activities;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.fragments.ProfessionalDetailFragment;

/**
 * Created by davidcavajimenez on 19/9/17.
 */

public class ProfessionalDetailActivity extends BaseActivity implements ProfessionalDetailFragment.OnFragmentInteractionListener {


    public static String EXTRA_PARAM_ID = "EXTRA_PARAM_ID";
    public static String VIEW_NAME_HEADER_IMAGE = "VIEW_NAME_HEADER_IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_professional_detail);

    }

    @Override
    public void onShowError(final String title, final String message){
       this.onShowErrorParent(title,message);

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}


