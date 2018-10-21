package entities.flowers;

import org.apache.log4j.Logger;

public class Flower {
    private static Logger logger = Logger.getLogger(Flower.class);

    private String name, color;
    private int stackLength, daysOfExistence;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStackLength() {
        return stackLength;
    }

    public void setStackLength(int stackLength) {
        this.stackLength = stackLength;
    }

    public int getDaysOfExistence() {
        return daysOfExistence;
    }

    public void setDaysOfExistence(int daysOfExistence) {
        this.daysOfExistence = daysOfExistence;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringBuilder("Name = ").append(this.name).append(", Color = ").append(this.color).append(", daysOfExistence = ")
                .append(this.daysOfExistence).append(", stackLength = ").append(this.stackLength).append(", Price = ")
                .append(this.price).toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || !(obj instanceof Flower)) {
            logger.info(obj.getClass().toString() + " != " + this.getClass().toString());
            return false;
        }

        Flower guest = (Flower) obj;
        return this.hashCode() == guest.hashCode()
                && (name == guest.name
                || (name != null && name.equals(guest.getName()))) && (color == guest.color
                || (color != null && color.equals(guest.getColor()))) && (stackLength == guest.stackLength
                || (stackLength != 0)) && (daysOfExistence == guest.daysOfExistence
                || (daysOfExistence != 0)) && (price == guest.price
                || (price != 0.0)
        );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());

        return result;
    }
}
