import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;

public class DataReader extends DataConstants{
    private static CriminalDatabaseApplication database = CriminalDatabaseApplication.getInstance();
    public static ArrayList<Administrator> loadAdmins(){
        ArrayList<Administrator> admin = new ArrayList<Administrator>();
        try{
            FileReader reader = new FileReader(ADMINISTRATOR_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray adminJSON = (JSONArray)new JSONParser().parse(reader);

            //TODO Issue In Loop
            
            for(int i=0;i<adminJSON.size();i++){
                JSONObject adminsJSON = (JSONObject)adminJSON.get(i);
                UUID userID = UUID.fromString((String)adminsJSON.get(USER_USER_ID));
                String firstName = (String)adminsJSON.get(USER_FIRST_NAME);
                String lastName = (String)adminsJSON.get(USER_LAST_NAME);
                String userName = (String)adminsJSON.get(USER_USERNAME);
                String password = (String)adminsJSON.get(USER_PASSWORD);
                String email = (String)adminsJSON.get(USER_EMAIL);
                String phoneNumber = (String)adminsJSON.get(USER_PHONE_NUMBER);
                String department = (String)adminsJSON.get(USER_DEPARTMENT);
                boolean updateCase = Boolean.parseBoolean((String)adminsJSON.get(ADMINISTRATOR_UPDATE_CASE));

                admin.add(new Administrator(userID, firstName, lastName, userName, password, email, phoneNumber, department, updateCase));
            }
            

            return admin;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Detective> loadDetective(){
        ArrayList<Detective> detective = new ArrayList<Detective>();
        try{
            FileReader reader = new FileReader(DETECTIVES_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray detectiveJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<detectiveJSON.size();i++){
                JSONObject detectivesJSON = (JSONObject)detectiveJSON.get(i);
                String associate = (String)detectivesJSON.get(DETECTIVE_ASSOCIATE);
                String department = (String)detectivesJSON.get(USER_DEPARTMENT);
                UUID userID = UUID.fromString((String)detectivesJSON.get(USER_USER_ID));
                String firstName = (String)detectivesJSON.get(USER_FIRST_NAME);
                String lastName = (String)detectivesJSON.get(USER_LAST_NAME);
                String userName = (String)detectivesJSON.get(USER_USERNAME);
                String password = (String)detectivesJSON.get(USER_PASSWORD);
                String email = (String)detectivesJSON.get(USER_EMAIL);
                String phoneNumber = (String)detectivesJSON.get(USER_PHONE_NUMBER);

                detective.add(new Detective(associate, department, userID, firstName, lastName, userName, password, email, phoneNumber));
            }
            return detective;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<policeOfficer> loadPoliceOfficer(){
        ArrayList<policeOfficer> policeOfficer = new ArrayList<policeOfficer>();
        try{
            FileReader reader = new FileReader(POLICEMEN_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray policeJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<policeJSON.size();i++){
                JSONObject policesJSON = (JSONObject)policeJSON.get(i);
                UUID userID = UUID.fromString((String)policesJSON.get(USER_USER_ID));
                String firstName = (String)policesJSON.get(USER_FIRST_NAME);
                String lastName = (String)policesJSON.get(USER_LAST_NAME);
                String userName = (String)policesJSON.get(USER_USERNAME);
                String password = (String)policesJSON.get(USER_PASSWORD);
                String email = (String)policesJSON.get(USER_EMAIL);
                String phoneNumber = (String)policesJSON.get(USER_PHONE_NUMBER);
                String department = (String)policesJSON.get(USER_DEPARTMENT);
                String badgeID = (String)policesJSON.get(POLICEMEN_BADGE_ID);
                int caseCount = ((Number)policesJSON.get(POLICEMEN_CASE_COUNT)).intValue();
                boolean editAccess = Boolean.parseBoolean((String)policesJSON.get(POLICEMEN_EDIT_ACCESS));

                policeOfficer.add(new policeOfficer(userID, firstName, lastName, userName, password, email, phoneNumber, department, badgeID, caseCount, editAccess));
            }
            return policeOfficer;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Case> loadCase(){
        ArrayList<Case> Case = new ArrayList<Case>();
        try{
            FileReader reader = new FileReader(CASES_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray caseJSON = (JSONArray)new JSONParser().parse(reader);

            //TODO broken loop
            for(int i=0;i<caseJSON.size();i++){
                JSONObject casesJSON = (JSONObject)caseJSON.get(i);
                UUID caseID = UUID.fromString((String)casesJSON.get(CASE_ID));
                boolean closedCase = Boolean.parseBoolean((String)casesJSON.get(CASE_CLOSED_CASE));
                String caseName = (String)casesJSON.get(CASE_NAME);
                boolean updateCase = Boolean.parseBoolean((String)casesJSON.get(CASE_UPDATE_CASE));
                boolean federalCase = Boolean.parseBoolean((String)casesJSON.get(CASE_FEDERAL_CASE));
                boolean misdimeanor = Boolean.parseBoolean((String)casesJSON.get(CASE_MISDEMEANOR));
                Category category = Category.valueOf((String)casesJSON.get(CASE_CATEGORY));
                ArrayList<User> userWorking = parseArrUser((JSONArray)casesJSON.get(CASE_USER_WORKING));
                ArrayList<Suspect> suspects = parseArrSuspect((JSONArray)casesJSON.get(CASE_SUSPECTS));
                ArrayList<Witness> witnesses = parseArrWitness((JSONArray)casesJSON.get(CASE_WITNESSES));
                ArrayList<Evidence> evidenceList = parseArrEvidence((JSONArray)casesJSON.get(CASE_EVIDENCE_LIST));

                Case.add(new Case(caseID, closedCase, caseName, updateCase, federalCase, misdimeanor, category, userWorking, suspects, witnesses, evidenceList));
            }
            return Case;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Criminal> loadCriminal(){
        ArrayList<Criminal> criminal = new ArrayList<Criminal>();
        try{
            FileReader reader = new FileReader(CRIMINALS_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray criminalJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<criminalJSON.size();i++){
                JSONObject criminalsJSON = (JSONObject)criminalJSON.get(i);
                UUID personID = UUID.fromString((String)criminalsJSON.get(PERSON_ID));
                String firstName = (String)criminalsJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)criminalsJSON.get(PERSON_LAST_NAME);
                String gender = (String)criminalsJSON.get(PERSON_GENDER);
                String race = (String)criminalsJSON.get(PERSON_RACE);
                int age = ((Number)criminalsJSON.get(PERSON_AGE)).intValue();
                double height = ((Number)criminalsJSON.get(PERSON_HEIGHT)).doubleValue();
                double weight = ((Number)criminalsJSON.get(PERSON_WEIGHT)).doubleValue();
                String phoneNumber = (String)criminalsJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)criminalsJSON.get(PERSON_ADDRESS);
                String occupation = (String)criminalsJSON.get(PERSON_OCCUPATION);
                String bloodType = (String)criminalsJSON.get(CRIMINAL_BLOOD_TYPE);
                String fingerprint = (String)criminalsJSON.get(CRIMINAL_FINGERPRINT);
                String hairColor = (String)criminalsJSON.get(CRIMINAL_HAIR_COLOR);
                ArrayList<String> clothing = parseArr((JSONArray)criminalsJSON.get(CRIMINAL_CLOTHING));
                String footSize = (String)criminalsJSON.get(CRIMINAL_FOOT_SIZE);
                String eyeColor = (String)criminalsJSON.get(CRIMINAL_EYE_COLOR);
                //TODO DEBUG THIS LINE
                boolean isAlive = Boolean.parseBoolean(criminalsJSON.get(CRIMINAL_IS_ALIVE).toString());
                ArrayList<String> tattoos = parseArr((JSONArray)criminalsJSON.get(CRIMINAL_TATTOOS));

                criminal.add(new Criminal(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, bloodType, fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos));
            }
            return criminal;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Evidence> loadEvidence(){
        ArrayList<Evidence> evidence = new ArrayList<Evidence>();
        try{
            FileReader reader = new FileReader(EVIDENCE_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray evidenceJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<evidenceJSON.size();i++){
                JSONObject evidencesJSON = (JSONObject)evidenceJSON.get(i);
                UUID evidenceID = UUID.fromString((String)evidencesJSON.get(EVIDENCE_EVIDENCE_ID));
                String evidenceType = (String)evidencesJSON.get(EVIDENCE_EVIDENCE_TYPE);
                String locationFound = (String)evidencesJSON.get(EVIDENCE_LOCATION_FOUND);

                evidence.add(new Evidence(evidenceID, evidenceType, locationFound));
            }
            return evidence;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<PersonOfInterest> loadPOI(){
        ArrayList<PersonOfInterest> poi = new ArrayList<PersonOfInterest>();
        try{
            FileReader reader = new FileReader(PERSONS_OF_INTEREST_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray poiJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<poiJSON.size();i++){
                JSONObject poisJSON = (JSONObject)poiJSON.get(i);
                UUID personID = UUID.fromString((String)poisJSON.get(PERSON_ID));
                String firstName = (String)poisJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)poisJSON.get(PERSON_LAST_NAME);
                String gender = (String)poisJSON.get(PERSON_GENDER);
                String race = (String)poisJSON.get(PERSON_RACE);
                int age = ((Number)poisJSON.get(PERSON_AGE)).intValue();
                double height = ((Number)poisJSON.get(PERSON_HEIGHT)).doubleValue();
                double weight = ((Number)poisJSON.get(PERSON_WEIGHT)).doubleValue();
                String phoneNumber = (String)poisJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)poisJSON.get(PERSON_ADDRESS);
                String occupation = (String)poisJSON.get(PERSON_OCCUPATION);
                String hairColor = (String)poisJSON.get(PERSON_OF_INTEREST_HAIR_COLOR);
                String eyeColor = (String)poisJSON.get(PERSON_OF_INTEREST_EYE_COLOR);
                String reasonofInterest = (String)poisJSON.get(PERSON_OF_INTEREST_REASON_OF_INTEREST);
                String avaliableDetails = (String)poisJSON.get(PERSON_OF_INTEREST_AVAILABLE_DETAILS);

                poi.add(new PersonOfInterest(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, reasonofInterest, avaliableDetails));
            }
            return poi;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Suspect> loadSuspect(){
        ArrayList<Suspect> suspect = new ArrayList<Suspect>();
        try{
            FileReader reader = new FileReader(SUSPECTS_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray suspectJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<suspectJSON.size();i++){
                JSONObject suspectsJSON = (JSONObject)suspectJSON.get(i);
                UUID personID = UUID.fromString((String)suspectsJSON.get(PERSON_ID));
                String firstName = (String)suspectsJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)suspectsJSON.get(PERSON_LAST_NAME);
                String gender = (String)suspectsJSON.get(PERSON_GENDER);
                String race = (String)suspectsJSON.get(PERSON_RACE);
                int age = ((Number)suspectsJSON.get(PERSON_AGE)).intValue();
                double height = ((Number)suspectsJSON.get(PERSON_HEIGHT)).doubleValue();
                double weight = ((Number)suspectsJSON.get(PERSON_WEIGHT)).doubleValue();
                String phoneNumber = (String)suspectsJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)suspectsJSON.get(PERSON_ADDRESS);
                String occupation = (String)suspectsJSON.get(PERSON_OCCUPATION);
                String hairColor = (String)suspectsJSON.get(SUSPECT_HAIR_COLOR);
                String eyeColor = (String)suspectsJSON.get(SUSPECT_EYE_COLOR);
                String footSize = (String)suspectsJSON.get(SUSPECT_FOOT_SIZE);
                String bloodType = (String)suspectsJSON.get(SUSPECT_BLOOD_TYPE);
                String fingerPrint = (String)suspectsJSON.get(SUSPECT_FINGERPRINT);
                String details = (String)suspectsJSON.get(SUSPECT_DETAILS);
                ArrayList<String> clothing = parseArr((JSONArray)suspectsJSON.get(SUSPECT_CLOTHING));
                ArrayList<String> tattoos = parseArr((JSONArray)suspectsJSON.get(CRIMINAL_TATTOOS));

                suspect.add(new Suspect(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, footSize, bloodType, fingerPrint, details, clothing, tattoos));
            }
            return suspect;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Witness> loadWitness(){
        ArrayList<Witness> witness = new ArrayList<Witness>();
        try{
            FileReader reader = new FileReader(WITNESSES_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray witnessJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<witnessJSON.size();i++){
                JSONObject witnessesJSON = (JSONObject)witnessJSON.get(i);
                UUID personID = UUID.fromString((String)witnessesJSON.get(PERSON_ID));
                String firstName = (String)witnessesJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)witnessesJSON.get(PERSON_LAST_NAME);
                String gender = (String)witnessesJSON.get(PERSON_GENDER);
                String race = (String)witnessesJSON.get(PERSON_RACE);
                int age = ((Number)witnessesJSON.get(PERSON_AGE)).intValue();
                double height = ((Number)witnessesJSON.get(PERSON_HEIGHT)).doubleValue();
                double weight = ((Number)witnessesJSON.get(PERSON_WEIGHT)).doubleValue();
                String phoneNumber = (String)witnessesJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)witnessesJSON.get(PERSON_ADDRESS);
                String occupation = (String)witnessesJSON.get(PERSON_OCCUPATION);
                String relationship = (String)witnessesJSON.get(WITNESS_RELATIONSHIP);
                String statement = (String)witnessesJSON.get(WITNESS_STATEMENT);

                witness.add(new Witness(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement));
            }
            return witness;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Victim> loadVictim(){
        ArrayList<Victim> victim = new ArrayList<Victim>();
        try{
            FileReader reader = new FileReader(VICTIMS_FILE_NAME);
            //JSONParser parser = new JSONParser();
            JSONArray victimJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<victimJSON.size();i++){
                JSONObject victimsJSON = (JSONObject)victimJSON.get(i);
                UUID personID = UUID.fromString((String)victimsJSON.get(PERSON_ID));
                String firstName = (String)victimsJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)victimsJSON.get(PERSON_LAST_NAME);
                String gender = (String)victimsJSON.get(PERSON_GENDER);
                String race = (String)victimsJSON.get(PERSON_RACE);
                int age = ((Number)victimsJSON.get(PERSON_AGE)).intValue();
                double height = ((Number)victimsJSON.get(PERSON_HEIGHT)).doubleValue();
                double weight = ((Number)victimsJSON.get(PERSON_WEIGHT)).doubleValue();
                String phoneNumber = (String)victimsJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)victimsJSON.get(PERSON_ADDRESS);
                String occupation = (String)victimsJSON.get(PERSON_OCCUPATION);
                String relationship = (String)victimsJSON.get(VICTIM_RELATIONSHIP);
                String statement = (String)victimsJSON.get(VICTIM_STATEMENT);

                victim.add(new Victim(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation, relationship, statement));
            }
            return victim;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> parseArr(JSONArray jArray) {
        ArrayList<String> ret = new ArrayList<String>();
        if(jArray != null){
            for (int i = 0; i < jArray.size(); i++) {
                ret.add(jArray.get(i).toString());
            } 
        }
        return ret;
    }

    public static ArrayList<User> parseArrUser(JSONArray jArray) {
        ArrayList<User> ret = new ArrayList<User>();
        if(jArray != null){
            for (int i = 0; i < jArray.size(); i++) {
                UUID userID = UUID.fromString((String)jArray.get(i));
                User user = UserList.getInstance().findUser(userID);
                ret.add(user);
            } 
        }
        return ret; 
    }

    public static ArrayList<Suspect> parseArrSuspect(JSONArray jArray) {
        ArrayList<Suspect> ret = new ArrayList<Suspect>();
        if(jArray != null){
            for (int i = 0; i < jArray.size(); i++) {
                UUID userID = UUID.fromString((String)jArray.get(i));
                Suspect suspect = PersonList.getInstance().findSuspect(userID);
                ret.add(suspect);
            } 
        }
        return ret; 
    }

    public static ArrayList<Witness> parseArrWitness(JSONArray jArray) {
        ArrayList<Witness> ret = new ArrayList<Witness>();
        if(jArray != null){
            for (int i = 0; i < jArray.size(); i++) {
                UUID userID = UUID.fromString((String)jArray.get(i));
                Witness witness = PersonList.getInstance().findWitness(userID);
                ret.add(witness);
            } 
        }
        return ret; 
    }

    public static ArrayList<Evidence> parseArrEvidence(JSONArray jArray) {
        ArrayList<Evidence> ret = new ArrayList<Evidence>();
        if(jArray != null){
            for (int i = 0; i < jArray.size(); i++) {
                UUID evidenceID = UUID.fromString((String)jArray.get(i));
                Evidence evidence = EvidenceList.getInstance().findEvidence(evidenceID);
                ret.add(evidence);
            } 
        }
        return ret; 
    }
    
}