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
        if ("L".equals(size)) {
            return basePrice + 25;
        } else if ("M".equals(size)) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    
    public void setSize(String size) {
        if ("S".equalsIgnoreCase(size)
                ||"M".equalsIgnoreCase(size)
                || "L".equalsIgnoreCase(size)) {
            this.size = size.toUpperCase();
        } else {
            System.out.println( "Invalid size. The previous size was kept.");
        }
    }
}
