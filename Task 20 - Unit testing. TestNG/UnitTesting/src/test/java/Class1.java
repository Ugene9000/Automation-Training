import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import org.testng.reporters.Buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/11/16.
 */
public class Class1 extends BeforeAndAfterTests {


    public Class1() throws FileNotFoundException {
    }

    @Test(priority = 3, timeOut = 30, groups = {"smoke", "fast"}, expectedExceptions = ThreadTimeoutException.class)
    public void testAdd() throws InterruptedException {
        mathematics.add(1, 2);
        Assert.assertEquals(3, mathematics.getResult());
        TimeUnit.MILLISECONDS.sleep(70);
    }

    @Test(priority = 1, groups = {"fast"}, expectedExceptions = AssertionError.class)
    public void testDeduct() {
        mathematics.deduct(1, 4);
        Assert.assertEquals(-3, mathematics.getResult());
    }

    @Test(priority = 6, groups = {"fast"})
    public void testDivide() {
        mathematics.multiply(7, 9);
        Assert.assertEquals(63, mathematics.getResult());
    }

    @Test(priority = 2, groups = {"fast"})
    public void testMultiply() {
        mathematics.divide(21, 3);
        Assert.assertEquals(7, mathematics.getResult());
    }

    @Test(groups = {"fast"}, expectedExceptions = ArithmeticException.class)
    public void divideByZero() {
        mathematics.divide(1, 0);
    }

    @DataProvider(name = "dataSetAdd")
    public Object[][] dataProviderAdd() {
        return new Object[][]{{1, 1, 2}, {-1, 1, 0}, {-2, -2, -4}, {5, 0, 5}};
    }

    @DataProvider(name = "dataSetDeduct")
    public Object[][] dataProviderDeduct() {
        return new Object[][]{{1, 1, 0}, {-1, 1, -2}, {-2, -2, 0}, {5, 0, 5}};
    }

    @DataProvider(name = "dataSetDivide")
    public Object[][] dataProviderDivide() {
        return new Object[][]{{1, 1, 1}, {-1, 1, -1}, {-2, -2, 1}, {0, 5, 0}};
    }

    @DataProvider(name = "dataSetMultiply")
    public Object[][] dataProviderMultiply() {
        return new Object[][]{
                {1, 1, 1},
                {-1, 1, -1},
                {-2, -2, 4},
                {5, 0, 0}};
    }

    @Test(dataProvider = "dataSetAdd", priority = 40)
    public void dataDrivenTestAdd(int x, int y, int resultAdd) {
        mathematics.add(x, y);
        Assert.assertEquals(resultAdd, mathematics.getResult());
    }

    @Test(dataProvider = "dataSetDeduct", expectedExceptions = AssertionError.class, priority = 30)
    public void dataDrivenTestDeduct(int x, int y, int resultDeduct) {
        mathematics.deduct(x, y);
        Assert.assertEquals(resultDeduct, mathematics.getResult());
    }

    @Test(dataProvider = "dataSetDivide", priority = 10)
    public void dataDrivenTestDivide(int x, int y, int resultDivide) {
        mathematics.divide(x, y);
        Assert.assertEquals(resultDivide, mathematics.getResult());
    }

    @Test(dataProvider = "dataSetMultiply", dependsOnMethods = "dataDrivenTestDivide", priority = 1)
    public void dataDrivenTestMultiply(int x, int y, int resultMultiply) {
        mathematics.multiply(x, y);
        Assert.assertEquals(resultMultiply, mathematics.getResult());
    }

    @Parameters({"x", "y", "addResult"})
    @Test()
    public void dataDrivenTestUsingXml(int x, int y, int addResult) {
        int m_x = x;
        int m_y = y;
        int m_addResult = addResult;
        mathematics.add(m_x, m_y);
        Assert.assertEquals(m_addResult, mathematics.getResult());
    }

    @DataProvider(name = "DataSetFromFile")
    public Iterator<Object[]> createDataSet() throws IOException {
        return  DataSetFromFileCreator.retrieveDataFromFile().iterator();
    }

    @Test(dataProvider = "DataSetFromFile")
    public void testAddUsingDataFromFile(int x, int y, int resultAdd) {
        mathematics.add(x,y);
        Assert.assertEquals(resultAdd, mathematics.getResult());
    }



}