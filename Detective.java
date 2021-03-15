import java.util.UUID;

public class Detective extends User{
    private String associate;
    private String department;

    public Detective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.associate = associate;
        this.department = department;
    }

    public void addWitnessStatement(String witnessStatement){

    }

    public void addAssociate(String associate){

    }

    public void addReport(String report){

    }

    public void addEvidence(String evidence){

    }

    public void updateDepartment(String department){

    }

    public String toString(){
        return department + associate;
    }
}
