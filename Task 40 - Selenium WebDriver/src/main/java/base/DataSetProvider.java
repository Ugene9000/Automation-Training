package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene_z on 7/26/16.
 */
public class DataSetProvider {

    private static BufferedReader reader;
    private static List<Object[]> list;
    private static String str;

    private static void readFromTxt() {
        try {
            while ((str = reader.readLine()) != null) {
                String[] stringArray = str.split(",");
                list.add(stringArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object[]> retrieveDataForNegativeLoginTest() throws FileNotFoundException {

        reader = new BufferedReader(new FileReader("/Users/eugene_z/Automation/Automation-Training/Task 40 - Selenium WebDriver/src/main/resources/login_page_negative_test_data.txt"));

        list = new ArrayList<Object[]>();
        str = new String();

        readFromTxt();

        return list;
    }

    public static List<Object[]> retrieveDataForPositiveLoginTest() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("/Users/eugene_z/Automation/Automation-Training/Task 40 - Selenium WebDriver/src/main/resources/login_page_positive_test_data.txt"));

        list = new ArrayList<Object[]>();
        str = new String();

        readFromTxt();

        return list;
    }

}



