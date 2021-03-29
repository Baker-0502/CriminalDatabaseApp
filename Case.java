import java.util.ArrayList;
import java.util.UUID;
/**
 * Case database information and details
 */
public class Case {
    private UUID caseID;
    private boolean closedCase;
    private String caseName;
    private boolean updateCase;
    private boolean federalCase;
    private boolean misdimeanor;
    private Category category;
    private ArrayList<User> userWorking;
    private ArrayList<Suspect> suspects;
    private ArrayList<Witness> witness; 
    private ArrayList<Evidence> evidenceList;
    /**
     * Case details 
     * @param caseID id of the case
     * @param closedCase checks if case is closed
     * @param caseName name of the case
     * @param updateCase updates the case
     * @param federalCase checks if case is federal case
     * @param misdimeanor checks if case is misdomeanor
     * @param category category of the case
     * @param userWorking case user is working
     * @param suspects suspects involved in case
     * @param witness witnesses in case
     * @param evidenceList case evidence
     */
    public Case(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor,
    Category category, ArrayList<User> userWorking, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList) {
        this.caseID = caseID;
        this.closedCase = closedCase;
        this.caseName = caseName;
        this.updateCase = updateCase;
        this.federalCase = federalCase;
        this.misdimeanor = misdimeanor;
        this.category = category;
        this.userWorking = userWorking;
        this.suspects = suspects;
        this.witness = witness;
        this.evidenceList = evidenceList;
    }

    /**
     * checks if case is active
     * @param closedCase if not closed then case is still active
     * @return returns if case is active or not
     */
    public boolean activeCase(boolean closedCase) {
        if(!closedCase) {
            closedCase = true;
        }
        else{
            closedCase = false;
        }
        return closedCase;

    }
    /**
     * Updates the case
     * @param updateCase if updatecase is true then the case is updated
     * @return return the updated case
     */
    public boolean updateCase(boolean updateCase) {

        if(updateCase){
            updateCase = true;

        }
        else{
            updateCase = false;
        }
        return updateCase;
    }
    /**
     * checks federal stateus of case
     * @param federalCase if federal case then return ture
     * @return return the federal case
     */
    public boolean updateFederalStatus(boolean federalCase) {
        if(federalCase){
            federalCase = true;
        }
        else{
            federalCase = false;
        }
        return federalCase;
    }
    /**
     * gets the case id
     * @return return the id
     */
    public UUID getCaseID() {
        return caseID;
    }
    /**
     * get the name of case
     * @return retunr name of case
     */
    public String getCaseName() {
        return caseName;
    }
    /**
     * updates the case
     * @return return the case updated
     */
    public boolean getUpdateCase() {
        return updateCase;
    }
    /**
     * gets the closed case
     * @return retunr the cloased case
     */
    public boolean getClosedCase() {
        return closedCase;
    }
    /**
     * gets the federal case
     * @return retunr the federal case
     */
    public boolean getFederalCase() {
        return federalCase;
    }
    /**
     * checks if case is misdomeanor
     * @return return if case of misdomeanor or not
     */
    public boolean getMisdimeanor() {
        return misdimeanor;
    }
    /**
     * get the category of the case
     * @return returns the category of case
     */
    public Category getCategory() {
        return category;
    }
    /**
     * get the list of working users on case
     * @return return list of working users
     */
    public ArrayList<User> getUserWorking() {
        return userWorking;
    }
    /**
     * lists the suspects of the case
     * @return return list of suspects
     */
    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }
    /**
     * lists of witnesses of case
     * @return return the witnesses
     */
    public ArrayList<Witness> getWitnesses() {
        return witness;
    }
    /**
     * collects the list of evidence regarding case
     * @return return list of evidence
     */
    public ArrayList<Evidence> getEvidenceList() {
        return evidenceList;
    }
    
    /**
     * tostring that outputs information
     * @return returns all the information regarding the case
     */
    public String toString() {
        return "Case ID: "+caseID+"\nActive Case: "+closedCase+"\nCase Name: "+caseName+"\nUpdate Case: "+updateCase+"\nUpdate Federal Case: "+federalCase+
        "\nMisdimeanor: "+misdimeanor+"\nCategory: "+category+"\nUser Working: "+userWorking+"\nSuspects: "+suspects+"\nWintesses: "+witness+
        "\nEvidence List: "+evidenceList+"\n";
    } 
}
