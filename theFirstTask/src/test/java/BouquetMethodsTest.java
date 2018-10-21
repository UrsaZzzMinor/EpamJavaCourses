import entities.Bouquet;
import entities.flowers.Azalea;
import entities.flowers.Flower;
import entities.flowers.Rose;
import entities.flowers.Tulip;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import service.BouquetService;
import java.util.ArrayList;

public class BouquetMethodsTest {
    private Logger logger = Logger.getLogger(BouquetMethodsTest.class);
    private Bouquet bouquet = new BouquetService().readBouquetFromFile();

    @DataProvider
    public Object[][] data(){
        ArrayList<Flower> expected1 = new ArrayList<Flower>() {{
            add(new Azalea("Purple",35,2,50.3));
            add(new Tulip("Red", 33, 1, 30.2));
            }};
        ArrayList<Flower> expected2 = new ArrayList<Flower>() {{
            add(new Rose("Red",30,5,50.5));
            add(new Azalea("Purple",35,2,50.3));
            add(new Tulip("Red", 33, 1, 30.2));
        }};
        return new Object[][]{{32, 37, expected1},
                {30, 35, expected2}};
    }

    @Test(dataProvider = "data")
    public void findNecessaryStackLength(Integer min, Integer max, ArrayList<Flower> expected){
        Assert.assertEquals(expected, bouquet.findNecessaryStackLength(min,max));
    }

    @Test
    public void sortByExistenceDay(){
        ArrayList<Flower> expected = new ArrayList<>();
        expected.add(new Tulip("Red", 33, 1, 30.2));
        expected.add(new Azalea("Purple", 35, 2, 50.3));
        expected.add(new Tulip("Yellow", 40, 3, 30.2));
        expected.add(new Rose("Red", 30, 5, 50.5));

        bouquet.sortByDaysOfExistence();

        Assert.assertEquals(expected, bouquet.getFlowers());
    }

    @Test
    public void countBouquetCost(){
        double expected = 177.7;

        Assert.assertEquals(expected, bouquet.countBouquetCost());
    }

}
