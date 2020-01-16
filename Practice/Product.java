package Practice;

import java.util.Objects;

public class Product {
    //Static Variable
    private static int id = 1; //Depends on n-Object created. Should not be changed
    //End

    //Variables
    private String name;
    private int price;
    private int productId; //Individual Product id can be changed
    //End

    //Constructor
    public Product(String name, int price) {
        if(name == null || price < 0) {
            throw new IllegalArgumentException("Error with parameter values");
        }
        else {
            this.name = name;
            this.price = price;
            productId = id++;
        }
    }
    //End

    //Getters
    public static int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getProductId() {
        return productId;
    }
    //End

    //Setters
    /*
    public void setId(int id) {
        if(id < 0) throw new IllegalArgumentException("Error with parameter value");
        else Product.id = id;
    }
    */ //I dont think the user should be able to set the id that depends on the number of objects created.
    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException("Error with parameter value");
        else this.name = name;
    }
    public void setPrice(int price) {
        if(price < 0) throw new IllegalArgumentException("Error with parameter value");
        else this.price = price;
    }
    public void setProductId(int productId) {
        if(productId < 0) throw new IllegalArgumentException("Error with parameter value");
        else this.productId = productId;
    }
    //End

    //Override Methods
    @Override
    public String toString() {
        return "Name = " + name + "\nPrice = " + price + "\nId = " + productId;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }
    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
    //End

    //Other Functionality
    public static void display(Object arg) {
        System.out.println(arg);
    }
    //End
}
