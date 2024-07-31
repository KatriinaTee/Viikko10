package com.example.viikko9kayttajarekkari;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage storage = null;
    private final String FILENAME = "users.data";

    private UserStorage() {
    }
    public void writeLog(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            users.forEach(user -> {
                String toWrite = user.getFirstName()+";"+user.getLastName()+";"+user.getEmail()+";"+user.getDegreeProgram()+";"+user.getTextUserDegrees()+"\n";
                sb.append(toWrite);
            });
            outputStreamWriter.write(sb.toString());
            outputStreamWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readLog(Context context) {
        try {
            InputStream inputStream = context.openFileInput(FILENAME);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                while ( (line = bufferedReader.readLine()) != null ) {
                    String[] userData = line.split(";");
                    User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4]);
                    users.add(user);
                }
                inputStream.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //public void writeLog(User user){
    //    try {
    //        BufferedWriter logWriter = new BufferedWriter(new FileWriter(FILENAME, true));
    //        String toWrite = user.getFirstName()+";"+user.getLastName()+";"+user.getEmail()+";"+user.getDegreeProgram()+"\n";
    //        logWriter.write(toWrite);
    //        logWriter.close();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
    //public void readLog(){
    //    try {
    //        BufferedReader logReader = new BufferedReader(new FileReader(FILENAME));
    //        String line;
    //        while ((line = logReader.readLine()) != null){
    //            String[] userData = line.split(";");
    //            User user = new User(userData[0], userData[1], userData[2], userData[3]);
    //            users.add(user);
    //        }
    //        logReader.close();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);
    }
    public static UserStorage getInstance() {
        if (storage == null) {
            storage = new UserStorage();
        }
        return storage;
    }
}

