package ru.major.crud;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static ru.major.crud.PathFile.findFile;

public class DbLinesTest {

    @Test
    public void testLines() throws IOException {
        File file = findFile("db-lines.txt");
        assertEquals(3, Files.lines(file.toPath()).count());

        ContactsRepository repository = new UsersFile(file.getAbsolutePath());
        repository.updateContact("+79047778811", "2", "2", "2");
        repository.updateContact("+79047778811", "3", "3", "3");
        repository.updateContact("+79047778811", "44", "4", "4");

        assertEquals(3, Files.lines(file.toPath()).count());
    }

    @Test
    public void testAddLines() throws IOException {
        File file = findFile("db-lines2.txt");
        assertEquals(1, Files.lines(file.toPath()).count());

        ContactsRepository repository = new UsersFile(file.getAbsolutePath());
        repository.addContact("+79047778811", "2", "2", "2");
        repository.addContact("+79047778812", "3", "3", "3");
        repository.addContact("+79047778813", "44", "4", "4");
        assertEquals(4, Files.lines(file.toPath()).count());
        repository.deleteContact("+79047778811");
        repository.deleteContact("+79047778812");
        repository.deleteContact("+79047778813");
        assertEquals(1,Files.lines(file.toPath()).count());
    }
}
