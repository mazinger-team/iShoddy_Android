package com.mazinger.ishoddy.activities;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mazinger.ishoddy.Navigator.Navigator;
import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.fragments.RegisterAndLoginFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements RegisterAndLoginFragment.OnMailAndPasswordListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.activity_login__fragment) == null) {
            RegisterAndLoginFragment fragment = RegisterAndLoginFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.activity_login__fragment, fragment)
                    .commit();
        }

        TextView passwordForgotTextViewLink = (TextView) findViewById(R.id.activity_login__password_forgotten_Link);

        passwordForgotTextViewLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.navigateFromLoginActivityToPasswordForgottenActivity(LoginActivity.this);
            }
        });
    }


    @Override
    public void OnMailAndPassword(String mailString, String passwordString) {

        // JSON built
        JSONObject jsonRegister = JSONBuilt(mailString, passwordString);

        Log.v("iShoddy", jsonRegister.toString());

        // Json post         ... TODO ..........pass.....
        // Next activity run ... TODO ...............

    }

    // Utils

    private JSONObject JSONBuilt(String mailString, String passwordString) {
        final JSONObject jsonRegister = new JSONObject();

        try {
            jsonRegister.put("mail", mailString);
            jsonRegister.put("password", passwordString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonRegister;

    }

}
