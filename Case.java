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
    private ArrayList<Integer> userWorking;
    private ArrayList<Integer> suspects;
    private ArrayList<Integer> witness;
    private ArrayList<Integer> evidenceList;

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

    public void activeCase(boolean closedCase)
    {
        closedCase = false;
    }

    public boolean updateCase(boolean updateCase)
    {
        return updateCase;
    }

    public void updateFederalStatus(boolean federalCase)
    {
        federalCase = true;
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
