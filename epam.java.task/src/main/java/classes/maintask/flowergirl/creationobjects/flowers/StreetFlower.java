package classes.maintask.flowergirl.creationobjects.flowers;


import java.util.List;

public class StreetFlower extends Flower {
    private boolean havingBuld;

    public StreetFlower() {
    }

    public StreetFlower(String name, double budDiameter, double stemLength, boolean isSpiked, List<FlowerColors> colors,
                        double price, double hoursAfterCutOff, boolean havingBuld) {
        super(name, budDiameter, stemLength, isSpiked, colors, price, hoursAfterCutOff);
        this.havingBuld = havingBuld;
    }

    public boolean isHavingBuld() {
        return havingBuld;
    }

    public void setHavingBuld(boolean havingBuld) {
        this.havingBuld = havingBuld;
    }
}