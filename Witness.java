import java.util.UUID;
/**
 * information and details about the witness in the database
 */
public class Witness extends Person {
    private String relationship;
    private String statement;
    /**
     * details about the witness
     * @param personID id placed for specific witness
     * @param firstName witness firstname
     * @param lastName witness lastname
     * @param gender gender of the witness
     * @param race witness race
     * @param age age of the witness
     * @param height witness height
     * @param weight weight of the witness
     * @param phoneNumber phone number of the witness
     * @param address witness address
     * @param occupation occupation of witness if avaliable
     * @param relationship relationship of witness to case
     * @param statement witness statement
     */
    public Witness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement)
    {
        super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
        this.relationship = relationship;
        this.statement = statement;
    }
    /**
     * relation of the witness to case
     * @return return that relationship
     */
    public String getRelationship() {
        return relationship;
    }
    /**
     * gets the statement of the witness
     * @return returns the statement of the witness
     */
    public String getStatement() {
        return statement;
    }
    /**
     * tostring outputs details of the witness
     * @return outputs the relationship of witness to case and the statment made by the witness
     */
    public String toString() { 
        return super.toString() + "\nRelationship: "+relationship+"\nStatement: "+statement+"\n";
    }

}