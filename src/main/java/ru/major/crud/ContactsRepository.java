package ru.major.crud;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ContactsRepository {

    List<Contact> findAllContacts(String args0) throws IOException;

    List<Contact> selectByPhone(String args0, Long args2) throws IOException;

}
