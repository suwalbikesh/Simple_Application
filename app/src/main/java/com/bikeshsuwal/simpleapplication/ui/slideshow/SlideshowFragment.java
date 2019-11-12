package com.bikeshsuwal.simpleapplication.ui.slideshow;

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

public class SlideshowFragment extends Fragment {

    EditText etradius;
    Button btnradius;
    private double radius, result;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        etradius = root.findViewById(R.id.etradius);
        btnradius = root.findViewById(R.id.btncalradius);

        btnradius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radius = Double.parseDouble(etradius.getText().toString());

                result = 3.14 * (radius * radius);

                Toast.makeText(getActivity(), "The Area of Circle is: " + result, Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}