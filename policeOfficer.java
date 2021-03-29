/**
 * @author Code Gods
 */
import java.util.UUID;

public class policeOfficer extends User {
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
   

    /**
     * 
     * @param userID Officer unique ID
     * @param firstName Officer first name
     * @param lastName Officer last name
     * @param username Officer username
     * @param password Officer password
     * @param email Officer email
     * @param phoneNumber Officer phone number
     * @param department Officer department
     * @param badgeID Officer badgeid
     * @param caseCount Officer casecount
     * @param editAccess Officer edit access
     */
    public policeOfficer(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess) {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.badgeID = badgeID;
        this.caseCount = caseCount;
        this.editAccess = editAccess;        
    }

    /**
     * taking in and adding a witness
     * @param witness
     */
    public void addWitness(String witness) {
       System.out.println("Adding Witness");
    }

    /**
     * taking in and adding associates
     * @param associates
     */

    public void addAssociate(String associates) {
        System.out.println("Adding Associate");
    }

    /**
     * taking in and adding suspects
     * @param suspect
     */
    public void addSuspect(String suspect) {
        System.out.println("Adding Suspect");
    }

    /**
     * taking in and adding victims
     * @param victim
     */
    public void addVictim(String victim) {
        System.out.println("Adding Victim");
    }

    /**
     * taking in and adding evidence
     */
    public void addEvidence(String evidence) {
        System.out.println("Adding Evidence");
    }

    /**
     * taking in and adding how many cases they worked on
     */
    public void addNumOfCases(int caseCount) {
        caseCount = 0;
    }

    /**
     * taking in the boolean of editing and changing who can and cant edit a case
     * @param editAccess
     */
    public void requestEdit(boolean editAccess) {
        editAccess = false;
    }

    /**
     * returning the officer badge id
     */
    public String getBadgeID() {
        return badgeID;
    }

    /**
     * returning how many cases the officer worked on
     */
    public int getCaseCount() {
        return caseCount;
    }

    /**
     * returning if someone can edit a case
     */
    public boolean getEditAccess() {
        return editAccess;
    }

    /**
     * returning the officers credentials
     */
    public String toString() {
        return super.toString()+"\nBadge ID: "+badgeID+"\nCase Count: "+caseCount+"\nEdit Access: "+editAccess+"\n";
    }
   
}