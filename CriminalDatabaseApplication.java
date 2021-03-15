import java.util.Scanner;

public class CriminalDatabaseApplication {
    private CaseList caseList;
    private UserList userList;
    private PersonList personList;
    private User user;
    static Scanner sc = new Scanner(System.in);

    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        this.caseList = caseList;
        this.userList = userList;
        this.personList = personList;
        this.user = user;
    }

    public User createAccount(String firstName, String lastName, String userName, String password, User user)
    {
        System.out.println("Enter First Name: ");
        firstName = sc.nextLine();
        user.setFirstName(firstName);

        System.out.println("Enter Last Name: ");
        lastName = sc.nextLine();
        user.setLastName(lastName);

        System.out.println("Enter User Name: ");
        userName = sc.nextLine();
        user.setUserName(userName);

        System.out.println("Enter Password: ");
        password = sc.nextLine();
        user.setPassword(password);

        return user;
    }

    public User login(String userName, String password, User user)
    {
        System.out.println("Enter UserName: ");
        userName = sc.nextLine();
        if(userName.equals(user.getUserName()))
        {
            System.out.println("Enter Password: ");
            password = sc.nextLine();
            if(password.equals(user.getPassword()))
            {
                System.out.println("Login Successful");
            }
            else{
                System.out.println("Password was wrong");
            }
        }
        else{
            System.out.println("UserName was wrong");
        }
        return user;
    }
}
