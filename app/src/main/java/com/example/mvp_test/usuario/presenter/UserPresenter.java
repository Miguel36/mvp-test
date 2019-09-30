package com.example.mvp_test.usuario.presenter;

import com.example.mvp_test.usuario.UserContract;
import com.example.mvp_test.usuario.UserRepository;
import com.example.mvp_test.usuario.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements UserContract.UserPresenterContract {

    private final UserRepository userRepository;
    private UserContract.UserViewContract view;

    public UserPresenter(UserContract.UserViewContract view) {
        userRepository = new UserRepository();
        this.view = view;
    }

    @Override
    public void loadUser() {

        view.load(true);
        userRepository.getUserInfo(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                view.showUserInformation(response.body());
                view.load(false);

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                view.displayMessage(t.getMessage());
                view.load(false);
            }
        });



    }
}
