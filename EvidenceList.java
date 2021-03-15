import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList {
    private ArrayList<Evidence> evidenceList;
    Evidence evidence;

    public EvidenceList(ArrayList<Evidence> evidence)
    {
        evidence = new ArrayList<Evidence>();
    }

    public Evidence searchID(UUID evidenceID)
    {
        for(Evidence evidence: evidenceList)
        {
            if(evidenceID.equals(evidence.getEvidenceID()))
            {
                return evidence;
            }
        }
        return evidence;
    }
}
