import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList {
    private ArrayList<String> evidence;

    public EvidenceList(ArrayList<String> evidence)
    {
        evidence = new ArrayList<String>();
    }

    public Evidence searchID(UUID evidenceID)
    {
        return evidenceID;
    }
}
