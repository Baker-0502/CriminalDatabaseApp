import java.util.UUID;
public class Administrator extends User{
    private boolean updateCase;
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }

    public void addCase(String caseName){
        
    }
    public void addCriminal(String criminalName){
       criminalName = "name";
    }
    public void addPolice(String policeName){
        CriminalDatabaseApplication.createPolice(userID, policeName, policeName, policeName, policeName, policeName, policeName, policeName, policeName, 0, updateCase, null);
    }
    public void addDetective(String detectiveName){
        CriminalDatabaseApplication.createDetective(detectiveName, detectiveName, userID, detectiveName, detectiveName, detectiveName, detectiveName, detectiveName, detectiveName, null);
    }
    public void caseName(String caseName){
        
    }
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public boolean getUpdateCase() {
        return updateCase;
    }
    public String toString(){
        return super.toString()+"\nUpdate Case: "+updateCase+"\n";
    }

    
}

