import java.util.ArrayList;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class CriminalDatabaseApplication {
    private static CaseList caseList = CaseList.getInstance();
    private static UserList userList = UserList.getInstance();
    private static PersonList personList = PersonList.getInstance();
    private static EvidenceList evidenceList = EvidenceList.getInstance();
    private static User user;
    private static CriminalDatabaseApplication criminalDatabaseApplication;
    
    /**
     * 
     * @param caseList arrayLists of cases
     * @param userList arrayLists of users
     * @param personList arrayLists of people
     * @param user a single user
     */
    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        CriminalDatabaseApplication.user = user;
    }
    
    /**
     * Creates an instance of the Database
     */
    public static CriminalDatabaseApplication getInstance() {
        if (criminalDatabaseApplication == null){
            criminalDatabaseApplication = new CriminalDatabaseApplication(caseList, userList, personList, user);//CaseList.getInstance(), UserList.getInstance(), PersonList.getInstance(), null);
        }
        return criminalDatabaseApplication;
    }

    /**
     * 
     * @param userID the unique user id
     * @param firstName first name of the admin
     * @param lastName last name of the admin
     * @param username username of the admin
     * @param password password of the admin
     * @param email email of the admin
     * @param phoneNumber phone number of the admin
     * @param department department of the admin
     * @param updateCase whether or not the admin can update a case
     * This method takes in the above parameters an creates an admin account
     */
    public void createAdmin(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase)
    {
        Administrator admin = new Administrator(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);
        userList.addAdmin(admin);
    }

    /**
     * 
     * @param userID unique user id
     * @param firstName first name of the officer
     * @param lastName last name of the officer
     * @param username username of the officer
     * @param password password of the officer
     * @param email email of the officer
     * @param phoneNumber phone number of the officer
     * @param department department of the officer
     * @param badgeID badge id of the officer
     * @param caseCount how many cases the officer entered
     * @param editAccess if the officer can edit
     * This method takes in the above parameters an creates an officer account
     */
    public void createPolice(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess)
    {
        policeOfficer policeofficer = new policeOfficer(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, caseCount, editAccess);
        userList.addPolice(policeofficer);
        
    }

    /**
     * 
     * @param associate associates of the detective
     * @param department department the detective is in
     * @param userID the unique user ID
     * @param firstName first name of the detective
     * @param lastName last name of the detective
     * @param username user name of the detective
     * @param password password of the detective
     * @param email email of the detective
     * @param phoneNumber phone number of the detective
     * This method takes in the above parameters an creates a detective account
     */
    public void createDetective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber)
    {
       Detective detective = new Detective(associate, department, userID, firstName, lastName, username, password, email, phoneNumber);
       userList.addDetective(detective);
    }

    /**
     * 
     * @param caseID unique Case ID
     * @param closedCase boolean if its a closed case
     * @param caseName name of the case
     * @param updateCase boolean if the case can be updated
     * @param federalCase boolean if its a federal case
     * @param misdimeanor boolean if its a misdimeanor
     * @param category what type of case it is
     * @param userWorking which users are on the case
     * @param criminals which criminals are part of the case
     * @param suspects which suspects are part of the case
     * @param witness which witnesses are part of the case
     * @param evidenceList the evidence associated with the case
     * This method takes in the above parameters an creates a case
     */
    public void createCase(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Criminal> criminals, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
            Case case1 =  new Case(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
            caseList.addCase(case1);
    }

    /**
     * 
     * @param personID unique person ID
     * @param firstName criminal first name
     * @param lastName criminal last name
     * @param gender criminal gender
     * @param race criminal race
     * @param age criminal age
     * @param height criminal height
     * @param weight criminal weight
     * @param phoneNumber criminal phone number
     * @param address criminal home address
     * @param occupation criminal occupation
     * @param bloodType criminal blood type 
     * @param fingerprint criminal fingerprint type
     * @param hairColor criminal hair color
     * @param clothing criminal number of clothing and type of clothing
     * @param footSize criminal foot size
     * @param eyeColor criminal eye color
     * @param isAlive boolean to check alive or dead
     * @param tattoos criminals number of tattoos and description
     * This method takes in the above parameters an creates a criminal
     */
    public void createCriminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, 
    String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos){
        Criminal criminal = new Criminal(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType,
        fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos);
        caseList.addCriminal(criminal);
    }

    /**
     * 
     * @param criminal takes in the made criminal and adds it to the personList
     */
    public void addCriminal(Criminal criminal){
        personList.addCriminal(criminal);
    }

     /**
     * 
     * @param criminal takes in the made suspect and adds it to the personList
     */
    public void addSuspect(Suspect suspect){
        personList.addSuspect(suspect);
    }

     /**
     * 
     * @param criminal takes in the made witness and adds it to the personList
     */
    public void addWitness(Witness witness){
        personList.addWitness(witness);
    }

     /**
     * 
     * @param criminal takes in the made victim and adds it to the personList
     */
    public void addVictim(Victim victim){
        personList.addVictim(victim);
    }

     /**
     * 
     * @param criminal takes in the made POI and adds it to the personList
     */
    public void addPOI(PersonOfInterest poi){
        personList.addPOI(poi);
    }

    /**
     * 
     * @param personID unique user ID
     * @param firstName witness first name
     * @param lastName witness last name
     * @param gender witness gender
     * @param race witness race
     * @param age witness race
     * @param height witness height
     * @param weight witness weight
     * @param phoneNumber witness phone number
     * @param address witness address
     * @param occupation witness occupation
     * @param relationship witness relationship to criminal
     * @param statement witness statment regarding crime
     * This method takes in the above parameters an creates a witness
     */
    public void createWitness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Witness witness = new Witness(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addWitness(witness);
    }

    /**
     * 
     * @param personID unique user id
     * @param firstName victim first name
     * @param lastName victim last name
     * @param gender victim gender
     * @param race victim race
     * @param age victim age
     * @param height victim height
     * @param weight victim weight
     * @param phoneNumber victim phone number
     * @param address victim address
     * @param occupation victim occupation
     * @param relationship victim relationship to criminal
     * @param statement victim crime statement
     * This method takes in the above parameters an creates a victim
     */
    public void createVictim(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Victim victim = new Victim(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addVictim(victim);
    }

    /**
     * 
     * @param personID unique user id
     * @param firstName suspect first name
     * @param lastName suspect last name
     * @param gender suspect gender
     * @param race suspect race
     * @param age suspect age
     * @param height suspect height
     * @param weight suspect weight
     * @param phoneNumber suspect phone number
     * @param address suspect address 
     * @param occupation suspect occupation
     * @param hairColor suspect hair color
     * @param eyeColor suspect eye color
     * @param footSize suspect foot size
     * @param bloodType suspect blood type
     * @param fingerPrint suspect finger print type
     * @param details details about the suspect
     * @param clothing number of clothes and type of clothes the suspect has on
     * @param tattoos number of tattoos the suspect has and description of the tattoos
     * This method takes in the above parameters an creates a suspect
     */
    public void createSuspect(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, 
    String eyeColor, String footSize, String bloodType, String fingerPrint, String details, ArrayList<String> clothing, ArrayList<String> tattoos){
        Suspect suspect = new Suspect(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, footSize, bloodType, fingerPrint, details, clothing, tattoos);
        caseList.addSuspect(suspect);
    }

    /**
     * 
     * @param personID unique user id
     * @param firstName POI first name
     * @param lastName POI last name
     * @param gender POI gender
     * @param race POI race
     * @param age POI age
     * @param height POI height
     * @param weight POI weight
     * @param phoneNumber POI phone number
     * @param address POI address 
     * @param occupation POI occupation
     * @param hairColor POI hair color
     * @param eyeColor POI eye color
     * @param reasonofInterest the reason this person might be a suspect
     * @param avaliableDetails any available details about the POI
     * This method takes in the above parameters an creates a POI
     */
    public void createPOI(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor,
    String eyeColor, String reasonofInterest, String avaliableDetails){
        PersonOfInterest poi = new PersonOfInterest(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, reasonofInterest, avaliableDetails);
        caseList.addPOI(poi);
    }

    /**
     * 
     * @param evidenceID unique evidence ID
     * @param evidenceType the type of evidence it was, any description about it
     * @param locationFound where it was found
     * This method takes in the above parameters an creates evidence
     */
    public void createEvidence(UUID evidenceID, String evidenceType, String locationFound){
        Evidence evidence = new Evidence(evidenceID, evidenceType, locationFound);
        evidenceList.addEvidence(evidence);
    }

    /**
     * 
     * @param evidence takes in the evidence and adds it to the evidenceList
     */
    public void addEvidence(Evidence evidence){
        evidenceList.addEvidence(evidence);
    }


    /**
     * 
     * @param userName entered user name
     * @param password entered password
     * @return the user that just logged in
     * If the user name and password entered is correct, it prints out that youre logging in as the first and last name of that user
     * if the user name and password is incorrect, it prints out that it was incorrect
     */
    public User login(String userName, String password)
    {
        if(userList.findUserName(userName)!=null){
        User desiredUser = userList.findUserName(userName);
        //System.out.println(desiredUser);//Colin is a dumb fool who needs to learn how to read
        if(userName.equals(desiredUser.getUserName()) && password.equals(desiredUser.getPassword())){
            System.out.println("Logging in as "+desiredUser.getFirstName()+" "+desiredUser.getLastName());
                return desiredUser;
        }
    }
    System.out.println("Username/Password was incorrect");
    return null;
    }

    /**
     * 
     * @param name first and last name of the person
     * @return returns a person in personList with that name
     */
    public Person findPerson(String name) {
        return personList.findPerson(name);
    }

    /**
     * 
     * @param username username of the user
     * @return returns a user in userList with that user name
     */
    public User findUser(String username) {
        return userList.findUserName(username);
    }

    /**
     * 
     * @param id unique user id
     * @return returns a person in personList with that UUID
     */
    public Person findPerson(UUID id) {
        return personList.findPerson(id);
    }

    /**
     * 
     * @param id unique user id
     * @return returns a user in userList with that UUID
     */
    public User findUser(UUID id) {
        return userList.findUser(id);
    }

    /**
     * 
     * @param id unique case id
     * @return returns a case in caseList with that UUID
     */
    public Case findCase(UUID id){
        return caseList.findCase(id);
    }

    /**
     * 
     * @param id unique evidence id
     * @return returns evidence in evidenceList with that UUID
     */
    public Evidence findEvidence(UUID id){
        return evidenceList.findEvidence(id);
    }

    /**
     * prints items in userList
     */
    public void printUserList(){
        userList.print();
    }

    /**
     * prints items in personList
     */
    public void printPersonList(){
        personList.print();
    }

    /**
     * prints items in caseList
     */
    public void printCaseList(){
        caseList.print();
    }

    /**
     * prints items in evidenceList
     */
    public void printEvidenceList(){
        evidenceList.print();
    }

    /**
     * 
     * @param firstName the first name the method is searching for
     * @return arrayList people of everyone who has that name
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchFirst(String firstName){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getFirstName().equals(firstName)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getFirstName().equals(firstName)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getFirstName().equals(firstName)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getFirstName().equals(firstName)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getFirstName().equals(firstName)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param lastName the last name the method is searching for
     * @return arrayList people of everyone who has that name
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchLast(String lastName){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getLastName().equals(lastName)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getLastName().equals(lastName)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getLastName().equals(lastName)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getLastName().equals(lastName)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getLastName().equals(lastName)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param gender the gender the method is searching for
     * @return arrayList people of everyone who has that gender
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchGender(String gender){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getGender().equals(gender)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getGender().equals(gender)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getGender().equals(gender)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getGender().equals(gender)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getGender().equals(gender)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param race the race the method is searching for
     * @return arrayList people of everyone who has that race
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchRace(String race){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getRace().equals(race)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getRace().equals(race)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getRace().equals(race)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getRace().equals(race)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getRace().equals(race)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param age the age the method is searching for
     * @return arrayList people of everyone who has that age
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchAge(int age){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getAge()==age){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getAge()==age){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getAge()==age){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getAge()==age){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getAge()==age){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param height the height the method is searching for
     * @return arrayList people of everyone who has that height
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchHeight(double height){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getHeight()==height){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getHeight()==height){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getHeight()==height){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getHeight()==height){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getHeight()==height){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param weight the weight the method is searching for
     * @return arrayList people of everyone who has that weight
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchWeight(double weight){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getWeight()==weight){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getWeight()==weight){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getWeight()==weight){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getWeight()==weight){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getWeight()==weight){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param phoneNumber the phoneNumber the method is searching for
     * @return arrayList people of everyone who has that phoneNumber
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchPhone(String phoneNumber){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getPhoneNumber().equals(phoneNumber)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getPhoneNumber().equals(phoneNumber)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getPhoneNumber().equals(phoneNumber)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getPhoneNumber().equals(phoneNumber)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getPhoneNumber().equals(phoneNumber)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param address the address the method is searching for
     * @return arrayList people of everyone who has that address
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchAddress(String address){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getAddress().equals(address)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getAddress().equals(address)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getAddress().equals(address)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getAddress().equals(address)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getAddress().equals(address)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param occupation the occupation the method is searching for
     * @return arrayList people of everyone who has that occupation
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchOccupation(String occupation){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Person name = personList.getSuspects().get(i);
            if(name.getOccupation().equals(occupation)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Person name = personList.getCriminals().get(i);
            if(name.getOccupation().equals(occupation)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getVictims().size();i++){
            Person name = personList.getVictims().get(i);
            if(name.getOccupation().equals(occupation)){
                people.add(personList.getVictims().get(i));
            }
        }
        for(int i=0;i<personList.getWitnesses().size();i++){
            Person name = personList.getWitnesses().get(i);
            if(name.getOccupation().equals(occupation)){
                people.add(personList.getWitnesses().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            Person name = personList.getPersonsOfInterests().get(i);
            if(name.getOccupation().equals(occupation)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param blood the blood type the method is searching for
     * @return arrayList people of everyone who has that blood type
     * Searches through the array list of people, which includes suspects, criminals, victims, witnesses, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchBlood(String blood){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getBloodType().equals(blood)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getBloodType().equals(blood)){
                people.add(personList.getCriminals().get(i));
            }
        }
        return people;
    }
    public ArrayList<Person> searchFinger(String finger){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getFingerPrint().equals(finger)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getFingerPrint().equals(finger)){
                people.add(personList.getCriminals().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param hair the hair color the method is searching for
     * @return arrayList people of everyone who has that hair color
     * Searches through the array list of people, which includes suspects, criminals, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchHair(String hair){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getHairColor().equals(hair)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getHairColor().equals(hair)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            PersonOfInterest name = personList.getPersonsOfInterests().get(i);
            if(name.getHairColor().equals(hair)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param foot the foot size the method is searching for
     * @return arrayList people of everyone who has that foot size
     * Searches through the array list of people, which includes suspects and criminals and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchFoot(String foot){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getFootSize().equals(foot)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getFootSize().equals(foot)){
                people.add(personList.getCriminals().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param gender the gender the method is searching for
     * @return arrayList people of everyone who has that gender
     * Searches through the array list of people, which includes suspects, criminals, and POIs, and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchEye(String eye){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getEyeColor().equals(eye)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getEyeColor().equals(eye)){
                people.add(personList.getCriminals().get(i));
            }
        }
        for(int i=0;i<personList.getPersonsOfInterests().size();i++){
            PersonOfInterest name = personList.getPersonsOfInterests().get(i);
            if(name.getEyeColor().equals(eye)){
                people.add(personList.getPersonsOfInterests().get(i));
            }
        }
        return people;
    }

    /**
     * 
     * @param tattoo the tattoos the method is searching for
     * @return arrayList people of everyone who has that tattoo
     * Searches through the array list of people, which includes suspects and criminals and adds them to a separate arrayList and prints out the array list
     */
    public ArrayList<Person> searchTattoo(String tattoo){
        ArrayList<Person> people = new ArrayList<Person>();
        for(int i=0;i<personList.getSuspects().size();i++){
            Suspect name = personList.getSuspects().get(i);
            if(name.getTattoos().toString().toLowerCase().contains(tattoo)){
                people.add(personList.getSuspects().get(i));
            }

        }
        for(int i=0;i<personList.getCriminals().size();i++){
            Criminal name = personList.getCriminals().get(i);
            if(name.getTattoos().toString().toLowerCase().contains(tattoo)){
                people.add(personList.getCriminals().get(i));
            }
        }
        return people;
    }

    public ArrayList<Person> findCorrectPersons(ArrayList<Person> people, int numNeeded) {
        ArrayList<Person> retMe = new ArrayList<Person>();
        ArrayList<String> uuids = new ArrayList<String>();

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (Person s: people) {
            Integer count = frequencyMap.get(s.getUUID().toString());
            if (count == null) {
                count = 0;
            }
 
            frequencyMap.put(s.getUUID().toString(), count + 1);
        }
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() == numNeeded) {
                retMe.add(findPerson(UUID.fromString(entry.getKey())));
            }
        }
        return retMe;

    }

    /**
     * 
     * @param obj takes in the object of either person, case, or evidence, and writes in the respective object. 
     * saves the object to a file
     */
    public void writeToText(Object obj) {
        if (obj instanceof Person) {
            DataWriter.writePerson((Person) obj);
        }
        else if (obj instanceof Case) {
            DataWriter.writeCase((Case) obj);
        }
        else if (obj instanceof Evidence) {
            DataWriter.writeEvidence((Evidence) obj);
        }
        else {
            System.out.println("This Item Cannot be Saved!");
        }
    }

    /**
     * saves all the objects 
     */
    public void saveAll() {
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.savePOI();
        DataWriter.saveSuspects();
        DataWriter.saveWitnesss();
        DataWriter.saveAdministrators();
        DataWriter.saveDetectives();
        DataWriter.savepoliceMans();
        DataWriter.saveCases();
        DataWriter.saveEvidences();
    }
}
