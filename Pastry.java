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

        if (warmed) {
            price += 10;
        }

        return price;
    }

    
    public String getDescription() {
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
