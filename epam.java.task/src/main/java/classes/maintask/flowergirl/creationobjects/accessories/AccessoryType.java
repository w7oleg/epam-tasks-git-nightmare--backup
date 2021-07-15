package classes.maintask.flowergirl.creationobjects.accessories;

public enum AccessoryType {
    WRAPPING_PAPER("wrapping paper"), RIBBONS("ribbons");

    private String type;

    AccessoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return type;
    }
}
