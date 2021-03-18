import java.util.UUID;

public class Evidence {
    private UUID evidenceID;
    private String evidenceType;
    private String locationFound;
    private UUID relationToPersonID;

    public Evidence(UUID evidenceID, String evidenceType, String locationFound)
    {
        this.evidenceID = evidenceID;
        this.evidenceType = evidenceType;
        this.locationFound = locationFound;
    }

    public UUID getUUID() {
        return evidenceID;
    }
    public String getEvidenceType()
    {
        return evidenceType;
    }

    public String getLocationFound()
    {
        return locationFound;
    }

    public UUID getEvidenceID()
    {
        return evidenceID;
    }

    public String toString()
    {
        return "Evidence Type: "+evidenceType+"\nLocation Found: "+locationFound+"\nRelation to Person: "+relationToPersonID;
    }

    public void createFile()
    {

    }

    public void readFile(String filepath)
    {
        filepath = "File";
    }
}
