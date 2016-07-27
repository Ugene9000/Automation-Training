import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by eugene_z on 7/11/16.
 */
abstract public class BeforeAndAfterTests {

    Mathematics mathematics = new Mathematics();

    @BeforeMethod(alwaysRun = true)
    public void setResultToZero() {
        mathematics.setResult(0);
    }

    @AfterMethod(alwaysRun = true)
    public void setResultToOne() {
        mathematics.setResult(1);
    }
}
