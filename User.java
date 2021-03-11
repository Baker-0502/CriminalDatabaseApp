import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String department;

    public User(int userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department)
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public void changePassword(String password) {
        System.out.println("changing password");
    }

    public void changeEmail(String email) {
        System.out.println("changing email");
    }

    public void changePhoneNumber(String phoneNumber) {
        System.out.println("changing phone number");
    }

    public void changeDepartment(String department) {
    System.out.println("chaging department");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLoginInfo() {
        return username+password+email;
    }

}