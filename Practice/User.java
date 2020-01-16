package Practice;

import java.util.Objects;

public class User {
    //Variables
    private String username;
    private String password;
    private int age;
    //End

    //Constructor
    public User(String username, String password, int age) {
        if(username == null || password == null || age < 0) {
            throw new IllegalArgumentException("Error with values passed");
        }
        else {
            this.username = username;
            this.password = password;
            this.age = age;
        }
    }
    //End

    //Getters / Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        if(username == null) {
            System.out.println("Error with value passed");
        }
        else this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(password == null) {
            System.out.println("Error with value passed");
        }
        else this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age < 0) {
            System.out.println("Error with value passed");
        }
        else this.age = age;
    }
    //End

    //Additional Functionality
    public boolean isOver18(User u) {
        return (u.age > 18);
    }
    public void display(Object arg) {
        System.out.println(arg);
    }
    //End

    //Override Methods
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equalsIgnoreCase(user.username);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
    @Override
    public String toString() {
        return "Username = " + username + "\nPassword = " + password + "\nAge = " + age;
    }
    //End
}
