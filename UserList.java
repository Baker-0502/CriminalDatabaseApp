import java.util.ArrayList;
import java.util.UUID;

public class UserList extends User {
    private User User;

    private UserList(ArrayList<String> User){
        super(UUID, String, String, String, String, String, String, String);
        User = new ArrayList<String>();
    }

    public CriminalDatabaseApplication makeLogin(){
        
    }

    public void addUser(String userName, String password, UUID ID){
        System.out.println("adding user!");
    }

    public UUID findUser(UUID User){
        return User;
    }

    public User loginSystem(String userName, String password){
        return User;
    }

    public boolean checkPasswords(User userLogin, String Passoword){
        return false;
    }

    public User searchID(UUID ID){
        return User;
    }
    
}
