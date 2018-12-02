import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadFromShipTest extends BaseTest {

    @Test
    public void loadFromShipTest(){
        //Given
        int expected1 = 50;
        int expected2 = 476;
        //When
        getShips().get(1).loadFromShip(getShips().get(3));
        int result1 = getShips().get(1).getLoadedGoods();
        int result2 = getShips().get(3).getLoadedGoods();
        //Then
        Assert.assertEquals(expected1, result1);
        Assert.assertEquals(expected2, result2);
    }

}
