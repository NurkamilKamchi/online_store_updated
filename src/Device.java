import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends Product{
    private String brand;
    private String color;
    private String isNew;
    private String memory;

    public Device(String name, String description, BigDecimal price,String brand,String color,String isNew,String memory) {
        super(name, description, price);
        this.brand=brand;
        this.color=color;
        this.isNew=isNew;
        this.memory=memory;
    }

    public Device() {
    }
    @Override
    public Product[] addNewProductForDevice(Product[] products) {
        Scanner scanner =new Scanner(System.in);
        Scanner scannerForNum = new Scanner(System.in);
        this.setId(MyGenerateId.generateId());
//        System.out.println("Enter book name: ");
//        this.setName(scanner.nextLine());
//        System.out.println("Enter book description: ");
//        this.setDescription(scanner.nextLine());
//        System.out.println("Enter price: ");
//        this.setPrice(scannerForNum.nextBigDecimal());
        System.out.println("Enter device brand: ");
        this.setBrand(scanner.nextLine());
        System.out.println("Enter device color: ");
        this.setColor(scanner.nextLine());
        System.out.println("Enter isnew: ");
        this.setIsNew(scanner.nextLine());
        System.out.println("Enter memory: ");
        this.setMemory(scanner.nextLine());

        this.setCreatedAt(ZonedDateTime.now());
        Product[] newProductArray = Arrays.copyOf(products,products.length+1);
        newProductArray[newProductArray.length-1]=this;
        return newProductArray;
    }

    @Override
    public Product[] addNewProduct(Product[] products) {
        return new Product[0];
    }

    @Override
    public void getProducts(Product[] products) {
        for (Product product : products) {
            if (product instanceof Device device){
                System.out.println(device);
            }
        }
    }
//
//    public Device(String brand, String color, boolean isNew, String memory) {
//        this.brand = brand;
//        this.color = color;
//        this.isNew = isNew;
//        this.memory = memory;
//    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isNew=" + isNew +
                ", memory='" + memory + '\'' +
                '}';
    }
}
