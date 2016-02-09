/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class PaintingPoint {
    public final int row;
    public final int column;
    private final boolean shouldBePainted;

    public PaintingPoint(int row, int column, boolean shouldBePainted) {
        this.row = row;
        this.column = column;
        this.shouldBePainted = shouldBePainted;
    }


}
