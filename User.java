import java.util.ArrayList;
import java.util.Scanner;

public class User {
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
    this.reader = reader;
    this.firstName = firstName;
    this.lastname = lastName;
    this.username = username;
    this.password = password;
    this.email = email;
    this.phoneNUmber = phoneNumber;
    this.department = department;
}

public void changePassword(String password) {

}

public void changeEmail(String email) {

}

public void changePhoneNumber(String phoneNumber) {

}

public void changeDepartment(String department) {
    
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