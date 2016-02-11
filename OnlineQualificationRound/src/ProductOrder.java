import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class ProductOrder {
    private final int id;
    private final int deliveryRow;
    private final int deliveryColumn;
    private int numberOfProductsToBeDelivered;
    private List<Product> productsToBeDelivered;

    public ProductOrder(int id, int deliveryRow, int deliveryColumn, int numberOfProductsToBeDelivered, List<Product> productsToBeDelivered) {
        this.id = id;
        this.deliveryRow = deliveryRow;
        this.deliveryColumn = deliveryColumn;
        this.numberOfProductsToBeDelivered = numberOfProductsToBeDelivered;
        this.productsToBeDelivered = productsToBeDelivered;
    }

    public int getDeliveryRow() {
        return deliveryRow;
    }

    public int getDeliveryColumn() {
        return deliveryColumn;
    }

    public int getNumberOfProductsToBeDelivered() {
        return numberOfProductsToBeDelivered;
    }

    public List<Product> getProductsToBeDelivered() {
        return productsToBeDelivered;
    }

    public int getId() {
        return id;
    }
}
