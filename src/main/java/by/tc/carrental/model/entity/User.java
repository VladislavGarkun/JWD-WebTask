package by.tc.carrental.model.entity;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String dateOfBirth;
    private String numberOfPassport;
    //private String drivingLicense;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(String firstName, String lastName, String phoneNumber, String login, String password, String dateOfBirth, String numberOfPassport){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPassport = numberOfPassport;
    }

    public User(String firstName, String lastName, String phoneNumber, String login, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public String getLastName(){
        return lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getNumberOfPassport(){
        return numberOfPassport;
    }

    /*public String getDrivingLicense(){
        return drivingLicense;
    }*/

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User)o;

        return login.equals(user.login) && password.equals(user.password) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && phoneNumber.equals(user.phoneNumber)
                && dateOfBirth.equals(user.dateOfBirth) && numberOfPassport.equals(user.numberOfPassport)/* && drivingLicense.equals(user.drivingLicense)*/;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(login, password, firstName, lastName, phoneNumber, dateOfBirth, numberOfPassport/*, drivingLicense*/);
    }

    @Override
    public String toString()
    {
        return  "login: " + login +
                "\n password: " + password +
                "\n firstname: " + firstName +
                "\n lastname: " + lastName +
                "\n phonenumber: " + phoneNumber +
                "\n dateofbirth: " + dateOfBirth +
                "\n numberofpassport: " + numberOfPassport/* +
                "\n drivinglicense: " + drivingLicense*/;
    }
}
