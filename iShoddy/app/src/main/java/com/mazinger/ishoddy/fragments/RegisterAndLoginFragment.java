package com.mazinger.ishoddy.fragments;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mazinger.ishoddy.R;


public class RegisterAndLoginFragment extends Fragment {

    private OnMailAndPasswordListener mListener;

    public RegisterAndLoginFragment() {
        // Required empty public constructor
    }


    public static RegisterAndLoginFragment newInstance() {
        RegisterAndLoginFragment fragment = new RegisterAndLoginFragment();
        Bundle args = new Bundle();
        // args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_register_and_login, container, false);

        // View
        final EditText mail = (EditText) root.findViewById(R.id.activity_register__mail);
        final EditText password = (EditText) root.findViewById(R.id.activity_register__password);
        final Button buttonAccept = (Button) root.findViewById(R.id.activity_register__button_accept);
        final Button buttonCancel = (Button) root.findViewById(R.id.activity_register__button_cancel);

        // Button actions
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String mailString = mail.getText().toString().trim();
                final String passwordString = password.getText().toString().trim();

                // Mail and password validate
                if (validate(mailString, passwordString)){

                    // Send mailString and passwordString to Activity
                    if (mListener != null) {
                        mListener.OnMailAndPassword(mailString, passwordString);
                    }
                }
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return root;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMailAndPasswordListener) {
            mListener = (OnMailAndPasswordListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnMailAndPasswordListener {

        void OnMailAndPassword(String mailString, String passwordString);
    }


    // Utils

    private Boolean validate(String mailString, String passwordString) {
        String emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (mailString.matches(emailPattern)) {

            // Validado el mail, validamos password
            if (passwordString.length() == 0) {
                // Toast.makeText(getView().getContext(), "El Password no puede estar vacío",Toast.LENGTH_LONG).show();
                Snackbar.make(getView(), "El Password no puede estar vacío", Snackbar.LENGTH_LONG).show();
                return false;
            } else {
                return true;
            }

        } else {
            // Toast.makeText(getView().getContext(), "Dirección Email no válida", Toast.LENGTH_LONG).show();
            Snackbar.make(getView(), "Dirección Email no válida", Snackbar.LENGTH_LONG).show();
            return false;
        }
    }




}
