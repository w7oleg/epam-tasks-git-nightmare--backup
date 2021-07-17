package collections.flowergirl.controllerqueryprocessing;

import collections.flowergirl.creationobjects.CreationObjectsConstants;
import collections.flowergirl.creationobjects.accessories.Accessory;
import collections.flowergirl.creationobjects.accessories.AccessoryType;
import collections.flowergirl.creationobjects.bouqet.Bouquet;
import collections.flowergirl.creationobjects.bouqet.FlowerBouquet;
import collections.flowergirl.creationobjects.flowers.Flower;
import collections.flowergirl.creationobjects.flowers.FlowerColors;
import collections.flowergirl.workwithmenu.View;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;


public class BouquetFromFileController extends Controller {
    private final int BOTTOM_SELECTION_VALUE = 1;
    private final int TOP_SELECTION_VALUE = 5;
    private final int SHOW_BOUQUET = 1;
    private final int SHOW_PRICE = 2;
    private final int SORT = 3;
    private final int SEARCH = 4;
    private final int RETURN_CODE = 5;

    private View view;

    public BouquetFromFileController() {
        this.view = new View();
    }

    /**
     * Method to process test bouquet from file
     *
     * @param scanner object of System scanner
     **/
    public void processBouquetFromFile(Scanner scanner) {
        Bouquet bouquet = initializeBouquet();
        int userSelection = Constants.DEFAULT_SELECTION_CODE;
        while (userSelection != RETURN_CODE) {
            view.printBouquetFromFileMenu();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printBouquetFromFileMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if (!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case SHOW_BOUQUET:
                    view.showBouquet(bouquet);
                    break;
                case SHOW_PRICE:
                    view.printMessage(bouquet.getPrice());
                    break;
                case SORT:
                    bouquet.sort();
                    break;
                case SEARCH:
                    view.printAll(processSearch(scanner, bouquet));
            }
        }
    }

    /**
     * Method that check if given value is in diapason
     *
     * @param input given value to check
     * @return result of comparing
     **/
    private boolean checkInput(int input) {
        return input >= BOTTOM_SELECTION_VALUE && input <= TOP_SELECTION_VALUE;
    }

    /**
     * Method that read bouquet from file
     *
     * @return pointer to Bouquet object
     **/
    private FlowerBouquet initializeBouquet() {
        List<String[]> entries = getEntriesFromFile(Constants.BOUQUET_FILE_PATH);
        FlowerBouquet.Builder builder = FlowerBouquet.newBuilder();

        for (String[] entry : entries) {
            if (entry[0].equals(CreationObjectsConstants.FLOWER)) {
                builder.addFlower(constructFlower(entry));
            } else {
                builder.addAccessory(constructAccessory(entry));
            }
        }

        System.out.println(entries.size());

        return builder.build();
    }

    /**
     * Method that construct flower from array of strings
     *
     * @param entry given array of Strings
     * @return pointer to Flower object
     **/
    private Flower constructFlower(String[] entry) {
        Flower flower = new Flower();

        flower.setName(entry[1]);
        flower.setBudDiameter(Double.parseDouble(entry[2]));
        flower.setStemLength(Double.parseDouble(entry[3]));
        flower.setSpiked(Boolean.parseBoolean(entry[4]));
        flower.setColors(Arrays.asList(FlowerColors.valueOf(entry[5])));
        flower.setPrice(Double.parseDouble(entry[6]));
        flower.setHoursAfterCutoff(Double.parseDouble((entry[7])));

        return flower;
    }

    /**
     * Method that construct flower from array of strings
     *
     * @param entry given array of Strings
     * @return pointer to Accessory object
     **/
    private Accessory constructAccessory(String[] entry) {
        Accessory accessory = new Accessory();

        accessory.setType(AccessoryType.valueOf(entry[1]));
        accessory.setPrice(Double.parseDouble(entry[2]));

        return accessory;
    }

    /**
     * Method that extract from file arrays of strings, which represents bouquet entries
     *
     * @param path path to file
     * @return List os Strings arrays thar represents bouquet entry
     **/
    private List<String[]> getEntriesFromFile(String path) {
        List<String[]> entries = new ArrayList<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(Constants.BOUQUET_FILE_PATH);

        if (url != null) {
            String filePath = url.getFile();
            try {
                filePath = URLDecoder.decode(filePath, Constants.DECODING_ALGORITHM);
            } catch (UnsupportedEncodingException e) {
                view.printMessage(view.getErrorMessage() + e);
            }

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    entries.add(line.split(Constants.SPLIT_MARK));
                }
            } catch (IOException e) {
                view.printMessage(view.getErrorMessage() + e);
            }
        }

        return entries;
    }
}
