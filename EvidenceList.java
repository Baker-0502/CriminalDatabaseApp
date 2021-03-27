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

    public Evidence findEvidence(UUID evidenceID) {
        for(Evidence evidence: evidenceList) {
            if(evidenceID.equals(evidence.getEvidenceID())) {
                return evidence;
            }
        }
        return evidence;
    }
}
