import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by eugene_z on 7/8/16.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({FastTests.class, SlowTests.class})
@Categories.ExcludeCategory(FastTests.class)
@Suite.SuiteClasses({Class1.class, Class2.class})
public class TestsRunnerViaCategories {
}
