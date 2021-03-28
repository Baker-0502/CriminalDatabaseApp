import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;

public class CriminalUI {
    private CriminalDatabaseApplication database = CriminalDatabaseApplication.getInstance();
    private Scanner readIn = new Scanner(System.in);
    private static final String WELCOME_MESSAGE = "Welcome to Criminal Database";
    private String[] mainMenuOptions = {/*"Create Account","Login",*/"Add People","Add Evidence","Add Case","Display Cases","Search", "Exit"};
    private User loggedIn;
    private boolean quit;

    public void run(){
        System.out.println(WELCOME_MESSAGE);
        quit = false;
        while(!quit){
            displayMenu();
            int choice = readIn.nextInt();
            readIn.nextLine();
            if(loggedIn==null){
                if(choice==1){
                    displayAddAccount();
                }
                else if(choice==2){
                    displayLogin();
                }
            }else{
                if (choice == 1) {
                    displayAddPeople();
                }
                else if(choice == 2) {
                    addEvidence();
                }
                else if(choice == 3) {
                    addCase();
                }
                else if(choice==4){
                    displayCase();
                }
                else if(choice==5){
                    displaySearchOptions();
                }
                else if(choice == 6) {
                    System.out.println("Would you like to save your edits? (Y/N)");
                    String temp = readIn.nextLine();
                    if(temp.toLowerCase().equals("y") || temp.toLowerCase().equals("yes")) {
                        database.saveAll();
                    }
                    quit=false;
                    break;
                }
                else {
                    System.out.println("Please input a valid option!");
                }
            }    
        }
    }

    public void displayMenu(){
        if(loggedIn==null){
            System.out.println("1. Create Account\n2. Login");
        }
        else{
        for(int i=0; i<mainMenuOptions.length;i++)
        {
                System.out.println((i+1)+". "+mainMenuOptions[i]);
        }
        System.out.println("\n");
    }
        
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
            else {
                System.out.println("Please input a valid option!");
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
        
        if(database.login(username, password)!=null){
            loggedIn = database.login(username, password);
        }
    }

    //TODO Fix adding command to arraylist of type user
    public void addCase(){
        System.out.println("adding case");
        String[] words = {"Closed Case?(y/n)","Case Name","Update Case?(y/n)","Federal Case?(y/n)","Misdimeanor?(y/n)","Category","Users Working","Criminals","Suspects","Witnesses","Evidence"};
        ArrayList<User> userWorking = new ArrayList<User>();
        
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();
        ArrayList<Suspect> suspects = new ArrayList<Suspect>();
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        ArrayList<Evidence> evidenceList = new ArrayList<Evidence>();
        
        ArrayList<String> inputs = new ArrayList<String>();
        boolean closedCase=false;
        boolean updateCase=false;
        boolean federalCase = false;
        boolean misdimeanor = false;
        int j=0;

        for(String i : words){
            if(i.equals("Users Working")){
                System.out.println(i+" (Enter amount of users):");
                try{
                    j=readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("User Working " + (k + 1) +":");
                    //TODO Fix Scanner Throwing Errors
                    userWorking.add(database.findUser(readIn.nextLine()));
                }
            }
            else if(i.equals("Criminals")){
                System.out.println(i+" (Enter amount of Criminals):");
                try{
                    j=readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("Criminal " + (k + 1) +":");
                    Criminal temp = addCriminal();
                    if(temp!=null){
                        criminals.add(temp);
                    }
                }
            }
            else if(i.equals("Suspects")){
                System.out.println(i+" (Enter amount of Suspects):");
                try{
                    j=readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("Suspect " + (k + 1) +":");
                    Suspect temp = addSuspect();
                    if(temp!=null){
                        suspects.add(temp);
                    }
                }
            }
            else if(i.equals("Witnesses")){
                System.out.println(i+" (Enter amount of Witnesses):");
                try{
                    j=readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("Witness " + (k + 1) +":");
                    Witness temp = addWitness();
                    if(temp!=null){
                        witnesses.add(temp);
                    }
                }
            }
            else if(i.equals("Evidence")){
                System.out.println(i+" (Enter amount of Evidence):");
                try{
                    j=readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("Evidence " + (k + 1) +":");
                    Evidence temp = addEvidence();
                    if(temp!=null){
                        evidenceList.add(temp);
                    }
                }
            }
            else {
                System.out.println(i + ":");
                inputs.add(readIn.nextLine());
            }
        }
        if (inputs.get(0).equalsIgnoreCase("y") || inputs.get(0).equalsIgnoreCase("yes")) {
            closedCase = true;
        }
        if (inputs.get(2).equalsIgnoreCase("y") || inputs.get(2).equalsIgnoreCase("yes")) {
            updateCase = true;
        }
        if (inputs.get(3).equalsIgnoreCase("y") || inputs.get(3).equalsIgnoreCase("yes")) {
            federalCase = true;
        }
        if (inputs.get(4).equalsIgnoreCase("y") || inputs.get(4).equalsIgnoreCase("yes")) {
            misdimeanor = true;
        }
        try{
            String caseName = inputs.get(1);
            Category category = Category.valueOf(inputs.get(5));

            database.createCase(UUID.randomUUID(), closedCase, caseName, updateCase, federalCase, misdimeanor, category,
            userWorking, criminals, suspects, witnesses, evidenceList);

            System.out.println("Case created!");
        }
        catch (Exception e) {
            System.out.println("-----------------------------\nSomething Went Wrong!\nCheck your input and try again!\n-----------------------------");
        }
    }

    public void displayCase(){
        database.printCaseList();
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
            else {
                System.out.println("Please input a valid option!");
            }
        }
    }

