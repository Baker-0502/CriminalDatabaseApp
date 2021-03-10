import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList extends Evidence{
    private ArrayList<String> evidence;

    public EvidenceList(ArrayList<String> evidence)
    {
        super(UUID,String,String,UUID);
        evidence = new ArrayList<String>();
    }

    public Evidence searchID(Evidence evidenceID)
    {
        return evidenceID;
    }
}
