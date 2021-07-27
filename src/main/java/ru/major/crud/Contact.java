package ru.major.crud;

public class Contact {

    private String name;
    private String surname;
    private String birthday;
    private String phoneNumber;

    public Contact(String name, String surname, String birthday, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;


    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return getName() + " " + getSurname() + " " + getBirthday() + " " + getPhoneNumber();
    }
}
