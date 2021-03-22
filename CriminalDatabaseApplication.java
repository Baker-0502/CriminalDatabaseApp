import java.util.ArrayList;
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

    public void createAdmin(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase)
    {
        Administrator admin = new Administrator(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);
        userList.addAdmin(admin);
    }

    public void createPolice(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess)
    {
        policeOfficer policeofficer = new policeOfficer(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, caseCount, editAccess);
        userList.addPolice(policeofficer);
    }

    public void createCase(String caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
        Case case =  new Case(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
        caseList.addCase(case);
    }

    //public void createWitness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
     //   Witness witness = new Witness(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
     //   caseList.addWitness(witness);
    //}


    public void createDetective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber)
    {
       Detective detective = new Detective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
       userList.addDetective(detective);
    }


    public User login(String userName, String password, boolean userNameFound)
    {
        userList.findUserName(userName);
        return user;
    }

}