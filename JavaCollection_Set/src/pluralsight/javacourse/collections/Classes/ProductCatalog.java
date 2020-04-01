package pluralsight.javacourse.collections.Classes;

import java.util.*;

public class ProductCatalog {

    private final SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

    public void isSuppliedBy(Supplier supplier) {
        products.addAll(supplier.products());
    }

    public Set<Product> lightVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return  products.headSet(heaviestLightVanProduct);
    }

    public Set<Product> heavyVanProducts() {
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.tailSet(heaviestLightVanProduct);
    }
    private Product findHeaviestLightVanProduct() {

        for(Product product : products) {
            if(product.getWeight() > 20) {
                return  product;
            }
        } return products.last();
    }

    public Iterator<Product> iterator() { return products.iterator();  }

}
