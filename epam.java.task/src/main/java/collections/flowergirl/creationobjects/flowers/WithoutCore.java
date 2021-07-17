package collections.flowergirl.creationobjects.flowers;

import java.util.List;


public class WithoutCore extends Flower {
    private int numberOfBerries;

    public WithoutCore() {
    }

    public WithoutCore(String name, double budDiameter, double stemLength, boolean isSpiked, List<FlowerColors> colors,
                       double price, double hoursAfterCutOf, int numberOfBerries) {
        super(name, budDiameter, stemLength, isSpiked, colors, price, hoursAfterCutOf);
        this.numberOfBerries = numberOfBerries;
    }

    public int getNumberOfBerries() {
        return numberOfBerries;
    }

    public void setNumberOfBerries(int numberOfBerries) {
        this.numberOfBerries = numberOfBerries;
    }
}
