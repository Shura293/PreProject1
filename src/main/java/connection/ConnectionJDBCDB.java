package connection;

import dao.UserDAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection getMysqlConnection() {
        try {
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);

            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_example?serverTimezone=Europe/Moscow",
                    "root",
                    "root");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public static UserDAO getUserDAO() {
        return new UserDAO(getMysqlConnection());
    }

}