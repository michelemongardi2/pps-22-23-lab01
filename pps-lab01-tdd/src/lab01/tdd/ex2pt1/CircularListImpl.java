package lab01.tdd.ex2pt1;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Exercise 2
 * Design a test for each method to be implemented for the CircularList
 * following the order suggested in the provided interface
 * In some cases, e.g. to test the next() method, more than one test
 * may improve the test suite
 * Think about a simple way to keep the internal state of the list
 */

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList;
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
        if(this.circularList.isEmpty())
            return Optional.empty();
        else {
            if(this.index <= 0)
                this.index = this.circularList.size()-1;
            return Optional.of(this.circularList.get(this.index--));
        }
    }

    @Override
    public void reset() {
        this.index = 0;
    }
}
