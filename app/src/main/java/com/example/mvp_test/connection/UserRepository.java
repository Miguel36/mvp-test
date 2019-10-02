package com.example.mvp_test.connection;

import com.example.mvp_test.usuario.model.User;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class UserRepository {

    private static UserRepository userRepository;
    private WebServices service;

    public static UserRepository getInstance(){
        if (userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

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
