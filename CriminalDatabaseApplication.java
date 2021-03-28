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
    public CriminalDatabaseApplication(CaseList caseList, UserList userList, PersonList personList, User user)
    {
        CriminalDatabaseApplication.user = user;
    }
    
    public static CriminalDatabaseApplication getInstance() {
        if (criminalDatabaseApplication == null){
            criminalDatabaseApplication = new CriminalDatabaseApplication(caseList, userList, personList, user);//CaseList.getInstance(), UserList.getInstance(), PersonList.getInstance(), null);
        }
        return criminalDatabaseApplication;
    }

    public void createAdmin(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, boolean updateCase)
    {
        Administrator admin = new Administrator(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, updateCase);
        userList.addAdmin(admin);
    }

    public void createPolice(UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber, String department, String badgeID, int caseCount, boolean editAccess)
    {
        policeOfficer policeofficer = new policeOfficer(UUID.randomUUID(), firstName, lastName, username, password, email, phoneNumber, department, badgeID, caseCount, editAccess);
        userList.addPolice(policeofficer);
        
    }

    public void createDetective(String associate, String department, UUID userID, String firstName, String lastName, String username, String password, String email, String phoneNumber)
    {
       Detective detective = new Detective(associate, department, userID, firstName, lastName, username, password, email, phoneNumber);
       userList.addDetective(detective);
    }

    public void createCase(UUID caseID, boolean closedCase, String caseName, boolean updateCase, boolean federalCase, boolean misdimeanor, Category category, ArrayList<User> userWorking,
            ArrayList<Criminal> criminals, ArrayList<Suspect> suspects, ArrayList<Witness> witness, ArrayList<Evidence> evidenceList){
            Case case1 =  new Case(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witness, evidenceList);
            caseList.addCase(case1);
    }

    public void createCriminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, 
    String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos){
        Criminal criminal = new Criminal(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType,
        fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos);
        caseList.addCriminal(criminal);
    }

    public void addCriminal(Criminal criminal){
        personList.addCriminal(criminal);
    }

    public void addSuspect(Suspect suspect){
        personList.addSuspect(suspect);
    }

    public void addWitness(Witness witness){
        personList.addWitness(witness);
    }

    public void addVictim(Victim victim){
        personList.addVictim(victim);
    }

    public void addPOI(PersonOfInterest poi){
        personList.addPOI(poi);
    }

    public void createWitness(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Witness witness = new Witness(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addWitness(witness);
    }

    public void createVictim(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String relationship, String statement){
        Victim victim = new Victim(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement);
        caseList.addVictim(victim);
    }

    public void createSuspect(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, 
    String eyeColor, String footSize, String bloodType, String fingerPrint, String details, ArrayList<String> clothing, ArrayList<String> tattoos){
        Suspect suspect = new Suspect(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, footSize, bloodType, fingerPrint, details, clothing, tattoos);
        caseList.addSuspect(suspect);
    }

    public void createPOI(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor,
    String eyeColor, String reasonofInterest, String avaliableDetails){
        PersonOfInterest poi = new PersonOfInterest(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, reasonofInterest, avaliableDetails);
        caseList.addPOI(poi);
    }

    public void createEvidence(UUID evidenceID, String evidenceType, String locationFound){
        Evidence evidence = new Evidence(evidenceID, evidenceType, locationFound);
        evidenceList.addEvidence(evidence);
    }

    public void addEvidence(Evidence evidence){
        evidenceList.addEvidence(evidence);
    }


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

    public Person findPerson(String name) {
        return personList.findPerson(name);
    }

    public User findUser(String username) {
        return userList.findUserName(username);
    }

    public Person findPerson(UUID id) {
        return personList.findPerson(id);
    }

    public User findUser(UUID id) {
        return userList.findUser(id);
    }

    public Case findCase(UUID id){
        return caseList.findCase(id);
    }

    public Evidence findEvidence(UUID id){
        return evidenceList.findEvidence(id);
    }

    public void printUserList(){
        userList.print();
    }

    public void printPersonList(){
        personList.print();
    }

    public void printCaseList(){
        caseList.print();
    }

    public void printEvidenceList(){
        evidenceList.print();
    }

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
