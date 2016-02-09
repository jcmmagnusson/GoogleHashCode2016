/**
 * Created by Chief on 2016-02-09.
 */
public class CommandEraseCell implements Command {
    private PaintingPoint erasePoint;

    public CommandEraseCell(PaintingPoint erasePoint) {
        this.erasePoint = erasePoint;

    }

    @Override
    public String getCommandOutput() {
        return "ERASE_CELL " + erasePoint.row + " " + erasePoint.column;
    }

}