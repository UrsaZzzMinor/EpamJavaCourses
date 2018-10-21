package entities.flowers;

import org.apache.log4j.Logger;

public class Tulip extends Flower{
    private static Logger logger = Logger.getLogger(Tulip.class);

    public Tulip(String color, int stackLength, int daysOfExistence, double price){
        this.setName("Tulip");
        this.setColor(color);
        this.setStackLength(stackLength);
        this.setDaysOfExistence(daysOfExistence);
        this.setPrice(price);
    }
}
