package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(userName, firstName, secondName, age) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setByte(4, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("update users set userName= ?, firstName= ?, secondName= ?, age= ? where id = ?")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setByte(4, user.getAge());
            preparedStatement.setLong(5, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id= ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isExistUser(User user) {
        boolean res = false;
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userName= ? and firstName = ? and  secondname= ? and age = ?")) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getSecondName());
            preparedStatement.setByte(4, user.getAge());
            ResultSet result = preparedStatement.executeQuery();
            res = result.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void dropTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS users");
        stmt.close();
    }

    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from users")) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                resultList.add(new User(
                        result.getLong("id"),
                        result.getString("userName"),
                        result.getString("firstName"),
                        result.getString("secondName"),
                        result.getByte("age")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public List<List<String>> getAllUsersList() {
        List<List<String>> resultList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from users")) {
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                List<String> userList = new ArrayList<>();
                userList.add(String.valueOf(result.getLong("id")));
                userList.add(result.getString("userName"));
                userList.add(result.getString("firstName"));
                userList.add(result.getString("secondName"));
                userList.add(String.valueOf(result.getByte("age")));
                resultList.add(userList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }



}