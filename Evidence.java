import java.util.UUID;
/**
 * provides information regarding the evidence in the database
 */
public class Evidence {
    private UUID evidenceID;
    private String evidenceType;
    private String locationFound;
    /**
     * the different types of information stored in evidence
     * @param evidenceID id label to that evidence
     * @param evidenceType the type of provided evidence
     * @param locationFound the location found of the evidence provided
     */
    public Evidence(UUID evidenceID, String evidenceType, String locationFound) {
        this.evidenceID = evidenceID;
        this.evidenceType = evidenceType;
        this.locationFound = locationFound;
    }
    /**
     * get the UUID
     * @return return the UUID through the UUID
     */
    public UUID getUUID() {
        return evidenceID;
    }
    /**
     * gets the type of evidence found/provided
     * @return return that type/category of evidence
     */
    public String getEvidenceType() {
        return evidenceType;
    }
    /**
     * finds location of where the evidence was found
     * @return return that location of the evidence
     */
    public String getLocationFound() {
        return locationFound;
    }
    /**
     * the id of the evidence
     * @return return that id for the evidence
     */
    public UUID getEvidenceID() {
        return evidenceID;
    }
    /**
     * to string to output the evidence details
     * @return outputs the evidence type and the location of where the evidence was found
     */
    public String toString() {
        return "Evidence Type: "+evidenceType+"\nLocation Found: "+locationFound;
    }
}
