import java.util.ArrayList;
import java.util.UUID;

public class SuspectList {
    private ArrayList<Suspect> suspectList;
    private static SuspectList suspectListObj;

    public SuspectList(ArrayList<Suspect> suspectList){
        suspectList = new ArrayList<Suspect>();
    }
    public SuspectList() {
        this.suspectList = DataReader.loadSuspect();
    }

    public static SuspectList getInstance() {
        if(suspectListObj == null) {
            suspectListObj = new SuspectList();
        }

        return suspectListObj;
    }

    public Suspect findSuspect(UUID id){
        
    }
}
