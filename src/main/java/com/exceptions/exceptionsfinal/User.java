package com.exceptions.exceptionsfinal;

public class User {
    private String firstName;
    private  String secondName;
    private  String middleName;
    private  String phoneNumber;
    private  String birthDay;
    private String gender;

    public User(String firstName, String secondName, String middleName, String phoneNumber, String birthDay, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getFirst() {
        return  firstName.toString();
    }
}
