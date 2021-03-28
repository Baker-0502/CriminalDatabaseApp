import java.util.ArrayList;
import java.util.UUID;

public class PersonList {
    private ArrayList<Criminal> criminalList = new ArrayList<Criminal>(); 
    private ArrayList<Witness> witnessList = new ArrayList<Witness>();
    private ArrayList<Suspect> suspectList = new ArrayList<Suspect>();
    private ArrayList<Victim> victimList = new ArrayList<Victim>();
    private ArrayList<PersonOfInterest> poiList = new ArrayList<PersonOfInterest>();
    private static PersonList personList = null;

    /**
     * default constructor
     */
    private PersonList() {
        this.criminalList = DataReader.loadCriminal();
        this.witnessList = DataReader.loadWitness();
        this.suspectList = DataReader.loadSuspect();
        this.victimList = DataReader.loadVictim();
        this.poiList = DataReader.loadPOI();
    }


    /**
     * making an instance of the personList
     */
    public static PersonList getInstance() {
        if(personList == null) {
            personList = new PersonList();
        }
        return personList;
    }

    /**
     * 
     * @param criminal takes in the made Criminal
     * adds the criminal to the criminal list
     */
    public void addCriminal(Criminal criminal){
        criminalList.add(criminal);
    }

    /**
     * @param witness takes in the made witness
     * adds the witness to the witness list
     */
    public void addWitness(Witness witness){
        witnessList.add(witness);
    }

    /**
     * 
     * @param suspect takes in the made suspect
     * adds the suspect to the suspect list
     */
    public void addSuspect(Suspect suspect){
        suspectList.add(suspect);
    }

    /**
     * 
     * @param victim takes in the made victim
     * adds the victim to the victim list
     */
    public void addVictim(Victim victim){
        victimList.add(victim);
    }

    /**
     * 
     * @param poi takes in the made POI
     * adds the poi to the poi list
     */
    public void addPOI(PersonOfInterest poi){
        poiList.add(poi);
    }

    /**
     * 
     * @param id takes in the unique person id
     * @return searches through everyone in the person list, so criminals, witnesses, suspects, victims, and pois, and returns 
     * the person with the matching UUID
     */
    public Person findPerson(UUID id){
        //id = Person.getUUID();
        for (int i = 0; i < criminalList.size(); i++) {
            if(criminalList.get(i).getUUID().equals(id)) {
                return criminalList.get(i);
            }
        }
        for (int i = 0; i < witnessList.size(); i++) {
            if(witnessList.get(i).getUUID().equals(id)) {
                return witnessList.get(i);
            }
        }
        for (int i = 0; i < suspectList.size(); i++) {
            if(suspectList.get(i).getUUID().equals(id)) {
                return suspectList.get(i);
            }
        }
        for (int i = 0; i < victimList.size(); i++) {
            if(victimList.get(i).getUUID().equals(id)) {
                return victimList.get(i);
            }
        }
        for (int i = 0; i < poiList.size(); i++) {
            if(poiList.get(i).getUUID().equals(id)) {
                return poiList.get(i);
            }
        }
        return null;
    }

    /**
     * @param name takes in the persons name
     * @return returns any person in the personList with a matching name
     */
    public Person findPerson(String name){
        for (int i = 0; i < criminalList.size(); i++) {
            String fullName = criminalList.get(i).getFirstName() + criminalList.get(i).getLastName();
            if(fullName.toLowerCase().contains(name)) {
                return criminalList.get(i);
            }
        }
        for (int i = 0; i < witnessList.size(); i++) {
            String fullName = witnessList.get(i).getFirstName() + witnessList.get(i).getLastName();
            if(fullName.toLowerCase().contains(name)) {
                return witnessList.get(i);
            }
        }
        for (int i = 0; i < suspectList.size(); i++) {
            String fullName = suspectList.get(i).getFirstName() + suspectList.get(i).getLastName();
            if(fullName.toLowerCase().contains(name)) {
                return suspectList.get(i);
            }
        }
        for (int i = 0; i < victimList.size(); i++) {
            String fullName = victimList.get(i).getFirstName() + victimList.get(i).getLastName();
            if(fullName.toLowerCase().contains(name)) {
                return victimList.get(i);
            }
        }
        for (int i = 0; i < poiList.size(); i++) {
            String fullName = poiList.get(i).getFirstName() + poiList.get(i).getLastName();
            if(fullName.toLowerCase().contains(name)) {
                return poiList.get(i);
            }
        }
        return null;
    }

