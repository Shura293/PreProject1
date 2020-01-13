package service;


import connection.ConnectionDB;
import connection.ConnectionHibernateDB;
import dao.UserDAO;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.List;

public class UserService {

    private static UserService userService;
    private SessionFactory sessionFactory;

    public UserService(){

    }

    private UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(ConnectionHibernateDB.getSessionFactory());
        }
        return userService;
    }

    public void addUser(User user){
/*
        UserDAO dao = ConnectionDB.getUserDAO();
        if (!dao.isExistUser(user)) {
            dao.addUser(user);
        }*/
        if (!new UserHibernateDAO(sessionFactory.openSession()).isExistUser(user)) {
            new UserHibernateDAO(sessionFactory.openSession()).addUser(user);
        }
    }


    public void updateUser(User user) {
        //ConnectionDB.getUserDAO().editUser(user);
        new UserHibernateDAO(sessionFactory.openSession()).editUser(user);
    }


    public void deleteUser(User user) {
        //ConnectionDB.getUserDAO().deleteUser(user);
        new UserHibernateDAO(sessionFactory.openSession()).deleteUser(user);
    }


    public List<User> getAllUsers() {
        //return ConnectionDB.getUserDAO().getAllUsers();
        return new UserHibernateDAO(sessionFactory.openSession()).getAllUsers();
    }
}