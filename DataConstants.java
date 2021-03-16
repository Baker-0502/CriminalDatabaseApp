public abstract class DataConstants {
    //Files
    protected static final String ADMINISTRATOR_FILE_NAME = "json/Administrator.json";
    protected static final String CASES_FILE_NAME = "json/Cases.json";
    protected static final String CRIMINALS_FILE_NAME = "json/Criminals.json";
    protected static final String DETECTIVES_FILE_NAME = "json/Detectives.json";
    protected static final String EVIDENCE_FILE_NAME = "json/Evidence.json";
    protected static final String PERSONS_OF_INTEREST_FILE_NAME = "json/PersonsOfInterest.json";
    protected static final String POLICEMEN_FILE_NAME = "json/Policemen.json";
    protected static final String SUSPECTS_FILE_NAME = "json/Suspects.json";
    protected static final String VICTIMS_FILE_NAME = "json/Victims.json";
    protected static final String WITNESSES_FILE_NAME = "json/Witnesses.json";
    //User vars are used by Admins, Detectives, and Officers.
    protected static final String USER_USER_ID = "userID";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USERNAME = "userName";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PHONE_NUMBER = "phoneNumber";
    protected static final String USER_DEPARTMENT = "department";
    //Specific user keys
    protected static final String ADMINISTRATOR_UPDATE_CASE = "updateCase";
    protected static final String DETECTIVE_ASSOCIATE = "associate";
    protected static final String POLICEMEN_BADGE_ID = "badgeID";
    protected static final String POLICEMEN_CASE_COUNT = "caseCount";
    protected static final String POLICEMEN_EDIT_ACCESS = "editAccess";
    //People vars are used by Witnesses, PersonsOfInterest, Suspects, Victims, Criminals
    protected static final String PERSON_ID = "personID";
    protected static final String PERSON_FIRST_NAME = "firstName";
    protected static final String PERSON_LAST_NAME = "lastName";
    protected static final String PERSON_GENDER = "gender";
    protected static final String PERSON_RACE = "race";
    protected static final String PERSON_AGE = "age";
    protected static final String PERSON_HEIGHT = "height";
    protected static final String PERSON_WEIGHT = "weight";
    protected static final String PERSON_PHONE_NUMBER = "phoneNumber";
    protected static final String PERSON_ADDRESS = "address";
    protected static final String PERSON_OCCUPATION = "occupation";
    //Specific person keys
    protected static final String WITNESS_RELATIONSHIP = "relationship";
    protected static final String WITNESS_STATEMENT = "statement";
    protected static final String PERSON_OF_INTEREST_HAIR_COLOR = "hairColor";
    protected static final String PERSON_OF_INTEREST_EYE_COLOR = "eyeColor";
    protected static final String PERSON_OF_INTEREST_REASON_OF_INTEREST = "reasonOfInterest";
    protected static final String PERSON_OF_INTEREST_AVAILABLE_DETAILS = "availableDetails";
    protected static final String SUSPECT_BLOOD_TYPE = "bloodType";
    protected static final String SUSPECT_FINGERPRINT = "fingerprint";
    protected static final String SUSPECT_HAIR_COLOR = "hairColor";
    protected static final String SUSPECT_CLOTHING = "clothing";
    protected static final String SUSPECT_FOOT_SIZE = "footSize";
    protected static final String SUSPECT_EYE_COLOR = "eyeColor";
    protected static final String SUSPECT_DETAILS = "details";
    protected static final String VICTIM_RELATIONSHIP = "relationship";
    protected static final String VICTIM_STATEMENT = "statement";
    protected static final String CRIMINAL_BLOOD_TYPE = "bloodType";
    protected static final String CRIMINAL_FINGERPRINT = "fingerprint";
    protected static final String CRIMINAL_HAIR_COLOR = "hairColor";
    protected static final String CRIMINAL_CLOTHING = "clothing";
    protected static final String CRIMINAL_FOOT_SIZE = "footSize";
    protected static final String CRIMINAL_EYE_COLOR = "eyeColor";
    protected static final String CRIMINAL_IS_ALIVE = "isAlive";
    protected static final String CRIMINAL_TATTOOS = "tattoos";
    //Evidence vars
    protected static final String EVIDENCE_EVIDENCE_ID = "evidenceID";
    protected static final String EVIDENCE_EVIDENCE_TYPE = "evidenceType";
    protected static final String EVIDENCE_LOCATION_FOUND = "locationFound";
    //Cases vars
    protected static final String CASE_ID = "caseID";
    protected static final String CASE_CLOSED_CASE = "closedCase";
    protected static final String CASE_NAME = "caseName";
    protected static final String CASE_UPDATE_CASE = "updateCase";
    protected static final String CASE_FEDERAL_CASE = "federalCase";
    protected static final String CASE_MISDEMEANOR = "misdemeanor";
    protected static final String CASE_CATEGORY = "category";
    protected static final String CASE_USER_WORKING = "userWorking";
    protected static final String CASE_SUSPECTS = "suspects";
    protected static final String CASE_WITNESSES = "witnesses";
    protected static final String CASE_EVIDENCE_LIST = "evidenceList";

}
