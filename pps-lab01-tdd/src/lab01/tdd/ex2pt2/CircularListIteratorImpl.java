package lab01.tdd.ex2pt2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Exercise 2 pt2
 * Create a new version of CircularList in a new package, fully adopting
 * TDD.
 * Remove methods next, previous, and clear, replacing them with a
 * forwardIterator() and backwardIterator().
 *   - forwardIterator() returns a new java.util.Iterator, which
 *     yields next elements, circularly;
 *   - backwardIterator() returns a new java.util.Iterator, which
 *     yields previous elements, circularly;
 */

public class CircularListIteratorImpl implements CircularListIterator {

    private final List<Integer> circularList;
    private int index;

    public CircularListIteratorImpl() {
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
    public Iterator<Integer> forwardIterator() {
       return new Iterator<Integer>() {
           @Override
           public boolean hasNext() {
               return !circularList.isEmpty();
           }

           @Override
           public Integer next() {
               if(circularList.size() == index)
                   index = 0;
               return circularList.get(index++);
           }
       };
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return this.circularList.iterator();
    }


}
