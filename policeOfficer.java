import java.util.UUID;

public class policeOfficer extends User{
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
   

    public policeOfficer(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess)
    {
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.badgeID = badgeID;
        this.caseCount = caseCount;
        this.editAccess = editAccess;        
    }

    public void addWitness(String witness)
    {
       System.out.println("adding witness");
    }

    public void addAssociate(String associates)
    {
        System.out.println("adding associate");
    }
    public void addSuspect(String suspect)
    {
        System.out.println("adding suspect");
    }
    public void addVictim(String victim)
    {
        System.out.println("adding victim");
    }
    public void addEvidence(String evidence)
    {
        System.out.println("adding evidence");
    }
    public void addNumOfCases(int caseCount)
    {
        caseCount = 0;
    }
    public void requestEdit(boolean editAccess)
    {
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
    public String toString(){
        return badgeID + caseCount + editAccess + getFirstName() + getLastName();
    }
   
}