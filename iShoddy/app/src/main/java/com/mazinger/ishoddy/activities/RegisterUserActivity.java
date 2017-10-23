package com.mazinger.ishoddy.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractor;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorImpl;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;
import com.mazinger.ishoddy.domain.managers.network.PostUserRegisterImpl;
import com.mazinger.ishoddy.fragments.RegisterAndLoginFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterUserActivity extends AppCompatActivity implements RegisterAndLoginFragment.OnMailAndPasswordListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        setTitle("Registro");

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
                    public void completion(@NonNull JSONObject jsonResponse) {

                        // Save user date in user singleton
                        // User user = User.getInstance();
                        // user.of(userResponse.getEmail(), userResponse.getId());
                        Log.d("iShoddy", "json response es: " + jsonResponse);

                        // Next activity with Extra 'user'
                        // Todo........ NAVEGAR HASTA ACTIVIDAD RegisterProfessionalQuiestionActivity

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


        // Si ha ido bien: guardamos email+pass+token en User.singleton
        //                 + matamos actividad para volver a la que nos llamó

        // Si ha ido mal: mostramos error que viene en cabecera


        // Next activity navigator ... TODO ............... próxima actividad tras register?


        Intent intent = new Intent(this, RegisterProfessionalQuestionActivity.class);
        // TODO...... pasar userID
        // intent.putExtra(RegisterProfessionalQuestionActivity.EXTRA_USERID, userId);
        startActivity(intent);

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
