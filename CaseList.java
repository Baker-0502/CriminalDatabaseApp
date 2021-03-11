import java.util.ArrayList;

<<<<<<< HEAD
public class CaseList{
=======
public class CaseList {
>>>>>>> a1fe1f93ae42157f87f2bb18c2e47f21fb9f8ea2
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
