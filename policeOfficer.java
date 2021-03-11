public class policeOfficer{
    private String badgeID;
    private int caseCount;
    private boolean editAccess;
   

    public policeOfficer(String badgeID, int caseCount, boolean editAccess)
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
    public String toString(){
        return badgeID + caseCount + witness + associates + editAccess;
    }
   
}