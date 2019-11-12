package com.bikeshsuwal.simpleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView detailimg;
    private TextView txtdetailname, txtdetailphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailimg = findViewById(R.id.detailimg);
        txtdetailname = findViewById(R.id.txtdetalname);
        txtdetailphone = findViewById(R.id.txtdetalphone);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            detailimg.setImageResource(bundle.getInt("image"));
            txtdetailname.setText("Name: "+bundle.getString("name"));
            txtdetailphone.setText("Phone: "+bundle.getString("phone"));
        }
    }
}

