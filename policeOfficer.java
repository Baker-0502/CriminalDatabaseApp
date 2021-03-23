import java.util.UUID;

public class policeOfficer extends User {
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
   

    public policeOfficer(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess) {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.badgeID = badgeID;
        this.caseCount = caseCount;
        this.editAccess = editAccess;        
    }

    public void addWitness(String witness) {
       System.out.println("Adding Witness");
    }
    public void addAssociate(String associates) {
        System.out.println("Adding Associate");
    }
    public void addSuspect(String suspect) {
        System.out.println("Adding Suspect");
    }
    public void addVictim(String victim) {
        System.out.println("Adding Victim");
    }
    public void addEvidence(String evidence) {
        System.out.println("Adding Evidence");
    }
    public void addNumOfCases(int caseCount) {
        caseCount = 0;
    }
    public void requestEdit(boolean editAccess) {
        editAccess = false;
    }
    public String getBadgeID() {
        return badgeID;
    }
    public int getCaseCount() {
        return caseCount;
    }
    public boolean getEditAccess() {
        return editAccess;
    }
    public String toString() {
        return super.toString()+"\nBadge ID: "+badgeID+"\nCase Count: "+caseCount+"\nEdit Access: "+editAccess+"\n";
    }
   
}