package apptests;

import app.TelephoneDialPad;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelDataReader;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

public class SanityTests {
    @Test(dataProvider = "sanitydatasupplier")
    public void sanityTest(String input, String expresult) {

        String[] expectedvals = expresult.split("\\|");
        LinkedList<String> expectedListvals
                = new LinkedList<>();

        Collections.addAll(expectedListvals, expectedvals);

        Assert.assertEquals(expectedListvals, TelephoneDialPad.retrieveCombinations(input));
    }

    @DataProvider
    public Object[][] sanitydatasupplier() throws IOException {
        File filename = new File("src/test/resources/TestScenarioData.xlsx");
        if (filename.exists())
        {
            return ExcelDataReader.getExceldata(filename, "SanityTestData");
        }
        return null;

    }

}
