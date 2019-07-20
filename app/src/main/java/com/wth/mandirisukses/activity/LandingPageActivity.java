package com.wth.mandirisukses.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.wth.mandirisukses.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LandingPageActivity extends AppCompatActivity {

    @BindView(R.id.btn_landing_login)
    Button btnLandingLogin;

    @BindView(R.id.btn_landing_register)
    Button btnLandingRegister;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_landing_register)
    void onRegister() {
        navigateTo(RegisterActivity.class);
    }

    @OnClick(R.id.btn_landing_login)
    void onLogin() {
        // TODO going to login page
    }

    private void navigateTo(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
