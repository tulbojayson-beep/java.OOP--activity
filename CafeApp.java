/**
 * Runs the Campus Cafe Ordering System demonstration.
 *
 * @author Jayson A. Tulbo
 * @version 1.0
 */
public class CafeApp {
    /**
     * Creates sample customers, menu items, orders, and prints receipts.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        final double STUDENT_DISCOUNT = 0.10;

        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        Order order1 = new Order("1001", ana);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie); // Demonstrates the three-item limit.
        order1.printReceipt();

        // Demonstrates a setter rejecting invalid data, then accepting valid data.
        Beverage chocolate = new Beverage();
        chocolate.setName("Hot Chocolate");
        chocolate.setItemCode("B-02");
        chocolate.setBasePrice(-5);
        chocolate.setBasePrice(80);
        chocolate.setSize("M");

        Meal tapa = new Meal("Beef Tapa", 130, "M-02", false, 0);
        Order order2 = new Order("1002", ben);
        order2.addItem(chocolate);
        order2.addItem(tapa);
        order2.printReceipt(20);
    }
}