    /**
     * @param firstName takes in the persons first name
     * @return returns a person in the personList with a matching first name
     */
    public Person findPersonFirst(String firstName){
        for (int i = 0; i < criminalList.size(); i++) {
            String Firstname = criminalList.get(i).getFirstName();
            if(Firstname.toLowerCase().contains(firstName)) {
                return criminalList.get(i);
            }
        }
        for (int i = 0; i < witnessList.size(); i++) {
            String Firstname = witnessList.get(i).getFirstName();
            if(Firstname.toLowerCase().contains(firstName)) {
                return witnessList.get(i);
            }
        }
        for (int i = 0; i < suspectList.size(); i++) {
            String Firstname = suspectList.get(i).getFirstName();
            if(Firstname.toLowerCase().contains(firstName)) {
                return suspectList.get(i);
            }
        }
        for (int i = 0; i < victimList.size(); i++) {
            String Firstname = victimList.get(i).getFirstName();
            if(Firstname.toLowerCase().contains(firstName)) {
                return victimList.get(i);
            }
        }
        for (int i = 0; i < poiList.size(); i++) {
            String Firstname = poiList.get(i).getFirstName();
            if(Firstname.toLowerCase().contains(firstName)) {
                return poiList.get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param personID takes in the UUID
     * @return returns the witness with a matching UUID
     */
    public Witness findWitness(UUID personID){
        
        for(int i = 0; i < witnessList.size(); i++){
            String temp = witnessList.get(i).getUUID().toString();
            if(temp.equals(personID.toString())){
                return witnessList.get(i);
            }
        }
        return null;
    }

    /**
     * @param personID takes in the UUID
     * @return returns the suspect with the matching UUID
     */
    public Suspect findSuspect(UUID personID){
        
        for(int i = 0; i < suspectList.size(); i++){
            String temp = suspectList.get(i).getUUID().toString();
            if(temp.equals(personID.toString())){
                return suspectList.get(i);
            }
        }
        return null;
    }

    /**
     * return the arrayList criminalList
     */
    public ArrayList<Criminal> getCriminals() {
        return criminalList;
    }

    /**
     * returns the arrayList suspectList
     */
    public ArrayList<Suspect> getSuspects() {
        return suspectList;
    }

    /**
     * returns the arrayList witnessList
     */
    public ArrayList<Witness> getWitnesses() {
        return witnessList;
    }

    /**
     * returns the arrayList victimList
     */
    public ArrayList<Victim> getVictims() {
        return victimList;
    }

    /**
     * returns the arrayList poiList
     */
    public ArrayList<PersonOfInterest> getPersonsOfInterests() {
        return poiList;
    }

    /**
     * prints the criminal, witness, victim, suspect, and poi lists
     */
    public void print(){
        for(int i=0;i<criminalList.size();i++){
            System.out.println(criminalList.get(i).toString());
        }
        for (int i=0;i<witnessList.size();i++){
            System.out.println(witnessList.get(i).toString());
        }
        for(int i=0;i<suspectList.size();i++){
            System.out.println(suspectList.get(i).toString());
        }
        for (int i=0;i<victimList.size();i++){
            System.out.println(victimList.get(i).toString());
        }
        for (int i=0;i<poiList.size();i++){
            System.out.println(poiList.get(i).toString());
        }
    }
    


}