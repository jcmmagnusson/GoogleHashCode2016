/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class PaintSquareCommand implements Command {
    private PaintingPoint paintingPoint;
    private int radius;

    public PaintSquareCommand(PaintingPoint paintingPoint, int radius) {
        this.paintingPoint = paintingPoint;
        this.radius = radius;
    }

    @Override
    public String getCommandOutput() {
        return "PAINT_SQUARE " + paintingPoint.row + " " + paintingPoint.column + " " + radius;
    }
}
