package com.example.moxyissue.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.moxyissue.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new FragmentA())
                    .commit();
        }
    }

    public void openFragmentB() {
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, new FragmentB())
                .commitAllowingStateLoss();
    }
}
