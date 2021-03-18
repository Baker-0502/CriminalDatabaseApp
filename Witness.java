public class Witness extends Person{
    private String relationship;
    private String statement;

public Witness(String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement)
{
    super(firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
    this.relationship = relationship;
    this.statement = statement;
}

public String getRelationship() {
    return relationship;
}

public String getStatement() {
    return statement;
}

public String toString(){
    return super.toString() + "\nRelationship: "+relationship+"\nStatement: "+statement+"\n";
}

}