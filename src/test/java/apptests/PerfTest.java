package apptests;

import app.TelephoneDialPad;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class PerfTest {
    @Test(timeOut = 5000)
    public void perftest1()
    {
        String expectedVal="Pneumonoultramicroscopicsilicovolcanoconiosis";
        LinkedList<String> testval= TelephoneDialPad.retrieveCombinations("763866668587264276736742745426805226626646747");

        Assert.assertTrue(testval.contains(expectedVal),"Perf Test failed");
    }
}
