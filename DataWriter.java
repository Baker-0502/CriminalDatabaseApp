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

        }
    }

    public static JSONObject getCriminalJSON(Criminal criminal) {
        JSONObject criminalObject = new JSONObject();

        criminalObject.put(PERSON_ID, criminal.getUUID());
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
        criminalObject.put(CRIMINAL_IS_ALIVE, criminal.);
        criminalObject.put(CRIMINAL_TATTOOS, );

    }
}
