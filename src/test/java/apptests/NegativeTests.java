package apptests;

import app.TelephoneDialPad;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import tools.ExcelDataReader;

import java.io.File;
import java.io.IOException;

public class NegativeTests {

    @Test(testName = "Invalid format first test -#1")
    public void invalidFormattest1() {
        try {
            TelephoneDialPad.retrieveCombinations("#1");
        } catch (Exception ex) {
            Assert.fail("Exception was thrown for invalid format!");
        }
    }

    @Test(testName = "Invalid format second test -4#")
    public void invalidFormattest2() {


        try {
            TelephoneDialPad.retrieveCombinations("4#");
        } catch (Exception ex) {
            Assert.fail("Exception was thrown for invalid format!");
        }
    }

    @Test(dataProvider = "negativetestdatasupplier",testName = "Negative scenarios")
    public void negativeTestscenarios(String input, String expresult) {
        Assert.assertFalse(TelephoneDialPad.retrieveCombinations(input).contains(expresult));
    }

    @DataProvider(parallel = true)
    public Object[][] negativetestdatasupplier() throws IOException {

        File filename = new File("src/test/resources/TestScenarioData.xlsx");
        if (filename.exists()) {
            return ExcelDataReader.getExceldata(filename, "NegativeTestData");
        }
        return null;

    }

}
