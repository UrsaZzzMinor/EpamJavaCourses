package entities;

import entities.accessories.Accessory;
import entities.flowers.Flower;
import org.apache.log4j.Logger;
import service.ByExistenceComparator;
import java.util.ArrayList;
import java.util.Collections;

public class Bouquet {
    final static Logger logger = Logger.getLogger(Bouquet.class);

    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();
    private double bouquetCost;

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public ArrayList<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Accessory> accessories) {
        this.accessories = accessories;
    }

    public double getBouquetCost() {
        return bouquetCost;
    }

    public void setBouquetCost(double bouquetCost) {
        this.bouquetCost = bouquetCost;
    }

    public double countBouquetCost(){
        double bouquetCost = 0.0;

        for(Flower thing: this.flowers){
            bouquetCost += thing.getPrice();
        }
        for(Accessory thing: this.getAccessories()){
            bouquetCost += thing.getPrice();
        }
        this.bouquetCost = bouquetCost;

        return bouquetCost;
    }

    public void sortByDaysOfExistence(){
        Collections.sort(this.getFlowers(), new ByExistenceComparator());
    }

    public ArrayList<Flower> findNecessaryStackLength(int min, int max){
        ArrayList<Flower> necessaryFlowers = new ArrayList<>();

        for(Flower thing: this.getFlowers()){
            if((thing.getStackLength() >= min) && (thing.getStackLength() <= max)){
                necessaryFlowers.add(thing);
            }
        }

        return necessaryFlowers;
    }

}
