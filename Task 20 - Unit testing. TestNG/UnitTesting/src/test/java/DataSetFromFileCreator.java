import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene_z on 7/14/16.
 */
public class DataSetFromFileCreator {

    public static List<Object[]> retrieveDataFromFile() throws IOException, FileNotFoundException {


        BufferedReader reader = new BufferedReader(new FileReader("/Users/eugene_z/Automation/Automation-Training/Task 20 - Unit testing. TestNG/UnitTesting/src/main/resources/TestData.txt"));
        String str;

        List<Object[]> list = new ArrayList<Object[]>();
        while ((str = reader.readLine()) != null) {
            String[] strArray = str.split(",");
            Integer[] intArray = new Integer[strArray.length];

            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = Integer.valueOf(strArray[i]);
            }
            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i]);
            }
            list.add(intArray);
        }
        for (Object[] element : list) {
            System.out.println(element);
        }
              return list;
    }



}
