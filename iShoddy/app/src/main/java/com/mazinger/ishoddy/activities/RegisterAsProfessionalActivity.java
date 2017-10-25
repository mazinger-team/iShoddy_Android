package com.mazinger.ishoddy.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mazinger.ishoddy.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterAsProfessionalActivity extends AppCompatActivity {

    public static final String EXTRA_USERID = "extra_userId";

    @BindView(R.id.toolbar) Toolbar mToolbar;

    // Views
    @BindView(R.id.activity_register_professional__name) EditText name;
    @BindView(R.id.activity_register_professional__mail) EditText mail;
    @BindView(R.id.activity_register_professional__telephone) EditText telephone;
    @BindView(R.id.activity_register_professional__address) EditText address;
    @BindView(R.id.activity_register_professional__category) EditText category;
    @BindView(R.id.activity_register_professional__subcategory) EditText subcategory;
    @BindView(R.id.activity_register_professional__description) EditText description;
    @BindView(R.id.activity_register_professional__userImage) ImageView image;
    @BindView(R.id.activity_register_professional__button_next) Button userImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_professional);

        setTitle("Registro Profesional");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);






    }
}
