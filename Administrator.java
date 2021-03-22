import java.util.ArrayList;
import java.util.UUID;
public class Administrator extends User{
    private boolean updateCase;
    private UUID userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String department;
    private String badgeID;
    private String associate;
    private static Administrator admin;
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.badgeID = badgeID;
        this.associate = associate;
    }

    

    public static Administrator getInstance(){
        admin = new Administrator();
        return admin;
    }

    public void addCase(String caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
        CriminalDatabaseApplication.createCase(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
    }
    public void addCriminal(String criminalName){
       criminalName = "name";
    }
    public void addPolice(String userID, String firstName, String lastName, String username, String password, String email, 
            String phoneNumber, String department, String badgeID, int caseCount, boolean updateCase){
        CriminalDatabaseApplication.createPolice(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, updateCase);
    }
    public void addDetective(String associate, String department, String userID, String firstName, String lastName,
            String username, String password, String email, String phoneNumber){
        CriminalDatabaseApplication.createDetective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
    }
  
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public boolean getUpdateCase() {
        return updateCase;
    }
    public String toString(){
        return super.toString()+"\nUpdate Case: "+updateCase+"\n";
    }

    
}

