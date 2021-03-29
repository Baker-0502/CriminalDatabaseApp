import java.util.UUID;
/**
 * allows access to changes and information about detective
 */
public class Detective extends User {
    private String associate;

    /**
     * 
     * @param associate detective associates    
     * @param department detective departments
     * @param userID detective unique user ids
     * @param firstName detective first names
     * @param lastName detective last names
     * @param username detective user names
     * @param password detective passwords
     * @param email detective email
     * @param phoneNumber detective phone number
     */
    public Detective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber) {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.associate = associate;
    }
    /**
     * provides a witness statement through the detective
     * @param witnessStatement outputs the statement of the witness
     */
    public void addWitnessStatement(String witnessStatement) {
        System.out.println("Witness Statement: " + witnessStatement + " added.");
    }
    /**
     * prints out the associate 
     * @param associate prints out the associates that are added
     */
    public void addAssociate(String associate) {
        System.out.println("Associate: " + associate + " added.");
    }
    /**
     * method will output the report
     * @param the report is stored and printed out
     */
    public void addReport(String report) {
        System.out.println("Report: " + report + " added.");
    }
    /**
     * allows evidence ot be added
     * @param evidence evidence stored and printed out
     */
    public void addEvidence(String evidence) {
        System.out.println("Evidence: " + evidence + " added.");
    }
    /**
     * will provide associate 
     * @return returns the associates provided
     */
    public String getAssociate() {
        return associate;
    }
    /**
     * to string that prints ut the associate in a super
     */
    public String toString() {
        return super.toString()+"\nAssociate: "+ associate + "\n";
    }
}
