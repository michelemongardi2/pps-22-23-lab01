import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertEquals(1, this.circularList.size());
        assertTrue(this.circularList.next().isPresent());
    }

}
