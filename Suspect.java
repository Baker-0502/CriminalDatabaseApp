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

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getFootSize() {
        return footSize;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public String getDetails() {
        return details;
    }

    public ArrayList<String> getClothing() {
        return clothing;
    }

    public ArrayList<String> getTattoos(){
        return tattoos;
    }

    public String toString(){
        return super.toString()+"\nHair Color: "+hairColor+"\nEye Color: "+eyeColor+"\nFoot Size: "+footSize+
        "\nBlood Type: "+bloodType+"\nFinger Print: "+fingerPrint+"\nDetails: "+details+"\nClothing: "+clothing+"\nTattoos: "+tattoos;
    }
}