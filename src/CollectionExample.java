import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExample {
    public static void main(String[] args){
        Product door = new Product("Wooden Door",35);
        Product floorPanel = new Product("Floor Panel",25);
        Product glassWindow = new Product("Glass Window",10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(glassWindow);

      for(Product product:products){
          if(product.getWeight()>20) {
              System.out.println(product);
          }
       }
        System.out.println(products);
    }
}
