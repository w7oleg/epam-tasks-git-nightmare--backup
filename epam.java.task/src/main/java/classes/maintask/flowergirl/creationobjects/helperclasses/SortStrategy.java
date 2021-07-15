package classes.maintask.flowergirl.creationobjects.helperclasses;

import java.util.List;

public interface SortStrategy<T> {
    /**
     * Method that sort considering certain option
     *
     * @param list list to be sorted
     **/
    public void sort(List<T> list);
}
