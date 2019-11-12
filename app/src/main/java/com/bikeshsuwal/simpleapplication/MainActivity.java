package com.bikeshsuwal.simpleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.bikeshsuwal.simpleapplication.adapters.AuthenticationViewPagerAdapter;
import com.bikeshsuwal.simpleapplication.fragments.LoginFragment;
import com.bikeshsuwal.simpleapplication.fragments.RegistrationFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabview;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabview = findViewById(R.id.tabview);
        viewPager = findViewById(R.id.viewPager);

        tabview.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        AuthenticationViewPagerAdapter authenticationViewPagerAdapter = new AuthenticationViewPagerAdapter(getSupportFragmentManager());
        authenticationViewPagerAdapter.addFragment(new LoginFragment(),"Login");
        authenticationViewPagerAdapter.addFragment(new RegistrationFragment(),"Registration");

        viewPager.setAdapter(authenticationViewPagerAdapter);
        tabview.setupWithViewPager(viewPager);

    }
}
