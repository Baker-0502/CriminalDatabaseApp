import java.util.ArrayList;

public class CaseList {
    private ArrayList<Case> caseList;
    private static CaseList caseListObj=null;
    private ArrayList<Witness> witnesses = new ArrayList<Witness>();
    private ArrayList<Criminal> criminals = new ArrayList<Criminal>();
    private ArrayList<Victim> victims = new ArrayList<Victim>();
    private ArrayList<Suspect> suspects = new ArrayList<Suspect>();
    private ArrayList<PersonOfInterest> pois = new ArrayList<PersonOfInterest>();
    private ArrayList<Evidence> evidences = new ArrayList<Evidence>();

    public CaseList(ArrayList<Case> caseList){
        caseList = new ArrayList<Case>();
    }
    public CaseList() {
        this.caseList = DataReader.loadCase();
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

    public Case searchID(Case caseID) {
        return caseID;
    }

    public Case searchByKeyword(String keyword) {
        return caseList.get(0);
    }

    public void addCase(Case newCase) {
        if(newCase!=null) {
            caseList.add(newCase);
        }
    }

    public void addWitness(Witness newWitness) {
        if(newWitness!=null) {
            witnesses.add(newWitness);
        }
    }

    public void addCriminal(Criminal newCriminal) {
        if(newCriminal!=null) {
            criminals.add(newCriminal);
        }
    }

    public void addVictim(Victim newVictim) {
        if(newVictim!=null) {
            victims.add(newVictim);
        }
    }

    public void addSuspect(Suspect newSuspect) {
        if(newSuspect!=null) {
            suspects.add(newSuspect);
        }
    }

    public void addPOI(PersonOfInterest newPOI) {
        if(newPOI!=null) {
            pois.add(newPOI);
        }
    }

    public void addEvidence(Evidence evidence){
        if(evidence!=null){
            evidences.add(evidence);
        }
    }
}
