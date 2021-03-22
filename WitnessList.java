import java.util.ArrayList;
import java.util.UUID;

public class WitnessList {
    private ArrayList<Witness> witnessList;
    private static WitnessList witnessListObj;

    public WitnessList(ArrayList<Witness> witnessList){
        witnessList = new ArrayList<Witness>();
    }
    public WitnessList() {
        this.witnessList = DataReader.loadWitness();
    }

    public static WitnessList getInstance() {
        if(witnessListObj == null) {
            witnessListObj  = new WitnessList();
        }

        return witnessListObj;
    }

    public Witness findWitness(UUID id){
        
    }
}
