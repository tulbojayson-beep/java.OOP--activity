/**
 * Represents a baked item that may be warmed for an extra fee.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private boolean warmed;

    /** Creates a pastry that is not warmed. */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with the supplied details.
     * @param name pastry name
     * @param basePrice starting price
     * @param itemCode item code
     * @param warmed whether it is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /** @return price including the warming fee when applicable */
    @Override
    public double computePrice() {
        double price = basePrice;
        if (warmed) price += 10; // Add the warming fee only when requested.
        return price;
    }

    /** @return pastry description, including warmed status */
    @Override
    public String getDescription() {
        return super.getDescription() + (warmed ? " (Warmed)" : "");
    }

    /** @return true when the pastry is warmed */
    public boolean isWarmed() { return warmed; }

    /** @param warmed new warmed status */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
