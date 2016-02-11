/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class DroneCommand implements Command {
    public static final String LOAD = "L";
    public static final String UNLOAD = "U";
    public static final String DELIVER = "D";

    private final int droneID;
    private final String action;
    private final int locationID;
    private final int productID;
    private final int amount;

    public DroneCommand(int droneID, String action, int locationID, int productID, int amount) {
        this.droneID = droneID;
        this.action = action;
        this.locationID = locationID;
        this.productID = productID;
        this.amount = amount;
    }

    @Override
    public String getCommandOutput() {
        return droneID + " " + action + " " + locationID + " " + productID + " " + amount;
    }
}
