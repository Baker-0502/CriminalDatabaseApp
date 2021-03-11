import java.util.ArrayList;

public class PersonList {
    private ArrayList<Integer> criminalList; 
    private ArrayList<Integer> witnessList;
    private ArrayList<Integer> suspectList;
    private ArrayList<Integer> victimList;
    private ArrayList<Integer> poiList;


public PersonList(ArrayList<Integer> criminalList, ArrayList<Integer> witnessList, private ArrayList<Integer> suspectList, private ArrayList<Integer> victimList, ArrayList<Integer> poiList)
{
    this.criminalList = criminalList;
    this.witnessList = witnessList;
    this.suspectList = suspectList;
    this.victimList = victimList;
    this.poiList = poiList;
}
}