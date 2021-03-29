import java.util.UUID;

/**
 * An abstract class representing a User.
 * @author Code Gods
 */
public abstract class User {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String department;

    /**
     * Constructor for a generic User.
     * @param userID A User ID for the User.
     * @param firstName First Name of the User.
     * @param lastName Last Name of the User.
     * @param userName Username of the User.
     * @param password Password of the User.
     * @param email Email Address of the User.
     * @param phoneNumber Phone Number of the User.
     * @param department Department that the User belongs to.
     */
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

    /**
     * Method used to change a User's password.
     * @param password The new password.
     */
    public void changePassword(String password) {
        setPassword(password);
    }

    /**
     * Method used to change a User's email address.
     * @param email The new email address.
     */
    public void changeEmail(String email) {
        setEmail(email);
    }

    /**
     * Method used to change a User's phone number.
     * @param phoneNumber The new phone number.
     */
    public void changePhoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }

    /**
     * Method used to change a User's department.
     * @param department The new department.
     */
    public void changeDepartment(String department) {
        setDepartment(department);
    }

    /**
     * Method used to change a User's first name.
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Returns User's ID.
     * @return User's ID.
     */
    public UUID getUserID() {
        return userID;
    }

    /**
     * Returns User's First Name.
     * @return User's First Name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method used to change a User's last name.
     * @param lastName The new last name.
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * Returns User's Last Name.
     * @return User's Last Name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method used to change a User's username.
     * @param userName The new username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns User's Username.
     * @return User's Username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Method used to change a User's password.
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns User's Password.
     * @return User's Password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method used to change a User's email.
     * @param email The new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns User's Email.
     * @return User's Email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method used to change a User's phone number.
     * @param phoneNumber The new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns User's Phone Number.
     * @return User's Phone Number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method used to change a User's department.
     * @param department The new department.
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns User's Department.
     * @return User's Department.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Returns a String representation of the User
     */
    public String toString() {
        return "User ID: "+userID+"\nFirst Name: "+firstName+"\nLast Name:"+lastName+"\nUserName: "+userName+"\nPassword: "+password+"\nEmail: "+email+"\nPhone Number: "+phoneNumber+
        "\nDepartment: "+department;
    }

}