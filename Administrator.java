import java.util.ArrayList;
import java.util.UUID;
/**
 * Administrator class allows access add information to the database
 */
public class Administrator extends User {
    private boolean updateCase;
    private CriminalDatabaseApplication database = CriminalDatabaseApplication.getInstance();
    /**
     * Admin login details and information
     * @param userID id of admin
     * @param firstName admin firstname
     * @param lastName admin last name
     * @param username username of admin to login
     * @param password admin password to log in
     * @param email email of admin
     * @param phoneNumber phone number of the admin
     * @param department admin department
     * @param updateCase allows admin to update case
     */
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase) {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }
    /**
     * Give administrator the ability to add Cases into the database
     * @param caseID ID of the case
     * @param closedCase checks if case is closed
     * @param caseName name of the case
     * @param updateCase updates the case
     * @param federalCase checks if federal case
     * @param misdimeanor checks if case is misdomeanor
     * @param category puts case in category
     * @param userWorking checks if user is working
     * @param criminals lists criminals
     * @param suspects lists suspects
     * @param witness lists witnesses
     * @param evidenceList lists the evidence
     */

    public void addCase(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Criminal> criminals, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
        database.createCase(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, criminals, suspects, witness, evidenceList);
    }

    /**
     * Gives administrator access to add criminals to database
     * @param personID id of criminal
     * @param firstName criminal first name
     * @param lastName criminal last name
     * @param gender gender of criminal
     * @param race race of criminal
     * @param age age of criminal
     * @param height height of criminal
     * @param weight criminal weight
     * @param phoneNumber phone number of criminal
     * @param address address of the criminal
     * @param occupation occupation of the criminal
     * @param bloodType crimina blood type
     * @param fingerprint finger print of criminal
     * @param hairColor criminal hair color
     * @param clothing any clothing provided of criminal
     * @param footSize measured foot size of criminal
     * @param eyeColor criminal eye color
     * @param isAlive checks if criminal is alive
     * @param tattoos criminal tatoos
     */

    public void addCriminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos){
        database.createCriminal(UUID.randomUUID(), firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType, fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos);
    }
    /**
     * Adimin access to add police to database
     * @param userID id of police 
     * @param firstName police first name
     * @param lastName police last name
     * @param username user of police
     * @param password police password
     * @param email police email
     * @param phoneNumber phonenumber of police
     * @param department police department
     * @param badgeID police badge id
     * @param caseCount police case count
     * @param updateCase allows case to be updated
     */
    public void addPolice(String userID, String firstName, String lastName, String username, String password, String email, 
            String phoneNumber, String department, String badgeID, int caseCount, boolean updateCase){
        database.createPolice(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, updateCase);
    }
    /**
     * Admin can add detective
     * @param associate lists associate 
     * @param department detective department
     * @param userID detective id 
     * @param firstName firstname of detective
     * @param lastName lastname of detective
     * @param username detective username
     * @param password detective password
     * @param email detective email
     * @param phoneNumber phone number of detective
     */
    public void addDetective(String associate, String department, String userID, String firstName, String lastName,
            String username, String password, String email, String phoneNumber){
        database.createDetective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
    }
    /**
     * Allows admin to update the case
     * @param updateCase set to true so admin can updatecase
     */
    public void updateCase(boolean updateCase) {
        updateCase = true;
    }
    /**
     * allows admin to get the updated case
     * @return return the updated case
     */
    public boolean getUpdateCase() {
        return updateCase;
    }
    /**
     * to string to list out the updated case
     */
    public String toString() {
        return super.toString() + "\nUpdate Case: " + updateCase + "\n";
    }

    
}

