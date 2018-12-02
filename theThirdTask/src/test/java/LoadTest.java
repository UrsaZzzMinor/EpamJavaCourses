import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadTest extends BaseTest{

    @Test
    public void loadTest1(){
        //Given
        int expected = 100;
        //When
        int result = getHarborService().load(getShips().get(0).getCapacity());
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void loadTest2(){
        //Given
        int expected = 0;
        //When
        getHarborService().load(getShips().get(2).getCapacity());
        int result = getHarbor().getStorageLoadedGoods();
                //Then
        Assert.assertEquals(expected, result);
    }

}
