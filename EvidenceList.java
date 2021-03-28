import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList {
    private ArrayList<Evidence> evidenceList;
    private static EvidenceList evidenceListObj;
    Evidence evidence;

    public EvidenceList(ArrayList<Evidence> evidence) {
        evidence = new ArrayList<Evidence>();
    }

    public EvidenceList() {
        this.evidenceList = DataReader.loadEvidence();
    }

    public static EvidenceList getInstance() {
        if(evidenceListObj == null) {
            evidenceListObj = new EvidenceList();
        }

        return evidenceListObj;
    }

    public ArrayList<Evidence> getEvidence() {
        return evidenceList;
    }

    public void addEvidence(Evidence evidence){
        evidenceList.add(evidence);
    }

    public Evidence findEvidence(UUID id) {
        for(int i=0; i<evidenceList.size(); i++){
            if(evidenceList.get(i).getEvidenceID().equals(id)){
                return evidenceList.get(i);
            }
        }
        return null;
    }

    public void print(){
        for(int i=0;i<evidenceList.size();i++){
            System.out.println(evidenceList.get(i).toString());
        }
    }
}
