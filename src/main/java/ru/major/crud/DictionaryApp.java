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
        ContactsRepository usersFile = new UsersFile(args[0]);


        if (args.length == 3 && args[1].equalsIgnoreCase("select") && !args[2].isEmpty()) {

            contacts = usersFile.selectByPhone(Long.parseLong(args[2]));

        } else if (args[1].equalsIgnoreCase("select")) {


            contacts = usersFile.findAllContacts();

        } else if (args[1].equalsIgnoreCase("create")) {
            usersFile.addContact(args[2], args[3], args[4], args[5]);

        } else if (args.length == 3 && args[1].equalsIgnoreCase("delete") && !args[2].isEmpty()) {

            usersFile.deleteContact(args[2]);

        } else {
            System.out.println("Вы не выбрали команду");

        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

    }

}