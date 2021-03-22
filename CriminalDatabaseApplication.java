import java.util.UUID;

public class CriminalDatabaseApplication {
    private static CaseList caseList;
    private static UserList userList;
    private static PersonList personList;
    private static User user;
    private static CriminalDatabaseApplication criminalDatabaseApplication;
    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        CriminalDatabaseApplication.caseList = caseList;
        CriminalDatabaseApplication.userList = userList;
        CriminalDatabaseApplication.personList = personList;
        CriminalDatabaseApplication.user = user;
    }

    //Please Implement! Thank you!
    public static CriminalDatabaseApplication getInstance() {
        if (criminalDatabaseApplication == null){
            System.out.println("Creating a Criminal Database Application");
            criminalDatabaseApplication = new CriminalDatabaseApplication(caseList, userList, personList, user);
        }
        return criminalDatabaseApplication;
    }

    public User createAdmin(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase, User user)
    {
        return new Administrator(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);
    }

    public User createPolice(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess)
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
