package com.example.mvp_test.connection;

import com.example.mvp_test.usuario.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("5d926755310000d48110cf36/")
    Call<User> getUser();

}
