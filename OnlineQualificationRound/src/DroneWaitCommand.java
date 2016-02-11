/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class DroneWaitCommand implements Command {
    private final int droneID;
    private final int turnsToWait;

    public DroneWaitCommand(int droneID, int turnsToWait) {
        this.droneID = droneID;
        this.turnsToWait = turnsToWait;
    }

    @Override
    public String getCommandOutput() {
        return droneID + " W " + turnsToWait;
    }
}
