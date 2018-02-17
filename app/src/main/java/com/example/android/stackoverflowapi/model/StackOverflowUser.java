package com.example.android.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

public class StackOverflowUser {
    @SerializedName("reputation")
    private String reputation;

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }
}
