package Practice;


public class LoginRegistration {
    public static void main(String[] args) {
        //Object to store Users in
        UserBase users = new UserBase();
        //End

        //Object to store Products in
        ProductBase products = new ProductBase();
        //End

        //Register User
        users.register();
        //End

        //Login User if successful then add or view products
        if(users.login()) {
            products.addViewProducts();
        }
        //End
        //TODO: More Validation: Regex To make sure username and password does not contain any symbols.
    }
}
