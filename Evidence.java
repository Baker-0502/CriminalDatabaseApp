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

    public String toString()
    {
        return evidenceType+locationFound+relationToPersonID;
    }

    public void createFile()
    {

    }

    public void readFile(String filepath)
    {
        filepath = "File";
    }
}
