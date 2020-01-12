package service;


import connection.ConnectionDB;
import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.util.List;

public class UserService {


    public void addUser(User user){
        System.out.println("<---- Used method: addUser() ---->");
        UserDAO dao = ConnectionDB.getUserDAO();
        if (!dao.isExistUser(user)) {
            dao.addUser(user);
        }
    }


    public void updateUser(User user) {
        System.out.println("<---- Used method: editUser() ---->");
        ConnectionDB.getUserDAO().editUser(user);
    }


    public void deleteUser(long id) {
        System.out.println("<---- Used method: deleteUser() ---->");
        ConnectionDB.getUserDAO().deleteUser(id);
    }


    public List<User> getAllUsers() {
        System.out.println("<---- Used method: getAllUsers() ---->");
        return ConnectionDB.getUserDAO().getAllUsers();
    }

    public List<List<String>> getAllUsersList() {
        System.out.println("<---- Used method: getAllUsers() ---->");
        return ConnectionDB.getUserDAO().getAllUsersList();
    }



}