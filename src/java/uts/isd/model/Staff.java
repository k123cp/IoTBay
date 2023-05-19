package uts.isd.model;

import java.io.Serializable;

/**
 * Author:  John
 * Created: 18 May 2023
 */
public class Staff implements Serializable{
    private int staffID;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String staffNumber;
    private boolean isActivated;

    public Staff(int staffID, String emailAddress, String firstName, String lastName, String phoneNumber, String password, String staffNumber, boolean isActivated) {
        this.staffID = staffID;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.staffNumber = staffNumber;
        this.isActivated = isActivated;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setstaffID(int staffID) {
        this.staffID = staffID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public boolean isIsActivated() {
        return isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    @Override
    public String toString() {
        return "staffID: " + staffID + ", emailAddress: " + emailAddress + ", firstName: "+ firstName + ", lastName: " + lastName + ", phoneNumber: " + phoneNumber + ", password: " + password + ", staffNumber: " + staffNumber + ", isActivated: " + isActivated;
    }
}
