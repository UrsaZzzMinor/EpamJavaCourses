package com.epam.training;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MostFrequentWordTest extends BaseTest{

    @Test
    public void findTheMostFrequentWordTest(){
        //GIVEN
        String expected = "the";
        //WHEN
        super.getTextService().findTheMostFrequentWord(super.getText());
        String result = super.getTextService().getTheMostFrequentWord().getContent();
        //THEN
        Assert.assertEquals(expected, result);
    }

    @Test
    public void findTheMostFrequentWordTest2(){
        //GIVEN
        int expected = 13;
        //WHEN
        super.getTextService().findTheMostFrequentWord(super.getText());
        int result = super.getTextService().getMax();
        //THEN
        Assert.assertEquals(expected, result);
    }

}
