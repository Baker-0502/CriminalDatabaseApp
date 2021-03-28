import java.util.ArrayList;
import java.util.UUID;

public class PersonList {
    private ArrayList<Criminal> criminalList = new ArrayList<Criminal>(); 
    private ArrayList<Witness> witnessList = new ArrayList<Witness>();
    private ArrayList<Suspect> suspectList = new ArrayList<Suspect>();
    private ArrayList<Victim> victimList = new ArrayList<Victim>();
    private ArrayList<PersonOfInterest> poiList = new ArrayList<PersonOfInterest>();
    private static PersonList personList = null;


    private PersonList() {
        this.criminalList = DataReader.loadCriminal();
        this.witnessList = DataReader.loadWitness();
        this.suspectList = DataReader.loadSuspect();
        this.victimList = DataReader.loadVictim();
        this.poiList = DataReader.loadPOI();
    }

    public static PersonList getInstance() {
        if(personList == null) {
            personList = new PersonList();
        }
        return personList;
    }

    public void addCriminal(Criminal criminal){
        criminalList.add(criminal);
    }

    public void addWitness(Witness witness){
        witnessList.add(witness);
    }

    public void addSuspect(Suspect suspect){
        suspectList.add(suspect);
    }

    public void addVictim(Victim victim){
        victimList.add(victim);
    }

    public void addPOI(PersonOfInterest poi){
        poiList.add(poi);
    }

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

    public Witness findWitness(UUID personID){
        
        for(int i = 0; i < witnessList.size(); i++){
            String temp = witnessList.get(i).getUUID().toString();
            if(temp.equals(personID.toString())){
                return witnessList.get(i);
            }
        }
        return null;
    }

    public Suspect findSuspect(UUID personID){
        
        for(int i = 0; i < suspectList.size(); i++){
            String temp = suspectList.get(i).getUUID().toString();
            if(temp.equals(personID.toString())){
                return suspectList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Criminal> getCriminals() {
        return criminalList;
    }

    public ArrayList<Suspect> getSuspects() {
        return suspectList;
    }

    public ArrayList<Witness> getWitnesses() {
        return witnessList;
    }

    public ArrayList<Victim> getVictims() {
        return victimList;
    }

    public ArrayList<PersonOfInterest> getPersonsOfInterests() {
        return poiList;
    }

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