package pluralsight.javacourse.collections.Main;

import pluralsight.javacourse.collections.Classes.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void Info(List<Product> products, Product p) {
        //NOT SO USE
        final Iterator<Product> productIterator = products.iterator();
        while(productIterator.hasNext()) {
            Product product = productIterator.next();
            if(product.getWeight() > 20) {
                System.out.println(product);
            } else {
                productIterator.remove();
            }
        }

        System.out.println(products);
        System.out.println();

        //EQUIVALENT BUT USED MORE BUT IT YOU LOOP WITH THIS METHOD DON'T MODIFY THE COLLECTION, USE AN ITERATOR INSTEAD
        for(Product product:products) {
            System.out.println(product);
        }



        //ANOTHER METHODS
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(p));
        System.out.println(products.contains(p));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(p);
        otherProducts.add(p);

        products.removeAll(otherProducts);
        System.out.println(products);
    }

    public static void main(String[] args) {
        Product door = new Product("Wooden Door",35);
        Product floorPanel = new Product("Floor Panel",25);
        Product window = new Product("Window",10);

        Collection<Product> products = new ArrayList<Product>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);


    }
}
