package pluralsight.javacourse.collections.Main;

import pluralsight.javacourse.collections.classes.Product;
import pluralsight.javacourse.collections.classes.ProductFixture;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        final Map<Integer, Product> idToProduct = new HashMap<>();

        idToProduct.put(1, ProductFixture.door);
        idToProduct.put(2, ProductFixture.floorPanel);
        idToProduct.put(3, ProductFixture.window);

        System.out.println(idToProduct);
        System.out.println();

        final Set<Integer> ids = idToProduct.keySet();
        System.out.println(ids);

        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);

        final Collection<Product> products = idToProduct.values();
        System.out.println(products);
        System.out.println();

        products.remove(ProductFixture.floorPanel);
        System.out.println(products);
        System.out.println(idToProduct);
        System.out.println();

        final Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();

        for (Map.Entry<Integer,Product> entry : entries) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
            entry.setValue(ProductFixture.floorPanel);
        }

        System.out.println(idToProduct);


    }
}
