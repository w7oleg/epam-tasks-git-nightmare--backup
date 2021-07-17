package collections.flowergirl.controllerqueryprocessing;

import collections.flowergirl.creationobjects.bouqet.Bouquet;
import collections.flowergirl.creationobjects.flowers.Flower;
import collections.flowergirl.workwithmenu.View;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;

    public Controller() {
        this.view = new View();
    }

    /**
     * Method to process main menu
     *
     * @param scanner object of System scanner
     **/
    public void processUser(Scanner scanner) {
        int userSelection = Constants.DEFAULT_SELECTION_CODE;
        while (userSelection != Constants.EXIT_CODE) {
            view.printBaseMenu();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printBaseMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if (!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case Constants.BOUQUET_FROM_FILE:
                    processBouquetFromFile(scanner);
                    break;
                case Constants.NEW_BOUQUET:
                    processNewBouquet(scanner);
                    break;
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
        return input >= Constants.BOTTOM_SELECTION_VALUE && input <= Constants.TOP_SELECTION_VALUE;
    }

    private void processBouquetFromFile(Scanner scanner) {
        new BouquetFromFileController().processBouquetFromFile(scanner);
    }

    private void processNewBouquet(Scanner scanner) {
        new NewBouquetController().processNewBouquet(scanner);
    }

    /**
     * Method that search flowers in given stem length diapason
     *
     * @param scanner object of System scanner
     * @param bouquet object of Bouquet in which search will be processed
     * @return result of search
     **/
    protected List<Flower> processSearch(Scanner scanner, Bouquet bouquet) {
        double min, max;

        view.printBottomLimit();
        while (!scanner.hasNextDouble()) {
            view.printIncorrectChoiceMessage();
            view.printBottomLimit();
            scanner.next();
        }
        min = scanner.nextDouble();

        view.printTopLimit();
        while (!scanner.hasNextDouble()) {
            view.printTopLimit();
            view.printIncorrectChoiceMessage();
            scanner.next();
        }
        max = scanner.nextDouble();

        return bouquet.getFlowersFromStemDiapason(min, max);
    }
}
