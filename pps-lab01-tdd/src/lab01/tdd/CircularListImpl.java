package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> circularList;
    private int index;

    public CircularListImpl() {
        this.circularList = new LinkedList<>();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(this.circularList.isEmpty())
            return Optional.empty();
        else {
            if(this.circularList.size() == this.index)
                this.index = 0;
            return Optional.of(this.circularList.get(this.index++));
        }
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
