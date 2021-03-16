import java.util.ArrayList;

public class Criminal extends Person{
    private String bloodType;
    private String fingerPrint;
    private String hairColor;
    private ArrayList<String> clothing;
    private String footSize;
    private String eyeColor;
    private boolean isAlive;
    private ArrayList<String> tattoos;

public Criminal(String firstName, String lastName, int age, double height, double weight, String phoneNumber, String address, String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos)
{
    super(firstName, lastName, age, height, weight, phoneNumber, address, occupation);
    this.bloodType = bloodType;
    this.fingerPrint = fingerprint;
    this.hairColor = hairColor;
    this.clothing = clothing;
    this.footSize = footSize;
    this.eyeColor = eyeColor;
    this.isAlive = isAlive;
    this.tattoos = tattoos;
}
public String getBloodType() {
    return bloodType;
}

public String getFingerPrint() {
    return fingerPrint;
}

public String getHairColor() {
    return hairColor;
}

public ArrayList<String> getClothing() {
    return clothing;
}

public String getFootSize() {
    return footSize;
}

public String getEyeColor() {
    return eyeColor;
}

public boolean isAlive(boolean isAlive) {
    return isAlive;
}

public String toString() {
    return bloodType+fingerPrint+hairColor+clothing+footSize+eyeColor+isAlive+tattoos;
}

private ArrayList<String> getTattoos(){
    return this.tattoos;
}



}