import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.UUID;

public class DataReader extends DataConstants{
    public static ArrayList<Administrator> loadAdmins(){
        ArrayList<Administrator> admin = new ArrayList<Administrator>();
        try{
            FileReader reader = new FileReader(ADMINISTRATOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray adminJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<adminJSON.size();i++){
                JSONObject adminsJSON = (JSONObject)adminJSON.get(i);
                String userID = (String)adminsJSON.get(USER_USER_ID);
                UUID userID1=UUID.fromString(userID);
                String firstName = (String)adminsJSON.get(USER_FIRST_NAME);
                String lastName = (String)adminsJSON.get(USER_LAST_NAME);
                String username = (String)adminsJSON.get(USER_USERNAME);
                String password = (String)adminsJSON.get(USER_PASSWORD);
                String email = (String)adminsJSON.get(USER_EMAIL);
                String phoneNumber = (String)adminsJSON.get(USER_PHONE_NUMBER);
                String department = (String)adminsJSON.get(USER_DEPARTMENT);
                String updateCase = (String)adminsJSON.get(ADMINISTRATOR_UPDATE_CASE);
                boolean updateCase1 = Boolean.parseBoolean(updateCase);

                admin.add(new Administrator(userID1, firstName, lastName, username, password, email, phoneNumber, department, updateCase1));
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
            JSONParser parser = new JSONParser();
            JSONArray detectiveJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<detectiveJSON.size();i++){
                JSONObject detectivesJSON = (JSONObject)detectiveJSON.get(i);
                String associate = (String)detectivesJSON.get(DETECTIVE_ASSOCIATE);
                String department = (String)detectivesJSON.get(USER_DEPARTMENT);
                String userID = (String)detectivesJSON.get(USER_USER_ID);
                UUID userID1 = UUID.fromString(userID);
                String firstName = (String)detectivesJSON.get(USER_FIRST_NAME);
                String lastName = (String)detectivesJSON.get(USER_LAST_NAME);
                String username = (String)detectivesJSON.get(USER_USERNAME);
                String password = (String)detectivesJSON.get(USER_PASSWORD);
                String email = (String)detectivesJSON.get(USER_EMAIL);
                String phoneNumber = (String)detectivesJSON.get(USER_PHONE_NUMBER);

                detective.add(new Detective(associate, department, userID1, firstName, lastName, username, password, email, phoneNumber));
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
            JSONParser parser = new JSONParser();
            JSONArray policeJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<policeJSON.size();i++){
                JSONObject policesJSON = (JSONObject)policeJSON.get(i);
                String userID = (String)policesJSON.get(USER_USER_ID);
                UUID userID1 = UUID.fromString(userID);
                String firstName = (String)policesJSON.get(USER_FIRST_NAME);
                String lastName = (String)policesJSON.get(USER_LAST_NAME);
                String username = (String)policesJSON.get(USER_USERNAME);
                String password = (String)policesJSON.get(USER_PASSWORD);
                String email = (String)policesJSON.get(USER_EMAIL);
                String phoneNumber = (String)policesJSON.get(USER_PHONE_NUMBER);
                String department = (String)policesJSON.get(USER_DEPARTMENT);
                String badgeID = (String)policesJSON.get(POLICEMEN_BADGE_ID);
                String caseCount = (String)policesJSON.get(POLICEMEN_CASE_COUNT);
                int caseCount1 = Integer.parseInt(caseCount);
                String editAccess = (String)policesJSON.get(POLICEMEN_EDIT_ACCESS);
                boolean editAccess1 = Boolean.parseBoolean(editAccess);

                policeOfficer.add(new policeOfficer(userID1, firstName, lastName, username, password, email, phoneNumber, department, badgeID, caseCount1, editAccess1));
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
            JSONParser parser = new JSONParser();
            JSONArray caseJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<caseJSON.size();i++){
                JSONObject casesJSON = (JSONObject)caseJSON.get(i);
                UUID caseID = (UUID)casesJSON.get(CASE_ID);
                boolean closedCase = (boolean)casesJSON.get(CASE_CLOSED_CASE);
                String caseName = (String)casesJSON.get(CASE_NAME);
                boolean updateCase = (boolean)casesJSON.get(CASE_UPDATE_CASE);
                boolean federalCase = (boolean)casesJSON.get(CASE_FEDERAL_CASE);
                boolean misdimeanor = (boolean)casesJSON.get(CASE_MISDEMEANOR);
                Category category = (Category)casesJSON.get(CASE_CATEGORY);
                ArrayList<User> userWorking = (ArrayList<User>)casesJSON.get(CASE_USER_WORKING);
                ArrayList<Suspect> suspects = (ArrayList<Suspect>)casesJSON.get(CASE_SUSPECTS);
                ArrayList<Witness> witnesses = (ArrayList<Witness>)casesJSON.get(CASE_WITNESSES);
                ArrayList<EvidenceList> evidenceList = (ArrayList<EvidenceList>)casesJSON.get(CASE_EVIDENCE_LIST);

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
            JSONParser parser = new JSONParser();
            JSONArray criminalJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<criminalJSON.size();i++){
                JSONObject criminalsJSON = (JSONObject)criminalJSON.get(i);
                String firstName = (String)criminalsJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)criminalsJSON.get(PERSON_LAST_NAME);
                int age = (int)criminalsJSON.get(PERSON_AGE);
                double height = (double)criminalsJSON.get(PERSON_HEIGHT);
                double weight = (double)criminalsJSON.get(PERSON_WEIGHT);
                String phoneNumber = (String)criminalsJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)criminalsJSON.get(PERSON_ADDRESS);
                String occupation = (String)criminalsJSON.get(PERSON_OCCUPATION);
                String bloodType = (String)criminalsJSON.get(CRIMINAL_BLOOD_TYPE);
                String fingerprint = (String)criminalsJSON.get(CRIMINAL_FINGERPRINT);
                String hairColor = (String)criminalsJSON.get(CRIMINAL_HAIR_COLOR);
                ArrayList<String> clothing = (ArrayList<String>)criminalsJSON.get(CRIMINAL_CLOTHING);
                String footSize = (String)criminalsJSON.get(CRIMINAL_FOOT_SIZE);
                String eyeColor = (String)criminalsJSON.get(CRIMINAL_EYE_COLOR);
                boolean isAlive = (boolean)criminalsJSON.get(CRIMINAL_IS_ALIVE);
                ArrayList<String> tattoos = (ArrayList<String>)criminalsJSON.get(PERSON_FIRST_NAME);

                criminal.add(new Criminal(firstName, lastName, age, height, weight, phoneNumber, address, occupation, bloodType, fingerprint, hairColor, clothing, footSize, eyeColor, isAlive, tattoos));
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
            JSONParser parser = new JSONParser();
            JSONArray evidenceJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<evidenceJSON.size();i++){
                JSONObject evidencesJSON = (JSONObject)evidenceJSON.get(i);
                UUID evidenceID = (UUID)evidencesJSON.get(EVIDENCE_EVIDENCE_ID);
                String evidenceType = (String)evidencesJSON.get(EVIDENCE_EVIDENCE_TYPE);
                String locationFound = (String)evidencesJSON.get(EVIDENCE_LOCATION_FOUND);
                UUID relationToPersonID = (UUID)evidencesJSON.get(EVIDENCE_RELATION);

                evidence.add(new Evidence(evidenceID, evidenceType, locationFound, relationToPersonID));
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
            JSONParser parser = new JSONParser();
            JSONArray poiJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<poiJSON.size();i++){
                JSONObject poisJSON = (JSONObject)poiJSON.get(i);
                String firstName = (String)poisJSON.get(PERSON_FIRST_NAME);
                String lastName = (String)poisJSON.get(PERSON_LAST_NAME);
                int age = (int)poisJSON.get(PERSON_AGE);
                double height = (double)poisJSON.get(PERSON_HEIGHT);
                double weight = (double)poisJSON.get(PERSON_WEIGHT);
                String phoneNumber = (String)poisJSON.get(PERSON_PHONE_NUMBER);
                String address = (String)poisJSON.get(PERSON_ADDRESS);
                String occupation = (String)poisJSON.get(PERSON_OCCUPATION);
                String hairColor = (String)poisJSON.get(PERSON_OF_INTEREST_HAIR_COLOR);
                String eyeColor = (String)poisJSON.get(PERSON_OF_INTEREST_EYE_COLOR);
                String reasonofInterest = (String)poisJSON.get(PERSON_OF_INTEREST_REASON_OF_INTEREST);
                String avaliableDetails = (String)poisJSON.get(PERSON_OF_INTEREST_AVAILABLE_DETAILS);

                poi.add(new PersonOfInterest(firstName, lastName, age, height, weight, phoneNumber, address, occupation, hairColor, eyeColor, reasonofInterest, avaliableDetails));
            }
            return poi;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}