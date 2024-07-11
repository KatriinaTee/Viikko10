package com.example.viikko9kayttajarekkari;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
    }

    public void addUser(View view){
        String firstName = ((EditText) findViewById(R.id.editFirstName)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.editLastName)).getText().toString();
        String email = ((EditText) findViewById(R.id.editEmail)).getText().toString();
        String degreeProgram = "";
        RadioGroup radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
        int chosenButton = radioDegreeProgram.getCheckedRadioButtonId();


       if(chosenButton == R.id.seRadioButton){
            degreeProgram = ((RadioButton) findViewById(R.id.seRadioButton)).getText().toString();
        }else if(chosenButton == R.id.imRadioButton){
           degreeProgram = ((RadioButton) findViewById(R.id.imRadioButton)).getText().toString();
        }else if(chosenButton == R.id.ceRadioButton){
           degreeProgram = ((RadioButton) findViewById(R.id.ceRadioButton)).getText().toString();
        }else if(chosenButton == R.id.eeRadioButton){
           degreeProgram = ((RadioButton) findViewById(R.id.eeRadioButton)).getText().toString();
        }

        User user = new User(firstName, lastName, email, degreeProgram);
        System.out.println(firstName + " " + lastName);

        UserStorage us = UserStorage.getInstance();
        us.addUser(user);
    }

}