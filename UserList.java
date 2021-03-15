import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private User user;

    private UserList(ArrayList<String> User){
        User = new ArrayList<String>();
    }

    public void makeLogin(){
        System.out.println("making login");
    }

    public void addUser(String userName, String password, UUID ID){
        System.out.println("adding user!");
    }

    public User findUser(UUID User){
        return user;
    }

    public User findUserName(String userName)
    {
        return user;
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
