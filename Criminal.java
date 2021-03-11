import java.util.ArrayList;

public class Criminal {
    private String bloodType;
    private String fingerprint;
    private String hairColor;
    private ArrayList<Integer> clothing;
    private double footSize;
    private String eyeColor;
    private boolean isAlive;
    private boolean tattoos;

public Criminal(String bloodType, String fingerprint, String hairColor, ArrayList<Integer> clothing, double footSize, String eyeColor, boolean isAlive, boolean tattoos)
{
    this.bloodType = bloodType;
    this.fingerprint = fingerprint;
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
    return fingerprint;
}

public String getHairColor() {
    return hairColor;
}

public <ArrayList> getClothing() {
    return clothing;
}

public double getFootSize() {
    return footSize;
}

public String getEyeColor() {
    return eyeColor;
}

public boolean isAlive(boolean isAlive) {
    return isAlive;
}

public String toString() {
    return bloodType+fingerPrint+hairColor+clothing+footSize+eyeColor+isAlive+tatoos;
}

private boolean tattoos(boolean tattoos) {
    return tattoos;
}



}