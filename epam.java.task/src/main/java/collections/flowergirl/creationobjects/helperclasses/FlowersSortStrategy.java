package collections.flowergirl.creationobjects.helperclasses;

import collections.flowergirl.creationobjects.flowers.Flower;

import java.util.Comparator;
import java.util.List;

public class FlowersSortStrategy implements SortStrategy<Flower> {
    @Override
    public void sort(List<Flower> list) {
        list.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower firstFlower, Flower secondFlower) {
                return (int) (firstFlower.getHoursAfterCutoff() - secondFlower.getHoursAfterCutoff());
            }
        });
    }
}
