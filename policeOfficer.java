import java.util.UUID;

public class policeOfficer extends User{
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
   

    public policeOfficer(String badgeID, int caseCount, boolean editAccess)
    {
        super(UUID, String, String, String, String, String, String, String);
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
    public String toString(){
        return badgeID + caseCount + editAccess + getFirstName() + getLastName();
    }
   
}