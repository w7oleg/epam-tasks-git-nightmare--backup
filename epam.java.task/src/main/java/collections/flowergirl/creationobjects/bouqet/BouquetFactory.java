package collections.flowergirl.creationobjects.bouqet;

public class BouquetFactory {
    public static Bouquet getFlowerBouquet() {
        return new FlowerBouquet();
    }
}
