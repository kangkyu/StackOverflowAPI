package com.example.android.stackoverflowapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UsersAdapter extends android.support.v7.widget.RecyclerView.Adapter {

    private List<String> users;
    private int rowLayout;
    private Context context;

    public UsersAdapter(List<String> users, int rowLayout, Context context) {
        this.setUsers(users);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView helloWorld;

        public UsersViewHolder(View view) {
            super(view);

            helloWorld = (TextView) view.findViewById(R.id.hello_world);
        }
    }
}
