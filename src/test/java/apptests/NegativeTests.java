package apptests;

import app.TelephoneDialPad;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class NegativeTests {
    @Test
    public void emptyTest() {
     Assert.assertTrue(TelephoneDialPad.retrieveCombinations("").isEmpty());
    }

    @Test
    public void invalidFormattest1() {
//        Assert.assertTrue(TelephoneDialPad.retrieveCombinations("#1").isEmpty());
        Assert.assertThrows(()->TelephoneDialPad.retrieveCombinations("#1"));
    }
    @Test
    public void invalidFormattest2() {
//        Assert.assertTrue(TelephoneDialPad.retrieveCombinations("#1").isEmpty());
        Assert.assertThrows(()->TelephoneDialPad.retrieveCombinations("4#"));
    }
}
