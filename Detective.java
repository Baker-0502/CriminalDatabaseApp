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
        System.out.println("Witness Statement: " + witnessStatement + " added.");
    }

    public void addAssociate(String associate){
        System.out.println("Associate: " + associate + " added.");
    }

    public void addReport(String report){
        System.out.println("Report: " + report + " added.");
    }

    public void addEvidence(String evidence){
        System.out.println("Evidence: " + evidence + " added.");
    }

    public void updateDepartment(String department){

    }

    public String toString(){
        return department + associate;
    }
}
