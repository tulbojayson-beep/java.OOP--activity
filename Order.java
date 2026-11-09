/**
 * Represents one customer order containing up to three menu items.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an order for a customer.
     * @param orderId order identification
     * @param customer customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds an item to the first available slot.
     * @param item menu item to add
     * @return true if added; otherwise false
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add a null item.");
            return false;
        } else if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }
        itemCount++;
        return true;
    }

    /** @return sum of the prices of all items */
    public double computeSubtotal() {
        double subtotal = 0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    /** @return subtotal after the student discount, if applicable */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        if (customer.isStudent()) return subtotal * 0.90;
        else return subtotal;
    }

    /**
     * Applies a voucher after any student discount.
     * @param voucher voucher amount
     * @return final total, never below zero
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - Math.max(0, voucher);
        if (total < 0) total = 0;
        return total;
    }

    /** Prints the receipt and awards points based on the amount paid. */
    public void printReceipt() {
        printReceipt(0.0, false);
    }

    /**
     * Prints a receipt with a voucher deduction.
     * @param voucher voucher amount
     */
    public void printReceipt(double voucher) {
        printReceipt(voucher, true);
    }

    private void printReceipt(double voucher, boolean useVoucher) {
        System.out.println("Order #" + orderId + " - " + customer.getName()
                + (customer.isStudent() ? " (Student)" : ""));
        printItem(item1);
        printItem(item2);
        printItem(item3);
        double subtotal = computeSubtotal();
        double discount = customer.isStudent() ? subtotal * 0.10 : 0;
        double total = useVoucher ? computeTotal(voucher) : computeTotal();
        System.out.printf("  Subtotal: %.2f%n", subtotal);
        if (discount > 0) System.out.printf("  Student discount (10%%): -%.2f%n", discount);
        if (useVoucher) System.out.printf("  Voucher: -%.2f%n", Math.min(Math.max(voucher, 0), computeTotal()));
        System.out.printf("  TOTAL: %.2f%n", total);
        customer.addPoints(total);
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("  %-48s %.2f%n", item.getDescription(), item.computePrice());
        }
    }
}
