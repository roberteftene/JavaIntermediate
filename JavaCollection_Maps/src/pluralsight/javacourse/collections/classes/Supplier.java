package pluralsight.javacourse.collections.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Supplier {

    public String description;

    public List<Product> products() {
        return new ArrayList<Product>();
    }

    public Supplier(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
