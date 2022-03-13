package apptests;

import app.TelephoneDialPad;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.ExcelDataReader;

import java.io.File;
import java.io.IOException;


public class UsertestCases {

    @Test(dataProvider = "usertestdatasupplier")
    public void userTestcases(String input,String expresult) {
        Assert.assertTrue(TelephoneDialPad.retrieveCombinations(input).contains(expresult));
    }
    @DataProvider(parallel = true)
    public Object[][] usertestdatasupplier() throws IOException {
        File filename = new File("src/test/resources/TestScenarioData.xlsx");
        if(filename.exists())
        {
            return ExcelDataReader.getExceldata(filename,"UserTestdata");
        }
       return null;

    }
}
