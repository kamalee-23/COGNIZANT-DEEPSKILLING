import java.util.Arrays;
import java.util.Comparator;

public class SearchOperations {

    public static void main(String[] args) {

        Product[] products = {
            new Product(110, "Tablet", "Electronics"),
            new Product(220, "Backpack", "Travel"),
            new Product(180, "Headphones", "Electronics"),
            new Product(310, "Sneakers", "Footwear"),
            new Product(145, "Water Bottle", "Accessories")
        };

        int searchId = 180;

        System.out.println("=== Linear Search Result ===");
        Product linearResult = linearSearch(products, searchId);

        if (linearResult != null)
            System.out.println(linearResult);
        else
            System.out.println("Product Not Found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("\n=== Binary Search Result ===");
        Product binaryResult = binarySearch(products, searchId);

        if (binaryResult != null)
            System.out.println(binaryResult);
        else
            System.out.println("Product Not Found");
    }

    public static Product linearSearch(Product[] products, int targetId) {

        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }

        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }

            if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}