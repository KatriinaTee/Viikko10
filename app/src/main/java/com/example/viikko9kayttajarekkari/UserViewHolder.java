package com.example.viikko9kayttajarekkari;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView textFirstName, textLastName, textEmail, textDegreeProgram, textUserDegrees;
    public UserViewHolder(@NonNull View itemView){
        super(itemView);
        textFirstName = itemView.findViewById(R.id.textFirstName);
        textLastName = itemView.findViewById(R.id.textLastName);
        textEmail = itemView.findViewById(R.id.textEmail);
        textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
        textUserDegrees = itemView.findViewById(R.id.textUserDegrees);
    }



}
