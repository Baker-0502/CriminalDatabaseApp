import java.util.ArrayList;

public class Suspect {
    private String hairColor;
    private String eyeColor;
    private String footSize;
    private String bloodType;
    private String fingerPrint;
    private String details;
    private ArrayList<Integer> clothing;

public Suspect(String hairColor, String eyeColor, String footSize, String bloodType, String fingerPrint, String details, ArrayList<Integer> clothing)
{
    this.hairColor = hairColor;
    this.eyeColor = eyeColor;
    this.footSize = footSize;
    this.bloodType = bloodType;
    this.fingerPrint = fingerPrint;
    this.details = details;
    this.clothing = clothing;
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

public ArrayList<String> getClothing(ArrayList<String> clothing) {
    return clothing;
}
}