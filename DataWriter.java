import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveCriminals() {
        PersonList people = PersonList.getInstance();
        ArrayList<Criminal> criminals = people.getCriminals(); 
        JSONArray jsonCriminals = new JSONArray();

        for(int i = 0; i < criminals.size(); i++) {
            jsonCriminals.add(getCriminalJSON(criminals.get(i)));
        }

        try (FileWriter file = new FileWriter(CRIMINALS_FILE_NAME)) {
            file.write(jsonCriminals.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCriminalJSON(Criminal criminal) {
        JSONObject criminalObject = new JSONObject();
        JSONArray tattoosJSON = new JSONArray();
        ArrayList<String> tattoos = criminal.getTattoos();
        for(int i = 0; i < tattoos.size(); i++) {
            tattoosJSON.add(tattoos.get(i));
        }
        criminalObject.put(PERSON_ID, criminal.getUUID().toString());
        criminalObject.put(PERSON_FIRST_NAME, criminal.getFirstName());
        criminalObject.put(PERSON_LAST_NAME, criminal.getLastName());
        criminalObject.put(PERSON_GENDER, criminal.getGender());
        criminalObject.put(PERSON_RACE, criminal.getRace());
        criminalObject.put(PERSON_AGE, criminal.getAge());
        criminalObject.put(PERSON_HEIGHT, criminal.getHeight());
        criminalObject.put(PERSON_WEIGHT, criminal.getWeight());
        criminalObject.put(PERSON_PHONE_NUMBER, criminal.getPhoneNumber());
        criminalObject.put(PERSON_ADDRESS, criminal.getAddress());
        criminalObject.put(PERSON_OCCUPATION, criminal.getOccupation());
        criminalObject.put(CRIMINAL_BLOOD_TYPE, criminal.getBloodType());
        criminalObject.put(CRIMINAL_FINGERPRINT, criminal.getFingerPrint());
        criminalObject.put(CRIMINAL_HAIR_COLOR, criminal.getHairColor());
        criminalObject.put(CRIMINAL_CLOTHING, criminal.getClothing();
        criminalObject.put(CRIMINAL_FOOT_SIZE, criminal.getFootSize());
        criminalObject.put(CRIMINAL_EYE_COLOR, criminal.getEyeColor());
        criminalObject.put(CRIMINAL_IS_ALIVE, criminal.isAlive());
        criminalObject.put(CRIMINAL_TATTOOS, tattoosJSON);

        return criminalObject;

    }

    public static void saveVictims() {
        PersonList people = PersonList.getInstance();
        ArrayList<Victim> victims = people.getVictims(); 
        JSONArray jsonCriminals = new JSONArray();

        for(int i = 0; i < victims.size(); i++) {
            jsonCriminals.add(getVictimJSON(victims.get(i)));
        }

        try (FileWriter file = new FileWriter(VICTIMS_FILE_NAME)) {
            file.write(jsonCriminals.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getVictimJSON(Victim victim) {
        JSONObject victimObject = new JSONObject();
        
        victimObject.put(PERSON_ID, victim.getUUID().toString());
        victimObject.put(PERSON_FIRST_NAME, victim.getFirstName());
        victimObject.put(PERSON_LAST_NAME, victim.getLastName());
        victimObject.put(PERSON_GENDER, victim.getGender());
        victimObject.put(PERSON_RACE, victim.getRace());
        victimObject.put(PERSON_AGE, victim.getAge());
        victimObject.put(PERSON_HEIGHT, victim.getHeight());
        victimObject.put(PERSON_WEIGHT, victim.getWeight());
        victimObject.put(PERSON_PHONE_NUMBER, victim.getPhoneNumber());
        victimObject.put(PERSON_ADDRESS, victim.getAddress());
        victimObject.put(PERSON_OCCUPATION, victim.getOccupation());
        victimObject.put(VICTIM_RELATIONSHIP, victim.getRelationship());
        victimObject.put(VICTIM_STATEMENT, victim.getStatement());
        

        return victimObject;

    }

    public static void savePOI() {
        PersonList people = PersonList.getInstance();
        ArrayList<PersonOfInterest> personOfInterests = people.getPersonsOfInterests(); 
        JSONArray jsonPOI = new JSONArray();

        for(int i = 0; i < personOfInterests.size(); i++) {
            jsonPOI.add(getPOI(personOfInterests.get(i)));
        }

        try (FileWriter file = new FileWriter(PERSONS_OF_INTEREST_FILE_NAME)) {
            file.write(jsonPOI.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getPOI(PersonOfInterest personOfInterest) {
        JSONObject personOfInterestObject = new JSONObject();
        
        personOfInterestObject.put(PERSON_ID, personOfInterest.getUUID().toString());
        personOfInterestObject.put(PERSON_FIRST_NAME, personOfInterest.getFirstName());
        personOfInterestObject.put(PERSON_LAST_NAME, personOfInterest.getLastName());
        personOfInterestObject.put(PERSON_GENDER, personOfInterest.getGender());
        personOfInterestObject.put(PERSON_RACE, personOfInterest.getRace());
        personOfInterestObject.put(PERSON_AGE, personOfInterest.getAge());
        personOfInterestObject.put(PERSON_HEIGHT, personOfInterest.getHeight());
        personOfInterestObject.put(PERSON_WEIGHT, personOfInterest.getWeight());
        personOfInterestObject.put(PERSON_PHONE_NUMBER, personOfInterest.getPhoneNumber());
        personOfInterestObject.put(PERSON_ADDRESS, personOfInterest.getAddress());
        personOfInterestObject.put(PERSON_OCCUPATION, personOfInterest.getOccupation());
        personOfInterestObject.put(PERSON_OF_INTEREST_HAIR_COLOR, personOfInterest.getHairColor());
        personOfInterestObject.put(PERSON_OF_INTEREST_EYE_COLOR, personOfInterest.getEyeColor());
        personOfInterestObject.put(PERSON_OF_INTEREST_REASON_OF_INTEREST, personOfInterest.getReasonofInterest());
        personOfInterestObject.put(PERSON_OF_INTEREST_AVAILABLE_DETAILS, personOfInterest.getAvaliableDetails());
        

        return personOfInterestObject;

    }

    public static void saveSuspects() {
        PersonList people = PersonList.getInstance();
        ArrayList<Suspect> suspects = people.getSuspects(); 
        JSONArray jsonSuspects = new JSONArray();

        for(int i = 0; i < suspects.size(); i++) {
            jsonSuspects.add(getSuspectJSON(suspects.get(i)));
        }

        try (FileWriter file = new FileWriter(SUSPECTS_FILE_NAME)) {
            file.write(jsonSuspects.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSuspectJSON(Suspect suspect) {
        JSONObject suspectObject = new JSONObject();
        
        suspectObject.put(PERSON_ID, suspect.getUUID().toString());
        suspectObject.put(PERSON_FIRST_NAME, suspect.getFirstName());
        suspectObject.put(PERSON_LAST_NAME, suspect.getLastName());
        suspectObject.put(PERSON_GENDER, suspect.getGender());
        suspectObject.put(PERSON_RACE, suspect.getRace());
        suspectObject.put(PERSON_AGE, suspect.getAge());
        suspectObject.put(PERSON_HEIGHT, suspect.getHeight());
        suspectObject.put(PERSON_WEIGHT, suspect.getWeight());
        suspectObject.put(PERSON_PHONE_NUMBER, suspect.getPhoneNumber());
        suspectObject.put(PERSON_ADDRESS, suspect.getAddress());
        suspectObject.put(PERSON_OCCUPATION, suspect.getOccupation());
        suspectObject.put(VICTIM_RELATIONSHIP, suspect.getRelationship());
        suspectObject.put(VICTIM_STATEMENT, suspect.getStatement());
        

        return suspectObject;

    }
}
