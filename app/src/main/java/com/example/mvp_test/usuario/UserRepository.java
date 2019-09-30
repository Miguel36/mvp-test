package com.example.mvp_test.usuario;

import com.example.mvp_test.connection.WebServices;
import com.example.mvp_test.usuario.model.User;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {

    private WebServices service;
    public UserRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(WebServices.class);
    }

    public void getUserInfo(Callback<User> callback){
        service.getUser().enqueue(callback);

    }



}
