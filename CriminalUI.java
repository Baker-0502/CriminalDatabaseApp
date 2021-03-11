import java.util.Scanner;

public class CriminalUI {
    private CriminalDatabaseApplication application;

    public void run(){
        System.out.println("running");
    }

    public void displayLogin(){
        System.out.println("displaying login");
    }

    public void displayMenu(){
        System.out.println("displaying menu");
    }

    public void displayAddCase(){
        System.out.println("adding case");
    }

    public void displayCases(){
        System.out.println("displaying cases");
    }

    public static void main(String[] args)
    {
        CriminalUI driver = new CriminalUI();
        driver.run();
    }
}
