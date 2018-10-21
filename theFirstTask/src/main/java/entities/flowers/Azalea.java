package entities.flowers;

import org.apache.log4j.Logger;

public class Azalea extends Flower{
    private static Logger logger = Logger.getLogger(Azalea.class);

    public Azalea(String color, int stackLength, int daysOfExistence, double price){
        this.setName("Azalea");
        this.setColor(color);
        this.setStackLength(stackLength);
        this.setDaysOfExistence(daysOfExistence);
        this.setPrice(price);
    }
}
