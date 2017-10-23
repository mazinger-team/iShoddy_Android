package com.mazinger.ishoddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mazinger.ishoddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterProfessionalQuestionActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_professional_question);

        setTitle("Registro Profesional");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

    }
}
