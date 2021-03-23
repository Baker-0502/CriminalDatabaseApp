import java.util.ArrayList;
import java.util.UUID;
public class Administrator extends User {
    private boolean updateCase;
    private CriminalDatabaseApplication database = CriminalDatabaseApplication.getInstance();
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase) {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }


    public void addCase(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
        database.createCase(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
    }
    public void addCriminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos){
        database.createCriminal(UUID.randomUUID(), firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType, fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos);
    }
    public void addPolice(String userID, String firstName, String lastName, String username, String password, String email, 
            String phoneNumber, String department, String badgeID, int caseCount, boolean updateCase){
        database.createPolice(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, updateCase);
    }
    public void addDetective(String associate, String department, String userID, String firstName, String lastName,
            String username, String password, String email, String phoneNumber){
        database.createDetective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
    }
  
    public void updateCase(boolean updateCase) {
        updateCase = true;
    }
    public boolean getUpdateCase() {
        return updateCase;
    }
    public String toString() {
        return super.toString() + "\nUpdate Case: " + updateCase + "\n";
    }

    
}

