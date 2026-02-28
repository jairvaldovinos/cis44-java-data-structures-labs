// Simple Item class for our adventure game.
// Each item just has a name for now.

public class Item {

    private String name;

    // Constructor
    public Item(String name) {
        this.name = name;
    }

    // Getter method
    public String getName() {
        return name;
    }

    // This makes printing items easier
    @Override
    public String toString() {
        return name;
    }
}
