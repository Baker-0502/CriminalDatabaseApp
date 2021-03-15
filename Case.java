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
    private ArrayList<EvidenceList> evidenceList;

    public Case(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor,
    Category category, ArrayList<Integer> userWorking, ArrayList<Integer> suspects, ArrayList<Integer> witness, ArrayList<Integer> evidenceList)
    {
        this.caseID = caseID;
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
        if(closedCase){
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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public void createFile()
    {

    }

    public void readFile(String filepath)
    {
        filepath = "File";
    }
}
