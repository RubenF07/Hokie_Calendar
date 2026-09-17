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
    // ----------------------------------------------------------
    /**
     * Create a new Day object.
     * @param date
     */
    public Day(int date)
    {
        this.date = date;
        listOfEvents = new ArrayList<Event>();
    }
    
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Adds an event to the day
     * @param e (new Event)
     * @return true if added successfully
     */
    public boolean addEvent(Event e)
    {
        listOfEvents.add(e);
        //orderEvents();
        return true;
    }
    
    // ----------------------------------------------------------
    /**
     * Removes an event from the day
     * @param e (event to be removed)
     * @return event removed
     */
    public Event deleteEvent(Event e)
    {
        listOfEvents.remove(e);
        return e;
    }
    
    // ----------------------------------------------------------
    /**
     * Get the numerical date of the day
     * @return date
     */
    public int getDate()
    {
        return date;
    }
    

    // ----------------------------------------------------------
    /**
     * Places events in order of start time throughout day
     * All day events shown first
     */
/*    
    public void orderEvents()
    {
        ArrayList<Event> tempTimed = new ArrayList<Event>();
        ArrayList<Event> tempUntimed = new ArrayList<Event>();
        Event curr;
        TimedEvent currTimedEvent;
        for(int i = 0; i < listOfEvents.size(); i++)
        {
            curr = listOfEvents.get(i);
            if(curr instanceof TimedEvent)
            {
                currTimedEvent = curr;
                tempTimed.add(curr);
                for(int j = 0; j < tempTimed.size(); j ++)
                {
                    
                    if((tempTimed..compareTo(tempTimed.get(j)) > 0)
                    {
                        
                    }
                                        
                    
                }
            }
            
        }
    }
*/    

}
