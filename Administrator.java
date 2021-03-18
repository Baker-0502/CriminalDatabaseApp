import java.util.UUID;
public class Administrator extends User{
    private boolean updateCase;
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }

    public void addCase(String caseName){
        caseName = "case";
    }
    public void addCriminal(String criminalName){
       criminalName = "name";
    }
    public void addPolice(String policeName){
        policeName = "name";
    }
    public void addDetective(String detectiveName){
        detectiveName = "name";
    }
    public void caseName(String caseName){
        
    }
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public String toString(){
        return "Name: " + getFirstName() + " " + getLastName();
    }

    
}

