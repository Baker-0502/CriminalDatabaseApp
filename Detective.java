public class Detective {
    private String associate;
    private String department;

    public Detective(String associate, String department){
        this.associate = associate;
        this.department = department;
    }

    public void addWitnessStatement(String witnessStatement){

    }

    public void addAssociate(String associate){

    }

    public void addReport(String report){

    }

    public void addEvidence(String evidence){

    }

    public void updateDepartment(String department){

    }

    public String toString(){
        return department + associate;
    }
}
