package classes.maintask.flowergirl.controllerqueryprocessing;

import classes.maintask.flowergirl.creationobjects.accessories.Accessory;
import classes.maintask.flowergirl.creationobjects.bouqet.Bouquet;
import classes.maintask.flowergirl.creationobjects.bouqet.FlowerBouquet;
import classes.maintask.flowergirl.creationobjects.flowers.Flower;
import classes.maintask.flowergirl.workwithmenu.View;

import java.util.Scanner;

public class NewBouquetController extends Controller {
    private final int BOTTOM_SELECTION_VALUE = 1;
    private final int TOP_SELECTION_VALUE = 8;
    private final int CREATE_NEW_BOUQUET = 1;
    private final int SHOW_BOUQUET = 2;
    private final int ADD_FLOWER = 3;
    private final int ADD_ACCESSORY = 4;
    private final int SHOW_PRICE = 5;
    private final int SORT = 6;
    private final int SEARCH = 7;
    private final int RETURN_CODE = 8;

    private View view;

    public NewBouquetController() {
        view = new View();
    }

    /**
     * Method to process bouquet
     *
     * @param scanner object of System scanner
     **/
    public void processNewBouquet(Scanner scanner) {
        Bouquet bouquet = new FlowerBouquet();
        int userSelection = Constants.DEFAULT_SELECTION_CODE;
        while (userSelection != RETURN_CODE) {
            view.printNewBouquetMessage();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printNewBouquetMessage();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if (!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case CREATE_NEW_BOUQUET:
                    bouquet = new FlowerBouquet();
                    break;
                case SHOW_BOUQUET:
                    view.showBouquet(bouquet);
                    break;
                case ADD_FLOWER:
                    bouquet.addFlower(getFlower(scanner));
                    break;
                case ADD_ACCESSORY:
                    bouquet.addAccessory(getAccessory(scanner));
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
     * Method to get new flower
     *
     * @param scanner object of System scanner
     * @return pointer to Flower object
     **/
    private Flower getFlower(Scanner scanner) {
        return new NewFlowerController().processNewFlower(scanner);
    }

    /**
     * Method to get new accessory
     *
     * @param scanner object of System scanner
     * @return pointer to Accessory object
     **/
    private Accessory getAccessory(Scanner scanner) {
        return new NewAccessoryController().processNewAccessory(scanner);
    }
}
