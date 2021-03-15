import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class EvidenceList {
    private ArrayList<Evidence> evidenceList;
    static Scanner sc = new Scanner(System.in);

    public EvidenceList(ArrayList<String> evidence)
    {
        evidence = new ArrayList<String>();
    }

    public Evidence searchID(UUID evidenceID, Evidence evidence)
    {
        for(evidence : evidenceList)
        {
            if(evidenceID.equals(evidence.getEvidenceID()))
            {
                return evidence;
            }
        }
        return evidence;
    }
}
