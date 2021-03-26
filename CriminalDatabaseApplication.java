import java.util.ArrayList;
import java.util.UUID;

public class CriminalDatabaseApplication {
    private static CaseList caseList;
    private static UserList userList = UserList.getInstance();
    private static PersonList personList;
    private static User user;
    private static CriminalDatabaseApplication criminalDatabaseApplication;
    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        CriminalDatabaseApplication.caseList = caseList;//CaseList.getInstance();
        CriminalDatabaseApplication.userList = userList;//UserList.getInstance();
        CriminalDatabaseApplication.personList = personList;//PersonList.getInstance();
        CriminalDatabaseApplication.user = user;
    }
    //Please Implement! Thank you!
    public static CriminalDatabaseApplication getInstance() {
        if (criminalDatabaseApplication == null){
            System.out.println("Creating a Criminal Database Application");
            criminalDatabaseApplication = new CriminalDatabaseApplication(caseList, userList, personList, user);//CaseList.getInstance(), UserList.getInstance(), PersonList.getInstance(), null);
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

    public void createDetective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber)
    {
       Detective detective = new Detective(associate, department, userID, firstName, lastName, username, password, email, phoneNumber);
       userList.addDetective(detective);
    }

    public void createCase(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Criminal> criminals, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
            Case case1 =  new Case(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
            caseList.addCase(case1);
    }

    public void createCriminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, 
    String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos){
        Criminal criminal = new Criminal(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType,
        fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos);
        caseList.addCriminal(criminal);
    }

    public void createWitness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Witness witness = new Witness(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addWitness(witness);
    }

    public void createVictim(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Victim victim = new Victim(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addVictim(victim);
    }

    public void createSuspect(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, 
    String eyeColor, String footSize, String bloodType, String fingerPrint, String details, ArrayList<String> clothing){
        Suspect suspect = new Suspect(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, footSize, bloodType, fingerPrint, details, clothing);
        caseList.addSuspect(suspect);
    }

    public void createPOI(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor,
    String eyeColor, String reasonofInterest, String avaliableDetails){
        PersonOfInterest poi = new PersonOfInterest(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, reasonofInterest, avaliableDetails);
        caseList.addPOI(poi);
    }

    public void createEvidence(UUID evidenceID, String evidenceType, String locationFound){
        Evidence evidence = new Evidence(evidenceID, evidenceType, locationFound);
        caseList.addEvidence(evidence);
    }


    public User login(String userName, String password)
    {
        if(userList.findUserName(userName)!=null){
        User desiredUser = userList.findUserName(userName);
        //System.out.println(desiredUser);//Colin is a dumb fool who needs to learn how to read
        if(userName.equals(desiredUser.getUserName())){
            if(password.equals(desiredUser.getPassword())){
                //TODO fix dis bug kid
                System.out.println("Logging in as "+desiredUser.getFirstName()+" "+desiredUser.getLastName());
                return desiredUser;
            }
        }
    }
    System.out.println("Username/Password was incorrect");
    return null;
}
}
