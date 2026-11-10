/**
 * Represents a customer and tracks loyalty points.
 *
 * @author Jayson A. Tulbo
 * @author Gilbert B. Sanchez
 * @version 1.0
 */
public class Customer {
    private String name;          // the customer's name
    private boolean student;      // true if the customer is a student
    private int loyaltyPoints;    // points the customer has earned so far

    // Default constructor: a nameless customer becomes "Guest", not a student
    public Customer() {
        this("Guest", false);     // calls the 2-parameter constructor below
    }

    // Constructor with only a name: assumes the customer is not a student
    public Customer(String name) {
        this(name, false);        // calls the 2-parameter constructor below
    }

    // Main constructor: sets the name and student status, starts with 0 points
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        loyaltyPoints = 0;
    }

    // Adds a fixed number of points (overloaded method #1: takes an int)
    public void addPoints(int points) {
        // Only add if the points are positive, so points can't be reduced
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    // Adds points based on money spent (overloaded method #2: takes a double)
    public void addPoints(double amountSpent) {
        // Ignore zero or negative amounts
        if (amountSpent > 0) {
            // Every 50 spent = 1 point; (int) drops the decimal part
            loyaltyPoints += (int) (amountSpent / 50.0);
        }
    }

    // Getter: returns the customer's name
    public String getName() {
        return name;
    }

    // Setter: changes the name
    public void setName(String name) {
        // Accept it only if it's not null and not empty/blank spaces;
        // otherwise the old name is kept
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    // Getter: returns true if the customer is a student
    public boolean isStudent() {
        return student;
    }

    // Setter: changes the student status
    public void setStudent(boolean student) {
        this.student = student;
    }

    // Getter: returns the current loyalty points
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setter: directly sets the loyalty points
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Points must be 0 or higher
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        // Negative value: show an error and keep the old points
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
