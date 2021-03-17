import java.util.UUID;

public class Evidence {
    private UUID evidenceID;
    private String evidenceType;
    private String locationFound;
    private UUID relationToPersonID;

    public Evidence(UUID evidenceID, String evidenceType, String locationFound, UUID relationToPersonID)
    {
        this.evidenceID = evidenceID;
        this.evidenceType = evidenceType;
        this.locationFound = locationFound;
        this.relationToPersonID = relationToPersonID;
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

    public UUID getRelationToPerson()
    {
        return relationToPersonID;
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
