import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/6/16.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(SlowTests.class)
public class Class1 extends ClassWithBeforeAndAfterMethods {

    @Rule
    public Timeout globalTimeout = Timeout.millis(40);

    @Test
    @Category(FastTests.class)
    public void testAdd() throws InterruptedException {
        mathematics.add(1, 2);
        assertEquals(3, mathematics.getResult());
        TimeUnit.MILLISECONDS.sleep(30);
    }

    @Test(expected = AssertionError.class)
    public void testDeduct() {
        mathematics.deduct(10, 3);
        assertEquals(7, mathematics.getResult());
    }

    @Test
    public void testMultiply() {
        mathematics.multiply(4, 3);
        assertEquals(12, mathematics.getResult());
    }

    @Test
    public void testDivide() {
        mathematics.divide(21, 3);
        assertEquals(7, mathematics.getResult());
    }

    @Test(expected = ArithmeticException.class)
    public void testTimedOutException() throws InterruptedException {
        mathematics.divide(1, 0);
    }
}