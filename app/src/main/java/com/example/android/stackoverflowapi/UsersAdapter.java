package com.example.android.stackoverflowapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.stackoverflowapi.model.StackOverflowUser;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<StackOverflowUser> users;
    private int rowLayout;
    private Context context;

    public UsersAdapter(List<StackOverflowUser> users, int rowLayout, Context context) {
        this.setUsers(users);
        this.setRowLayout(rowLayout);
        this.setContext(context);
    }

    public void setUsers(List<StackOverflowUser> users) {
        this.users = users;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, int position) {
        holder.helloWorld.setText(users.get(position).getReputation());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView helloWorld;

        public UsersViewHolder(View view) {
            super(view);

            helloWorld = (TextView) view.findViewById(R.id.hello_world);
        }
    }
}
