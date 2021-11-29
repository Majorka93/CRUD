package ru.major.crud;

import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryApp {

    public static void main(String[] args) throws IOException, ParseException {


        List<Contact> contacts = new ArrayList<>();
        ContactsRepository usersFile;

        Options options = new Options();
        options.addOption("s", "select", false, "Выводит пользователей на экран")
                .addOption("d", "db", true, "Путь к файлу БД")
                .addOption("h", "help", false, "Помощь")
                .addOption("del", "delete", false, "Удаление пользователя")
                .addOption("a", "add", false, "Добавление пользователя")
                .addOption("u", "update", false, "Обновление пользователя")
                .addOption("p", "phone", true, "Телефон")
                .addOption("n", "name", true, "Имя")
                .addOption("sn", "surname", true, "Фамилия")
                .addOption("b", "birthday", true, "День рождения");


        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("d") && !cmd.getOptionValue("d").isEmpty()) {
            System.out.println("Загружаем бд из файла : " + cmd.getOptionValue("d"));
            usersFile = new UsersFile(cmd.getOptionValue("d"));

        } else {
            System.out.println("Загружаем пользователей из бд");
            usersFile = new UsersDb();

        }


        if (cmd.hasOption("s") && !cmd.hasOption("p")) {
            contacts = usersFile.findAllContacts();

        } else if (cmd.hasOption("s") && cmd.hasOption("p")) {
            contacts = usersFile.selectByPhone(cmd.getOptionValue("p"));

        } else if (cmd.hasOption("del")) {
            usersFile.deleteContact(cmd.getOptionValue("p"));
        } else if (cmd.hasOption("a")) {
            usersFile.addContact(cmd.getOptionValue("p"), cmd.getOptionValue("n"), cmd.getOptionValue("sn"), cmd.getOptionValue("b"));
        } else if (cmd.hasOption("u")) {
            usersFile.updateContact(cmd.getOptionValue("p"), cmd.getOptionValue("n"), cmd.getOptionValue("sn"), cmd.getOptionValue("b"));
        } else {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("CRUD by major", options);
        }

        for (Contact contact : contacts) {
            System.out.println(contact);
        }

    }

}