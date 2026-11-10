public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        itemCount = 0;
    }

    public boolean addItem(MenuItem item) {
        // If the item is null, reject it and return false
        if (item == null) {
            System.out.println("Cannot add a null item.");
            return false;
        // Otherwise, if slot 1 is empty, put the item there
        } else if (item1 == null) {
            item1 = item;
        // Otherwise, if slot 2 is empty, put the item there
        } else if (item2 == null) {
            item2 = item;
        // Otherwise, if slot 3 is empty, put the item there
        } else if (item3 == null) {
            item3 = item;
        // All 3 slots are taken: the order is full, so reject the item
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }

        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0;

        // Add the price of item 1 only if the slot is not empty
        if (item1 != null) {
            subtotal += item1.computePrice();
        }

        // Add the price of item 2 only if the slot is not empty
        if (item2 != null) {
            subtotal += item2.computePrice();
        }

        // Add the price of item 3 only if the slot is not empty
        if (item3 != null) {
            subtotal += item3.computePrice();
        }

        return subtotal;
    }

    public double computeTotal() {
        double subtotal = computeSubtotal();

        // Students get a 10% discount (pay 90% of the subtotal)
        if (customer.isStudent()) {
            return subtotal * 0.90;
        // Non-students pay the full subtotal
        } else {
            return subtotal;
        }
    }

     
    public double computeTotal(double voucher) {
        // Subtract the voucher; Math.max(0, voucher) ignores negative vouchers
        double total = computeTotal() - Math.max(0, voucher);

        // If the voucher is bigger than the total, don't go below 0
        if (total < 0) {
            total = 0;
        }

        return total;
    }

    public void printReceipt() {
        printReceipt(0.0, false);
    }

    
    public void printReceipt(double voucher) {
        printReceipt(voucher, true);
    }

    private void printReceipt(double voucher, boolean useVoucher) {
        // Shows " (Student)" after the name if the customer is a student, otherwise nothing
        System.out.println("Order #" + orderId + " - " + customer.getName()+ (customer.isStudent() ? " (Student)" : ""));

        printItem(item1);
        printItem(item2);
        printItem(item3);

        double subtotal = computeSubtotal();
        // Student: discount is 10% of the subtotal. Not a student: discount is 0
        double discount = customer.isStudent()
                ? subtotal * 0.10 : 0;

        // If a voucher is used, compute t
