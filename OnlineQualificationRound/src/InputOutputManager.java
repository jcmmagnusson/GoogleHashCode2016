import java.io.*;
import java.util.*;

/**
 * @author Johan Magnusson
 *         Date: 2016-02-11
 */
public class InputOutputManager {
    private InputOutputManager() {
    }

    public static ProblemState readInputFile(String fileName) {
        int numberOfRows;
        int numberOfColumns;
        int maxPayload;
        int numberOfDrones;
        int numberOfTurns;
        List<Warehouse> warehouses = new ArrayList<Warehouse>();
        List<ProductOrder> productOrders = new ArrayList<ProductOrder>();
        Map<Integer, Integer> productWeights = new HashMap<Integer, Integer>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String firstLine = br.readLine();
            String[] inputParameters = firstLine.split(" ");
            numberOfRows = Integer.parseInt(inputParameters[0]);
            numberOfColumns = Integer.parseInt(inputParameters[1]);
            numberOfDrones = Integer.parseInt(inputParameters[2]);
            numberOfTurns = Integer.parseInt(inputParameters[3]);
            maxPayload = Integer.parseInt(inputParameters[4]);

            int numberOfProductTypes = Integer.parseInt(br.readLine());
            String[] productTypeWeights = br.readLine().split(" ");
            for (int i = 0; i < numberOfProductTypes; i++) {
                productWeights.put(i, Integer.parseInt(productTypeWeights[i]));
            }

            int numberOfWarehouses = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberOfWarehouses; i++) {
                String location = br.readLine();
                String productsInStore = br.readLine();
                String[] coords = location.split(" ");
                String[] productsInfo = productsInStore.split(" ");
                Warehouse warehouse = new Warehouse(i, Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
                for (int j = 0; j < numberOfProductTypes; j++) {
                    if (productsInfo[j] != "0") {
                        int numberOfProductsOfThisType = Integer.parseInt(productsInfo[j]);
                        for (int k = 0; k < numberOfProductsOfThisType; k++) {
                            warehouse.addProductToInventory(new Product(j, productWeights.get(j)));
                        }
                    }
                }
            }

            int numberOfOrders = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberOfOrders; i++) {
                String location = br.readLine();
                int numberOfItems = Integer.parseInt(br.readLine());
                String products = br.readLine();
                String[] coords = location.split(" ");
                String[] productTypes = products.split(" ");
                int row = Integer.parseInt(coords[0]);
                int column = Integer.parseInt(coords[1]);
                List<Product> productList = new ArrayList<Product>(numberOfItems);
                for (int j = 0; j < numberOfItems; j++) {
                    int productId = Integer.parseInt(productTypes[j]);
                    productList.add(new Product(productId, productWeights.get(productId)));
                }
                productOrders.add(new ProductOrder(i, row, column, numberOfItems, productList));
            }

            return new ProblemState(numberOfRows, numberOfColumns, maxPayload, numberOfDrones, warehouses, productOrders, productWeights, numberOfTurns);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InputMismatchException("Something wrong with the input file");
    }

    public static void createSubmissionFile(List<Command> commands, String fileName) {
        int numberOfCommands = commands.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOfCommands).append("\n");

        for (Command command : commands) {
            stringBuilder.append(command.getCommandOutput()).append("\n");
        }

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
