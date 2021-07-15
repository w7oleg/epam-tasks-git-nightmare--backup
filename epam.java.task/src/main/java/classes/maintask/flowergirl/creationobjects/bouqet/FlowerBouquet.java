package classes.maintask.flowergirl.creationobjects.bouqet;

import classes.maintask.flowergirl.creationobjects.accessories.Accessory;
import classes.maintask.flowergirl.creationobjects.flowers.Flower;
import classes.maintask.flowergirl.creationobjects.helperclasses.FlowersSortStrategy;
import classes.maintask.flowergirl.creationobjects.helperclasses.SortStrategy;

import java.util.ArrayList;
import java.util.List;

public class FlowerBouquet implements Bouquet {
    private List<Flower> flowers;

    private List<Accessory> accessories;

    private SortStrategy<Flower> sortStrategy;

    public FlowerBouquet() {
        flowers = new ArrayList<Flower>();
        accessories = new ArrayList<Accessory>();
        sortStrategy = new FlowersSortStrategy();
    }

    @Override
    public List<Flower> sort() {
        sortStrategy.sort(flowers);
        return flowers;
    }

    @Override
    public double getPrice() {
        double price = 0;

        price += flowers.stream().mapToDouble(Flower::getPrice).sum();
        price += accessories.stream().mapToDouble(Accessory::getPrice).sum();

        return price;
    }

    @Override
    public List<Flower> getFlowersFromStemDiapason(double bottomLimit, double topLimit) {
        List<Flower> result = new ArrayList<>();

        flowers.stream().filter(flower -> flower.getStemLength() >= bottomLimit && flower.getStemLength() <= topLimit)
                .forEach(result::add);

        return result;
    }

    @Override
    public void addFlower(Flower flower) {
        this.flowers.add(flower);
    }

    @Override
    public void addAccessory(Accessory accessory) {
        this.accessories.add(accessory);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public static Builder newBuilder() {
        return new FlowerBouquet().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder addFlower(Flower flower) {
            FlowerBouquet.this.flowers.add(flower);
            return this;
        }

        public Builder addAccessory(Accessory accessory) {
            FlowerBouquet.this.accessories.add(accessory);
            return this;
        }

        public FlowerBouquet build() {
            return FlowerBouquet.this;
        }
    }
}
