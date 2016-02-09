import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class Painting {
    private final int numberOfRows;
    private final int numberOfColumns;
    private List<PaintingPoint> paintingPoints;

    public Painting(int numberOfRows, int numberOfColumns, List<PaintingPoint> paintingPoints) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.paintingPoints = paintingPoints;
    }

    public List<Command> convertPaintingPointsToCommands() {
        List<Command> commands = new ArrayList<Command>();
        for(PaintingPoint paintingPoint : paintingPoints) {
            if (paintingPoint.shouldBePainted()) {
                commands.add(new CommandPaintLine(paintingPoint, paintingPoint));
            }
        }
        return commands;
    }
}
