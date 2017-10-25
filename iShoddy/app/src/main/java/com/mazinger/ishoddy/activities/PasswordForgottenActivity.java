package com.mazinger.ishoddy.activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mazinger.ishoddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordForgottenActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgotten);

        setTitle("Password");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);


        final EditText email = (EditText) findViewById(R.id.activity_password__forgotten_textedit_email);
        final Button acceptButton = (Button) findViewById(R.id.activity_password__button_accept);
        final Button cancelButton = (Button) findViewById(R.id.activity_password__button_cancel);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String emailString = email.getText().toString().trim();

                if (validateMail(emailString, v)) {
                    finishActivity();

                    // ToDo: Gestión de Reset password con envío de email capturado

                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishActivity();
            }
        });

    }


    private Boolean validateMail (String emailString, View view) {

        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (emailString.matches(emailPattern)) {
            return true;
        } else {
            // Toast.makeText(getView().getContext(), "Dirección Email no válida", Toast.LENGTH_LONG).show();
            Snackbar.make(view, "Dirección Email no válida", Snackbar.LENGTH_LONG).show();
            return false;
        }
    }

    private void finishActivity() {
        // Indicamos que  ha ido bien y que haga caso a los datos de salida
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        // Matamos esta actividad y volvemos
        finish();
    }




}
