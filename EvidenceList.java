import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList {
    private ArrayList<String> evidence = new ArrayList<String>();;

    public EvidenceList(ArrayList<String> evidence)
    {
        this.evidence = evidence;
    }

    public Evidence searchID(Evidence evidenceID)
    {
        return evidenceID;
    }
}
