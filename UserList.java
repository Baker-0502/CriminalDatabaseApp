import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<Administrator> administrators;
    private ArrayList<Detective> detectives;
    private ArrayList<policeOfficer> officers;
    private static UserList userList;
    private User user;

    public UserList() {
        
    }

    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public void makeLogin(){
        System.out.println("making login");
    }

    public void addUser(String userName, String password, UUID ID){
        System.out.println("adding user!");
    }

    //Fix/Implement These!
    public User findUser(UUID User){
        return user;
    }

    public User findUserName(String userName)
    {
        return user;
    }

    public User loginSystem(String userName, String password){
        return user;
    }

    public boolean checkPasswords(User userLogin, String Passoword){
        return false;
    }

    public User searchID(UUID ID){
        return user;
    }

    
    
}
