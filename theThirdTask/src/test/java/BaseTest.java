import com.epam.training.models.Harbor;
import com.epam.training.models.Ship;
import com.epam.training.services.HarborService;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    private Harbor harbor;
    private HarborService harborService;
    private List<Ship> ships = new ArrayList<>();



    @BeforeMethod
    public void init(){
        setHarbor(new Harbor(2, 500, 200));
        setHarborService(new HarborService(getHarbor()));
        getShips().add(new Ship("Caravella", 100, 0, getHarborService()));
        getShips().add(new Ship("Brig", 50, 25, getHarborService()));
        getShips().add(new Ship("Fregat", 300, 0, getHarborService()));
        getShips().add(new Ship("Fregat2", 501, 501, getHarborService()));
    }

    public Harbor getHarbor() {
        return harbor;
    }

    public void setHarbor(Harbor harbor) {
        this.harbor = harbor;
    }

    public HarborService getHarborService() {
        return harborService;
    }

    public void setHarborService(HarborService harborService) {
        this.harborService = harborService;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
