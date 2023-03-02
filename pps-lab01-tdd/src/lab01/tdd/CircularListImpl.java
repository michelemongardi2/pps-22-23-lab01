package lab01.tdd;

import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private boolean empty;

    @Override
    public void add(int element) {

        this.empty = true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.empty;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
