/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class Main {
    public static final String BUSY_DAY = "busy_day";
    public static final String MOTHER_OF_ALL_WAREHOUSES = "mother_of_all_warehouses";
    public static final String REDUNDANCY = "redundancy";

    public static void main(String[] args) {
        ProblemState busyDayProblemState = InputOutputManager.readInputFile("OnlineQualificationRound/InputFilesFromGoogle/" + BUSY_DAY + ".in");
        ProblemState motherOfAllWarehousesProblemState = InputOutputManager.readInputFile("OnlineQualificationRound/InputFilesFromGoogle/" + MOTHER_OF_ALL_WAREHOUSES + ".in");
        ProblemState redundancyProblemState = InputOutputManager.readInputFile("OnlineQualificationRound/InputFilesFromGoogle/" + REDUNDANCY + ".in");

        busyDayProblemState.startSimulation(BUSY_DAY);
        motherOfAllWarehousesProblemState.startSimulation(MOTHER_OF_ALL_WAREHOUSES);
        redundancyProblemState.startSimulation(REDUNDANCY);
    }
}
