import java.util.UUID;
/**
 * information and details about the witness in the database
 */
public class Witness extends Person {
    private String relationship;
    private String statement;


/**
 * 
 * @param personID witness unique ID
 * @param firstName witness first name
 * @param lastName witness last name
 * @param gender witness gender
 * @param race witness race
 * @param age witness age
 * @param height witness height
 * @param weight witness weight 
 * @param phoneNumber witness phone number
 * @param address witness address
 * @param occupation witness occupation
 * @param relationship witness relationship
 * @param statement witness statement
 */
public Witness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement)
{
    super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
    this.relationship = relationship;
    this.statement = statement;
}

/**
 * returning the relation of the witness to the criminal
 */
public String getRelationship() {
    return relationship;
}

/**
 * returns the witness statment
 */
public String getStatement() {
    return statement;
}

/**
 * prints out the relationship and statement
 */
public String toString() { 
    return super.toString() + "\nRelationship: "+relationship+"\nStatement: "+statement+"\n";
}

}