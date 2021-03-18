import java.util.UUID;

public abstract class User {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String department;

    public User(UUID userID, String firstName, String lastName, String userName, String password, String email, String phoneNumber, String department)
    {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public void changePassword(String password) {
        setPassword(password);
    }

    public void changeEmail(String email) {
        setEmail(email);
    }

    public void changePhoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    public void changeDepartment(String department) {
        setDepartment(department);
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getLoginInfo() {
        return "UserName: "+userName+"\nPassword: "+password+"\nUser ID: "+userID+"\nEmail: "+email+"\nPhone Number: "+phoneNumber+
        "\nDepartment: "+department;
    }

}