import java.util.UUID;

public class Victim extends Person{
    private String relationship;
    private String statement;


/**
 * efault constructor for a victim
 */
public Victim(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement)
{
    super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
    this.relationship = relationship;
    this.statement = statement;
}

/**
 * returning victim relationship to criminal
 */
public String getRelationship() {
    return relationship;
}

/**
 * 
 * @param relationship taking in the relationship to the criminal
 * setting relationship equal to parameter
 */
public void setRelationship(String relationship)
{
    this.relationship = relationship;
}

/**
 * getting victim statment on crime
 */
public String getStatement() {
    return statement;
}

/**
 * taking in a statement and setting it equal to the taken in statement
 */
public void setStatement(String statement)
{
    this.statement = statement;
}

/**
 * printing out relationship and statement
 */
public String toString(){
    return super.toString() + "\nRelationship: "+relationship+"\nStatement: "+statement+"\n";
}
}