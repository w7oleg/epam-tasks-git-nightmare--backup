package collections.flowergirl.creationobjects.flowers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Flower {
    private String name;

    private double budDiameter;

    private double stemLength;

    private boolean isSpiked;

    private List<FlowerColors> colors;

    private double price;

    private double hoursAfterCutoff;

    public Flower() {
        colors = new ArrayList<>();
    }

    public Flower(String name, double budDiameter, double stemLength, boolean isSpiked, List<FlowerColors> colors,
                  double price, double hoursAfterCutoff) {
        this.name = name;
        this.budDiameter = budDiameter;
        this.stemLength = stemLength;
        this.isSpiked = isSpiked;
        this.colors = colors;
        this.price = price;
        this.hoursAfterCutoff = hoursAfterCutoff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudDiameter() {
        return budDiameter;
    }

    public void setBudDiameter(double budDiameter) {
        this.budDiameter = budDiameter;
    }

    public double getStemLength() {
        return stemLength;
    }

    public void setStemLength(double stemLength) {
        this.stemLength = stemLength;
    }

    public boolean isSpiked() {
        return isSpiked;
    }

    public void setSpiked(boolean isSpiked) {
        this.isSpiked = isSpiked;
    }

    public List<FlowerColors> getColors() {
        return colors;
    }

    public void setColors(List<FlowerColors> colors) {
        this.colors = colors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getHoursAfterCutoff() {
        return hoursAfterCutoff;
    }

    public void setHoursAfterCutoff(double hoursAfterCutoff) {
        this.hoursAfterCutoff = hoursAfterCutoff;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Flower)) {
            return false;
        }

        Flower flower = (Flower) (obj);

        return this.name.equals(flower.getName()) &&
                this.budDiameter == flower.budDiameter &&
                this.stemLength == flower.stemLength &&
                this.isSpiked == flower.isSpiked &&
                this.colors.equals(flower.colors) &&
                this.price == flower.price &&
                this.hoursAfterCutoff == flower.hoursAfterCutoff;
    }

    @Override
    public String toString() {
        return "{name: " + name +
                ", bud diameter: " + budDiameter +
                ", stem length: " + stemLength +
                ", isSpiked: " + isSpiked +
                ", colors: " + colors.stream().map(FlowerColors::toString).collect(Collectors.joining(", ")) +
                ", price: " + price +
                ", hours after cutoff: " + hoursAfterCutoff +
                "}";
    }
}
