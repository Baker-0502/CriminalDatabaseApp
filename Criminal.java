import java.util.ArrayList;
import java.util.UUID;
/**
 * information about the criminals in the database
 */
public class Criminal extends Person{
    private String bloodType;
    private String fingerPrint;
    private String hairColor;
    private ArrayList<String> clothing;
    private String footSize;
    private String eyeColor;
    private boolean isAlive;
    private ArrayList<String> tattoos;
/**
 * Criminal information 
 * @param personID criminal id
 * @param firstName firstname of criminal
 * @param lastName lastname of criminal
 * @param gender criminal gender
 * @param race criminal race
 * @param age age of criminal
 * @param height height of criminal
 * @param weight criminal weight
 * @param phoneNumber phonenumber of the criminal
 * @param address address of the criminal
 * @param occupation accupation of the criminal
 * @param bloodType crimial blood type
 * @param fingerprint criminal finger print
 * @param hairColor criminal hair color
 * @param clothing avaliable clothing of the criminal
 * @param footSize criminal footsize
 * @param eyeColor eye color of the criminal
 * @param isAlive is the criminal alive
 * @param tattoos criminal tatoos
 */
public Criminal(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation, String bloodType, String fingerprint, String hairColor, ArrayList<String> clothing, String footSize, String eyeColor, boolean isAlive, ArrayList<String> tattoos)
{
    super(personID, firstName, lastName, gender, race, age, height, weight, phoneNumber, address, occupation);
    this.bloodType = bloodType;
    this.fingerPrint = fingerprint;
    this.hairColor = hairColor;
    this.clothing = clothing;
    this.footSize = footSize;
    this.eyeColor = eyeColor;
    this.isAlive = isAlive;
    this.tattoos = tattoos;
}
/**
 * gets the blood type for the criminal
 * @return returns the blood type of the criminal
 */
public String getBloodType() {
    return bloodType;
}
/**
 * get the fingerprint of the criminal
 * @return return the fingerprint
 */
public String getFingerPrint() {
    return fingerPrint;
}
/**
 * gets the haircolor of the criminal
 * @return returns the hair color
 */
public String getHairColor() {
    return hairColor;
}
/**
 * list of provided clothing of the criminal
 * @return return provided clothing
 */
public ArrayList<String> getClothing() {
    return clothing;
}
/**
 * lists the footsize of the criminal
 * @return return the footsize
 */
public String getFootSize() {
    return footSize;
}
/**
 * the eye color of the criminal
 * @return return that eye color
 */
public String getEyeColor() {
    return eyeColor;
}
/**
 * checks if the criminal is alive
 * @return returns if the criminal is alive or not
 */
public boolean isAlive() {
    return isAlive;
}
/**
 * lists avaliable tattoos for the criminal
 * @return return the tattoos
 */
public ArrayList<String> getTattoos(){
    return this.tattoos;
}
/**
 * outputs all the information for the criminal
 * @return returns all the information for the criminal
 */
public String toString(){
    return super.toString()+"\nBlood Type: "+bloodType+"\nFinger Print: "+fingerPrint+"\nHair Color: "+hairColor+"\nClothing: "+clothing+
    "\nFoot Size: "+footSize+"\nEye Color: "+eyeColor+"\nAlive: "+isAlive+"\nTattoos: "+tattoos+"\n";
}



}