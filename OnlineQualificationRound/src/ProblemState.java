import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class ProblemState {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final int maxPayload;
    private final List<Drone> drones;
    private final List<Warehouse> warehouses;
    private final List<ProductOrder> productOrders;
    private Map<Integer, Integer> productWeights;
    private List<Command> commands;

    private int numberOfTurnsLeft;

    public ProblemState(int numberOfRows, int numberOfColumns, int maxPayload, int numberOfDrones, List<Warehouse> warehouses, List<ProductOrder> productOrders, Map<Integer, Integer> productWeights, int numberOfTurnsLeft) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.maxPayload = maxPayload;
        this.warehouses = warehouses;
        this.productOrders = productOrders;
        this.productWeights = productWeights;
        this.numberOfTurnsLeft = numberOfTurnsLeft;
        drones = new ArrayList<Drone>(numberOfDrones);
        commands = new ArrayList<Command>();

        for (int i = 0; i < numberOfDrones; i++) {
            drones.add(new Drone(i, maxPayload));
        }
    }

    public void startSimulation(String fileName) {
        int failCounterXDXDXD = 0;
        for (Drone drone : drones) {
            commands.addAll(drone.giveMission(productOrders.get(failCounterXDXDXD), warehouses));
            failCounterXDXDXD += 1;
        }
        InputOutputManager.createSubmissionFile(commands, fileName);
    }
}
