public class CriminalDatabaseApplication {
    private CaseList caseList;
    private UserList userList;
    private PersonList personList;
    private User user;

    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        this.caseList = caseList;
        this.userList = userList;
        this.personList = personList;
        this.user = user;
    }

    public User createAccount(String firstName, String lastName, String userName, String password, User user)
    {
        return user;
    }

    public User login(String userName, String password, User user)
    {
        return user;
    }
}
