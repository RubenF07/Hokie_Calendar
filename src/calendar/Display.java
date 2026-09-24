package calendar;
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
       //String ANSI_GREEN = "\u001B[32m";
       //String ANSI_ORANGE = "\u001B[33m";
       String outerDivider = "-----------------------------";
       String innerDivider = "|---------------------------|";

       System.out.println(" ");
       System.out.println(outerDivider);


       String titleText = month.getMonth() + " 2026 :)";
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
           System.out.printf(ansi_color + "%02d |", d);
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
     * Place a description of your method here.
     */
    public void printDay(Day d, Month m) {
       System.out.println("\n"+m.getMonth()+" "+d.getDate());
       System.out.println("-----------");
       if (d.getListOfEvents().size() == 0) {
           System.out.println("NO EVENTS TODAY");
       }
       d.printEvents();
       System.out.println(" ");
   }

   // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void printEvent(Event e) {
        System.out.println("\n"+e);
   }


}
