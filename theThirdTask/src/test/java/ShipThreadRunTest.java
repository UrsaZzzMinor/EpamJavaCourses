import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShipThreadRunTest extends BaseTest {

    private static Logger logger = Logger.getLogger(ShipThreadRunTest.class);

    @Test
    public void shipThreadRunTest(){
        //Given
        int expected = 125;
        //When
        Thread thread1 = new Thread(getShips().get(0));
        Thread thread2 = new Thread(getShips().get(1));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.info("\"Thread was interrupted!\"");
        }
        int result = getHarbor().getStorageLoadedGoods();
        //Then
        Assert.assertEquals(expected, result);
    }

}
