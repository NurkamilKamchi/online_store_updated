import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[0];
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        Syrtkysykl:
        while (true) {
            System.out.print("""
                    Welcome to online store!!!
                    1.Register.
                    2.Get all users.
                    3.Login.
                    4.Exit.
                    Enter your choice:\s
                    """);

            switch (scanner.nextLine().toLowerCase()) {
                case "1", "register" -> {
                    User registerUser = User.register(new User());
                    users = User.addUserToArray(users, registerUser);
                    System.out.println("Successfully saved oser! ");
                }
                case "2", "get all users" -> {
                    System.out.println(Arrays.toString(users));
                }
                case "3", "login" -> {
                    currentUser = User.login(users);
                    System.out.println("Login succes! ");
                    IchkiSykl:
                    while (true) {
                        System.out.println("""
                                1.Logout.
                                2.Add product.
                                3.Get all products.
                                4.Get all books.
                                5.Get all device.
                                6.Delete product by id.
                                7.Delete product by ids.
                                """);
                        switch (scanner.nextLine().toLowerCase()) {
                            case "1", "logout" -> {
                                break IchkiSykl;

                            }
                            case "2", "add product" -> {
                                System.out.println("Book or Device");
                                switch (scanner.nextLine().toLowerCase()) {
                                    case "1" -> {
                                        Book product = new Book();
                                        if (currentUser != null) {
                                            Product[] products = product.addNewProduct(currentUser.getProducts());
                                            currentUser.setProducts(products);
                                            System.out.println("Book added!");
                                        }
                                    }
                                    case "2","device" -> {
                                        Device product = new Device();
                                        if (currentUser != null) {
                                            Product[] products = product.addNewProductForDevice(currentUser.getProducts());
                                            currentUser.setProducts(products);
                                            System.out.println("🔴🔴🔴Device added!");
                                        }


                                    }
                                }
                            }
                            case "3", "get all products" -> {
                                if (currentUser != null) Product.getAllProductcs(currentUser.getProducts());

                            }
                            case "4","get all books"->{
                                assert currentUser != null;
                                new Book().getProducts(currentUser.getProducts());


                            }
                            case "5","get all device"->{
                                assert currentUser != null;
                                new Device().getProducts(currentUser.getProducts());

                            }
                            case "6","delete"->{
                                System.out.println("Enter id: ");

                                Product[] products = Product.deleteProduct(currentUser.getProducts(),scanner.nextLong());
                                currentUser.setProducts(products);
                            }
                            case "7","delete by ids"->{
                                System.out.println("Enter ids: ");
                                int length= scanner.nextInt();
                                long[] ids = new long[length];
                                for (int i = 0; i < length; i++) {
                                    System.out.println("Kaisy id: ");
                                    ids[i] = scanner.nextLong();
                                }

                                    Product[] newProducts = Product.deleteProduct(currentUser.getProducts(),ids);
                                    currentUser.setProducts(newProducts);
                                    System.out.println("Succes deleted!");


                            }

                        }
                    }
                }


                case "4" -> {
                    break Syrtkysykl;
                }
            }
        }
    }

}
