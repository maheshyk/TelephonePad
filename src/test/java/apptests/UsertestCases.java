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

public class UsertestCases {

    @Test(dataProvider = "usertestdatasupplier")
    public void Test1(String input,String expresult) {
        Assert.assertTrue(TelephoneDialPad.retrieveCombinations(input).contains(expresult));
//        System.out.println("vals:"+input+":"+expresult);
    }
    @DataProvider(parallel = true)
    public Object[][] usertestdatasupplier() throws IOException {
        File filename = new File("src/test/resources/TestScenarioData.xlsx");
        System.out.println("file " + filename.exists());
        String[][] sanitydata= ExcelDataReader.getExceldata(filename,"UserTestdata");
        return sanitydata;

    }
}
