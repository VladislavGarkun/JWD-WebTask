package by.tc.carrental.model.entity;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String userName;
    private String phoneNumber;
    //private String dateOfBirth;
    //private String numberOfPassport;
    //private String drivingLicense;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    /*public User(String login, String password, String name, String surname, String userName, String phoneNumber, String dateOfBirth, String numberOfPassport){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPassport = numberOfPassport;
    }*/

    public User( String login, String password, String name, String surname, String userName, String phoneNumber){
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getUserName(){
        return userName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    /*public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getNumberOfPassport(){
        return numberOfPassport;
    }*/

    /*public String getDrivingLicense(){
        return drivingLicense;
    }*/

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User)o;

        return login.equals(user.login) && password.equals(user.password) && name.equals(user.name) && surname.equals(user.surname) && phoneNumber.equals(user.phoneNumber) && userName.equals(user.userName)
                /*&& dateOfBirth.equals(user.dateOfBirth) && numberOfPassport.equals(user.numberOfPassport)/* && drivingLicense.equals(user.drivingLicense)*/;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(login, password, name, surname, userName, phoneNumber/*, dateOfBirth, numberOfPassport/*, drivingLicense*/);
    }

    @Override
    public String toString()
    {
        return  "login: " + login +
                "\n password: " + password +
                "\n name: " + name +
                "\n surname: " + surname +
                "\n phonenumber: " + phoneNumber +
                "\n username: " + userName/* +
                "\n dateofbirth: " + dateOfBirth +
                "\n numberofpassport: " + numberOfPassport/* +
                "\n drivinglicense: " + drivingLicense*/;
    }
}
