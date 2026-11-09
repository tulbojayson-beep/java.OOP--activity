/**
 * Abstract parent class for items sold in the campus cafe.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Creates an unnamed menu item with default values. */
    public MenuItem() {
        this("Unnamed Item", 0.0, "N/A");
    }

    /**
     * Creates a menu item with the supplied details.
     * @param name item name
     * @param basePrice starting price
     * @param itemCode item identification code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice);
        this.itemCode = itemCode;
    }

    /** Computes the final price; subclasses provide their own rules.
     * @return final item price
     */
    public abstract double computePrice();

    /**
     * Returns the item's name and code.
     * @return item description
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return item name */
    public String getName() { return name; }

    /** @param name new item name */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else System.out.println("Error: item name cannot be empty.");
    }

    /** @return base price */
    public double getBasePrice() { return basePrice; }

    /**
     * Changes the base price only when it is nonnegative.
     * @param basePrice new base price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) this.basePrice = basePrice;
        else System.out.println("Error: base price cannot be negative.");
    }

    /** @return item code */
    public String getItemCode() { return itemCode; }

    /** @param itemCode new item code */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) this.itemCode = itemCode;
        else System.out.println("Error: item code cannot be empty.");
    }
}
