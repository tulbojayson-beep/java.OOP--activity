/**
 * Represents a beverage whose price depends on its size.
 *
 * @author Jayson A. Tulbo
 * @author Gilbert B. Sanchezh
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

  public Beverage() {
        super();
        size = "S";
  }

 
    public Beverage(String name, double basePrice,String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    public double computePrice() {
    // If the size is Large, add 25 to the base price
    if ("L".equals(size)) {
        return basePrice + 25;
    // Otherwise, if the size is Medium, add 15 to the base price
    } else if ("M".equals(size)) {
        return basePrice + 15;
    // Any other size (Small) has no extra charge, so return the base price
    } else {
        return basePrice;
    }
  }
    
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public void setSize(String size) {
    // Check if the given size is S, M, or L (ignoring upper/lower case)
    if ("S".equalsIgnoreCase(size)
            || "M".equalsIgnoreCase(size)
            || "L".equalsIgnoreCase(size)) {
        // Valid size: save it in uppercase so it matches "S", "M", "L" in computePrice()
        this.size = size.toUpperCase();
    // If the size is not S, M, or L
    } else {
        // Invalid size: show a message and keep the previous size unchanged
        System.out.println("Invalid size. The previous size was kept.");
    }
  }
    
}
