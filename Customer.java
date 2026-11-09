/**
 * Represents a customer and tracks student status and loyalty points.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Creates a customer with default values. */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a non-student customer.
     * @param name customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with student status.
     * @param name customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    /** Adds a specified number of points.
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points > 0) loyaltyPoints += points;
    }

    /**
     * Adds one point for every 50 pesos spent.
     * @param amountSpent purchase amount
     */
    public void addPoints(double amountSpent) {
        if (amountSpent > 0) loyaltyPoints += (int) (amountSpent / 50.0);
    }

    /** @return customer name */
    public String getName() { return name; }

    /** @param name new customer name */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
    }

    /** @return true if customer is a student */
    public boolean isStudent() { return student; }

    /** @param student new student status */
    public void setStudent(boolean student) { this.student = student; }

    /** @return current loyalty points */
    public int getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Changes points only when the value is nonnegative.
     * @param loyaltyPoints new point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) this.loyaltyPoints = loyaltyPoints;
        else System.out.println("Error: loyalty points cannot be negative.");
    }
}
