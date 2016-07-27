import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by eugene_z on 7/7/16.
 */
@RunWith(Parameterized.class)
public class DataDrivenTests extends ClassWithBeforeAndAfterMethods {

    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{{8, 2, 10, 6, 16, 4}, {-10, 5, -5, -15, -50, -2}, {0, 1, 1, -1, 0, 0}, {1, -1, 0, 2, -1, -1}});
    }

    private int x;
    private int y;
    private int resultAdd;
    private int resultDeduct;
    private int resultMultiply;
    private int resultDivide;

    public DataDrivenTests(int x, int y, int resultAdd, int resultDeduct, int resultMultiply, int resultDivide) {
        this.x = x;
        this.y = y;
        this.resultAdd = resultAdd;
        this.resultDeduct = resultDeduct;
        this.resultMultiply = resultMultiply;
        this.resultDivide = resultDivide;
    }

    @Test
    public void dataDrivenTestAddition() {
        mathematics.add(x, y);
        Assert.assertEquals(resultAdd, mathematics.getResult());
    }

    @Test(expected = AssertionError.class)
    public void dataDrivenTestDeduct() {
        mathematics.deduct(x, y);
        Assert.assertEquals(resultDeduct, mathematics.getResult());
    }

    @Test
    public void dataDrivenTestMultiply() {
        mathematics.multiply(x, y);
        Assert.assertEquals(resultMultiply, mathematics.getResult());
    }

    @Test
    public void dataDrivenTestDivide() {
        mathematics.divide(x, y);
        Assert.assertEquals(resultDivide, mathematics.getResult());
    }
}
