import java.util.ArrayList;
import java.util.UUID;

public class EvidenceList extends Evidence{
    private ArrayList<String> evidence = new ArrayList<String>();;

    public EvidenceList(ArrayList<String> evidence)
    {
        super(UUID,String,String,UUID);
    }

    public Evidence searchID(Evidence evidenceID)
    {
        return evidenceID;
    }
}
