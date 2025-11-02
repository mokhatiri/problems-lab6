package problem1;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<Item>();
        Item item;
        String itemName;
        double itemPrice;
        int quantity;
        double total = 0;
        Scanner scan = new Scanner(System.in);
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();
            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();
            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();
            // clearing the input
            scan.nextLine();
            // *** create a new item and add it to the cart
            item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            // *** print the contents of the cart object using println
            System.out.println("-------- current cart --------");
            for(Item choice : cart)
                System.out.println("- " + choice + " ");
            total += (item.getPrice() *  item.getQuantity()); // add to the total
            System.out.println("------------------------------");
            System.out.println("-> total : " + fmt.format(total));
            System.out.println("------------------------------");
            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
        }
        while (keepShopping.equals("y"));
    }
}
