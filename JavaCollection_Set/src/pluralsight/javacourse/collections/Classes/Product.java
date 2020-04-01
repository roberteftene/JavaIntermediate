package pluralsight.javacourse.collections.Classes;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private final String name;
    private final int weight;
    public static final Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);
    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);


    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.weight - o.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        if(weight != product.weight) return false;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }
}
