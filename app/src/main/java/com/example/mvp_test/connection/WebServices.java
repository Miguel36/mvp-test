package com.example.mvp_test.connection;

import com.example.mvp_test.usuario.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("5d925906310000e1ac10cf04/")
    Call<User> getUser();

}
