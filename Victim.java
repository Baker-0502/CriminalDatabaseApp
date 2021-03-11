public class Victim {
    private String relationship;
    private String statement;

public Victim(String relationship, String statement)
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