import org.junit.After;
import org.junit.Before;

/**
 * Created by eugene_z on 7/7/16.
 */
public abstract class ClassWithBeforeAndAfterMethods {

    Mathematics mathematics = new Mathematics();

    @Before
    public void setResultToZero() {
        mathematics.setResult(0);
    }

    @After
    public void setResultToOne() {
        mathematics.setResult(1);
    }
}
