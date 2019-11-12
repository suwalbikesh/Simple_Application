package com.bikeshsuwal.simpleapplication.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bikeshsuwal.simpleapplication.R;
import com.bikeshsuwal.simpleapplication.logic.AuthenticationCheck;
import com.bikeshsuwal.simpleapplication.model.UsersDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {
    private EditText etRegisterEmail, etRegisterPassword, etRegisterRePassword;
    private Button btnRegister;
    private String useremail,userpassword,cpassword;
    private List<UsersDetails> userList = new ArrayList<>();


    public RegistrationFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        etRegisterEmail =view.findViewById(R.id.etRegisterEmail);
        etRegisterPassword =view.findViewById(R.id.etRegisterPassword);
        etRegisterRePassword=view.findViewById(R.id.etRegisterRePassword);
        btnRegister =view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useremail = etRegisterEmail.getText().toString();
                userpassword = etRegisterPassword.getText().toString();
                cpassword = etRegisterRePassword.getText().toString();

                if (userpassword.equals(cpassword)){
                    UsersDetails usersDetails = new UsersDetails();
                    usersDetails.setEmail(useremail);
                    usersDetails.setPassword(userpassword);
                    userList.add(usersDetails);

                    AuthenticationCheck check = new AuthenticationCheck();
                    check.setUsersDetailsList(userList);

                    Toast.makeText(getActivity(), "Register Successful", Toast.LENGTH_SHORT).show();
                    etRegisterEmail.getText().clear();
                    etRegisterPassword.getText().clear();
                    etRegisterRePassword.getText().clear();
                }
                else if (TextUtils.isEmpty(etRegisterEmail.getText().toString())){
                    etRegisterEmail.setError("Please enter your email");
                }
                else if (TextUtils.isEmpty(etRegisterPassword.getText().toString())){
                    etRegisterPassword.setError("Please enter your password");
                }
                else {
                    etRegisterRePassword.setError("Re-type Password doesn't match");
                }
            }
        });
        return view;
    }

}
