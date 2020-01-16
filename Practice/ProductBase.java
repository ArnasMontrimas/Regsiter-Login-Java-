package Practice;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductBase {
    //Store Products here
    private ArrayList<Product> products;
    //End

    //Constructor
    public ProductBase() {
        products = new ArrayList<>();
    }
    //End

    //Add/View Products
    public void addViewProducts() {
        Scanner scan = new Scanner(System.in);
        String action;
        boolean tryAgain = false;
        do {
            System.out.println("Welcome\nSelect option\nPress '1' to view all products\nPress '2' to add new product\nPress '3' to exit");
            action = scan.next();
            switch(action) {
                case "1":
                    for(Product p: products) {
                        System.out.println(p);
                    }
                    tryAgain = true;
                    break;
                case "2":
                    System.out.println("Enter Product name\nTo exit enter '-10'");
                    String name;
                    int price = -1;
                    name = scan.next();
                    if(name.equalsIgnoreCase(String.valueOf(-10))) {
                        tryAgain = false;
                        break;
                    }
                    do {
                        try {
                            tryAgain = false;
                            System.out.println("Enter Price");
                            price = scan.nextInt();
                            if(price == -10) {
                                break;
                            }
                        }
                        catch(InputMismatchException ex) {
                            System.out.println("Numbers only");
                            tryAgain = true;
                            scan.next();
                        }
                    } while(tryAgain);
                    try {
                        Product product = new Product(name,price);
                        products.add(product);
                        System.out.println("Product Added");
                    }
                    catch(IllegalArgumentException ex) {
                        System.out.println("Product was not added");
                    }
                    tryAgain = true;
                    break;
                case "3":
                    System.out.println("Exit Successful");
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Program Terminated");
            }
        } while(tryAgain);
    }

}
