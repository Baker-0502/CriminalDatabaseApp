import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveCriminals() {
        PersonList people = PersonList.getInstance();
        ArrayList<Criminal> criminals = DataReader.loadCriminal();
        //ArrayList<Criminal> criminals = people.getCriminals(); 
        JSONArray jsonCriminals = new JSONArray();

        for(int i = 0; i < criminals.size(); i++) {
            jsonCriminals.add(getCriminalJSON(criminals.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
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
        JSONArray clothingJSON = new JSONArray();
        ArrayList<String> clothing = criminal.getClothing();
        for(int i = 0; i < clothing.size(); i++) {
            clothingJSON.add(clothing.get(i));
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
        criminalObject.put(CRIMINAL_CLOTHING, clothingJSON);
        criminalObject.put(CRIMINAL_FOOT_SIZE, criminal.getFootSize());
        criminalObject.put(CRIMINAL_EYE_COLOR, criminal.getEyeColor());
        criminalObject.put(CRIMINAL_IS_ALIVE, criminal.isAlive());
        criminalObject.put(CRIMINAL_TATTOOS, tattoosJSON);

        return criminalObject;

    }

    public static void saveVictims() {
        PersonList people = PersonList.getInstance();
        ArrayList<Victim> victims = DataReader.loadVictim();
        //ArrayList<Victim> victims = people.getVictims(); 
        JSONArray jsonVictims = new JSONArray();

        for(int i = 0; i < victims.size(); i++) {
            jsonVictims.add(getVictimJSON(victims.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonVictims.toJSONString());
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
        ArrayList<PersonOfInterest> personOfInterests = DataReader.loadPOI(); 
        //ArrayList<PersonOfInterest> personOfInterests = people.getPersonsOfInterests(); 
        JSONArray jsonPOI = new JSONArray();

        for(int i = 0; i < personOfInterests.size(); i++) {
            jsonPOI.add(getPOI(personOfInterests.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
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
        ArrayList<Suspect> suspects = DataReader.loadSuspect();
        //ArrayList<Suspect> suspects = people.getSuspects(); 
        JSONArray jsonSuspects = new JSONArray();

        for(int i = 0; i < suspects.size(); i++) {
            jsonSuspects.add(getSuspectJSON(suspects.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonSuspects.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSuspectJSON(Suspect suspect) {
        JSONObject suspectObject = new JSONObject();
        JSONArray clothingJSON = new JSONArray();
        ArrayList<String> clothing = suspect.getClothing();
        for(int i = 0; i < clothing.size(); i++) {
            clothingJSON.add(clothing.get(i));
        }
        
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
        suspectObject.put(SUSPECT_BLOOD_TYPE, suspect.getBloodType());
        suspectObject.put(SUSPECT_FINGERPRINT, suspect.getFingerPrint());
        suspectObject.put(SUSPECT_HAIR_COLOR, suspect.getHairColor());
        suspectObject.put(SUSPECT_CLOTHING, clothingJSON);
        suspectObject.put(SUSPECT_FOOT_SIZE, suspect.getFootSize());
        suspectObject.put(SUSPECT_EYE_COLOR, suspect.getEyeColor());
        suspectObject.put(SUSPECT_DETAILS, suspect.getDetails());

        return suspectObject;

    }
    public static void saveWitnesss() {
        PersonList people = PersonList.getInstance();
        ArrayList<Witness> witnesses = DataReader.loadWitness();
        //ArrayList<Witness> witnesses = people.getWitnesses(); 
        JSONArray jsonWitness = new JSONArray();

        for(int i = 0; i < witnesses.size(); i++) {
            jsonWitness.add(getWitnessJSON(witnesses.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonWitness.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getWitnessJSON(Witness witness) {
        JSONObject witnessObject = new JSONObject();
        
        witnessObject.put(PERSON_ID, witness.getUUID().toString());
        witnessObject.put(PERSON_FIRST_NAME, witness.getFirstName());
        witnessObject.put(PERSON_LAST_NAME, witness.getLastName());
        witnessObject.put(PERSON_GENDER, witness.getGender());
        witnessObject.put(PERSON_RACE, witness.getRace());
        witnessObject.put(PERSON_AGE, witness.getAge());
        witnessObject.put(PERSON_HEIGHT, witness.getHeight());
        witnessObject.put(PERSON_WEIGHT, witness.getWeight());
        witnessObject.put(PERSON_PHONE_NUMBER, witness.getPhoneNumber());
        witnessObject.put(PERSON_ADDRESS, witness.getAddress());
        witnessObject.put(PERSON_OCCUPATION, witness.getOccupation());
        witnessObject.put(WITNESS_RELATIONSHIP, witness.getRelationship());
        witnessObject.put(WITNESS_STATEMENT, witness.getStatement());
        

        return witnessObject;

    }

    public static void saveAdministrators() {
        UserList users = UserList.getInstance();
        ArrayList<Administrator> administrators = DataReader.loadAdmins();
        //ArrayList<Administrator> administrators = users.getAdministrators(); 
        JSONArray jsonAdministrator = new JSONArray();

        for(int i = 0; i < administrators.size(); i++) {
            jsonAdministrator.add(getAdministratorJSON(administrators.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonAdministrator.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getAdministratorJSON(Administrator administrator) {
        JSONObject administratorObject = new JSONObject();
        
        administratorObject.put(USER_USER_ID, administrator.getUserID().toString());
        administratorObject.put(USER_FIRST_NAME, administrator.getFirstName());
        administratorObject.put(USER_LAST_NAME, administrator.getLastName());
        administratorObject.put(USER_USERNAME, administrator.getUserName());
        administratorObject.put(USER_PASSWORD, administrator.getPassword());
        administratorObject.put(USER_EMAIL, administrator.getEmail());
        administratorObject.put(USER_PHONE_NUMBER, administrator.getPhoneNumber());
        administratorObject.put(USER_DEPARTMENT, administrator.getDepartment());
        administratorObject.put(ADMINISTRATOR_UPDATE_CASE, administrator.getUpdateCase());

        return administratorObject;

    }

    public static void saveDetectives() {
        UserList users = UserList.getInstance();
        ArrayList<Detective> detectives = DataReader.loadDetective();
        //ArrayList<Detective> detectives = users.getDetectives(); 
        JSONArray jsonDetective = new JSONArray();

        for(int i = 0; i < detectives.size(); i++) {
            jsonDetective.add(getDetectiveJSON(detectives.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonDetective.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getDetectiveJSON(Detective detective) {
        JSONObject detectiveObject = new JSONObject();
        
        detectiveObject.put(USER_USER_ID, detective.getUserID().toString());
        detectiveObject.put(USER_FIRST_NAME, detective.getFirstName());
        detectiveObject.put(USER_LAST_NAME, detective.getLastName());
        detectiveObject.put(USER_USERNAME, detective.getUserName());
        detectiveObject.put(USER_PASSWORD, detective.getPassword());
        detectiveObject.put(USER_EMAIL, detective.getEmail());
        detectiveObject.put(USER_PHONE_NUMBER, detective.getPhoneNumber());
        detectiveObject.put(USER_DEPARTMENT, detective.getDepartment());
        detectiveObject.put(DETECTIVE_ASSOCIATE, detective.getAssociate());


        return detectiveObject;

    }

    public static void savepoliceMans() {
        UserList users = UserList.getInstance();
        ArrayList<policeOfficer> policeMen = DataReader.loadPoliceOfficer(); 
        //ArrayList<policeOfficer> policeMen = users.getPoliceOfficers(); 
        JSONArray jsonPoliceMan = new JSONArray();

        for(int i = 0; i < policeMen.size(); i++) {
            jsonPoliceMan.add(getPoliceManJSON(policeMen.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonPoliceMan.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getPoliceManJSON(policeOfficer policeMan) {
        JSONObject policeManObject = new JSONObject();
        
        policeManObject.put(USER_USER_ID, policeMan.getUserID().toString());
        policeManObject.put(USER_FIRST_NAME, policeMan.getFirstName());
        policeManObject.put(USER_LAST_NAME, policeMan.getLastName());
        policeManObject.put(USER_USERNAME, policeMan.getUserName());
        policeManObject.put(USER_PASSWORD, policeMan.getPassword());
        policeManObject.put(USER_EMAIL, policeMan.getEmail());
        policeManObject.put(USER_PHONE_NUMBER, policeMan.getPhoneNumber());
        policeManObject.put(USER_DEPARTMENT, policeMan.getDepartment());
        policeManObject.put(POLICEMEN_BADGE_ID, policeMan.getBadgeID());
        policeManObject.put(POLICEMEN_CASE_COUNT, policeMan.getCaseCount());
        policeManObject.put(POLICEMEN_EDIT_ACCESS, policeMan.getEditAccess());

        return policeManObject;

    }

    public static void saveCases() {
        CaseList cases = CaseList.getInstance();
        ArrayList<Case> caseList = DataReader.loadCase();
        //ArrayList<Case> caseList = cases.getCases(); 
        JSONArray jsonCase = new JSONArray();

        for(int i = 0; i < caseList.size(); i++) {
            jsonCase.add(getCaseJSON(caseList.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonCase.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCaseJSON(Case casePass) {
        JSONObject caseObject = new JSONObject();
        //Convert Arrays into JSON Arrays.
        JSONArray userWorkingJSON = new JSONArray();
        ArrayList<User> userWorking = casePass.getUserWorking();
        for(int i = 0; i < userWorking.size(); i++) {
            userWorkingJSON.add(userWorking.get(i).getUserID().toString());
        }
        JSONArray suspectsJSON = new JSONArray();
        ArrayList<Suspect> suspects = casePass.getSuspects();
        for(int i = 0; i < suspects.size(); i++) {
            suspectsJSON.add(suspects.get(i).getUUID().toString());
        }
        JSONArray witnessJSON = new JSONArray();
        ArrayList<Witness> witnesses = casePass.getWitnesses();
        for(int i = 0; i < witnesses.size(); i++) {
            witnessJSON.add(witnesses.get(i).getUUID().toString());
        }
        
		caseObject.put(CASE_ID, casePass.getCaseID());
        caseObject.put(CASE_CLOSED_CASE, casePass.getClosedCase());
        caseObject.put(CASE_NAME, casePass.getCaseName());
        caseObject.put(CASE_UPDATE_CASE, casePass.getUpdateCase());
        caseObject.put(CASE_FEDERAL_CASE, casePass.getFederalCase());
        caseObject.put(CASE_MISDEMEANOR, casePass.getMisdimeanor());
        caseObject.put(CASE_CATEGORY, casePass.getCategory().toString());
        caseObject.put(CASE_USER_WORKING, userWorkingJSON);
        caseObject.put(CASE_SUSPECTS, suspectsJSON);
        caseObject.put(CASE_WITNESSES, witnessJSON);
        caseObject.put(CASE_EVIDENCE_LIST, casePass.getEvidenceList().toString());

        return caseObject;

    }

    public static void saveEvidences() {
        EvidenceList evidenceList = EvidenceList.getInstance();
        ArrayList<Evidence> evidence = DataReader.loadEvidence();
        //ArrayList<Evidence> evidence = evidenceList.getEvidence();
        JSONArray jsonEvidence = new JSONArray();

        for(int i = 0; i < evidence.size(); i++) {
            jsonEvidence.add(getEvidenceJSON(evidence.get(i)));
        }

        try (FileWriter file = new FileWriter(TEST_FILE_NAME)) {
            file.write(jsonEvidence.toJSONString());
            file.flush();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getEvidenceJSON(Evidence evidence) {
        JSONObject evidenceObject = new JSONObject();
        
		evidenceObject.put(EVIDENCE_EVIDENCE_ID, evidence.getEvidenceID().toString());
        evidenceObject.put(EVIDENCE_EVIDENCE_TYPE, evidence.getEvidenceType());
        evidenceObject.put(EVIDENCE_LOCATION_FOUND, evidence.getLocationFound());
        //evidenceObject.put(EVIDENCE_RELATION, evidence.getRelationToPerson().toString());

        return evidenceObject;

    }

    //DEBUG ZONE
    
    

    public static void main(String[] args) {
        saveAdministrators();
    }
    

}
