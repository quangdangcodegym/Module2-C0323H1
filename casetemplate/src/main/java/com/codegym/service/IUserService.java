package com.codegym.service;

import com.codegym.model.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User findUserById(long idUserEdit);
    public void updateUserById(long idUser, User user);
    public void deleteUserById(long idUser);
    public void addUser(User user);
    public void sortUsersByName();

    List<User> searchUserByName(String keyName);

    List<User> searchUserByYear(int year);

    List<User> searchUserByRangeDate(LocalDate d1, LocalDate d2);
}
