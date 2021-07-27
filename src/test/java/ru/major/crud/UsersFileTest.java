package ru.major.crud;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersFileTest {


    @Test
    public void findAllContactsTest() throws IOException {
        UsersFile repository = new UsersFile("C:\\Users\\Integro\\IdeaProjects\\CRUD\\src\\test\\resources\\db1.txt");
        List<Contact> allContacts = repository.findAllContacts();
        assertEquals(3, allContacts.size());
        assertEquals("Иван", allContacts.get(0).getName());
    }

    @Test
    public void findByPhoneNumberTest() throws IOException {
        UsersFile repository = new UsersFile("C:\\Users\\Integro\\IdeaProjects\\CRUD\\src\\test\\resources\\db1.txt");
        List<Contact> allContacts = repository.selectByPhone(79047778811L);
        assertEquals(1, allContacts.size());
        assertEquals("Алеша", allContacts.get(0).getName());
        assertEquals("Алешков", allContacts.get(0).getSurname());
    }

}
