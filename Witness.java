public class Witness {
    private String relationship;
    private String statement;

public Witness(String relationship, String statement)
{
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