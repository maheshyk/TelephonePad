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
    public void Test1(String input,String expresult) {

        String[] expectedvals=expresult.split("\\|");
        LinkedList<String> expectedListvals
                = new LinkedList<String>();

        Collections.addAll(expectedListvals,expectedvals);

        Assert.assertEquals(expectedListvals, TelephoneDialPad.retrieveCombinations(input));
//        System.out.println("vals:"+input+":"+expresult);
    }
    @DataProvider
    public Object[][] sanitydatasupplier() throws IOException {
        File filename = new File("src/test/resources/TestScenarioData.xlsx");
        System.out.println("file " + filename.exists());
        String[][] sanitydata=ExcelDataReader.getExceldata(filename,"SanityData");
        return sanitydata;

    }
    @Test
    void Test2() {
//        assertEquals("1",TelephoneDialPad.retrieveCombinations("1"));
//        assertArrayEquals(new String[]{"1"},TelephoneDialPad.retrieveCombinations("1"));
        Assert.assertTrue(TelephoneDialPad.retrieveCombinations("1").equals(new LinkedList<String>(Collections.singleton("1"))));
    }
}
