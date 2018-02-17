package com.example.android.stackoverflowapi.model;

import com.google.gson.annotations.SerializedName;

public class StackOverflowUser {

    @SerializedName("display_name")
    private String name;

    @SerializedName("reputation")
    private String reputation;

    @SerializedName("location")
    private String location;

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
