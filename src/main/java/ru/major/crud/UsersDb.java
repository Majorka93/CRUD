package ru.major.crud;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDb implements ContactsRepository {
    @Override
    public List<Contact> findAllContacts() throws IOException {
        return null;
    }

    @Override
    public List<Contact> selectByPhone(String phoneNumber) throws IOException {
        List<Contact> contacts = new ArrayList<>();

        try {
            PreparedStatement statement = SingletonConnection.create().prepareStatement("SELECT * FROM public.users WHERE PHONE_NUMBER =?");
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                contacts.add(new Contact(
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("phone_number")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public void addContact(String phoneNumber, String name, String surname, String birthday) throws IOException {

        try {
            PreparedStatement statement = SingletonConnection.create().prepareStatement("INSERT INTO public.users" +
                    "(name, surname,date_of_birth,phone_number) " +
                    "VALUES (?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, birthday);
            statement.setString(4, phoneNumber);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteContact(String phoneNumber) throws IOException {

        try {
            PreparedStatement statement = SingletonConnection.create().prepareStatement("DELETE FROM public.users WHERE PHONE_NUMBER =?");
            statement.setString(1, phoneNumber);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateContact(String phoneNumber, String name, String surname, String birthday) throws IOException {
        try {
            PreparedStatement statement = SingletonConnection.create().prepareStatement(
                    "UPDATE public.users SET " +
                            "NAME =?," +
                            "SURNAME=?," +
                            "DATE_OF_BIRTH=?" +
                            "WHERE PHONE_NUMBER =?");

            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, birthday);
            statement.setString(4, phoneNumber);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
