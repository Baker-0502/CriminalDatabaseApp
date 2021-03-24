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

    public UUID getUUID() {
        return personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getOccupation() {
        return occupation;
    }

    public String toString() {
        return "Person ID: "+personID+"\nFirst Name: "+firstName+"\nLast Name: "+lastName+"\nGender: "+gender+"\nRace: "+race+"\nAge: "+age+"\nHeight: "+
        height+"\nWeight: "+weight+"\nPhone Number: "+phoneNumber+"\nAddress: "+address+"\nOccupation: "+occupation;
    }
}
