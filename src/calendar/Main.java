package calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * Entry point for Hokie Calendar. Runs the console menu system for managing
 * events.
 *
 * @author Ruben Finkel
 * @version Sep 21, 2026
 */
public class Main {
    public static Calendar calendar;
    public static Display disp;
    public static Scanner input;

    /**
     * Sets up the calendar, loads the static VT events, starts the main menu.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        calendar = new Calendar();
        input = new Scanner(System.in);
        disp = new Display();

        parseStaticEvents(calendar);

        System.out.println("Welcome to Hokie Calendar!");
        System.out.println("--------------------------\n");
        mainMenu();
    }


    /**
     * Displays the list of months and prompts the user to pick one to view.
     * Loops until the user exits
     */
    public static void mainMenu() {
        Month[] months = calendar.getYear();
        System.out.println("Which month would you like to view?");

        for (int i = 0; i < months.length; i++) {
            System.out.println("" + (i + 1) + ": " + months[i].getMonth());
        }
        System.out.println("0: Exit\n");

        int userInput = input.nextInt();

        while (userInput != 0) {
            if (userInput > months.length || userInput < 0) {
                System.out.println("Invalid Input. Try again:\n");

                userInput = input.nextInt();
                continue;
            }

            // get the chosen month
            monthMenu(months[userInput - 1]);

            // Re-prompt
            System.out.println("\nMain Menu");
            System.out.println("---------\n");
            System.out.println("Which month would you like to view?");
            for (int i = 0; i < months.length; i++) {
                System.out.println("" + (i + 1) + ": " + months[i].getMonth());
            }
            System.out.println("0: Exit\n");

            userInput = input.nextInt();

        }

        input.close();
    }


    /**
     * Displays the given month and lets the user select a day to expand.
     * Returns to the main menu when the user chooses to go back.
     *
     * @param month
     *            the month to display
     */
    public static void monthMenu(Month month) {
        disp.printMonth(month);

        // get month operation
        System.out.println("Which option would you like:");
        System.out.println("1: Select Day");
        System.out.println("0: Go Back\n");

        int userInput = input.nextInt();
        while (userInput != 0) {
            while (userInput != 1 && userInput != 0) {
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }
            if (userInput == 0) { // Back to menu
                return;
            }

            // Get day
            Day[] days = month.getDays();
            System.out.println("Enter the day you would like to expand:\n");

            userInput = input.nextInt();

            while (!(userInput > 0 && userInput <= days.length)) {
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }

            dayMenu(days[userInput - 1], month);

            // Re-prompt
            disp.printMonth(month);

            // get month operation
            System.out.println("Which option would you like:");
            System.out.println("1: Select Day");
            System.out.println("0: Go Back\n");

            userInput = input.nextInt();
        }
    }


    /**
     * Displays a single day and lets the user view, edit, add, or remove
     * events. VT events are read-only
     * Only custom events can be edited or removed.
     *
     * @param day
     *            the day to display
     * @param month
     *            the month containing the day
     */
    public static void dayMenu(Day day, Month month) {
        disp.printDay(day, month);
        ArrayList<Event> events = day.getListOfEvents();

        // get day operation
        System.out.println("Which option would you like:");
        System.out.println("1: View Event Details");
        System.out.println("2: Edit Event");
        System.out.println("3: Add All-Day Event");
        System.out.println("4: Add Timed Event");
        System.out.println("5: Remove Event");
        System.out.println("0: Go Back\n");

        int userInput = input.nextInt();
        while (userInput != 0) {
            while (!(userInput >= 0 && userInput <= 5)) {
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }
            if (userInput == 0) { // Back to menu
                return;
            }

            int mutableCount = 0;
            for (Event event : events) {
                if (event.getMutability()) {
                    mutableCount++;
                }
            }

            int eventIdx = -1;
            switch (userInput) {
                case 1:
                    if (events.size() == 0) {
                        System.out.println("\nNo events available.\n");
                        break;
                    }
                    eventIdx = inputEventIdx(events);
                    disp.printEvent(events.get(eventIdx));
                    break;
                case 2:
                    if (mutableCount == 0) {
                        System.out.println("\nNo custom events available.\n");
                        break;
                    }
                    eventIdx = inputEventIdx(events);
                    if (!events.get(eventIdx).getMutability()) {
                        System.out.println(
                            "\nInvalid operation. VT events cannot be edited\n");
                        break;
                    }
                    eventEditMenu(events.get(eventIdx));
                    break;
                case 3:
                    addEventMenu(events);
                    break;
                case 4:
                    addTimedEventMenu(events);
                    break;
                case 5:
                    if (mutableCount == 0) {
                        System.out.println("\nNo custom events available.\n");
                        break;
                    }
                    eventIdx = inputEventIdx(events);
                    if (!events.get(eventIdx).getMutability()) {
                        System.out.println(
                            "\nInvalid operation. VT events cannot be edited\n");
                        break;
                    }
                    day.deleteEvent(events.get(eventIdx));
                    break;
                default:
                    break;
            }

            // Re-prompt
            disp.printDay(day, month);

            // get day operation
            System.out.println("Which option would you like:");
            System.out.println("1: View Event Details");
            System.out.println("2: Edit Event");
            System.out.println("3: Add All-Day Event");
            System.out.println("4: Add Timed Event");
            System.out.println("5: Remove Event");
            System.out.println("0: Go Back\n");

            userInput = input.nextInt();
        }
    }


