import java.util.ArrayList;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class Warehouse {
    private final int id;
    private final int row;
    private final int column;
    private List<Product> inventory;

    public Warehouse(int id, int row, int column) {
        this.id = id;
        this.row = row;
        this.column = column;
        inventory = new ArrayList<Product>();
    }

    public void addProductToInventory(Product product) {
        inventory.add(product);
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public boolean hasProduct(Product product) {
        return inventory.contains(product);
    }

    public void takeProduct(Product product) {
        inventory.remove(product);
    }
}
