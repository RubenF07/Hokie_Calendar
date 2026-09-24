package calendar;
import java.lang.Character;

public class Display
{
   // ----------------------------------------------------------
   /**
    * Print month calendar based on input.
    * Example:
    *
       ----------------------------
       | August 2026 :))           |
       |---------------------------|
       |Sun|Mon|Tue|Wed|Thu|Fri|Sat|
       |---------------------------|
       | X | X | X | X | X | X |01 |
       |02 |03 |04 |05 |06 |07 |08 |
       -----------------------------
    * @param month
    */

   public Display(){}


    /**
     * Place a description of your method here.
     * @param month
     */
    public void printMonth(Month month) {
       String ANSI_RED = "\u001B[31m";
       String ANSI_RESET = "\033[0m";
       //String ANSI_GREEN = "\u001B[32m";
       //String ANSI_ORANGE = "\u001B[33m";
       String outerDivider = "-----------------------------";
       String innerDivider = "|---------------------------|";

       System.out.println(" ");
       System.out.println(outerDivider);
       
       String emoji = "🦃";
       
       switch(month.getMonth()){
           case ("October"):
               emoji = "🎃👻🍬💀";
           case ("November"):
               emoji = "☕🍂🧺🧸";
           case ("December"):
               emoji = "❄️☃️🍫☕️";
           case ("January"):
               emoji = "🧊☃️🧤❄️";
           case ("February"):
               emoji = "🍓🍰💌🧸";
           case ("March"):
               emoji = "🐰🐇🐣🌷";
           case ("April"):
               emoji = "🌞🐝🌸☂";
           case ("May"):
               emoji = "🌴🍹🍉⛱️";
       }
       
       String titleText = month.getMonth() + " 2026 " + emoji;
       System.out.printf("| %-25s |\n", titleText);

       System.out.println(innerDivider);
       System.out.println("|Sun|Mon|Tue|Wed|Thu|Fri|Sat|");
       System.out.println(innerDivider);
       // Grid Rows
       int startDayIndex = 0;
       switch(month.getStartWeekDay()){
           case ("Monday"):
               startDayIndex = 1;
               break;
           case ("Tuesday"):
               startDayIndex = 2;
               break;
           case ("Wednesday"):
               startDayIndex = 3;
               break;
           case ("Thursday"):
               startDayIndex = 4;
               break;
           case ("Friday"):
               startDayIndex = 5;
               break;
           case ("Saturday"):
               startDayIndex = 6;
       }
       int totalDays = month.getNumDays();  // e.g., 31 for August

       int currentColumn = 0;
       System.out.print("|");
       // Print leading X's for days before the 1st
       for (int i = 0; i < startDayIndex; i++) {
           System.out.print("   |");
           currentColumn++;
       }
       // Print month days
       for (int d = 1; d <= totalDays; d++) {
           String ansi_color = "\u001B[0m"; //reset color
           if (month.getDays()[d-1].containEvent()) {
               ansi_color = ANSI_RED;
           }
           System.out.printf(ansi_color + "%02d " + ANSI_RESET + "|", d);
           currentColumn++;
           // Wrap to the next line after Saturday (7 columns)
           if (currentColumn == 7 && d != totalDays) {
               System.out.println();
               System.out.print("|");
               currentColumn = 0;
           }
       }
       // Pad remaining empty cells in the final row with X's
       while (currentColumn > 0 && currentColumn < 7) {
           System.out.print("   |");
           currentColumn++;
       }
       // 5. Bottom border
       System.out.println();
       System.out.println(outerDivider);
   }




   // ----------------------------------------------------------
    /**
     * Print event list based on inputed Day
     * @param d
     *      day
     * @param m
     *      month
     * @return 
     *      list of event string
     */
    public String printDay(Day d, Month m) {
       String result = "\n"+m.getMonth()+" "+d.getDate();
       result += "\n-----------";
       if (d.getListOfEvents().size() == 0) {
           result += "NO EVENTS TODAY";
       }
       result += d.printEvents();
       result += " ";
       return result;
   }

   // ----------------------------------------------------------
    /**
     * Print event.
     * @param e 
     *      event object
     * @return 
     *      event string
     */     
    public String printEvent(Event e) {
        return "\n"+e;
   }


}
