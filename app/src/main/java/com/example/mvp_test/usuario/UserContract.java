package com.example.mvp_test.usuario;

import com.example.mvp_test.usuario.model.User;

public interface UserContract {

    interface UserPresenterContract{
        void loadUser();
    }

    interface UserViewContract{
        void setPresenter(UserPresenterContract presenter);
        void load(boolean loading);
        void showUserInformation(User user);
        void displayMessage(String message);
    }

}
