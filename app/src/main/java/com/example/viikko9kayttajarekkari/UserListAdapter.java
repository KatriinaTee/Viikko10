package com.example.viikko9kayttajarekkari;

import android.content.Context;
import android.icu.text.Collator;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private Context context;
    private ArrayList<User> users = new ArrayList<>();

    public UserListAdapter(Context context, ArrayList<User> users) {
        List<User> users2 = users.stream()
                .sorted(Comparator.comparing(User::getLastName))
                .collect(Collectors.toList());
        this.context = context;
        this.users = (ArrayList<User>) users2;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textFirstName.setText(users.get(position).getFirstName());
        holder.textLastName.setText(users.get(position).getLastName());
        holder.textEmail.setText(users.get(position).getEmail());
        holder.textDegreeProgram.setText(users.get(position).getDegreeProgram());
        holder.textUserDegrees.setText(users.get(position).getTextUserDegrees());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
