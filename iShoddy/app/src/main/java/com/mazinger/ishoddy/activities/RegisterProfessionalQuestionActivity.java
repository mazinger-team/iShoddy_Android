package com.mazinger.ishoddy.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mazinger.ishoddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterProfessionalQuestionActivity extends AppCompatActivity {

    public static final String EXTRA_USERID = "extra_userId";
    String userId;

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.register_professional_question_activity__yes_button) Button yesButton;
    @BindView(R.id.register_professional_question_activity__no_button) Button noButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_professional_question);

        setTitle("Registro Profesional");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentProfessionalRegister = new Intent(getApplicationContext(), RegisterAsProfessionalActivity.class);
                intentProfessionalRegister.putExtra(RegisterAsProfessionalActivity.EXTRA_USERID, userId);
                startActivity(intentProfessionalRegister);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentReturn = new Intent(getApplicationContext(), CategoriesListActivity.class);
                startActivity(intentReturn);


            }
        });


    }
}
