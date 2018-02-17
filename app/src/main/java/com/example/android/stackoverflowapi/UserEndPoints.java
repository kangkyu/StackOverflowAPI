package com.example.android.stackoverflowapi;

import com.example.android.stackoverflowapi.model.UsersReceived;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserEndPoints {
    @GET("/2.2/users?page=1&pagesize=5&order=desc&sort=reputation&site=stackoverflow")
    Call<UsersReceived> getUsers();
}
