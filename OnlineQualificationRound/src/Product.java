/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class Product {
    private final int id;
    private final int weight;

    public Product(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product other = (Product) obj;
            return id == other.id;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
