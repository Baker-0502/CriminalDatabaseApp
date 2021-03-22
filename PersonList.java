import java.util.ArrayList;
import java.util.UUID;

public class PersonList {
    private ArrayList<Criminal> criminalList; 
    private ArrayList<Witness> witnessList;
    private ArrayList<Suspect> suspectList;
    private ArrayList<Victim> victimList;
    private ArrayList<PersonOfInterest> poiList;
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

    

    public Person findPerson(UUID id){
        id = Person.getUUID();
        for (int i = 0; i < criminalList.size(); i++) {
            if (criminalList.get(i).equals(id)) {
                return criminalList.get(i);
            }
        }
        for (int i = 0; i < witnessList.size(); i++) {
            if (witnessList.get(i).equals(id)) {
                return witnessList.get(i);
            }
        }
        for (int i = 0; i < suspectList.size(); i++) {
            if (suspectList.get(i).equals(id)) {
                return suspectList.get(i);
            }
        }
        for (int i = 0; i < victimList.size(); i++) {
            if (victimList.get(i).equals(id)) {
                return victimList.get(i);
            }
        }
        for (int i = 0; i < poiList.size(); i++) {
            if (poiList.get(i).equals(id)) {
                return poiList.get(i);
            }
        }
        return null;
    }

    public Witness findWitness(UUID personID){
        
        for(int i=0;i<witnessList.size();i++){
            String temp = witnessList.get(i).getUUID().toString();
            if(temp.equals(personID.toString())){
                return witnessList.get(i);
            }
        }
        return null;
    }

    public Suspect findSuspect(UUID personID){
        
        for(int i=0;i<suspectList.size();i++){
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
    


}