import java.util.ArrayList;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class Yolo {
    public static final String LEARN_AND_TEACH = "learn_and_teach";
    public static final String LOGO = "logo";
    public static final String RIGHT_ANGLE = "right_angle";

    public static void main(String[] args) {
//        List<PaintingPoint> paintingPoints = new ArrayList<PaintingPoint>();
//        paintingPoints.add(new PaintingPoint(0, 0, true));
//        paintingPoints.add(new PaintingPoint(0, 1, false));
//        paintingPoints.add(new PaintingPoint(1, 0, false));
//        paintingPoints.add(new PaintingPoint(1, 1, true));

        Painting learnAndTeachPainting = FileManager.readInputFile("PaintingTestProblem/InputFilesFromGoogle/" + LEARN_AND_TEACH + ".in");
        Painting logoPainting = FileManager.readInputFile("PaintingTestProblem/InputFilesFromGoogle/" + LOGO + ".in");
        Painting rightAnglePainting = FileManager.readInputFile("PaintingTestProblem/InputFilesFromGoogle/" + RIGHT_ANGLE + ".in");

        FileManager.createSubmissionFile(learnAndTeachPainting.convertPaintingPointsToCommands(), LEARN_AND_TEACH);
        FileManager.createSubmissionFile(logoPainting.convertPaintingPointsToCommands(), LOGO);
        FileManager.createSubmissionFile(rightAnglePainting.convertPaintingPointsToCommands(), RIGHT_ANGLE);
    }

}
