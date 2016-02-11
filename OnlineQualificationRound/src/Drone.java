import java.util.ArrayList;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class Drone {
    private int id;
    private int currentRow;
    private int currentColumn;
    private List<Product> cargo;
    private int turnsUntilDone;
    private ProductOrder currentMission;
    private int weightLimit;

    public Drone(int id, int weightLimit) {
        this.id = id;
        this.weightLimit = weightLimit;
        currentRow = 0;
        currentColumn = 0;
        cargo = new ArrayList<Product>();
        turnsUntilDone = 0;
    }

    public List<Command> giveMission(ProductOrder productOrder, List<Warehouse> pickUpWarehouses) {
        currentMission = productOrder;
        List<Command> commandsToCompleteMission = new ArrayList<Command>();
        for (Warehouse warehouse : pickUpWarehouses) {
            for (Product product : productOrder.getProductsToBeDelivered()) {
                if (warehouse.hasProduct(product) && getCargoWeight() + product.getWeight() <= weightLimit) {
                    warehouse.takeProduct(product);
                    commandsToCompleteMission.add(new DroneCommand(id, DroneCommand.LOAD, warehouse.getId(), product.getId(), 1));
                    cargo.add(product);
                    turnsUntilDone += 1;
                } else if (getCargoWeight() + product.getWeight() > weightLimit) {
                    for (Product cargoProduct : cargo) {
                        commandsToCompleteMission.add(new DroneCommand(id, DroneCommand.DELIVER, productOrder.getId(), cargoProduct.getId(), 1));
                        turnsUntilDone += 1;
                    }
                    productOrder.getProductsToBeDelivered().removeAll(cargo);
                    cargo = new ArrayList<Product>();
                }
            }
        }
        return commandsToCompleteMission;
    }

    private int turnsToFlyToLocation(int destinationRow, int destinationColumn) {
        return (int) Math.sqrt(Math.pow(currentRow - destinationRow, 2) + Math.pow(currentColumn - destinationColumn, 2));
    }

    private int getCargoWeight() {
        int weight = 0;
        for (Product product : cargo) {
            weight += product.getWeight();
        }
        return weight;
    }
}
