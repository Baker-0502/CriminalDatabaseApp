import java.util.ArrayList;
import java.util.UUID;

public class CaseList extends Case {
    private ArrayList<String> caseList;

    public CaseList(ArrayList<String> caseList){
        super(UUID, boolean, String, boolean, boolean, boolean, Category, ArrayList, ArrayList, ArrayList, ArrayList)
        caseList = new ArrayList<String>();
    }

    public Case searchID(Case caseID){
        return caseID;
    }

    public Case searchByKeyword(String keyword){
        return caseID;
    }
}
