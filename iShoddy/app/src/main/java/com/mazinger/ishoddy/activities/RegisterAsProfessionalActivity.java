package com.mazinger.ishoddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mazinger.ishoddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterAsProfessionalActivity extends AppCompatActivity {

    public static final String EXTRA_USERID = "extra_userId";
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_professional);

        setTitle("Registro Profesional");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

    }
}
