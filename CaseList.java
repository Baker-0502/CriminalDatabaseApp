import java.util.ArrayList;
import java.util.UUID;

/**
 * An Object representing a List of Cases.
 * @author Code Gods
 */
public class CaseList {
    private ArrayList<Case> caseList;
    private static CaseList caseListObj=null;
    private ArrayList<Witness> witnesses = new ArrayList<Witness>();
    private ArrayList<Criminal> criminals = new ArrayList<Criminal>();
    private ArrayList<Victim> victims = new ArrayList<Victim>();
    private ArrayList<Suspect> suspects = new ArrayList<Suspect>();
    private ArrayList<PersonOfInterest> pois = new ArrayList<PersonOfInterest>();
    private ArrayList<Evidence> evidences = new ArrayList<Evidence>();

    /**
     * Default Constructor. Utilizes DataReader to initialize cases from JSON.
     */
    public CaseList() {
        this.caseList = DataReader.loadCase();
    }

    /**
     * Returns the current instance of CaseList.
     * @return The current instance of CaseList.
     */
    public static CaseList getInstance() {
        if(caseListObj == null) {
            caseListObj = new CaseList();
        }

        return caseListObj;
    }

    /**
     * Returns all cases currently in the application.
     * @return All Cases in the application.
     */
    public ArrayList<Case> getCases() {
        return caseList;
    }

    /**
     * Adds a case to the Case List.
     * @param newCase The Case to be added.
     */
    public void addCase(Case newCase) {
        if(newCase!=null) {
            caseList.add(newCase);
        }
    }

    /**
     * Adds a Witness to the Case List
     * @param newWitness The witness to be added.
     */
    public void addWitness(Witness newWitness) {
        if(newWitness!=null) {
            witnesses.add(newWitness);
        }
    }

    /**
     * Adds a Criminal to the Case List.
     * @param newCriminal The Criminal to be added.
     */
    public void addCriminal(Criminal newCriminal) {
        if(newCriminal!=null) {
            criminals.add(newCriminal);
        }
    }

    /**
     * Adds a Victim to the Case List.
     * @param newVictim The Victim to be added.
     */
    public void addVictim(Victim newVictim) {
        if(newVictim!=null) {
            victims.add(newVictim);
        }
    }

    /**
     * Adds a Suspect to the Case List.
     * @param newSuspect The Suspect to be added.
     */
    public void addSuspect(Suspect newSuspect) {
        if(newSuspect!=null) {
            suspects.add(newSuspect);
        }
    }

    /**
     * Adds a Person of Interest to the Case List.
     * @param newPOI The Person of Interest to be added.
     */
    public void addPOI(PersonOfInterest newPOI) {
        if(newPOI!=null) {
            pois.add(newPOI);
        }
    }

    /**
     * Adds a piece of Evidence to the Case List.
     * @param evidence The Evidence to be added.
     */
    public void addEvidence(Evidence evidence){
        if(evidence!=null){
            evidences.add(evidence);
        }
    }

    /**
     * Finds a Case stored in the case list.
     * @param id The ID of the Case being searched up.
     * @return The Case that was found. Returns null if none were found.
     */
    public Case findCase(UUID id){
        for(int i=0;i<caseList.size();i++){
            if(caseList.get(i).getCaseID().equals(id)){
                return caseList.get(i);
            }
        }
        return null;
    } 

    /**
     * Prints out to the console the case list in a human readable format.
     */
    public void print(){
        for(int i=0;i<caseList.size();i++){
            System.out.println(caseList.get(i).toString());
        }
    }
}
