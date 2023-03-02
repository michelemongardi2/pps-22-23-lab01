import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    CircularList circularList = new CircularListImpl();

    @Test
    void testAddingElement() {
        assertTrue(circularList.isEmpty());
        circularList.add(0);
        assertFalse(circularList.isEmpty());
        assertEquals(1, circularList.size());
    }


}
