import java.util.UUID;

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

    public User createAdmin(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase, User user)
    {
        return new Administrator(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);
    }

    public User createPolice(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess, User user)
    {
        return new policeOfficer(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, caseCount, editAccess);
    }


    public User createDetective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, User user)
    {
        return new Detective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
    }


    public User login(String userName, String password, boolean userNameFound)
    {
        userList.findUserName(userName);
        return user;
    }
}
