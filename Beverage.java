/**
 * Represents a beverage whose price depends on its size.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /** Creates a small beverage with default menu-item values. */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage with its name, price, code, and size.
     * @param name beverage name
     * @param basePrice starting price
     * @param itemCode item code
     * @param size S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /** @return price based on beverage size */
    @Override
    public double computePrice() {
        if ("L".equals(size)) return basePrice + 25;
        else if ("M".equals(size)) return basePrice + 15;
        else return basePrice;
    }

    /** @return description including beverage size */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /** @return beverage size */
    public String getSize() { return size; }

    /**
     * Sets size only to S, M, or L.
     * @param size selected size
     */
    public void setSize(String size) {
        if ("S".equalsIgnoreCase(size) || "M".equalsIgnoreCase(size)
                || "L".equalsIgnoreCase(size)) this.size = size.toUpperCase();
        else System.out.println("Invalid size. The previous size was kept.");
    }
}
