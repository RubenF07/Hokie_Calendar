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
     * Place a description of your method here.
     */
    public void testDisplay()
       {
           dis.printMonth(m);
       }
       
       // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testPrintDay()
       {
       Day day = m.getDays()[10];
       
       Event e = new Event("Rest", "nothing", "Hoge", true);
       day.addEvent(e);
       
       dis.printDay(day, m);
       dis.printMonth(m);
       }
  
}
