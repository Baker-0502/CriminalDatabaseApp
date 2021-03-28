/**
 * @author Code Gods
 */
import java.util.UUID;
public class Person {
    private UUID personID;
    private String firstName;
    private String lastName;
    private String gender;
    private String race;
    private int age;
    private double height;
    private double weight;
    private String phoneNumber;
    private String address;
    private String occupation;

    /**
     * 
     * @param personID unique person id
     * @param firstName person first name
     * @param lastName person last name
     * @param gender person gender
     * @param race person race
     * @param age person age
     * @param height person height
     * @param weight person weight
     * @param phoneNumber person phone number
     * @param address person address
     * @param occupation person occupation
     */
    public Person(UUID personID, String firstName, String lastName, String gender, String race, int age, double height, double weight, String phoneNumber, String address, String occupation) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.race = race;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.occupation = occupation;
    }

    /**
     * returning the person UUID
     */
    public UUID getUUID() {
        return personID;
    }

    /**
     * returning the persons first name
     * 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * returning the persons last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * returning the persons gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * returning the persons race
     */
    public String getRace() {
        return race;
    }

    /**
     * returning the persons age
     */
    public int getAge() {
        return age;
    }

    /**
     * returning the persons height
     */
    public double getHeight() {
        return height;
    }

    /**
     * returing the persons weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * returning the persons phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * returning the persons address
     */
    public String getAddress() {
        return address;
    }

    /**
     * returning the persons occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Returning the persons credentials
     */
    public String toString() {
        return "Person ID: "+personID+"\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nGender: "+gender+"\nRace: "+race+"\nAge: "+age+"\nHeight: "+
        height+"\nWeight: "+weight+"\nPhone Number: "+phoneNumber+"\nAddress: "+address+"\nOccupation: "+occupation;
    }
}
