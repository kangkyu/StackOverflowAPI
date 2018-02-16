package com.example.android.stackoverflowapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    RecyclerView mUsersView;
    RecyclerView.Adapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsersView = (RecyclerView) findViewById(R.id.users_recycler_view);

        mUsersView.setLayoutManager(new LinearLayoutManager(this));

        usersAdapter = new UsersAdapter(Collections.<String>emptyList(), R.layout.item_user, getApplicationContext());
        mUsersView.setAdapter(usersAdapter);
    }
}
