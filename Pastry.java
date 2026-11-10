public class Pastry extends MenuItem {
    private boolean warmed;

    public Pastry() {
        super();
        warmed = false;
    }

    public Pastry(String name, double basePrice,String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }
    
    public double computePrice() {
        double price = basePrice;

        // If the pastry is warmed, add 10 to the price
        if (warmed) {
            price += 10;
        }

        return price;
    }

    
    public String getDescription() {
        // Adds " (Warmed)" to the description if warmed, otherwise adds nothing
        return super.getDescription()
                + (warmed ? " (Warmed)" : "");
    }

    public boolean isWarmed() {
        return warmed;
    }

    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
