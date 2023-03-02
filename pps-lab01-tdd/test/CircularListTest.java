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
}
