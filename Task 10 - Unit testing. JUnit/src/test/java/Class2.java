import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 * Created by eugene_z on 7/6/16.
 */

@Category(FastTests.class)
public class Class2 extends ClassWithBeforeAndAfterMethods {

    @Ignore("This test is ignored according to the task")
    @Test
    public void testWithEmptyBody() {


    }
}

