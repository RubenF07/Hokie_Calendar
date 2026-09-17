package calendar;

import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Creates a day object that contains and manages events for a specific day
 * 
 * @author Ruben Finkel
 * @version Sep 17, 2026
 */
public class Main {
    public static Calendar calendar;
    public static Display disp;
    public static Scanner input;
    

    public static void main(String[] args) {
        calendar = new Calendar();
        input = new Scanner(System.in);
        disp = new Display();


        System.out.println("Welcome to Hokie Calendar!");
        System.out.println("--------------------------\n");
        mainMenu();
    }
    
    public static void mainMenu(){
        Month[] months = calendar.getMonths();
        System.out.println("Which month would you like to view?");
        for(int i=0; i<months.length; i++){
            System.out.println("" + (i+1) + ": " + months[i]);
        }
        System.out.println("0: Exit");
        System.out.println("");
        
        int userInput = input.nextInt();
        
        while(userInput != 0){
            if (userInput > months.length){
                System.out.println("Invalid Input. Try again:\n");
                
                userInput = input.nextInt();
                continue;
            }

            // get the chosen month
            monthMenu(months[userInput-1]);

            // Re-prompt
            System.out.println("\nMain Menu");
            System.out.println("---------\n");
            System.out.println("Which month would you like to view?");
            for(int i=0; i<months.length; i++){
                System.out.println("" + (i+1) + ": " + months[i]);
            }
            System.out.println("0: Exit\n");
            
            userInput = input.nextInt();

        }

        input.close();
    }

    public static void monthMenu(Month month){
        disp.printMonth(month);

        // get month operation
        System.out.println("Which option would you like:");
        System.out.println("1: Select Day");
        System.out.println("2: Go Back\n");
        
        int userInput = input.nextInt();
        while(userInput != 2){
            while(userInput != 1 && userInput != 2 ){
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }
            if(userInput == 2){ // Back to menu
                return;
            }
            
            // Get day
            Day[] days = month.getDays();
            System.out.println("Enter the day you would like to expand:\n");
            
            userInput = input.nextInt();
            
            while(!(userInput>0 && userInput<=days.length)){
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }
            
            dayMenu(days[userInput-1]);

            // Re-prompt
            disp.printMonth(month);

            // get month operation
            System.out.println("Which option would you like:");
            System.out.println("1: Select Day");
            System.out.println("2: Go Back\n");
        }
    }
    
    public static void dayMenu(Day day){
        System.out.println("Day Menu Placeholder");
        System.out.println("\npress enter");

        input.nextLine();

    }

}
