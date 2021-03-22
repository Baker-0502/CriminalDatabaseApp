import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<Administrator> administrators;
    private ArrayList<Detective> detectives;
    private ArrayList<policeOfficer> officers;
    private static UserList userList;
    private User user;

    public UserList() {
        //ArrayList<User> user = DataReader.loadCase();
    }

    public static UserList getInstance() {
        if(userList == null) {
            userList = new UserList();
        }

        return userList;
    }

    public ArrayList<Administrator> getAdministrators() {
        return administrators;
    }

    public ArrayList<Detective> getDetectives() {
        return detectives;
    }

    public ArrayList<policeOfficer> getPoliceOfficers() {
        return officers;
    }

    public void makeLogin(){
        System.out.println("making login");
    }

    public void addUser(String userName, String password, UUID ID){
        System.out.println("adding user!");
    }

    //Fix/Implement These!
    public User findUser(UUID id){
        for (int i = 0; i < administrators.size(); i++) {
            if (administrators.get(i).equals(id)) {
                return administrators.get(i);
            }
        }
        for (int i = 0; i < detectives.size(); i++) {
            if (detectives.get(i).equals(id)) {
                return detectives.get(i);
            }
        }
        for (int i = 0; i < officers.size(); i++) {
            if (officers.get(i).equals(id)) {
                return officers.get(i);
            }
        }
        return null;
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
