package com.mazinger.ishoddy.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractor;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorImpl;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;
import com.mazinger.ishoddy.domain.managers.network.PostProfessionalRegisterImpl;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RegisterAsProfessionalActivity extends AppCompatActivity {

    public static final String EXTRA_USERID = "extra_userId";

    @BindView(R.id.toolbar) Toolbar mToolbar;


    // Views
    @BindView(R.id.activity_register_professional__name) EditText name;
    // final EditText name = (EditText) findViewById(R.id.activity_register_professional__name);

    @BindView(R.id.activity_register_professional__mail) EditText mail;
    @BindView(R.id.activity_register_professional__telephone) EditText telephone;
    @BindView(R.id.activity_register_professional__address) EditText address;
    @BindView(R.id.activity_register_professional__category) EditText category;
    @BindView(R.id.activity_register_professional__subcategory) EditText subcategory;
    @BindView(R.id.activity_register_professional__description) EditText description;
    @BindView(R.id.activity_register_professional__userImage) ImageView image;
    @BindView(R.id.activity_register_professional__button_next) Button nextButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_professional);

        setTitle("Registro Profesional");
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        // Dates to save

        final String nameString = name.getText().toString().trim();
        final String mailString = mail.getText().toString().trim();
        final String telephoneString =  telephone.toString().trim();
        final String addressString = address.getText().toString().trim();
        final String categoryString = category.getText().toString().trim();
        final String subcategoryString = subcategory.getText().toString().trim();
        final String descriptionString = description.getText().toString().trim();
        // Todo: Image save


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Json built
                JSONObject jsonRegister = JSONBuilt(nameString, mailString, telephoneString, addressString, categoryString, subcategoryString, descriptionString);

                // Register peticion
               NetworkPostManager manager = new PostProfessionalRegisterImpl(getApplicationContext());
                PostRegisterUserInteractor postRegisterUserInteractor = new PostRegisterUserInteractorImpl(manager, jsonRegister);
                postRegisterUserInteractor.execute(

                        new PostRegisterUserInteractorCompletion() {
                            @Override
                            public void completion(@NonNull JSONObject response) {

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
                            }
                        }
                );


            }
        });

    }


    // Utils

    private JSONObject JSONBuilt(String name, String email, String telephone, String address, String category, String subcategory, String description) {

        final JSONObject jsonRegister = new JSONObject();

        try {
            jsonRegister.put("name", name);
            jsonRegister.put("email", email);
            jsonRegister.put("telephone", telephone);
            jsonRegister.put("address", address);
            jsonRegister.put("category", category);
            jsonRegister.put("subcategory", subcategory);
            jsonRegister.put("description", description);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonRegister;

    }

}
