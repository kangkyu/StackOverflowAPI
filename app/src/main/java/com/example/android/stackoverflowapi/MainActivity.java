package com.example.android.stackoverflowapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.stackoverflowapi.model.UsersReceived;
import com.example.android.stackoverflowapi.model.StackOverflowUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mUsersView;
    RecyclerView.Adapter usersAdapter;
    List<StackOverflowUser> myDataSource = new ArrayList<StackOverflowUser>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsersView = (RecyclerView) findViewById(R.id.users_recycler_view);

        mUsersView.setLayoutManager(new LinearLayoutManager(this));

        usersAdapter = new UsersAdapter(myDataSource, R.layout.item_user, getApplicationContext());
        mUsersView.setAdapter(usersAdapter);

        loadUsers();
    }

    public void loadUsers() {
        final UserEndPoints apiService = APIClient.getClient().create(UserEndPoints.class);
        Call<UsersReceived> call = apiService.getUsers();

        call.enqueue(new Callback<UsersReceived>() {
            @Override
            public void onResponse(Call<UsersReceived> call, Response<UsersReceived> response) {
                myDataSource.clear();
                myDataSource.addAll(response.body().getStackOverflowUsers());
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UsersReceived> call, Throwable t) {
                // log error
                System.out.println("Failed!" + t.toString());
            }
        });
    }
}
