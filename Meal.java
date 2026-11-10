/**
 * Represents a rice meal with optional upsize and extra sides.
 *
 * @author Jayson A. Tulbo
 * @author Gilbert B. Sanchez
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;     // true if the meal is upsized (costs extra)
    private int extraSides;      // number of extra side dishes added

    // Default constructor: calls MenuItem's default constructor,
    // then sets the meal to regular size with no extra sides
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    // Main constructor: sets name, base price, and item code through MenuItem
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;         // start at 0 first
        setExtraSides(extraSides);   // then use the setter so negative values are rejected
    }

    // Computes the final price of the meal
    public double computePrice() {
        double price = basePrice;    // start from the base price

        // If upsized, add 20 to the price
        if (upsized) {
            price += 20;
        }

        // Add 12 for each extra side, then return the total
        return price + (12 * extraSides);
    }

    // Builds the description text shown on the receipt
    public String getDescription() {
        return super.getDescription()                       // name and code from MenuItem
                + (upsized ? " Upsized" : " Regular")       // "Upsized" if true, otherwise "Regular"
                + ", " + extraSides
                + (extraSides == 1 ? " side" : " sides");   // "side" for 1, "sides" for any other number
    }

    // Getter: returns true if the meal is upsized
    public boolean isUpsized() {
        return upsized;
    }

    // Setter: changes the upsized status
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    // Getter: returns the number of extra sides
    public int getExtraSides() {
        return extraSides;
    }

    // Setter: changes the number of extra sides
    public void setExtraSides(int extraSides) {
        // Accept only 0 or higher
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        // Negative value: show an error and keep the old value
        } else {
            System.out.println("Error: extra sides cannot be negative.");
