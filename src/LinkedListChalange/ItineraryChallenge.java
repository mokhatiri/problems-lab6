package LinkedListChalange;

import java.util.*;

public class ItineraryChallenge {
    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        // same example from course
        addPlace(placesToVisit, new Place("Adelaide", 1374));
        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));
        addPlace(placesToVisit, new Place("Perth", 3923));
        addPlace(placesToVisit, new Place("Sydney", 0));

        visit(placesToVisit);
    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        // Prevent duplicates and insert in order
        ListIterator<Place> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (current.name().equalsIgnoreCase(place.name())) {
                System.out.println(place.name() + " already exists, not added.");
                return;
            } else if (current.distanceFromStart() > place.distanceFromStart()) {
                iterator.previous();
                iterator.add(place);
                return;
            }
        }
        iterator.add(place);
    }

    private static void visit(LinkedList<Place> places) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<Place> iterator = places.listIterator();
        if (places.isEmpty()) {
            System.out.println("No places in the itinerary.");
            return;
        } else {
            System.out.println("Starting trip at " + iterator.next());
        }

        printMenu();

        while (!quit) {
            System.out.print("Enter action: ");
            String action = scanner.nextLine().toUpperCase();

            switch (action) {
                case "F" -> {
                    if (!goingForward) {
                        if (iterator.hasNext()) iterator.next(); // adjust cursor
                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("Reached the end of the list.");
                        goingForward = false;
                    }
                }

                case "B" -> {
                    if (goingForward) {
                        if (iterator.hasPrevious()) iterator.previous(); // adjust cursor
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("We are at the start of the list.");
                        goingForward = true;
                    }
                }

                case "L" -> printList(places);
                case "M" -> printMenu();
                case "Q" -> {
                    System.out.println("Exiting itinerary...");
                    quit = true;
                }
                default -> System.out.println("Invalid action. Type 'M' for menu.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackward
                (L)ist places
                (M)enu
                (Q)uit
                """);
    }

    private static void printList(LinkedList<Place> list) {
        System.out.println("Itinerary:");
        for (Place place : list) {
            System.out.println(" - " + place.name() + " (" + place.distanceFromStart() + " km)");
        }
    }
}
