package com.example.android.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersReceived {
    @SerializedName("items")
    private List<StackOverflowUser> mStackOverflowUsers;

    public List<StackOverflowUser> getStackOverflowUsers() {
        return mStackOverflowUsers;
    }

    public void setStackOverflowUsers(List<StackOverflowUser> stackOverflowUsers) {
        mStackOverflowUsers = stackOverflowUsers;
    }
}
