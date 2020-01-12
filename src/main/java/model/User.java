package model;

import java.util.Objects;

public class User {
    private long id;
    private String userName;
    private String firstName;
    private String secondName;
    private byte age;

    public User() {

    }

    public User(String userName, String firstName, String secondName, byte age) {
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public User(long id, String userName, String firstName, String secondName, byte age) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserName());
    }

    @Override
    public String toString() {
        return "id " + id +
                "; userName: " + userName +
                "; firstName: " + firstName +
                "; secondName: " + secondName +
                "; age: " + age;
    }
}

