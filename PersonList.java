import java.util.ArrayList;
import java.util.UUID;

public class PersonList {
    private ArrayList<Criminal> criminalList; 
    private ArrayList<Witness> witnessList;
    private ArrayList<Suspect> suspectList;
    private ArrayList<Victim> victimList;
    private ArrayList<PersonOfInterest> poiList;
    private static PersonList personList = null;


    public PersonList() {
        
    }

    public static PersonList getInstance() {
        if(personList == null) {
            personList = new PersonList();
        }

        return personList;
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