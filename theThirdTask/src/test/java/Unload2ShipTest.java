import org.testng.Assert;
import org.testng.annotations.Test;

public class Unload2ShipTest extends BaseTest {

    @Test
    public void unload2ShipTest(){
        //Given
        int expected1 = 201;
        int expected2 = 300;
        //When
        getShips().get(3).unload2Ship(getShips().get(2));
        int result1 = getShips().get(3).getLoadedGoods();
        int result2 = getShips().get(2).getLoadedGoods();
        //Then
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }

}
