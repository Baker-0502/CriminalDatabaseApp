import java.util.UUID;
public class Administrator extends User{
    private boolean updateCase;
    private UUID userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String department;
    private String badgeID;
    private String associate;
    
    public Administrator(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.badgeID = badgeID;
        this.associate = associate;
    }

    public void addCase(String caseName){
        
    }
    public void addCriminal(String criminalName){
       criminalName = "name";
    }
    public void addPolice(String policeName){
        CriminalDatabaseApplication.createPolice(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, updateCase);
    }
    public void addDetective(String detectiveName){
        CriminalDatabaseApplication.createDetective(associate, department, UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber);
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

