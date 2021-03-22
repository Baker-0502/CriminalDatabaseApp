import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;

public class CriminalUI {
    private Scanner readIn = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "Welcome to Criminal Database";
    private String[] mainMenuOptions = {"Create Account","Login","Exit"};
    private boolean quit;

    public void run(){
        CriminalDatabaseApplication application = CriminalDatabaseApplication.getInstance();
        System.out.println(WELCOME_MESSAGE);
        quit = true;
        while(quit){
            displayMenu();
            int choice = readIn.nextInt();
            readIn.nextLine();
            switch(choice) {
                case 1: 
                    displayAddAccount();
                    break;
                case 2:
                    displayLogin();
                    break;
                case 3:
                    quit = false;
                    break;
                default:
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
        System.out.println("Welcome to the add account screen!\nWhich type of account would you like to add?\n1. Police Officer\n2. Detective\n3. Administrator");
        int choice = readIn.nextInt();
        readIn.nextLine();
        switch(choice) {
            case 1:
                addPolice();
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
        CriminalDatabaseApplication.createPolice(UUID.randomUUID(),firstName, lastName, username, password, email, phoneNumber, department, badgeID, 0, editAccess);

        System.out.println();
    }

    public void displayLogin(){
        System.out.println("displaying login");
    }

    public void displayAddCase(){
        System.out.println("adding case");
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
