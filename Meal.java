public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    public Meal(String name, double basePrice,String itemCode, boolean upsized,int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    
    public double computePrice() {
        double price = basePrice;

        if (upsized) {
            price += 20;
        }

        return price + (12 * extraSides);
    }

    
    public String getDescription() {
        return super.getDescription()
                + (upsized ? " Upsized" : " Regular")
                + ", " + extraSides
                + (extraSides == 1 ? " side" : " sides");
    }

    public boolean isUpsized() {
        return upsized;
    }

    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }

    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
