public class Administrator {
    private boolean updateCase;
    
    public Administrator(boolean updateCase){
        this.updateCase = updateCase;
       
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

