public class Victim extends Person{
    private String relationship;
    private String statement;

public Victim(String firstName, String lastName, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement)
{
    super(firstName, lastName, age, height, weight, phoneNumber, address, occupation);
    this.relationship = relationship;
    this.statement = statement;
}

public String getRelationship() {
    return relationship;
}

public String getStatement() {
    return statement;
}

}