package ru.major.crud;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UsersFileTest {


    @Test
    public void findAllContactsTest() throws IOException {
        UsersFile repository = findFilePath("db1.txt");
        List<Contact> allContacts = repository.findAllContacts();
        assertEquals(3, allContacts.size());
        assertEquals("Иван", allContacts.get(0).getName());
    }

    @Test
    public void findByPhoneNumberTest() throws IOException {
        UsersFile repository = findFilePath("db1.txt");
        List<Contact> allContacts = repository.selectByPhone("+79047778811");
        assertEquals(1, allContacts.size());
        assertEquals("Алеша", allContacts.get(0).getName());
        assertEquals("Алешков", allContacts.get(0).getSurname());
    }

    @Test
    public void deleteContactTest() throws IOException {
//todo Тесты проверить в 2 этапа. Сначала проверяем начальное состояние, потом проверяем результат
        UsersFile repository = findFilePath("SubscribersTest.txt");
        List<Contact> allContacts = repository.findAllContacts();
        repository.deleteContact("+79996660000");
        assertEquals(4, repository.findAllContacts().size());
    }

    @Test
    public void updateContactTest() throws IOException {
        UsersFile repository = findFilePath("SubscribersTest.txt");
        repository.updateContact("+79046741611", "Сергей", "Жириновский", "01.02.1945");
        List<Contact> allContacts = repository.findAllContacts();
        assertEquals("Сергей", allContacts.get(3).getName());
        assertEquals("Жириновский", allContacts.get(3).getSurname());
        assertEquals("01.02.1945", allContacts.get(3).getBirthday());
    }

    private UsersFile findFilePath(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return new UsersFile(file.getAbsolutePath());

    }
}
