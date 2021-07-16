package ru.major.crud;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersFile implements ContactsRepository {


    @Override
    public List<Contact> findAllContacts(String args0) throws IOException {

        List<Contact> sublist = new ArrayList<>();

        try {
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader(args0));

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
    public List<Contact> selectByPhone(String args0, Long args2) throws IOException {
        List<Contact> filteredByPhone = new ArrayList<>();
        List<Contact> allContacts = findAllContacts(args0);
        for (Contact contact : allContacts) {
            if (contact.getPhoneNumber() == args2)
                filteredByPhone.add(contact);
        }

        return filteredByPhone;
    }
}



