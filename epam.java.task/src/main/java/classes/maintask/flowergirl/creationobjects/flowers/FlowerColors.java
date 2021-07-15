package classes.maintask.flowergirl.creationobjects.flowers;


public enum FlowerColors {
    RED("red"), ORANGE("orange"), BLUE("blue"), WHITE("white"),
    GREEN("green"), YELLOW("yellow"), PINK("pink");

    private String color;

    FlowerColors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
