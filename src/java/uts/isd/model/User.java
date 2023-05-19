package uts.isd.model;

import java.io.Serializable;

/**
 * Author:  John
 * Created: 18 May 2023
 */
public class User implements Serializable{
    private int userID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User(int userID, String emailAddress, String firstName, String lastName, String phoneNumber) {
        this.userID = userID;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "userID: " + userID + ", emailAddress: " + emailAddress + ", firstName: "+ firstName + ", lastName: " + lastName + ", phoneNumber: " + phoneNumber;
    }
}
