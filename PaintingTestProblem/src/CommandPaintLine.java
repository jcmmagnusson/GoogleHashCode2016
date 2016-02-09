/**
 * Created by Chief on 2016-02-09.
 */
public class CommandPaintLine implements Command {
    private PaintingPoint paintingPointStart;
    private PaintingPoint paintingPointStop;

    public CommandPaintLine(PaintingPoint paintingPointStart, PaintingPoint paintingPointStop) {
        this.paintingPointStart = paintingPointStart;
        this.paintingPointStop = paintingPointStop;


    }

    @Override
    public String getCommandOutput() {
        return "PAINT_LINE " + paintingPointStart.row + " " + paintingPointStart.column + " " + paintingPointStop.row + " " + paintingPointStop.column;

    }
}
