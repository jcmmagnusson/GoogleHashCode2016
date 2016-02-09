import java.util.Map;
import java.util.Set;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class Painting {
    private final int numberOfRows;
    private final int numberOfColumns;
    private PaintingPoint[][] paintingGrid;

    public Painting(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }
}
