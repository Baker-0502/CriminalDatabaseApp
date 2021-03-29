import java.util.UUID;
/**
 * information and details about the witness in the database
 */
public class Witness extends Person {
    private String relationship;
    private String statement;


/**
 * default constructor for a witness
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