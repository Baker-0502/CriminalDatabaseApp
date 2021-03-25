import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<Administrator> administrators = new ArrayList<Administrator>();
    private ArrayList<Detective> detectives = new ArrayList<Detective>();
    private ArrayList<policeOfficer> officers = new ArrayList<policeOfficer>();
    private static UserList userList;
    private User user;

    public UserList(ArrayList<Administrator> administrators, ArrayList<Detective> detectives, ArrayList<policeOfficer> officers, UserList userList, User user) {
        this.administrators =  administrators;
        this.detectives = detectives;
        this.officers = officers;
        this.user = user;
    }

    public UserList() {
        administrators = DataReader.loadAdmins();
        detectives = DataReader.loadDetective();
        officers = DataReader.loadPoliceOfficer();
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
        System.out.println("Making Login");
    }

    public void addPolice(policeOfficer newUser) {
        if(newUser!=null){
            officers.add(newUser);
        }
    }
    public void addDetective(Detective newUser) {
        if(newUser!=null){
            detectives.add(newUser);
        }
    }
    public void addAdmin(Administrator newUser) {
        if(newUser!=null){
            administrators.add(newUser);
        }
    }

    //Fix/Implement These!
    public User findUser(UUID id) {
        for (int i = 0; i < administrators.size(); i++) {
            String temp = administrators.get(i).getUserID().toString();
            if (temp.equals(id.toString())) {
                return administrators.get(i);
            }
        }
        for (int i = 0; i < detectives.size(); i++) {
            String temp = detectives.get(i).getUserID().toString();
            if (temp.equals(id.toString())) {
                return detectives.get(i);
            }
        }
        for (int i = 0; i < officers.size(); i++) {
            String temp = officers.get(i).getUserID().toString();
            if (temp.equals(id.toString())) {
                return officers.get(i);
            }
        }
        return null;
    }

    public User findUserName(String userName)
    {
        for (int i = 0; i < administrators.size(); i++) {
            String temp = administrators.get(i).getUserName();
            if (temp.equals(userName)) {
                return administrators.get(i);
            }
        }
        for (int i = 0; i < officers.size(); i++) {
            String temp = officers.get(i).getUserName();
            if (temp.equals(userName)) {
                return officers.get(i);
            }
        }
        for (int i = 0; i < detectives.size(); i++) {
            String temp = detectives.get(i).getUserName();
            if (temp.equals(userName)) {
                return detectives.get(i);
            }
        }
        return null;
    }

    
}
