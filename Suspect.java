import java.util.ArrayList;
import java.util.UUID;

public class Suspect extends Person{
    private String hairColor;
    private String eyeColor;
    private String footSize;
    private String bloodType;
    private String fingerPrint;
    private String details;
    private ArrayList<String> clothing;
    private ArrayList<String> tattoos;

    /**
     * information regarding the suspect
     * @param personID id of the suspect
     * @param firstName suspect firstname
     * @param lastName suspect lastname
     * @param gender gender of the suspect
     * @param race suspect race
     * @param age age of the suspect
     * @param height height of the suspect
     * @param weight weight of the suspect
     * @param phoneNumber suspect phone number
     * @param address address of the suspect
     * @param occupation suspect occupation
     * @param hairColor hair color of the suspect
     * @param eyeColor eye color of the suspect
     * @param footSize provided footsize of the suspect
     * @param bloodType suspect blood type
     * @param fingerPrint finger print of the suspect
     * @param details extra details of the suspect
     * @param clothing avaliable clothing information for the suspect
     * @param tattoos suspect tattoos
     */
    public Suspect(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, String eyeColor, String footSize, String bloodType, String fingerPrint, String details, ArrayList<String> clothing, ArrayList<String> tattoos)
    {
        super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.footSize = footSize;
        this.bloodType = bloodType;
        this.fingerPrint = fingerPrint;
        this.details = details;
        this.clothing = clothing;
        this.tattoos = tattoos;
    }

    /**
     * gets the haircolor for the suspect
     * @return return the hair color of suspect
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * eye color of the suspect
     * @return return eye color
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * get footsize of the suspect 
     * @return return the footsize of the suspect
     */
    public String getFootSize() {
        return footSize;
    }

    /**
     * get the blood type for the suspect
     * @return return the footsize for suspect
     */
    public String getBloodType() {
        return bloodType;
    }

    /**
     * get the finger print of the suspect
     * @return return the fingerprint pattern
     */
    public String getFingerPrint() {
        return fingerPrint;
    }

    /**
     * get extra avaliable details about the suspect
     * @return return the details of the suspect
     */
    public String getDetails() {
        return details;
    }

    /**
     * get the avaliable provided clothing of the suspect that is stored in an array list
     * @return return the clothing that is stored in array
     */
    public ArrayList<String> getClothing() {
        return clothing;
    }

    /**
     * get the tattoos that is stored in an array list for suspect
     * @return return all the tattoos for suspect
     */
    public ArrayList<String> getTattoos(){
        return tattoos;
    }

    /**
     * to string to output information about suspect
     * @return return information about the suspect
     */
    public String toString(){
        return super.toString()+"\nHair Color: "+hairColor+"\nEye Color: "+eyeColor+"\nFoot Size: "+footSize+
        "\nBlood Type: "+bloodType+"\nFinger Print: "+fingerPrint+"\nDetails: "+details+"\nClothing: "+clothing+"\nTattoos: "+tattoos;
    }
}