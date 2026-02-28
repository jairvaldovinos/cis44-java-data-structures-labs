// This class demonstrates building and managing a travel itinerary.
public class Main {

    public static void main(String[] args) {

        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // Add some destinations
        Position<String> paris = itinerary.addLast("Paris");
        Position<String> rome = itinerary.addLast("Rome");
        Position<String> berlin = itinerary.addLast("Berlin");

        // Insert a stop after Paris
        itinerary.addAfter(paris, "Eiffel Tower");

        // Insert before Rome
        itinerary.addBefore(rome, "Florence");

        // Add one at the beginning
        itinerary.addFirst("London");

        System.out.println("Final Travel Itinerary:");
        
        // This proves our custom iterator works
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}
