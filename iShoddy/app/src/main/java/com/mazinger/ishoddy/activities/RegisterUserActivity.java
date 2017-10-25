package com.mazinger.ishoddy.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractor;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorImpl;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;
import com.mazinger.ishoddy.domain.managers.network.PostUserRegisterImpl;
import com.mazinger.ishoddy.domain.model.User;
import com.mazinger.ishoddy.fragments.RegisterAndLoginFragment;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterUserActivity extends AppCompatActivity implements RegisterAndLoginFragment.OnMailAndPasswordListener{

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        setTitle("Registro");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);


        FragmentManager fm = getFragmentManager();
        if (fm.findFragmentById(R.id.activity_register_user__fragment) == null) {
            RegisterAndLoginFragment fragment = RegisterAndLoginFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.activity_register_user__fragment, fragment)
                    .commit();
        }
    }

    // Upload register data with mail and password returned by fragment
    @Override
    public void OnMailAndPassword(final String mailString, final String passwordString) {

        // JSON built
        final JSONObject jsonRegister = JSONBuilt(mailString, passwordString);

        // Register peticion
        NetworkPostManager manager = new PostUserRegisterImpl(this);
        PostRegisterUserInteractor postRegisterUserInteractor = new PostRegisterUserInteractorImpl(manager, jsonRegister);
        postRegisterUserInteractor.execute(

                new PostRegisterUserInteractorCompletion() {
                    @Override
                    public void completion(@NonNull String token) {

                        Intent intent = new Intent(getApplicationContext(), RegisterProfessionalQuestionActivity.class);
                        startActivity(intent);
                    }
                }
                ,
                jsonRegister
                ,
                new InteractorErrorCompletion(){
                    @Override
                    public void onError(String errorDescription) {
                        Log.d("iShoddy", "ha ocurrido un error: " + errorDescription);
                        // Todo....Mostrar error en un Snacbar o Alert
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