    /**
     * Lists the given events and prompts the user to select one.
     *
     * @param events
     *            the events to choose from
     * @return the index of the selected event
     */
    public static int inputEventIdx(ArrayList<Event> events) {
        System.out.println("\nEvents");
        System.out.println("------");

        for (int i = 0; i < events.size(); i++) {
            System.out.println("" + (i + 1) + ": " + events.get(i).getTitle());
        }

        System.out.println("\nWhich event would you like to select: ");
        int userInput = input.nextInt();
        while (!(userInput >= 1 && userInput <= events.size())) {
            System.out.println("Invalid Input. Try again:\n");
            userInput = input.nextInt();
        }

        return userInput - 1;
    }


    /**
     * Displays an event and lets the user change its title, description, or
     * location. Returns when the user chooses to go back.
     *
     * @param event
     *            the event to edit
     */
    public static void eventEditMenu(Event event) {
        disp.printEvent(event);

        // get event operation
        System.out.println("Which option would you like:");
        System.out.println("1: Change Title");
        System.out.println("2: Change Description");
        System.out.println("3: Change Location");
        System.out.println("0: Go Back\n");

        int userInput = input.nextInt();
        while (userInput != 0) {
            while (!(userInput >= 0 && userInput <= 3)) {
                System.out.println("Invalid Input. Try again:\n");
                userInput = input.nextInt();
            }
            if (userInput == 0) { // Back to menu
                return;
            }

            String fieldVal = "";
            switch (userInput) {
                case 1:
                    System.out.println("Enter new title:\n");
                    input.nextLine();
                    fieldVal = input.nextLine();
                    event.setTitle(fieldVal);
                    break;
                case 2:
                    System.out.println("Enter new description:\n");
                    input.nextLine();
                    fieldVal = input.nextLine();
                    event.setDescription(fieldVal);
                    break;
                case 3:
                    System.out.println("Enter new location:\n");
                    input.nextLine();
                    fieldVal = input.nextLine();
                    event.setLocation(fieldVal);
                    break;
                default:
                    break;
            }

            // Re-prompt
            disp.printEvent(event);

            // get event operation
            System.out.println("Which option would you like:");
            System.out.println("1: Change Title");
            System.out.println("2: Change Description");
            System.out.println("3: Change Location");
            System.out.println("0: Go Back");

            userInput = input.nextInt();
        }
    }


    /**
     * Prompts the user for a title, description, and location, then adds a
     * new event to the list.
     *
     * @param events
     *            the list of events to add to
     */
    public static void addEventMenu(ArrayList<Event> events) {
        String title;
        String description;
        String location;

        input.nextLine();
        System.out.println("Enter event title:");
        title = input.nextLine();

        System.out.println("Enter event description:");
        description = input.nextLine();

        System.out.println("Enter event location:");
        location = input.nextLine();

        events.add(new Event(title, description, location, true));
    }


    /**
     * Prompts the user for a title, description, location, start time, and
     * end time, then adds a new timed event to the list.
     *
     * @param events
     *            the list of events to add to
     */
    public static void addTimedEventMenu(ArrayList<Event> events) {
        String title;
        String description;
        String location;

        Time start;
        Time end;

        input.nextLine();
        System.out.println("Enter event title:");
        title = input.nextLine();

        System.out.println("Enter event description:");
        description = input.nextLine();

        System.out.println("Enter event location:");
        location = input.nextLine();

        System.out.println("Enter event start time (format: 03:12pm):");
        start = inputTime(null);

        System.out.println("Enter event end time (format: 03:12pm):");
        end = inputTime(start);

        events.add(new TimedEvent(title, description, location, true, start,
            end));
    }


    /**
     * Reads a time from the user in the format hh:mmam or hh:mmpm
     * Re-prompts until the input is valid.
     *
     * @param min
     *            the start time the result must not precede, or null if there
     *            is no lower bound
     * @return the validated time
     */
    public static Time inputTime(Time min) {
        String timeStr = input.nextLine();
        boolean valid = false;

        int hour = 0;
        int minute = 0;
        Boolean am = true;

        Time res = null;

        while (!valid) {
            if ((timeStr.length() != 7) || (timeStr.charAt(2) != ':')
                || (timeStr.charAt(5) != 'a' && timeStr.charAt(5) != 'p')) {
                System.out.println("Invalid Input. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }
            if (timeStr.charAt(6) != 'm') {
                System.out.println("Invalid Input. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }

            try {
                hour = Integer.parseInt(timeStr.substring(0, 2));
                minute = Integer.parseInt(timeStr.substring(3, 5));
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid Input. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }

            if (hour < 1 || hour > 12) {
                System.out.println("Invalid Input. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }
            if (minute < 0 || minute > 59) {
                System.out.println("Invalid Input. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }

            am = (timeStr.charAt(5) == 'a');

            res = new Time(hour, minute, am);
            if (min != null && min.compareTo(res) == -1) {
                System.out.println(
                    "End time must be after the start. Try again:\n");
                timeStr = input.nextLine();
                continue;
            }

            valid = true;
        }

        return res;
    }


    /**
     * Loads the built-in VT events from the "staticEvents" file
     *
     * @param cal
     *            the calendar to add the events to
     */
    private static void parseStaticEvents(Calendar cal) {
        Month[] months = cal.getYear();
        try {
            File file = new File("staticEvents");
            Scanner scanner = new Scanner(file);

            while (true) {
                String title = scanner.nextLine();
                if (title.equals("*END*")) {
                    break;
                }
                String description = scanner.nextLine();
                String location = scanner.nextLine();
                int monthIdx = scanner.nextInt();
                int day = scanner.nextInt();
                scanner.nextLine();

                // Create event
                Event hokieEvent = new Event(title, description, location,
                    false);

                // Add to correct day
                months[monthIdx].getDays()[day - 1].addEvent(hokieEvent);
            }
            scanner.close();

        }
        catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }
        catch (NumberFormatException e) {
            System.err.println(
                "Error parsing integers from file. Check number formats.");
        }
    }
}
