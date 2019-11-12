package com.bikeshsuwal.simpleapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bikeshsuwal.simpleapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText etfirst, etsecond;
    Button btncalculate;

    private int first,second,result;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        etfirst = root.findViewById(R.id.etfirst);
        etsecond = root.findViewById(R.id.etsecond);
        btncalculate = root.findViewById(R.id.btncalculate);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = Integer.parseInt(etfirst.getText().toString());
                second = Integer.parseInt(etsecond.getText().toString());

                result = first + second;

                Toast.makeText(getActivity(), "The sum of two number is: " + result, Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}