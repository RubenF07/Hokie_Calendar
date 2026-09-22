package calendar;
public class DispTest extends student.TestCase
{
    //~ Fields ................................................................
    private Display dis;
    private Month m;
  
    //~ Constructors ..........................................................
    public void setUp() {
        dis = new Display();
       m = new Month("August", 31, "Saturday");
    }   
  
    // ----------------------------------------------------------
    /**
     * To test the display method print month
     */
    public void testPrintMonth()
       {
           dis.printMonth(m);
       }
       
       // ----------------------------------------------------------
    /**
     * to test the display method print day
     */
    public void testPrintDay()
       {
       Day day = m.getDays()[10];
       
       Event e = new Event("Rest", "Hoge", true);
       day.addEvent(e);
       
       dis.printDay(day);
       }
  
}
