package pluralsight.javacourse.collections.Main;

import netscape.javascript.JSUtil;
import pluralsight.javacourse.collections.classes.Product;
import pluralsight.javacourse.collections.classes.ProductFixture;

import java.util.HashMap;
import java.util.Map;

public class Java8Enhacements {

    public static void main(String[] args) {
        final Product defaultProduct = new Product(-1,"Whatever the customer wants",100);

        final Map<Integer,Product> idToProduct = new HashMap<>();

        idToProduct.put(1, ProductFixture.door);
        idToProduct.put(2, ProductFixture.floorPanel);
        idToProduct.put(3, ProductFixture.window);

        // Before Java8
        System.out.println("The element with the key 10: ");
        final Product result = idToProduct.get(10);
        System.out.println(result);
        // After Java8
        System.out.println("The element with the key 10 or if it doesnt exist return the default element: ");
        final Product resultOrDefault = idToProduct.getOrDefault(10, defaultProduct);
        System.out.println(resultOrDefault);

        System.out.println("Replace the product with the key 1");
        Product reslt = idToProduct.replace(1,new Product(1,"Big door",50));
        System.out.println("This is the value that have been replaced:");
        System.out.println(reslt); //The value that has been replaced
        System.out.println("The new value: ");
        System.out.println(idToProduct.get(1)); //The new value

        System.out.println("Replaced all the elements with a given value:");
        idToProduct.replaceAll((id,oldProduct) ->
        new Product(id,oldProduct.getName(), oldProduct.getWeight() + 10
        ));

        System.out.println(idToProduct);

        System.out.println();


        System.out.println("Return the product with the key 10 and if it doesn't exist return a new value with the key 10");
        Product product = idToProduct.computeIfAbsent(10, (id) -> new Product(id, "CustomProduct", 10));
        System.out.println(product);
        System.out.println(idToProduct.get(10));

        System.out.println("The map is: ");
        System.out.println(idToProduct);

        System.out.println();

        idToProduct.forEach((key,value) -> {
            System.out.println(key + " -> " + value );
        });

    }
}
