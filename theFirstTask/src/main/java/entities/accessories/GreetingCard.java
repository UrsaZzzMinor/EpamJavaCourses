package entities.accessories;

import org.apache.log4j.Logger;

public class GreetingCard extends Accessory {
    private static Logger logger = Logger.getLogger(GreetingCard.class);

    public GreetingCard(double price){
        this.setName("GreetingCard");
        this.setPrice(price);
    }
}
