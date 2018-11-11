package com.epam.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ComparisonTest extends BaseTest {

    @Test
    public void compareGivenText2AssembledTest(){
        //GIVEN
        boolean expected = true;
        //WHEN
        boolean result = super.getTextService().compareGivenText2Assembled(super.getText());
        //THEN
        Assert.assertEquals(expected, result);
    }
}
