package ex2pt3test;

import lab01.tdd.ex2pt3.CircularList;
import lab01.tdd.ex2pt3.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    void setCircularList() {
        this.circularList = new CircularListImpl();
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
    void testNextElementOfTheList() {
        this.circularList.next();
        assertFalse(this.circularList.next().isPresent());
        this.circularList.add(1);
        assertTrue(this.circularList.next().isPresent());
    }

    @Test
    void testNextCircular() {
        testSizeMethod();
        assertEquals(Optional.of(0), this.circularList.next());
        this.circularList.next();
        assertEquals(Optional.of(2), this.circularList.next());
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void testReset() {
        testNextCircular();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(Optional.of(0), this.circularList.next());
    }

    @Test
    void testPreviousElementOfTheList() {
        this.circularList.add(100);
        assertEquals(Optional.of(100), this.circularList.previous());
        assertEquals(Optional.of(100), this.circularList.previous());
    }

    @Test
    void testPreviousCircular() {
        this.circularList.previous();
        assertFalse(this.circularList.next().isPresent());
        testSizeMethod();
        assertEquals(Optional.of(2), this.circularList.previous());
    }

    @Test
    void testFilteredNext() {
        for(int i=0; i<10; i++){
            this.circularList.add(i);
        }
        this.circularList.next();
        this.circularList.next();
        this.circularList.next();
        assertEquals(Optional.of(4), this.circularList.filteredNext(firstEven -> firstEven %2 == 0));
    }

    @Test
    void testFilteredNextNotFound() {
        for(int i=0; i<10; i++){
            this.circularList.add(2);
        }
        this.circularList.next();
        assertEquals(Optional.empty(), this.circularList.filteredNext(firstZero -> firstZero == 0));
    }
}
