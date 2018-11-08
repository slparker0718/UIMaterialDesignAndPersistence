package edu.psu.slparker.androiduiandlogin_samanthaparker;

public class UserProfile {

    private long ID;
    private String firstname;
    private String lastname;
    private String username;
    private String emailAddress;
    private String password;
    private String birthdate;
    private String mobilePhone;

    public UserProfile(){}

    public UserProfile(String firstName, String lastName, String userName, String password, String emailAddress, String birthDate, String mobilePhone)
    {
        this.firstname = firstName;
        this.lastname = lastName;
        this.username = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.birthdate = birthDate;
        this.mobilePhone = mobilePhone;
    }

    public String getFirstname() {return firstname; }

    public void setFirstName(String firstName) { this.firstname = firstName; }

    public String getLastName() {return lastname; }

    public void setLastName(String lastName) {this.lastname = lastname; }

    public String getUsername() {return username; }

    public void setUsername(String username) {this.username = username; }

    public String getEmailAddress() {return emailAddress; }

    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getPassword() {return password; }

    public void setPassword(String password) {this.password = password;}

    public String getBirthdate() {return birthdate;}

    public void setBirthdate(String birthdate) {this.birthdate = birthdate;}

    public String getMobilePhone() {return mobilePhone;}

    public void setMobilePhone(String mobilePhone) {this.mobilePhone = mobilePhone;}
}
