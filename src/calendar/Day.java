package calendar;
import java.util.ArrayList;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author Sarah
 *  @version Sep 17, 2026
 */
public class Day
{
    //~ Fields ................................................................
    private ArrayList<Event> listOfEvents;
    private int date;
    
    //~ Constructors ..........................................................
    public Day(int date)
    {
        this.date = date;
        listOfEvents = new ArrayList<Event>();
    }
    
    //~Public  Methods ........................................................
    public boolean addEvent(Event e)
    {
        listOfEvents.add(e);
        //orderEvents();
        return true;
    }
    
    public Event deleteEvent(Event e)
    {
        listOfEvents.remove(e);
        return e;
    }
    
    public int getDate()
    {
        return date;
    }
    
/*
    public void orderEvents()
    {
        ArrayList<Event> tempTimed = new ArrayList<Event>();
        ArrayList<Event> tempUntimed = new ArrayList<Event>();
        Event curr;
        for(int i = 0; i < listOfEvents.size(); i++)
        {
            curr = listOfEvents.get(i);
            if(curr instanceof TimedEvent)
            {
                tempTimed.add(curr);
                for(int j = 0; j < tempTimed.size(); j ++)
                {
                    
                    if((curr.getStartTime())compareTo(tempTimed.get(j)))
                                        
                    
                }
            }
            
        }
    }
*/
}
