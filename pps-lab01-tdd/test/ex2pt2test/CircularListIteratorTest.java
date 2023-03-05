package ex2pt2test;

import lab01.tdd.ex2pt2.CircularListIterator;
import lab01.tdd.ex2pt2.CircularListIteratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListIteratorTest {

    private CircularListIterator circularList;

    @BeforeEach
    void setCircularList() {
        this.circularList = new CircularListIteratorImpl();
    }

    @Test
    void testCircularListIsEmpty() {
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void testAddingElement() {
        assertTrue(this.circularList.isEmpty());
        this.circularList.add(0);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void testSizeMethod() {
        this.circularList.add(0);
        this.circularList.add(1);
        this.circularList.add(2);
        assertEquals(3, this.circularList.size());
    }

    @Test
    void testForwardIterator() {
        testSizeMethod();
        this.circularList.forwardIterator().next();
        assertEquals(1, this.circularList.forwardIterator().next());
        this.circularList.forwardIterator().next();
        assertEquals(0, this.circularList.forwardIterator().next());
        this.circularList.forwardIterator().next();
    }

    @Test
    void testBackwardIterator() {
        testForwardIterator();
        assertEquals(2, this.circularList.backwardIterator().next());
        this.circularList.backwardIterator().next();
        assertEquals(0, this.circularList.backwardIterator().next());
    }

}
