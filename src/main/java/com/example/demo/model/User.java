package com.example.demo.model;


public class User {

    private String firstName;
    private String lastName;

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

   

    @Override
    public String toString() {
        StringBuilder name = new StringBuilder();

        if (firstName != null && !firstName.isBlank()) {
            name.append(firstName.trim());
        }

        if (lastName != null && !lastName.isBlank()) {
            if (name.length() > 0) {
                name.append(" ");
            }
            name.append(lastName.trim());
        }

        return name.toString();
    }
}
