import java.util.ArrayList;
import java.util.UUID;

public class UserList extends User {
    private ArrayList<String> User;

    private UserList(ArrayList<String> User){
        super(UUID, String, String, String, String, String, String, String);
        User = new ArrayList<String>();
    }

    public LoginDatabase makeLogin(){
        
    }

    public void addUser(String Username, String Password, UUID ID){

    }

    public int findUser(String User){
        return 1;
    }

    public User loginSystem(String Username, String Password){
        return User;
    }

    public boolean checkPasswords(User userLogin, String Passoword){
        return false;
    }

    public User searchID(UUID ID){
        return User;
    }
    
}
