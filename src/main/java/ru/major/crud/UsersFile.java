package ru.major.crud;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

                if (list.length == 5 && list[4].equalsIgnoreCase("deleted")) {
                    continue;

                }
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


        FileWriter writer = new FileWriter(pathToFile, true);
        writer.write("\n");
        writer.write(name);
        writer.write(";");
        writer.write(surname);
        writer.write(";");
        writer.write(birthday);
        writer.write(";");
        writer.write(phoneNumber);
        writer.close();
        System.out.println("Файл записан");

    }

    @Override
    public void deleteContact(String phoneNumber) throws IOException {

        List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(pathToFile), StandardCharsets.UTF_8));

        for (int i = 0; i < fileContent.size(); i++) {
            if (fileContent.get(i).contains(phoneNumber)) {
                fileContent.remove(i);
                break;
            }

        }

        Files.write(Paths.get(pathToFile), fileContent, StandardCharsets.UTF_8);

    }

    @Override
    public void updateContact(String phoneNumber, String name, String surname, String birthday) throws IOException {



    }


}




