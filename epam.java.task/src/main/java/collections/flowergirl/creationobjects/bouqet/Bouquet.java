package collections.flowergirl.creationobjects.bouqet;

import collections.flowergirl.creationobjects.accessories.Accessory;
import collections.flowergirl.creationobjects.flowers.Flower;

import java.util.List;

public interface Bouquet {
    /**
     * Method that sort flowers in bouquet by time after cutoff
     *
     * @return list of sorted flowers
     **/
    public List<Flower> sort();

    /**
     * Method that calculate total price of bouquet
     *
     * @return bouquet price
     **/
    public double getPrice();

    /**
     * Method that search bouquet flowers in stem length diapason
     *
     * @return list of flowers for given diapason
     **/
    public List<Flower> getFlowersFromStemDiapason(double bottomLimit, double topLimit);

    /**
     * Method that returns flowers
     *
     * @return list of flowers
     **/
    public List<Flower> getFlowers();

    /**
     * Method that returns accessories
     *
     * @return list of accessories
     **/
    public List<Accessory> getAccessories();

    /**
     * Method to add new flower in bouquet
     *
     * @param flower pointer to Flower object
     **/
    public void addFlower(Flower flower);

    /**
     * Method to add new accessory in bouquet
     *
     * @param accessory pointer to Accessory object
     **/
    public void addAccessory(Accessory accessory);
}
