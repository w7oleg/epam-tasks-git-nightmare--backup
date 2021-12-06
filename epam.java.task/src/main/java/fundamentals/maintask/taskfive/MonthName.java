package fundamentals.maintask.taskfive;

public class MonthName {
    private int datam;
    private String nameMonth;

    public void setDatam(int datam) {
        this.datam = datam;
    }

    public int getDatam() {
        return datam;
    }

    public String name() {
        switch (datam) {
            case 1:
                nameMonth = "Январь";
                break;
            case 2:
                nameMonth = "Февраль";
                break;
            case 3:
                nameMonth = "Март";
                break;
            case 4:
                nameMonth = "Апрель";
                break;
            case 5:
                nameMonth = "Май";
                break;
            case 6:
                nameMonth = "Июнь";
                break;
            case 7:
                nameMonth = "Июль";
                break;
            case 8:
                nameMonth = "Август";
                break;
            case 9:
                nameMonth = "Сентябрь";
                break;
            case 10:
                nameMonth = "Октябрь";
                break;
            case 11:
                nameMonth = "Ноябрь";
                break;
            case 12:
                nameMonth = "Декабрь";
                break;
            default:
                break;
        }
        return nameMonth;
    }
}
