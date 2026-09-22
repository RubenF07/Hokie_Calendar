package calendar;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Sarah
 * @version Sep 17, 2026
 */
public class Day
{
    // ~ Fields ................................................................
    private ArrayList<Event> listOfEvents;
    private int date;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Day object.
     * 
     * @param date
     */
    public Day(int date)
    {
        this.date = date;
        listOfEvents = new ArrayList<Event>();
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Adds an event to the day
     * 
     * @param e
     *            (new Event)
     * @return true if added successfully
     */
    public boolean addEvent(Event e)
    {
        listOfEvents.add(e);
        orderEvents();
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Removes an event from the day
     * 
     * @param e
     *            (event to be removed)
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
     * 
     * @return date
     */
    public int getDate()
    {
        return date;
    }


    // ----------------------------------------------------------
    /**
     * Places events in order of start time throughout day. All day events shown
     * first
     */

    private void orderEvents()
    {
        // Initializes two temporary branches to sort
        ArrayList<TimedEvent> tempTimed = new ArrayList<TimedEvent>();
        ArrayList<Event> tempUntimed = new ArrayList<Event>();
        ArrayList<Event> newList = new ArrayList<Event>();
        TimedEvent currTimedEvent;
        int nextIndex = 0;
        boolean found;
        int compare;

        for (int i = 0; i < listOfEvents.size(); i++)
        {
            // if event is timed find the index of the first time after the
            // event and add event there
            if (listOfEvents.get(i) instanceof TimedEvent)
            {
                found = false;
                currTimedEvent = (TimedEvent)listOfEvents.get(i);

                for (int j = 0; j < tempTimed.size(); j++)
                {
                    while (!found)
                    {
                        compare = currTimedEvent.getStart()
                            .compareTo(tempTimed.get(j).getStart());
                        if (compare >= 0)
                        {
                            nextIndex = j;
                            found = true;
                        }

                    }
                }
                tempTimed.add(nextIndex, currTimedEvent);

            }
            // if event is not timed add to untimed list
            else if (listOfEvents.get(i) != null)
            {
                tempUntimed.add(listOfEvents.get(i));
            }
        }
        // combine timed and untimed list to hold all timed events in order
        // followed by untimed events
        for (int i = 0; i < tempTimed.size(); i++)
        {
            newList.add(tempTimed.get(i));
        }
        for (int i = 0; i < tempUntimed.size(); i++)
        {
            newList.add(tempUntimed.get(i));
        }

        listOfEvents = newList;

    }


    // ----------------------------------------------------------
    /**
     * Get the list of events for the day
     * 
     * @return listOfEvents
     */
    public ArrayList<Event> getListOfEvents()
    {
        return listOfEvents;
    }


    public String toString()
    {
        String result = "";
        for (int i = 0; i < listOfEvents.size(); i++)
        {
            result += listOfEvents.get(i) + "\n";
        }
        return result;

    }


    // ----------------------------------------------------------
    /**
     * added on for display sake. returns whether the day has events or not
     * 
     * @return listOfEvents.size() != 0
     */
    public boolean containEvent()
    {
        return listOfEvents.size() != 0;
    }


    // ----------------------------------------------------------
    /**
     * for display
     */
    public void printEvents()
    {
        for (Event event : listOfEvents)
        {
            System.out.println(event.toString());
            // Spacing between months
            // System.out.println();
        }
    }

}
