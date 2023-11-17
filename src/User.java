import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Product[] products=new Product[0];

    public User() {
    }

    public User(String name, String surname, String email, String password, Product[] products) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.products = products;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public static User register(User newUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        newUser.setName(scanner.nextLine());
        System.out.print("Enter surname: ");
        newUser.setSurname(scanner.nextLine());
        while (true){
            System.out.print("Enter email: ");
            newUser.setEmail(scanner.nextLine());
            if (newUser.getEmail().endsWith("@gmail.com")){
                break;
            }else {
                System.out.println("Invalid email, please try again!!!");
            }
        }
        while (true){
            System.out.print("Enter password: ");
            newUser.setPassword(scanner.nextLine());
            if (newUser.getPassword().length() >= 4){
                break;
            } else {
                System.out.println("Invalid password, please try again!!!"
                );
            }
        }
        return newUser;
    }
    public static User[] addUserToArray(User[] users, User registerUser) {
        User[] newArray =Arrays.copyOf(users,users.length+1);
        newArray[newArray.length-1]=registerUser;
        return newArray;
    }

    public static User login(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                System.out.println("Succes login! ");
                return user;
            } else if (user.getEmail().isEmpty() && user.getPassword().isEmpty()) {
                System.out.println("Email and password is empty!!!");
            } else {
                System.out.println("Invalid login!");
            }

        }
        return login(users);
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' ;
//    }
}
