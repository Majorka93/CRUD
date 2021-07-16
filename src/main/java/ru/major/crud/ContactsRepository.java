package ru.major.crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ContactsRepository {

    List<Contact> findAllContacts() throws IOException;

    List<Contact> selectByPhone(Long args2) throws IOException;

    void addContact (String phoneNumber, String name, String surname, String birthday) throws IOException;

}
