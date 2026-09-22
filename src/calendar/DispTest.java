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
  
   public void testDisplay()
   {
       dis.printMonth(m);
   }
  
   public void testPrint()
   {
       System.out.println("help meeee");
   }
}
