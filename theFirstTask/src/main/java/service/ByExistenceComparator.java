package service;

import entities.flowers.Flower;
import org.apache.log4j.Logger;

import java.util.Comparator;

public class ByExistenceComparator implements Comparator<Flower> {
    private static Logger logger = Logger.getLogger(ByExistenceComparator.class);

    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getDaysOfExistence() - o2.getDaysOfExistence();
    }
}
