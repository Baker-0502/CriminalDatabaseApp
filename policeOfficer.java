public class policeOfficer{
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
    private String witness;
    private String associates;
    

    public policeOfficer(String badgeID, int caseCount, boolean editAccess, String witness, String associates)
    {
        this.badgeID = badgeID;
        this.caseCount = caseCount;
        this.editAccess = editAccess;
        
    }

    public void addWitness(String witness)
    {
       
    }

    public void addAssociate(String associates)
    {
        
    }
    public void addSuspect(String suspect)
    {
        
    }
    public void addVictim(String victim)
    {
        
    }
    public void addEvidence(String evidence)
    {
        
    }
    public void addNumOfCases(int caseCount)
    {
        caseCount = 0;
    }
    public void requestEdit(boolean editAccess)
    {
        editAccess = false;
    }
   
}