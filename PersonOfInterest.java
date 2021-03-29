/**
 * @author Code Gods
 */
import java.util.UUID;

public class PersonOfInterest extends Person{
    private String hairColor;
    private String eyeColor;
    private String reasonofInterest;
    private String avaliableDetails;


/**
 * 
 * @param personID POI unique id
 * @param firstName POI first name
 * @param lastName POI last name
 * @param gender POI gender
 * @param race POI race
 * @param age POI age
 * @param height POI height
 * @param weight POI weight
 * @param phoneNumber POI phone number
 * @param address POI address 
 * @param occupation POI occupation
 * @param hairColor POI haircolor
 * @param eyeColor POI eye color
 * @param reasonofInterest POI interest
 * @param avaliableDetails POI available details
 */
public PersonOfInterest(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, String eyeColor, String reasonofInterest, String avaliableDetails)
{
    super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
    this.hairColor = hairColor;
    this.eyeColor = eyeColor;
    this.reasonofInterest = reasonofInterest;
    this.avaliableDetails = avaliableDetails;
}

    /**
     * returning the persons hair color
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * returning the persons eye color
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     *returning the persons suspicion/reason of interest
     */
    public String getReasonofInterest() {
        return reasonofInterest;
    }

    /**
     * returning any details on the person
     */
    public String getAvaliableDetails() {
        return avaliableDetails;
    }   

    /**
     * returning the persons credentials
     */
    public String toString(){
        return super.toString()+"\nHair Color: "+hairColor+"\nEye Color: "+eyeColor+"\nReason of Interest: "
            +reasonofInterest+"\nAvaliable Details: "+avaliableDetails+"\n";
    }
}