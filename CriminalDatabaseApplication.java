public class CriminalDatabaseApplication {
    private CaseList caseList;
    private UserList userList;
    private PersonList personList;
    private User user;

    public CriminalDatabaseApplication()
    {
        super.User();
        super.PersonList();
        super.UserList();
        super.CaseList();
    }

    public User createAccount(String firstName, String lastName, String userName, String password)
    {
        return firstName+lastName+userName+password;
    }

    public User login(String userName, String password)
    {
        return userName+password;
    }
}
