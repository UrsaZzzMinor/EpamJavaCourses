package entities.flowers;

import org.apache.log4j.Logger;

public class Rose extends Flower{
    private static Logger logger = Logger.getLogger(Rose.class);

    public Rose(String color, int stackLength, int daysOfExistence, double price){
        this.setName("Rose");
        this.setColor(color);
        this.setStackLength(stackLength);
        this.setDaysOfExistence(daysOfExistence);
        this.setPrice(price);
    }
}
