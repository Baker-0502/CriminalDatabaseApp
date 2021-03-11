import java.util.UUID;
public class Administrator extends User{
    private boolean updateCase;
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }

    public void addCase(String caseName){
        System.out.print("Case" + caseName + "Added!");
    }
    public void addCriminal(String criminalName){
        System.out.print("Criminal," + criminalName + "Added!");
    }
    public void addPolice(String policeName){
        System.out.print("Police Officer, " + policeName + " Added!");
    }
    public void addDetective(String detectiveName){
        System.out.print("Detective, " + detectiveName + " Added!");
    }
    public void caseName(String caseName){
        ;
    }
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public String toString(){
        return "Name: " + getFirstName() + " " + getLastName();
    }

    
}

