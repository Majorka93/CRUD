package ru.major.crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ContactsRepository {

    List<Contact> findAllContacts() throws IOException;

    List<Contact> selectByPhone(String phoneNumber) throws IOException;

    void addContact (String phoneNumber, String name, String surname, String birthday) throws IOException;

    void deleteContact (String phoneNumber) throws IOException;

    void updateContact (String phoneNumber, String name, String surname, String birthday) throws IOException;

}
