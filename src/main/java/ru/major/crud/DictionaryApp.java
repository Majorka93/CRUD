package ru.major.crud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryApp {

    public static void main(String[] args) throws IOException {


        List<Contact> contacts = new ArrayList<>();
        ContactsRepository usersFile = new UsersFile();

        if (args[1].equalsIgnoreCase("select") && !args[2].isEmpty()) {

            contacts = usersFile.selectByPhone(args[0], Long.parseLong(args[2]));

        } else if (args[1].equalsIgnoreCase("select") && args[2].isEmpty()) {


            contacts = usersFile.findAllContacts(args[0]);

        } else {
            System.out.println("Вы не выбрали команду");
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

    }

}