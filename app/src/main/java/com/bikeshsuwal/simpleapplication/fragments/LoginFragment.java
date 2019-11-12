package com.bikeshsuwal.simpleapplication.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bikeshsuwal.simpleapplication.DashboardActivity;
import com.bikeshsuwal.simpleapplication.R;
import com.bikeshsuwal.simpleapplication.logic.AuthenticationCheck;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    private EditText etLoginEmail, etLoginPassword;
    private Button btnLogin;
    private String loginuseremail, loginuserpassword;
    private boolean result;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        etLoginEmail = view.findViewById(R.id.etLoginEmail);
        etLoginPassword = view.findViewById(R.id.etLoginPassword);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginuseremail = etLoginEmail.getText().toString();
                loginuserpassword = etLoginPassword.getText().toString();

                if (TextUtils.isEmpty(etLoginEmail.getText().toString())) {
                    etLoginEmail.setError("Please enter your email");
                } else if (TextUtils.isEmpty(etLoginPassword.getText().toString())) {
                    etLoginPassword.setError("Please enter your email");
                } else {
                    AuthenticationCheck authenticationCheck = new AuthenticationCheck();
                    authenticationCheck.setLoginemail(loginuseremail);
                    authenticationCheck.setLoginpassword(loginuserpassword);

                    result = authenticationCheck.check();

                    if (result){
                        Intent intent = new Intent(getActivity(), DashboardActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getActivity(), "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                        etLoginEmail.getText().clear();
                        etLoginPassword.getText().clear();
                    }
                }
            }
        });
        return view;
    }

}
