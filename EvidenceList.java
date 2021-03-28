import java.util.ArrayList;
import java.util.UUID;
/**
 * The list for all evidence that is stored into database
 */
public class EvidenceList {
    private ArrayList<Evidence> evidenceList;
    private static EvidenceList evidenceListObj;
    Evidence evidence;
    /**
     * evidence list is stored in arraylist
     * @param evidence holds all the evidence
     */
    public EvidenceList(ArrayList<Evidence> evidence) {
        evidence = new ArrayList<Evidence>();
    }
    /**
     * evidence list is read in datareader and evidence is loaded
     */
    public EvidenceList() {
        this.evidenceList = DataReader.loadEvidence();
    }
    /**
     * gets the instance of the eveidence list 
     * @return returns the list of objects in the evidence list
     */
    public static EvidenceList getInstance() {
        if(evidenceListObj == null) {
            evidenceListObj = new EvidenceList();
        }

        return evidenceListObj;
    }
    /**
     * gets the evdence that is stored in an array list
     * @return returns the evidence list
     */
    public ArrayList<Evidence> getEvidence() {
        return evidenceList;
    }
    /**
     * can add evidence to the edvidence list
     * @param evidence the evidences that is added
     */
    public void addEvidence(Evidence evidence){
        evidenceList.add(evidence);
    }
    /**
     * allows user to go through evidence to find evidence
     * @return returns null if there is no evidence after running through loop
     */
    public Evidence findEvidence(UUID id) {
        for(int i=0; i<evidenceList.size(); i++){
            if(evidenceList.get(i).getEvidenceID().equals(id)){
                return evidenceList.get(i);
            }
        }
        return null;
    }
    /**
     * prints out all the edvidence in the evidence list
     */
    public void print(){
        for(int i=0;i<evidenceList.size();i++){
            System.out.println(evidenceList.get(i).toString());
        }
    }
}
