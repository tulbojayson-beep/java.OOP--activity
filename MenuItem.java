/**
 * Abstract parent class for items sold in the campus cafe.
 *
 * @author Jayson A. Tulbo
 * @author Gilbert B. Sanchez
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;        // item name (protected so child classes can access it)
    protected double basePrice;   // starting price before any size/extra charges
    private String itemCode;      // item code, private so it's changed only through the setter

    // Default constructor: gives placeholder values, then calls the main constructor
    public MenuItem() {
        this("Unnamed Item", 0.0, "N/A");
    }

    // Main constructor: used by Beverage, Pastry, and Meal through super(...)
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);     // use the setter so a negative price is rejected
        this.itemCode = itemCode;
    }

    // Abstract method: has no body here. Every child class (Beverage, Pastry, Meal)
    // must write its own version of how the final price is computed.
    public abstract double computePrice();

    // Returns the text used on the receipt, e.g. "Iced Latte (B-01)".
    // Child classes call this with super.getDescription() and add their own details.
    public String getDescription() {
        return name + " (" + itemCode + ")";
    }

    // Getter: returns the item name
    public String getName() {
        return name;
    }

    // Setter: changes the item name
    public void setName(String name) {
        // Accept only a name that is not null and not blank
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        // Otherwise show an error and keep the old name
        } else {
            System.out.println("Error: item name cannot be empty.");
        }
    }

    // Getter: returns the base price
    public double getBasePrice() {
        return basePrice;
    }

    // Setter: changes the base price
    public void setBasePrice(double basePrice) {
        // Price must be 0 or higher
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        // Negative price: show an error and keep the old price
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    // Getter: returns the item code
    public String getItemCode() {
        return itemCode;
    }

    // Setter: changes the item code
    public void setItemCode(String itemCode) {
        // Accept only a code that is not null and not blank
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        // Otherwise show an error and keep the old code
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
