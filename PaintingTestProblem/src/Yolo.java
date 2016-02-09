import java.util.ArrayList;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class Yolo {
    public static void main(String[] args) {
        List<PaintingPoint> paintingPoints = new ArrayList<PaintingPoint>();
        paintingPoints.add(new PaintingPoint(0, 0, true));
        paintingPoints.add(new PaintingPoint(0, 1, false));
        paintingPoints.add(new PaintingPoint(1, 0, false));
        paintingPoints.add(new PaintingPoint(1, 1, true));

        Painting painting = new Painting(2, 2, paintingPoints);
        FileManager.createSubmissionFile(painting.convertPaintingPointsToCommands());
    }

}
