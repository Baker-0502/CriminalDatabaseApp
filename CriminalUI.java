import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;

public class CriminalUI {
    private CriminalDatabaseApplication database = CriminalDatabaseApplication.getInstance();
    private Scanner readIn = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "Welcome to Criminal Database";
    private String[] mainMenuOptions = {"Create Account","Login","Add People","Add Evidence","Add Case", "Exit"};
    private User loggedIn;
    private boolean quit;

    public void run(){
        System.out.println(WELCOME_MESSAGE);
        quit = false;
        while(!quit){
            displayMenu();
            int choice = readIn.nextInt();
            readIn.nextLine();
                if(choice == 1) {
                    displayAddAccount();
                }
                else if(choice == 2) {
                    displayLogin();
                }
                else if(choice == 3) {
                    displayAddPeople();
                }
                else if(choice == 4) {
                    displayAddEvidence();
                }
                else if(choice == 5) {
                    displayAddCase();
                }
                else if(choice == 6) {
                    quit = false;
                    break;
                }
                else {
                    System.out.println("Please input a valid option!");
                }
                
        }
    }

    public void displayMenu(){
        System.out.println("displaying menu");
        for(int i=0; i<mainMenuOptions.length;i++)
        {
            System.out.println((i+1) + ". "+mainMenuOptions[i]);
        }
        System.out.println("\n");
    }

    public void displayAddAccount() {
        int choice;
        boolean quit2 = false;
        while(!quit) {
            System.out.println("Welcome to the add account screen!\nWhich type of account would you like to add?\n1. Police Officer\n2. Detective\n3. Administrator\n4. Go Back\n");
            choice = readIn.nextInt();
            readIn.nextLine();
            if(choice == 1) {
                addPolice();
            }
            else if(choice == 2) {
                addDetective();
            }
            else if(choice == 3) {
                addAdmin();
            }
            else if(choice == 4){
                quit2 = true;
                break;
            }
        }
    }

    private void addPolice() {
        String[] words = {"First Name", "Last Name", "Username", "Password", "Email", "Phone Number", "Department", "Badge ID", "Edit Access"};
        ArrayList<String> wordsArr = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> inputs = new ArrayList<String>();
        for(int i = 0; i < wordsArr.size(); i++) {
            System.out.println(wordsArr.get(i) + ":");
            inputs.add(readIn.nextLine());
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String username = inputs.get(2);
        String password = inputs.get(3);
        String email = inputs.get(4);
        String phoneNumber = inputs.get(5);
        String department = inputs.get(6);
        String badgeID = inputs.get(7);
        boolean editAccess = Boolean.parseBoolean(inputs.get(8));
        database.createPolice(UUID.randomUUID(),firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, editAccess);
    }

    public void addDetective() {
        String[] words = {"First Name", "Last Name", "Username", "Password", "Email", "Phone Number", "Department", "Associate"};
        ArrayList<String> wordsArr = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> inputs = new ArrayList<String>();
        for(int i = 0; i < wordsArr.size(); i++) {
            System.out.println(wordsArr.get(i) + ":");
            inputs.add(readIn.nextLine());
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String username = inputs.get(2);
        String password = inputs.get(3);
        String email = inputs.get(4);
        String phoneNumber = inputs.get(5);
        String department = inputs.get(6);
        String associate = inputs.get(7);

        database.createDetective(associate, department, UUID.randomUUID(),firstName, lastName, username, password, email, phoneNumber);

        System.out.println();
    }

    public void addAdmin() {
        String[] words = {"First Name", "Last Name", "Username", "Password", "Email", "Phone Number", "Department", "Update Case"};
        ArrayList<String> wordsArr = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> inputs = new ArrayList<String>();
        for(int i = 0; i < wordsArr.size(); i++) {
            System.out.println(wordsArr.get(i) + ":");
            inputs.add(readIn.nextLine());
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String username = inputs.get(2);
        String password = inputs.get(3);
        String email = inputs.get(4);
        String phoneNumber = inputs.get(5);
        String department = inputs.get(6);
        boolean updateCase = Boolean.parseBoolean(inputs.get(7));

        database.createAdmin(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);

        System.out.println();
    }

    //private void add

    public void displayLogin(){
        System.out.println("Welcome to the Login Page!\nPlease input your credentials.\nUsername:");
        String username = readIn.nextLine();
        System.out.println("Password:");
        String password = readIn.nextLine();
        if (password instanceof String) {
            String passCheck = (String) password;
            System.out.println("good");
         } else {
            System.out.println("nah");
         }
        //loggedIn = database.login(username, password);
    }

    public void displayAddCase(){
        System.out.println("adding case");
    }

    public void displayAddPeople() {
        int choice;
        boolean quit2 = false;
        while(!quit) {
            System.out.println("Welcome to the add account screen!\nWhich type of person would you like to add?\n1. Criminal\n2. Person of Interest\n3. Suspect\n4. Victim\n5. Witness\n6. Go Back\n");
            choice = readIn.nextInt();
            readIn.nextLine();
            if(choice == 1) {
                addCriminal();
            }
            else if(choice == 2) {
                addPOI();
            }
            else if(choice == 3) {
                addSuspect();
            }
            else if(choice == 4) {
                addVictim();
            }
            else if(choice == 5) {
                addWitness();
            }
            else if(choice == 6){
                quit2 = true;
                break;
            }
        }
    }

    public void addCriminal() {

    }

    public void addPOI() {

    }

    public void addSuspect() {

    }

    public void addVictim() {

    }

    public void addWitness() {

    }

    public void displayAddEvidence() {
        
    }

    public void displayCases(){
        System.out.println("displaying cases");
    }

    public static void main(String[] args)
    {
        CriminalUI driver = new CriminalUI();
        driver.run();
    }
}
