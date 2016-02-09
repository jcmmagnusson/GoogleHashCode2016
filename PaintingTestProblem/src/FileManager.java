import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-09
 */
public class FileManager {
    public FileManager() {

    }

    public static void createSubmissionFile(List<Command> commands) {
        int numberOfCommands = commands.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfCommands).append("\n");

        for (Command command : commands) {
            stringBuilder.append(command.getCommandOutput()).append("\n");
        }

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("submission_file.txt");
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
