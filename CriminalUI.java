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

    /**
     * The main method to run the program, displays different options depending on the users input
     * boolean quit stops the program when the user decides to exit
     * loggedIn checks the type of User logged in, and displays corresponding menus
     */
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

    /**
     * if the user is not logged in, asks for them to create an account or log in
     * if the user is logged in, it prints the different menu options
     */
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

    /**
     * if a user is not logged in, and wants to create an account, this has three different accounts it can add
     * boolean quit2 will quit this method and return back to the main menu when satisfied
     */
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

    /**
     * A user can add a police account, with the given credentials
     * The program writes the entered credentials and creates the police officer
     */
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

        System.out.println();
    }

    /**
    * A user can add a Detective, with the given credentials
    * The program writes the entered credentials and creates the Detective
    */
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

     /**
     * A user can add an admin account, with the given credentials
     * The program writes the entered credentials and creates the admin
     */
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

    /**
     * the program takes in the entered username and password and checks them with what is in the database
     * if it doesnt match what is in the database, asks them to try again
     */
    public void displayLogin(){
        System.out.println("Welcome to the Login Page!\nPlease input your credentials.\nUsername:");
        String username = readIn.nextLine();
        System.out.println("Password:");
        String password = readIn.nextLine();
        
        if(database.login(username, password)!=null){
            loggedIn = database.login(username, password);
        }
    }

    /**
     * lets the user add a case given the below credentials
     * The user the inputs each credential when given the prompt and adds the case
     */
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

    /**
     * prints out the case credentials
     */
    public void displayCase(){
        database.printCaseList();
    }

    /**
     * asks the user what kind of person they want to add
     * boolean quit2 will quit back to the main menu if selected
     */
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

    /**
     * asks the user if they want to search by ID or a keyword
     * boolean quit2 quits to the menu if selected
     */
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

    /**
     * asks the user to enter the UUID they want to search for
     * the database checks all the people, users, cases, and pieces of evidence for that ID, and prints if found, otherwise prints invalid UUID
     * If found, asks the user if they want to print it to a file
     */
    public void displaySearchByID(){
            System.out.println("Enter UUID");
            String id = readIn.nextLine();
            UUID lookingID = UUID.fromString(id);

            if(database.findPerson(lookingID)!=null){
                System.out.println(database.findPerson(lookingID));
                System.out.println("Would you like to print this person?(Y/N)");
                String input = readIn.nextLine();
                if(input.toLowerCase().equals("Y")){
                    database.writeToText(database.findPerson(lookingID));
                }
            }
            else if(database.findUser(lookingID)!=null){
                System.out.println(database.findUser(lookingID));
                System.out.println("Would you like to print this user?(Y/N)");
                String input = readIn.nextLine();
                if(input.toLowerCase().equals("Y")){
                    database.writeToText(database.findPerson(lookingID));
                }

            }
            else if(database.findCase(lookingID)!=null){
                System.out.println(database.findCase(lookingID));
                System.out.println("Would you like to print this case?(Y/N)");
                String input = readIn.nextLine();
                if(input.toLowerCase().equals("y")){
                    database.writeToText(database.findCase(lookingID));
                }
            }
            else if(database.findEvidence(lookingID)!=null){
                System.out.println(database.findEvidence(lookingID));
                System.out.println("Would you like to print this evidence?(Y/N)");
                String input = readIn.nextLine();
                if(input.toLowerCase().equals("y")){
                    database.writeToText(database.findEvidence(lookingID));
                }
            }
            else{
                System.out.println("Invalid UUID");
            }
        }
    
        /**
         * asks the user how many keywords they want to search by, and gives them each type of credential they can search by
         * check the amount of keywords, and then checks the type of search the user inputs for validity
         * The user then enters the credential, and the program goes through and calls a search method for that credential
         * The program then adds all people matching the credential, puts them in a separate arrayList, and prints out that arrayList
         * Then asks the user if they want to print out the arrayList into a file
         */
    public void displaySearchByKeyword(){
        int amt_input=0;
        String input;
        int input1;
        double input2;
        ArrayList<String> personID = new ArrayList<String>();
        System.out.println("You may search by:\nFirst Name, Last Name, Gender, Race, Age, Height, Weight, Phone Number, Address, Occupations, Blood Type, Fingerprint, Hair Color, Footsize, Eye Color, Tattoos");
        System.out.println("Enter the number of keywords you want to search by");
        amt_input = readIn.nextInt();
        readIn.nextLine();
        ArrayList<Person> peopleFound = new ArrayList<Person>();

        for(int i=0;i<amt_input;i++){
            System.out.println("Keyword "+(i+1)+":");
            input = readIn.nextLine();
            input.toLowerCase();
            if(input.toLowerCase().equals("first name")){
                System.out.println("Enter First Name");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchFirst(input));
            }
            else if(input.toLowerCase().equals("last name")){
                System.out.println("Enter Last Name");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchLast(input));
            }
            else if(input.toLowerCase().equals("gender")){
                System.out.println("Enter Gender");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchGender(input));
            }
            else if(input.toLowerCase().equals("race")){
                System.out.println("Enter Race");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchRace(input));
            }
            else if(input.toLowerCase().equals("age")){
                System.out.println("Enter Age");
                input1 = readIn.nextInt();
                readIn.nextLine();
                peopleFound.addAll(database.searchAge(input1));
            }
            else if(input.toLowerCase().equals("height")){
                System.out.println("Enter Height");
                input2 = readIn.nextDouble();
                readIn.nextLine();
                peopleFound.addAll(database.searchHeight(input2));
            }
            else if(input.toLowerCase().equals("weight")){
                System.out.println("Enter Weight");
                input2 = readIn.nextDouble();
                readIn.nextLine();
                peopleFound.addAll(database.searchWeight(input2));
            }
            else if(input.toLowerCase().equals("phone number")){
                System.out.println("Enter Phone Number");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchPhone(input));
            }
            else if(input.toLowerCase().equals("address")){
                System.out.println("Enter Address");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchAddress(input));
            }
            else if(input.toLowerCase().equals("occupation")){
                System.out.println("Enter Occupation");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchOccupation(input));
            }
            else if(input.toLowerCase().equals("blood type")){
                System.out.println("Enter Blood Type");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchBlood(input));
            }
            else if(input.toLowerCase().equals("fingerprint")){
                System.out.println("Enter Fingerprint");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchFinger(input));
            }
            else if(input.toLowerCase().equals("hair color")){
                System.out.println("Enter Hair Color");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchHair(input));
            }
            else if(input.toLowerCase().equals("footsize")){
                System.out.println("Enter Foot Size");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchFoot(input));
            }
            else if(input.toLowerCase().equals("eye color")){
                System.out.println("Enter Eye Color");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchEye(input));
            }
            else if(input.toLowerCase().equals("tattoos")){
                System.out.println("Enter Tattoo");
                input = readIn.nextLine();
                peopleFound.addAll(database.searchTattoo(input));
            }
        }
        ArrayList<Person> people = database.findCorrectPersons(peopleFound, amt_input);
        System.out.println(database.findCorrectPersons(peopleFound, amt_input));
        for(int i=0;i<database.findCorrectPersons(peopleFound, amt_input).size();i++){
            
        }
        System.out.println("Would you like to print this out?(Y/N)");
        input = readIn.nextLine();
        if(input.toLowerCase().equals("y")){
            for(int i=0;i<people.size();i++){
                database.writeToText(people.get(i));
            }
        }

    }

    /**
     * lets the user add a criminal given the below credentials
     * The user then inputs each credential when given the prompt and creates a criminal
     */
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
                    tattoos.add(readIn.nextLine());
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

    /**
     * lets the user add a person of interest given the below credentials
     * The user the inputs each credential when given the prompt and creates a person of interest
     */
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

    /**
     * lets the user add a suspect given the below credentials
     * The user the inputs each credential when given the prompt and creates a suspect
     */
    public Suspect addSuspect() {
        String[] words = {"First Name", "Last Name", "Gender", "Race", "Age", "Height", "Weight", "Phone Number", "Address", "Occupation", "Hair Color", "Eye Color", "Foot Size", "Blood Type", "Finger Print", "details", "Articles of Clothing (#)","Tattoos (#)"};
        ArrayList<String> inputs = new ArrayList<String>();
        ArrayList<String> clothing = new ArrayList<String>();
        ArrayList<String> tattoos = new ArrayList<String>();
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
                    tattoos.add(readIn.nextLine());
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
    
        Suspect temp = new Suspect(UUID.randomUUID(),firstName,lastName,gender,race,age,height,weight,phoneNumber,address,occupation,hairColor,eyeColor,footSize,bloodType,fingerPrint,details,clothing,tattoos);
        database.addSuspect(temp);
        return temp;
    }

    /**
     * lets the user add a victim given the below credentials
     * The user the inputs each credential when given the prompt and creates a victim
     */
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

    /**
     * lets the user add a witness given the below credentials
     * The user the inputs each credential when given the prompt and creates a witness
     */
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

    /**
     * lets the user add evidence given the below credentials
     * The user the inputs each credential when given the prompt and adds evidence
     */
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
    

    /**
     * runs the program
     */
    public static void main(String[] args) {
        CriminalUI driver = new CriminalUI();
        driver.run();
    }
}
