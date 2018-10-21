package entities.accessories;

import org.apache.log4j.Logger;

public class Ribbon extends Accessory{
    private static Logger logger = Logger.getLogger(Ribbon.class);

    public Ribbon(double price){
        this.setName("Ribbon");
        this.setPrice(price);
    }
}
