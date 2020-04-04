package pluralsight.javacourse.collections.interfaces;

import pluralsight.javacourse.collections.classes.Product;

public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();

}
