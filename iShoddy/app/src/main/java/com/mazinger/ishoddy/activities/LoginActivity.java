package com.mazinger.ishoddy.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mazinger.ishoddy.Navigator.Navigator;
import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractor;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorImpl;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheInteractor;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheInteractorImp;
import com.mazinger.ishoddy.domain.interactors.cache.SaveUserDataAndTokenInteractor;
import com.mazinger.ishoddy.domain.interactors.cache.SaveUserDataAndTokenInteractorImpl;
import com.mazinger.ishoddy.domain.managers.cache.SaveUserDataAndTokenManager;
import com.mazinger.ishoddy.domain.managers.cache.SaveUserDataAndTokenManagerImpl;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;
import com.mazinger.ishoddy.domain.managers.network.PostLoginImpl;
import com.mazinger.ishoddy.domain.managers.network.PostUserRegisterImpl;
import com.mazinger.ishoddy.fragments.RegisterAndLoginFragment;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements RegisterAndLoginFragment.OnMailAndPasswordListener {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    // @BindView(R.id.toolbar_title) TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        // toolbarTitle.setText("Login");


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
        JSONObject jsonLogin = JSONBuilt(mailString, passwordString);

        // Register peticion
        NetworkPostManager manager = new PostLoginImpl(this);
        PostRegisterUserInteractor postRegisterUserInteractor = new PostRegisterUserInteractorImpl(manager, jsonLogin);
        postRegisterUserInteractor.execute(

                new PostRegisterUserInteractorCompletion() {
                    @Override
                    public void completion(@NonNull JSONObject response) {

                        // Save User data and token
                        SaveUserDataAndTokenManager manager = new SaveUserDataAndTokenManagerImpl(getApplicationContext());
                        SaveUserDataAndTokenInteractor saveUserDataAndTokenInteractor = new SaveUserDataAndTokenInteractorImpl(manager, response);
                        saveUserDataAndTokenInteractor.execute(new Runnable() {
                            @Override
                            public void run() {

                            }
                        }, response);

                        Intent intent = new Intent(getApplicationContext(), CategoriesListActivity.class);
                        startActivity(intent);
                    }
                }
                ,
                jsonLogin
                ,
                new InteractorErrorCompletion(){
                    @Override
                    public void onError(String errorDescription) {
                        Log.d("iShoddy", "ha ocurrido un error: " + errorDescription);
                    }
                }
        );

    }

    // Utils

    private JSONObject JSONBuilt(String mailString, String passwordString) {
        final JSONObject jsonRegister = new JSONObject();

        try {
            jsonRegister.put("email", mailString);
            jsonRegister.put("password", passwordString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonRegister;

    }

}
