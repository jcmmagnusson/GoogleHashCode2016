import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class FileManager {
    private FileManager() {
    }

    public static Painting readInputFile(String fileName) {
        List<PaintingPoint> paintingPoints;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String firstLine = bufferedReader.readLine();
            String[] inputParameters = firstLine.split(" ");
            int numberOfRows = Integer.parseInt(inputParameters[0]);
            int numberOfColumns = Integer.parseInt(inputParameters[1]);
            paintingPoints = new ArrayList<PaintingPoint>(numberOfRows*numberOfColumns);
            for (int row = 0; row < numberOfRows; row++) {
                String currentLine = bufferedReader.readLine();
                for (int column = 0; column < numberOfColumns; column++) {
                    paintingPoints.add(new PaintingPoint(row, column, isPaintChar(currentLine.charAt(column))));
                }
            }

            return new Painting(numberOfRows, numberOfColumns, paintingPoints);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InputMismatchException("Something wrong with the input file");
    }

    private static boolean isPaintChar(char inputChar) {
        return inputChar == '#';
    }
}
