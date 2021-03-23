import java.util.ArrayList;
import java.util.UUID;

public class Case {
    private UUID caseID;
    private boolean closedCase;
    private String caseName;
    private boolean updateCase;
    private boolean federalCase;
    private boolean misdimeanor;
    private Category category;
    private ArrayList<User> userWorking;
    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witness;
    private ArrayList<Evidence> evidenceList;

    public Case(UUID caseID2, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor,
    Category category, ArrayList<User> userWorking, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList)
    {
        this.caseID = caseID2;
        this.closedCase = closedCase;
        this.caseName = caseName;
        this.updateCase = updateCase;
        this.federalCase = federalCase;
        this.misdimeanor = misdimeanor;
        this.category = category;
        this.userWorking = userWorking;
        this.suspects = suspects;
        this.witness = witness;
        this.evidenceList = evidenceList;
    }

    public boolean activeCase(boolean closedCase)
    {
        if(!closedCase){
            closedCase = true;
        }
        else{
            closedCase = false;
        }
        return closedCase;

    }

    public boolean updateCase(boolean updateCase)
    {

        if(updateCase){
            updateCase = true;

        }
        else{
            updateCase = false;
        }
        return updateCase;
    }

    public boolean updateFederalStatus(boolean federalCase)
    {
        if(federalCase){
            federalCase = true;
        }
        else{
            federalCase = false;
        }
        return federalCase;
    }

    public UUID getCaseID()
    {
        return caseID;
    }

    public String getCaseName()
    {
        return caseName;
    }

    public boolean getUpdateCase()
    {
        return updateCase;
    }

    public boolean getClosedCase()
    {
        return closedCase;
    }

    public boolean getFederalCase()
    {
        return federalCase;
    }

    public boolean getMisdimeanor()
    {
        return misdimeanor;
    }

    public Category getCategory()
    {
        return category;
    }

    public ArrayList<User> getUserWorking() {
        return userWorking;
    }

    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }

    public ArrayList<Witness> getWitnesses() {
        return witness;
    }

    public ArrayList<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void createFile()
    {

    }

    public void readFile(String filepath)
    {
        filepath = "File";
    }

    public String toString(){
        return "Case ID: "+caseID+"\nActive Case: "+closedCase+"\nCase Name: "+caseName+"\nUpdate Case: "+updateCase+"\nUpdate Federal Case: "+federalCase+
        "\nMisdimeanor: "+misdimeanor+"\nCategory: "+category+"\nUser Working: "+userWorking+"\nSuspects: "+suspects+"\nWintesses: "+witness+
        "\nEvidence List: "+evidenceList+"\n";
    } 
}
