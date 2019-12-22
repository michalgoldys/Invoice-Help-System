package pl.michalgoldys.InvoiceHelpSystem;

import java.util.Objects;

public class User {

    private final UserType userType;
    private String userName;
    private String userPassword;

    public User(UserType userType, String userName, String userPassword) {
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userType=" + userType +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userType == user.userType &&
                Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userType, userName);
    }

}