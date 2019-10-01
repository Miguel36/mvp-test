package com.example.mvp_test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp_test.usuario.presenter.UserPresenter;
import com.example.mvp_test.usuario.view.UserInfoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserInfoFragment userInfoFragment = (UserInfoFragment) getSupportFragmentManager().findFragmentById(R.id.user_fragment);
        UserPresenter mUserPresenter = new UserPresenter(userInfoFragment);

        if (userInfoFragment != null) {
            userInfoFragment.setPresenter(mUserPresenter);
            mUserPresenter.loadUser();
        }

    }
}
