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
                    addEvidence();
                }
                else if(choice == 5) {
                    addCase();
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
        
        //loggedIn = database.login(username, password);
    }

    //Implement
    public void addCase(){
        String[] words = {"Closed Case", "Case Name", "Update Case", "Federal Case", "Misdimeanor", "Category", "User Working", "Suspects", "Witness", "Evidence List"};
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<String> userWorking = new ArrayList<String>();
        ArrayList<String> suspects = new ArrayList<String>();
        ArrayList<String> witness = new ArrayList<String>();
        ArrayList<String> evidenceList = new ArrayList<String>();
        int j = 0;
        for (String i : words) {
            if(i.equals("User Working")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("User Working " + (k + 1) +":");
                    userWorking.add(readIn.nextLine());
                }
            }
            else if(i.equals("Suspects")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Suspect " + (k+1) +":");
                    suspects.add(readIn.nextLine());
                }
            }
            else if(i.equals("Witness")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Witness " + (k+1) +":");
                    witness.add(readIn.nextLine());
                }
            }
            else if(i.equals("Evidence List")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Evidence List " + (k+1) +":");
                    evidenceList.add(readIn.nextLine());
                }
            }
            else {
                System.out.println(i + ":");
                inputs.add(readIn.nextLine());
            }
        }
        String closedCase = inputs.get(0);
        String caseName = inputs.get(1);
        String updateCase = inputs.get(2);
        String federalCase = inputs.get(3);
        String misdomeanor = inputs.get(4);
        String category = inputs.get(5);
        
        database.createCase(UUID.randomUUID(), closedCase, caseName, updateCase, federalCase, misdomeanor, category, userWorking, suspects, witness, evidenceList);

        System.out.println();
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
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Blood Type", "Fingerprint", "Hair Color", "Articles of Clothing (#)", "Foot Size", "Eye Color", "Currently Alive? (y/n)", "Tattoos (#)"};
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<String> clothing = new ArrayList<String>();
        ArrayList<String> tattoos = new ArrayList<String>();
        boolean alive = false;
        int j = 0;
        for (String i : words) {
            if(i.equals("Articles of Clothing (#)")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Article " + (k + 1) +":");
                    clothing.add(readIn.nextLine());
                }
            }
            else if(i.equals("Tattoos (#)")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Tattoo " + (k+1) +":");
                    clothing.add(readIn.nextLine());
                }
            }
            else {
                System.out.println(i + ":");
                inputs.add(readIn.nextLine());
            }
        }
        //Pass Values to Database!
        if (inputs.get(15).equalsIgnoreCase("y") || inputs.get(15).equalsIgnoreCase("yes")) {
            alive = true;
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String gender = inputs.get(2);
        String race = inputs.get(3);
        int age = Integer.parseInt(inputs.get(4));
        double height = Double.parseDouble(inputs.get(5));
        double weight = Double.parseDouble(inputs.get(6));
        String phoneNumber = inputs.get(7);
        String address = inputs.get(8);
        String occupation = inputs.get(9);
        String bloodType = inputs.get(10);
        String fingerprint = inputs.get(11);
        String hairColor = inputs.get(12);
        //clothing
        String footSize = inputs.get(13);
        String eyeColor = inputs.get(14);
        //alive
        //tattoos


        database.createCriminal(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,bloodType,fingerprint,hairColor,clothing,footSize,eyeColor,alive,tattoos);
    }

    public void addPOI() {
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Hair Color", "Eye Color", "Reason of Interest", "Avaliable Details"};
        ArrayList<String> inputs = new ArrayList<String>();
        for (String i : words) {
                System.out.println(i + ":");
                inputs.add(readIn.nextLine());
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String gender = inputs.get(2);
        String race = inputs.get(3);
        int age = Integer.parseInt(inputs.get(4));
        double height = Double.parseDouble(inputs.get(5));
        double weight = Double.parseDouble(inputs.get(6));
        String phoneNumber = inputs.get(7);
        String address = inputs.get(8);
        String occupation = inputs.get(9);
        String hairColor = inputs.get(10);
        String eyeColor = inputs.get(11);
        String reasonofInterest = inputs.get(12);
        String avaliableDetails = inputs.get(13);

        database.createPOI(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,hairColor,eyeColor,reasonofInterest,avaliableDetails);

    }

    public void addSuspect() {
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Hair Color", "Eye Color", "Foot Size", "Blood Type", "Finger Print", "details", "Articles of Clothing (#)"};
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<String> clothing = new ArrayList<String>();
        int j = 0;
        for (String i : words) {
            if(i.equals("Articles of Clothing (#)")) {
                System.out.println(i + ":");
                j = readIn.nextInt();
                readIn.nextLine();
                for (int k = 0; k < j; k++) {
                    System.out.println("Article " + (k + 1) +":");
                    clothing.add(readIn.nextLine());
                }
            }
            else {
                System.out.println(i + ":");
                inputs.add(readIn.nextLine());
            }
        }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String gender = inputs.get(2);
        String race = inputs.get(3);
        int age = Integer.parseInt(inputs.get(4));
        double height = Double.parseDouble(inputs.get(5));
        double weight = Double.parseDouble(inputs.get(6));
        String phoneNumber = inputs.get(7);
        String address = inputs.get(8);
        String occupation = inputs.get(9);
        String hairColor = inputs.get(10);
        String eyeColor = inputs.get(11);
        String footSize = inputs.get(12);
        String bloodType = inputs.get(13);
        String fingerPrint = inputs.get(14);
        String details = inputs.get(15);
    
        database.createSuspect(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,hairColor,eyeColor,footSize,bloodType,fingerPrint,details,clothing);
    }

    public void addVictim() {
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Relationship", "Statement"};
        ArrayList<String> inputs = new ArrayList<String>();
        for (String i : words) {
            System.out.println(i + ":");
            inputs.add(readIn.nextLine());
    }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String gender = inputs.get(2);
        String race = inputs.get(3);
        int age = Integer.parseInt(inputs.get(4));
        double height = Double.parseDouble(inputs.get(5));
        double weight = Double.parseDouble(inputs.get(6));
        String phoneNumber = inputs.get(7);
        String address = inputs.get(8);
        String occupation = inputs.get(9);
        String relationship = inputs.get(10);
        String statement = inputs.get(11);

        database.createVictim(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,relationship,statement);
    }

    public void addWitness() {
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Relationship", "Statement"};
        ArrayList<String> inputs = new ArrayList<String>();
        for (String i : words) {
            System.out.println(i + ":");
            inputs.add(readIn.nextLine());
    }
        String firstName = inputs.get(0);
        String lastName = inputs.get(1);
        String gender = inputs.get(2);
        String race = inputs.get(3);
        int age = Integer.parseInt(inputs.get(4));
        double height = Double.parseDouble(inputs.get(5));
        double weight = Double.parseDouble(inputs.get(6));
        String phoneNumber = inputs.get(7);
        String address = inputs.get(8);
        String occupation = inputs.get(9);
        String relationship = inputs.get(10);
        String statement = inputs.get(11);

        database.createWitness(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,relationship,statement);
    }

    public void addEvidence(){
        String[] words = {"Evidence Type", "Location Found"};
        ArrayList<String> inputs = new ArrayList<String>();
        for (String i : words) {
            System.out.println(i + ":");
            inputs.add(readIn.nextLine());
    }
        String evidenceType = inputs.get(0);
        String locationFound = inputs.get(1);

        database.createEvidence(UUID.randomUUID(), evidenceType, locationFound);
    }

    public void displayCases() {
        System.out.println("displaying cases");
    }

    public static void main(String[] args) {
        CriminalUI driver = new CriminalUI();
        driver.run();
    }
}
