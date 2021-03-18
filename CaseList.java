import java.util.ArrayList;

public class CaseList {
    private ArrayList<Case> caseList;
    private static CaseList caseListObj;

    public CaseList(ArrayList<String> caseList){
        caseList = new ArrayList<String>();
    }
    public CaseList() {
        //Depending on implementation of reader and database, we may eventually not need a parametrized constructor.
    }

    public static CaseList getInstance() {
        if(caseListObj == null) {
            caseListObj = new CaseList();
        }

        return caseListObj;
    }

    public ArrayList<Case> getCases() {
        return caseList;
    }

    public Case searchID(Case caseID){
        return caseID;
    }

    public Case searchByKeyword(String keyword){
        return caseList.get(0);
    }
}
