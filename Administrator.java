public class Administrator {
    private boolean updateCase;
    private String criminalName;
    private String policeName;
    private String detectiveName;

    public Administrator(boolean updateCase, String criminalName, String policeName, String detectiveName){
        this.updateCase = updateCase;
        this.criminalName = criminalName;
        this.policeName = policeName;
        this.detectiveName = detectiveName;
    }

    public void addCase(String caseName){

    }
    public void addCriminal(String criminalName){

    }
    public void addPolice(String policeName){

    }
    public void addDetective(String detectiveName){

    }
    public void caseName(String caseName){
        caseName = "";
    }
    public void updateCase(boolean updateCase){
        updateCase = true;
    }
    public String toString(){
        return policeName + criminalName + detectiveName + updateCase;
    }

    
}

