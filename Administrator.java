public class Administrator extends User{
    private boolean updateCase;
    
    public Administrator(int userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase){
        super(userID, firstName, lastName, username, password, email, phoneNumber, department);
        this.updateCase = updateCase;
    }

    public void addCase(String caseName){
        System.out.print("Case Added!");
    }
    public void addCriminal(String criminalName){
        System.out.print("Case Added!");
    }
    public void addPolice(String policeName){
        System.out.print("Case Added!");
    }
    public void addDetective(String detectiveName){
        System.out.print("Case Added!");
    }
    public void caseName(String caseName){
        caseName = "";
    }
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public String toString(){
        return getFirstName() + " " + getLastName() + ;
    }

    
}

