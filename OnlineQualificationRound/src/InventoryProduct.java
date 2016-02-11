/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class InventoryProduct {
    private final Product product;
    private int stock;

    public InventoryProduct(Product product, int stock) {
        this.product = product;
        this.stock = stock;
    }
}
