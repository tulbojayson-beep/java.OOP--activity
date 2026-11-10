public class CafeApp {

    public static void main(String[] args) {

        // Create two customers. Ana has a true flag (likely a member or
        // discount holder); Ben uses the constructor with only a name.
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // Create menu items (name, base price, item code, extras)
        // Beverage: Iced Latte, price 95, code B-01, size "L" (Large)
        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        // Pastry: Ensaymada, price 45, code P-01, true flag (likely warmed)
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        // Meal: Chicken Adobo, price 110, code M-01, plus two extra options
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        // Pastry: Cookie, same flag set to false
        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        // ORDER 1: Ana's order
        Order order1 = new Order("1001", ana);   // order number 1001 for Ana
        order1.addItem(latte);                   // add each item to the order
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie);
        order1.printReceipt();                   // print the receipt

        // Create a Beverage using the default constructor (size defaults to "S"),
        // then fill in its details with setters.
        Beverage chocolate = new Beverage();
        chocolate.setName("Hot Chocolate");      // set the item name
        chocolate.setItemCode("B-02");           // set the item code

        // Test validation: -5 is an invalid price, so the setter
        // should reject it and keep the old value.
        chocolate.setBasePrice(-5);

        // Valid price, so this one is accepted
        chocolate.setBasePrice(80);
        chocolate.setSize("M");                  // set size to Medium (+15 in computePrice)

        // Create another meal: Beef Tapa, price 130, code M-02
        Meal tapa = new Meal("Beef Tapa", 130, "M-02", false, 0);

        // ORDER 2: Ben's order
        Order order2 = new Order("1002", ben);   // order number 1002 for Ben
        order2.addItem(chocolate);               // add the hot chocolate
        order2.addItem(tapa);                    // add the beef tapa

        // Print the receipt with a value of 20 passed in (likely a discount
        // or payment amount, depending on how printReceipt is written)
        order2.printReceipt(20);
    }
}
