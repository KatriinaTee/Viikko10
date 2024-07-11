package com.example.viikko9kayttajarekkari;

public class User {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String degreeProgram;

    public static int userCounter = 0;

    public User(String firstName, String lastName, String email, String degreeProgram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;

        userCounter++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDegreeProgram() {
        return degreeProgram;

    }
}
