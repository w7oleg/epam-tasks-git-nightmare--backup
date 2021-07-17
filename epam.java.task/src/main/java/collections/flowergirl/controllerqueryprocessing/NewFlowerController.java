package collections.flowergirl.controllerqueryprocessing;

import collections.flowergirl.creationobjects.flowers.Flower;
import collections.flowergirl.creationobjects.flowers.FlowerColors;
import collections.flowergirl.creationobjects.flowers.StreetFlower;
import collections.flowergirl.creationobjects.flowers.WithoutCore;
import collections.flowergirl.workwithmenu.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewFlowerController {
    View view;

    public NewFlowerController() {
        this.view = new View();
    }

    /**
     * Method to process creation of new flower
     *
     * @param scanner object of System scanner
     * @return pointer to Flower object
     **/
    public Flower processNewFlower(Scanner scanner) {
        Flower flower;

        flower = chooseFlowerType(scanner);

        view.printSelectNameMessage();
        flower.setName(scanner.next());

        view.printSelectBudDiameterMessage();
        flower.setBudDiameter(readDouble(scanner));

        view.printSelectStemLengthMessage();
        flower.setStemLength(readDouble(scanner));

        view.printSelectSpikedMessage();
        flower.setSpiked(readBoolean(scanner));

        flower.setColors(readColors(scanner));

        view.printSelectPriceMessage();
        flower.setPrice(readDouble(scanner));

        view.printSelectHoursAfterCutOffMessage();
        flower.setHoursAfterCutoff(readDouble(scanner));

        return flower;
    }

    /**
     * Method to get flower type from scanner
     *
     * @param scanner object of System scanner
     * @return pointer to Flower object
     **/
    private Flower chooseFlowerType(Scanner scanner) {
        final int BERRY_TYPE = 1;
        final int WILD_TYPE = 2;
        final int REGULAR_TYPE = 3;
        int selectedType;

        while (true) {
            view.printAddFlowerMessage();
            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printAddFlowerMessage();
                scanner.next();
            }

            selectedType = scanner.nextInt();
            if (selectedType != BERRY_TYPE && selectedType != WILD_TYPE && selectedType != REGULAR_TYPE) {
                view.printIncorrectChoiceMessage();
                continue;
            } else {
                if (selectedType == BERRY_TYPE) {
                    return new WithoutCore();
                }
                if (selectedType == WILD_TYPE) {
                    return new StreetFlower();
                } else {
                    return new Flower();
                }
            }
        }
    }

    /**
     * Method to read double value from scanner
     *
     * @param scanner object of System scanner
     * @return double value
     **/
    private double readDouble(Scanner scanner) {
        double value;

        while (true) {
            while (!scanner.hasNextDouble()) {
                view.printIncorrectChoiceMessage();
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value <= 0) {
                view.printIncorrectChoiceMessage();
                continue;
            }
            break;
        }

        return value;
    }

    /**
     * Method to read boolean value from scanner
     *
     * @param scanner object of System scanner
     * @return boolean value
     **/
    private boolean readBoolean(Scanner scanner) {
        boolean value;

        while (true) {
            while (!scanner.hasNextBoolean()) {
                view.printIncorrectChoiceMessage();
                scanner.next();
            }

            value = scanner.nextBoolean();
            break;
        }

        return value;
    }

    /**
     * Method to read get List of flower colors from user
     *
     * @param scanner object of System scanner
     * @return list of colors
     **/
    private List<FlowerColors> readColors(Scanner scanner) {
        List<FlowerColors> colors = new ArrayList<>();
        final int END_CODE = 8;

        int userSelection = 0;

        while (userSelection != END_CODE) {
            view.printColorSelectionMenu();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printColorSelectionMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();

            if (userSelection <= 0 || userSelection > END_CODE) {
                view.printIncorrectChoiceMessage();
            } else {
                if (userSelection != END_CODE) {
                    FlowerColors flowerColor = FlowerColors.values()[userSelection - 1];
                    if (!colors.contains(flowerColor)) {
                        colors.add(flowerColor);
                    }
                }
            }
        }

        return colors;
    }
}
