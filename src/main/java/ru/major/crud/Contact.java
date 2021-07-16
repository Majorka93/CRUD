package ru.major.crud;

public class Contact {

    private String name;
    private String surname;
    private String birthday;
    private long phoneNumber;

    public Contact(String name, String surname, String birthday, long phoneNumber) {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String toString() {
        return getName() + " " + getSurname() + " " + getBirthday() + " " + getPhoneNumber();
    }
}
