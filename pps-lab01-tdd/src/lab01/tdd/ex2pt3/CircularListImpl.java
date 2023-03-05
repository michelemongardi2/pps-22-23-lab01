package lab01.tdd.ex2pt3;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Exercise 2 pt3
 * Create a new version of CircularList in a new package, fully
 * adopting TDD.
 * Implement a filteredNext(?) method for your CircularList that
 * finds and returns the next element that satisfies a given condition.
 * Choose an appropriate argument, seeking for good generality.
 * If no such element is found the method should return an empty
 * Optional.
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

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> filter) {
        if(this.circularList.isEmpty())
            return Optional.empty();
        else {
            List<Integer> supportList = new LinkedList<>(this.circularList.subList(index, this.circularList.size()));
            supportList.addAll(this.circularList.subList(0, index));
            Optional<Integer> next = supportList.stream().filter(filter).findFirst();
            if(next.isEmpty()) {
                return Optional.empty();
            }
            this.index = this.circularList.indexOf(next.get());
            return next;
        }
    }
}
