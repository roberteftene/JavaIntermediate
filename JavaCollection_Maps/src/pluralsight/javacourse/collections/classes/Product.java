package pluralsight.javacourse.collections.classes;

import java.util.Comparator;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private final int id;
    private final String name;
    private final int weight;
    public static final Comparator<Product> BY_WEIGHT = Comparator.comparing(Product::getWeight);
    public static final Comparator<Product> BY_NAME = Comparator.comparing(Product::getName);


    public Product(final int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", name='" + name + '\'' +
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

