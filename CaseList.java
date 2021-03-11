import java.util.ArrayList;
import java.util.UUID;

public class CaseList {
    private ArrayList<Case> caseList;

    public CaseList(ArrayList<String> caseList){
        caseList = new ArrayList<String>();
    }

    public Case searchID(Case caseID){
        return caseID;
    }

    public Case searchByKeyword(String keyword){
        return caseList.get(0);
    }
}
