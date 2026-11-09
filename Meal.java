/**
 * Represents a rice meal that can be upsized and served with extra sides.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /** Creates a regular meal with no extra sides. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with the supplied options.
     * @param name meal name
     * @param basePrice starting price
     * @param itemCode item code
     * @param upsized whether the meal is upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /** @return price including upsize and extra-side fees */
    @Override
    public double computePrice() {
        double price = basePrice;
        if (upsized) price += 20; // Upsizing adds a fixed fee.
        return price + (12 * extraSides);
    }

    /** @return meal description showing options */
    @Override
    public String getDescription() {
        return super.getDescription() + (upsized ? " Upsized" : " Regular")
                + ", " + extraSides + (extraSides == 1 ? " side" : " sides");
    }

    /** @return true when the meal is upsized */
    public boolean isUpsized() { return upsized; }

    /** @param upsized new upsize status */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    /** @return number of extra sides */
    public int getExtraSides() { return extraSides; }

    /**
     * Sets the number of extra sides when the value is nonnegative.
     * @param extraSides number of extra sides
     */
    public void setExtraSides(int extraSides) {
        if (extraSides >= 0) this.extraSides = extraSides;
        else System.out.println("Error: extra sides cannot be negative.");
    }
}
