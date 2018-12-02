import org.testng.Assert;
import org.testng.annotations.Test;

public class UnloadTest extends BaseTest{

    @Test
    public void unloadTest1(){
        //Given
        int expected = 25;
        //When
        int result = getHarborService().unload(getShips().get(1).getLoadedGoods());
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void unloadTest2(){
        //Given
        int expected = 500;
        //When
        getHarborService().unload(getShips().get(3).getLoadedGoods());
        int result = getHarbor().getStorageLoadedGoods();
        //Then
        Assert.assertEquals(expected, result);
    }

}
