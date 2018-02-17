package com.example.android.stackoverflowapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.stackoverflowapi.model.StackOverflowUser;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
        holder.userName.setText(users.get(position).getName());
        holder.userReputation.setText(commaInNumber(users.get(position).getReputation()));
        holder.userLocation.setText(users.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userReputation;
        TextView userLocation;

        public UsersViewHolder(View view) {
            super(view);

            userName = (TextView) view.findViewById(R.id.user_name);
            userReputation = (TextView) view.findViewById(R.id.user_reputation);
            userLocation = (TextView) view.findViewById(R.id.user_location);
        }
    }

    private String commaInNumber(String number) {
        return NumberFormat.getNumberInstance(Locale.getDefault())
                .format(Integer.parseInt(number));
    }
}
