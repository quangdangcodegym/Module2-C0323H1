package com.codegym.service;

import com.codegym.config.Config;
import com.codegym.model.User;
import com.codegym.utils.DateUtils;
import com.codegym.utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserService implements IUserService {
    private String fileName = "./data/Data.txt";

    public List<User> getAllUsers() {
        return FileUtils.readFile(fileName, Config.TYPE_USER);
    }

    public User findUserById(long idUserEdit) {
        List<User> users = FileUtils.readFile(fileName, Config.TYPE_USER);
        for (User e : users) {
            if (e.getId() == idUserEdit) {
                return e;
            }
        }
        return null;
    }

    public void updateUserById(long idUser, User user) {
        List<User> users = FileUtils.readFile(fileName, Config.TYPE_USER);
        for (User e : users) {
            if (e.getId() == idUser) {
                e.setName(user.getName());
                e.setAddress(user.getAddress());
                e.setEgender(user.getEgender());
                e.setErole(user.getErole());
                e.setDob(user.getDob());
            }
        }
        FileUtils.writeFile(fileName, users);
    }

    public void deleteUserById(long idUser) {
        List<User> users = FileUtils.readFile(fileName, Config.TYPE_USER);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == idUser) {
                users.remove(i);
                break;
            }
        }
        FileUtils.writeFile(fileName, users);
    }

    public void addUser(User user) {
        List<User> users = FileUtils.readFile(fileName, Config.TYPE_USER);
        users.add(user);
        FileUtils.writeFile(fileName, users);
    }

    public void sortUsersByName() {
        List<User> users = FileUtils.readFile(fileName, Config.TYPE_USER);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getName().compareTo(user2.getName());
            }
        });
    }

    @Override
    public List<User> searchUserByName(String keyName) {
        List<User> users = getAllUsers();
        List<User> results = new ArrayList<>();

        for (User u : users) {
            if (u.getName().toLowerCase().contains(keyName.toLowerCase())) {
                results.add(u);
            }
        }
        return results;
    }

    @Override
    public List<User> searchUserByYear(int year) {
        List<User> users = getAllUsers();
        List<User> results = new ArrayList<>();

        for (User u : users) {
            if (u.getDob()!=null && u.getDob().getYear() == year) {
                results.add(u);
            }
        }
        return results;
    }

    @Override
    public List<User> searchUserByRangeDate(LocalDate d1, LocalDate d2) {
        List<User> users = getAllUsers();
        List<User> results = new ArrayList<>();

        for (User u : users) {
            if (u.getDob()!=null && DateUtils.isDateInRange(u.getDob(), d1, d2)) {
                results.add(u);
            }
        }
        return results;
    }
}