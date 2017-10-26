package com.mazinger.ishoddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.mazinger.ishoddy.R;

/**
 * Created by davidcavajimenez on 23/9/17.
 */

public class BaseActivity extends AppCompatActivity {

    public void onShowErrorParent(final String title, final String message){
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        final View popupView = inflater.inflate(R.layout.popup_window, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.setContentView( popupView );

        Button close = (Button) popupView.findViewById(R.id.btn_closepopup);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    ( (TextView) popupView.findViewById(R.id.txt_title)).setText(title);
                    ( (TextView) popupView.findViewById(R.id.txt_message)).setText(message);
                    popupWindow.showAtLocation( getWindow().getDecorView().getRootView() , Gravity.CENTER, 0, 0);
                    ( (View) popupView.findViewById(R.id.bac_dim_layout)).setVisibility(View.VISIBLE);

                }
            }
        });


    }
}
