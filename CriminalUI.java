import java.util.Scanner;

public class CriminalUI {
    private CriminalDatabaseApplication application;
    private static final String WELCOME_MESSAGE = "Welcome to Criminal Database";
    private String[] mainMenuOptions = {"Create Account","Login","Exit"};

    public void run(){
        System.out.println(WELCOME_MESSAGE);
        while(true){
            displayMenu();
        }
    }

    public void displayLogin(){
        System.out.println("displaying login");
    }

    public void displayMenu(){
        System.out.println("displaying menu");
        for(int i=0; i<mainMenuOptions.length;i++)
        {
            System.out.println((i+1) + ". "+mainMenuOptions[i]);
        }
        System.out.println("\n");
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
