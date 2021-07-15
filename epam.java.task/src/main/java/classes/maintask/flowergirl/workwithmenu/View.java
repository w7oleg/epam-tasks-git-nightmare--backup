package classes.maintask.flowergirl.workwithmenu;

import classes.maintask.flowergirl.creationobjects.bouqet.Bouquet;
import classes.maintask.flowergirl.creationobjects.helperclasses.ResourceBundleManager;

import java.util.List;
import java.util.ResourceBundle;

public class View {
    public <T> void printMessage(T message) {
        System.out.println(message);
    }

    public <T> void printAll(List<T> list) {
        list.forEach(System.out::println);
    }

    public void printBaseMenu() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String menu = "\n" + resourceBundle.getString("menu.bouquet.file") + "\n" +
                resourceBundle.getString("menu.bouquet.new") + "\n" +
                resourceBundle.getString("menu.exit");
        System.out.println(menu);
    }

    public void printBouquetFromFileMenu() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String menu = "\n" + resourceBundle.getString("menu.file.show") + "\n" +
                resourceBundle.getString("menu.file.price") + "\n" +
                resourceBundle.getString("menu.file.sort") + "\n" +
                resourceBundle.getString("menu.file.search") + "\n" +
                resourceBundle.getString("menu.file.return");
        System.out.println(menu);
    }

    public void printNewBouquetMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String menu = "\n" + resourceBundle.getString("menu.new.bouquet") + "\n" +
                resourceBundle.getString("menu.new.show") + "\n" +
                resourceBundle.getString("menu.new.add.flower") + "\n" +
                resourceBundle.getString("menu.new.add.accessory") + "\n" +
                resourceBundle.getString("menu.new.price") + "\n" +
                resourceBundle.getString("menu.new.sort") + "\n" +
                resourceBundle.getString("menu.new.search") + "\n" +
                resourceBundle.getString("menu.new.return") + "\n";
        System.out.println(menu);
    }

    public void printIncorrectChoiceMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("menu.incorrect"));
    }

    public void printBottomLimit() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("search.bottom"));
    }

    public void printTopLimit() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("search.top"));
    }

    public String getErrorMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        return resourceBundle.getString("error") + " ";
    }

    public void showBouquet(Bouquet bouquet) {
        bouquet.getFlowers().forEach(System.out::println);
        bouquet.getAccessories().forEach(System.out::println);
    }

    public void printAddAccessoryMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String message = resourceBundle.getString("new.accessory.type") + "\n" +
                resourceBundle.getString("new.accessory.type.paper") + "\n" +
                resourceBundle.getString("new.accessory.type.ribbons");

        System.out.println(message);
    }

    public void printSelectPriceMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.accessory.price"));
    }

    public void printAddFlowerMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String message = resourceBundle.getString("new.flower.type") + "\n" +
                resourceBundle.getString("new.flower.type.berry") + "\n" +
                resourceBundle.getString("new.flower.type.wild") + "\n" +
                resourceBundle.getString("new.flower.type.regular");

        System.out.println(message);
    }

    public void printSelectNameMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.flower.name"));
    }

    public void printSelectBudDiameterMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.flower.diameter"));
    }

    public void printSelectStemLengthMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.flower.stem"));
    }

    public void printSelectSpikedMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.flower.spiked"));
    }

    public void printColorSelectionMenu() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        String menu = resourceBundle.getString("new.flower.color") + "\n" +
                resourceBundle.getString("new.flower.color.red") + "\n" +
                resourceBundle.getString("new.flower.color.orange") + "\n" +
                resourceBundle.getString("new.flower.color.blue") + "\n" +
                resourceBundle.getString("new.flower.color.white") + "\n" +
                resourceBundle.getString("new.flower.color.green") + "\n" +
                resourceBundle.getString("new.flower.color.yellow") + "\n" +
                resourceBundle.getString("new.flower.color.pink") + "\n" +
                resourceBundle.getString("new.flower.color.end");

        System.out.println(menu);
    }

    public void printSelectHoursAfterCutOffMessage() {
        ResourceBundle resourceBundle = ResourceBundleManager.getResourceBundle();
        System.out.println(resourceBundle.getString("new.flower.hours"));
    }
}
