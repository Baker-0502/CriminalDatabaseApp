public class PersonOfInterest extends Person{
    private String hairColor;
    private String eyeColor;
    private String reasonofInterest;
    private String avaliableDetails;

public PersonOfInterest(String firstName, String lastName, int age, double height, double weight, String phoneNumber, String address, String occupation, String hairColor, String eyeColor, String reasonofInterest, String avaliableDetails)
{
    super(firstName, lastName, age, height, weight, phoneNumber, address, occupation);
    this.hairColor = hairColor;
    this.eyeColor = eyeColor;
    this.reasonofInterest = reasonofInterest;
    this.avaliableDetails = avaliableDetails;
}

public String getHairColor() {
    return hairColor;
}

public String getEyeColor() {
    return eyeColor;
}

public String getReasonofInterest() {
    return reasonofInterest;
}

public String getAvaliableDetails() {
    return avaliableDetails;
}

public String toString(){
    return super.toString()+"\nHair Color: "+hairColor+"\nEye Color: "+eyeColor+"\nReason of Interest: "
    +reasonofInterest+"\nAvaliable Details: "+avaliableDetails+"\n";
}
}