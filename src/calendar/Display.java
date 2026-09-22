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
  
  
   public void printMonth(Month month) {
       String ANSI_RED = "\u001B[31m";
       //String ANSI_GREEN = "\u001B[32m";
       //String ANSI_ORANGE = "\u001B[33m";
       String outerDivider = "-----------------------------";
       String innerDivider = "|---------------------------|";
       // 1. Top border
       System.out.println(outerDivider);
       // 2. Month Title Header
       // %-26s left-aligns the text within a fixed 26-character width
       String titleText = month.getMonth() + " 2026 :)";
       System.out.printf("| %-25s |\n", titleText);
       // 3. Day Names Header
       System.out.println(innerDivider);
       System.out.println("|Sun|Mon|Tue|Wed|Thu|Fri|Sat|");
       System.out.println(innerDivider);
       // 4. Grid Rows
       int startDayIndex = 0;
       switch(month.getStartWeekDay()){
           case ("Monday"):
               startDayIndex = 1;
           case ("Tuesday"):
               startDayIndex = 2;
           case ("Wednesday"):
               startDayIndex = 3;
           case ("Thursday"):
               startDayIndex = 4;
           case ("Friday"):
               startDayIndex = 5;
           case ("Saturday"):
               startDayIndex = 6;
       }
       int totalDays = month.getNumDays();  // e.g., 31 for August
      
       int currentColumn = 0;
       System.out.print("|");
       // Print leading X's for days before the 1st
       for (int i = 0; i < startDayIndex; i++) {
           System.out.print(" X |");
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
           System.out.print(" X |");
           currentColumn++;
       }
       // 5. Bottom border
       System.out.println();
       System.out.println(outerDivider);
   }
      
  
  
 
   //~Public  Methods ........................................................
   /*public void printDay() {
       //code
   }
  
   public void printEvent() {
       //code
   }*/
  
  
}
