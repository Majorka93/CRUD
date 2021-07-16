package ru.major.crud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersFile implements ContactsRepository {

    private String pathToFile;

    public UsersFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public List<Contact> findAllContacts() throws IOException {



        List<Contact> sublist = new ArrayList<>();

        try {
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader(pathToFile));

            while ((str = br.readLine()) != null) {
                String[] list = str.split(";");
                long i = Long.parseLong(list[3].trim());
                sublist.add(new Contact(list[0], list[1], list[2], i));

            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return sublist;
    }

    @Override
    public List<Contact> selectByPhone(Long args2) throws IOException {
        List<Contact> filteredByPhone = new ArrayList<>();
        List<Contact> allContacts = findAllContacts();
        for (Contact contact : allContacts) {
            if (contact.getPhoneNumber() == args2)
                filteredByPhone.add(contact);
        }

        return filteredByPhone;
    }

    @Override
    public void addContact(String phoneNumber, String name, String surname, String birthday) throws IOException {

    }
}



