package calendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 


/* // -------------------------------------------------------------------------
/**
 *  A file with information on month, days and start week day is used, 
 *  Calendar initiates the school year and includes the display class
 * 
 *  @author Tiffany
 *  @version Sep 17, 2026
 */

@SuppressWarnings("javadoc")
public class Calendar {
 // Instance variables 
    private Month[] fullCalendar;
    private Display display;

    // Default constructor: Initializes 10 Month objects for 2026
    public Calendar() {
        this.fullCalendar = new Month[10];
        this.display = new Display();
        
        try {
            File file = new File("monthinfo");
            Scanner scanner = new Scanner(file);
            
            int index = 0;
            
            while (scanner.hasNext() && index < 10) {
                String monthName = scanner.next();
                int numDays = scanner.nextInt();                
                String startWeekDay = scanner.next();
                
                fullCalendar[index] = new Month(monthName, numDays, startWeekDay);
                index++;
            }
            scanner.close();
            
        }catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }catch (NumberFormatException e) {
            System.err.println("Error parsing integers from file. Check number formats.");
        }
        
    }
        
        

    // Getter for the full array
    public Month[] getYear() {
        return fullCalendar;
    }


    // Prints the entire year 
    public void printYear() {
        for (Month month : fullCalendar) {
            display.printMonth(month);
             //Spacing between months
            System.out.println();
        }
    }
}