    public void displaySearchOptions(){
        int choice;
        boolean quit2 = false;
        while(!quit){
            System.out.println("Welcome to the Search Option screen!\nWhat would you like to search by?\n1. Search by ID\n2. Search by Keyword\n3. Go Back");
            choice = readIn.nextInt();
            readIn.nextLine();
            if(choice == 1){
                displaySearchByID();
            }
            else if(choice == 2){
                displaySearchByKeyword();
            }
            else if(choice == 3){
                quit2 = true;
                break;
            }
            else{
                System.out.println("Please input a valid option!");
            }
        }
    }

    public void displaySearchByID(){
        
            System.out.println("Enter UUID");
            String id = readIn.nextLine();
            UUID lookingID = UUID.fromString(id);

            if(database.findPerson(lookingID)!=null){
                System.out.println(database.findPerson(lookingID));
            }
            else if(database.findUser(lookingID)!=null){
                System.out.println(database.findUser(lookingID));
            }
            else if(database.findCase(lookingID)!=null){
                System.out.println(database.findCase(lookingID));
            }
            else if(database.findEvidence(lookingID)!=null){
                System.out.println(database.findEvidence(lookingID));
            }
            else{
                System.out.println("Invalid UUID");
            }
        }
        

    public void displaySearchByKeyword(){
        int choice;
        boolean quit2 = false;
        while(!quit){
            System.out.println("What would you like to search for?\n1. Person\n2. Evidence\n3. Case\n4. Go back");
            choice = readIn.nextInt();
            readIn.nextLine();
            if(choice == 1){
                //displaySearchPerson();
            }
            else if(choice == 2){
                //displaySearchEvidence();
            }
            else if(choice == 3){
                //displaySearchCase();
            }
            else if(choice == 4){
                quit2 = true;
                break;
            }
            else{
                System.out.println("Please input a valid option!");
            }

        }
    }

    public void displaySearchPerson(){
        System.out.println("")
    }

    public Criminal addCriminal() {
        //TODO Fix Extraneous Input Causing Crashes.
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Blood Type", "Fingerprint", "Hair Color", "Articles of Clothing (#)", "Foot Size", "Eye Color", "Currently Alive? (y/n)", "Tattoos (#)"};
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<String> clothing = new ArrayList<String>();
        ArrayList<String> tattoos = new ArrayList<String>();
        boolean alive = false;
        int j = 0;
        for (String i : words) {
            if(i.equals("Articles of Clothing (#)")) {
                System.out.println(i + ":");
                try {
                    j = readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
                for (int k = 0; k < j; k++) {
                    System.out.println("Article " + (k + 1) +":");
                    clothing.add(readIn.nextLine());
                }
            }
            else if(i.equals("Tattoos (#)")) {
                System.out.println(i + ":");
                try {
                    j = readIn.nextInt();
                    readIn.nextLine();
                }
                catch (Exception e){
                    System.out.println("Please Input a Valid Number and Try Again!");
                }
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
        try {
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
            String footSize = inputs.get(13);
            String eyeColor = inputs.get(14);

            Criminal temp = new Criminal(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,bloodType,fingerprint,hairColor,clothing,footSize,eyeColor,alive,tattoos);
            database.addCriminal(temp);
            return temp;
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----------------------------\nSomething Went Wrong!\nCheck your input and try again!\n-----------------------------");
        }
        return null;
    }

    public PersonOfInterest addPOI() {
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

        PersonOfInterest temp = new PersonOfInterest(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,hairColor,eyeColor,reasonofInterest,avaliableDetails);
        database.addPOI(temp);
        return temp;

    }

    public Suspect addSuspect() {
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
    
        Suspect temp = new Suspect(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,hairColor,eyeColor,footSize,bloodType,fingerPrint,details,clothing);
        database.addSuspect(temp);
        return temp;
    }

    public Victim addVictim() {
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

        Victim temp = new Victim(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,relationship,statement);
        database.addVictim(temp);
        return temp;
    }

    public Witness addWitness() {
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

        Witness temp = new Witness(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,relationship,statement);
        database.addWitness(temp);
        return temp;
    }

    public Evidence addEvidence(){
        String[] words = {"Evidence Type", "Location Found"};
        ArrayList<String> inputs = new ArrayList<String>();
        for (String i : words) {
            System.out.println(i + ":");
            inputs.add(readIn.nextLine());
    }
        String evidenceType = inputs.get(0);
        String locationFound = inputs.get(1);

        Evidence temp = new Evidence(UUID.randomUUID(), evidenceType, locationFound);
        database.addEvidence(temp);
        return temp;
    }
    

    public static void main(String[] args) {
        CriminalUI driver = new CriminalUI();
        driver.run();
    }
}
