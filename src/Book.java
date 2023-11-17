import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends Product{
    private String authorName;
    public Book(String name, String description, BigDecimal price, String authorName) {
        super(name, description, price);
        this.authorName = authorName;
    }

    public Book() {

    }

    @Override
    public Product[] addNewProductForDevice(Product[] products) {
        return new Product[0];
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        Scanner scanner =new Scanner(System.in);
        Scanner scannerForNum = new Scanner(System.in);
        this.setId(MyGenerateId.generateId());
        System.out.println("Enter book name: ");
        this.setName(scanner.nextLine());
        System.out.println("Enter book description: ");
        this.setDescription(scanner.nextLine());
        System.out.println("Enter price: ");
        this.setPrice(scannerForNum.nextBigDecimal());
        System.out.println("Enter authorname: ");
        this.setAuthorName(scanner.nextLine());
        this.setCreatedAt(ZonedDateTime.now());
        Product[] newProductArray = Arrays.copyOf(products,products.length+1);
        newProductArray[newProductArray.length-1]=this;
        return newProductArray;
    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if (product instanceof Book book){
                System.out.println(book);
            }
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                "} " + super.toString();
    }
}
