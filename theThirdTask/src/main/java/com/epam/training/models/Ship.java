package com.epam.training.models;

import com.epam.training.services.HarborService;
import org.apache.log4j.Logger;

public class Ship implements Runnable{
    private static Logger logger = Logger.getLogger(Ship.class);
    private String name;
    private int capacity;
    private int loadedGoods;
    private HarborService harborService;

    public Ship(String name, int capacity, int loadedGoods, HarborService harborService){
        this.setName(name);
        this.setCapacity(capacity);
        this.setLoadedGoods(loadedGoods);
        this.setHarborService(harborService);
    }

    public Ship(){}

    @Override
    public void run(){
        try {
            Thread.currentThread().setName(name);
            logger.info(new StringBuilder(name).append(" : acquiring lock...").append(" : available Semaphore permits now: ")
                    .append(harborService.getSemaphore().availablePermits()));
            harborService.getSemaphore().acquire();
            Thread.sleep(200);
            harborService.acquireShip();

            if(isEmpty()) {
                loadedGoods += harborService.load(capacity);
            } else {
                loadedGoods -= harborService.unload(loadedGoods);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted!");
        } catch (NullPointerException e ){
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        } finally {
            harborService.getSemaphore().release();
            harborService.releaseShip();
        }
    }

    public boolean isEmpty(){
        if (loadedGoods == 0){
            return true;
        }else{
            return false;
        }
    }

    public void unload2Ship(Ship ship){
        if(ship.getLoadedGoods() + loadedGoods <= ship.getCapacity()){
            ship.setLoadedGoods(ship.getLoadedGoods() + loadedGoods);
            loadedGoods = 0;
        } else if(loadedGoods>0){
            loadedGoods -= ship.getCapacity()- ship.getLoadedGoods();
            ship.setLoadedGoods(ship.getCapacity());
        }
    }

    public void loadFromShip(Ship ship){
        if (loadedGoods + ship.getLoadedGoods()<=capacity){
            loadedGoods += ship.getLoadedGoods();
            ship.setLoadedGoods(0);
        } else if(loadedGoods < capacity){
            ship.setLoadedGoods(ship.getLoadedGoods()-(capacity - loadedGoods));
            loadedGoods = capacity;
        }
    }

    public int getLoadedGoods() {
        return loadedGoods;
    }

    public void setLoadedGoods(int loadedGoods) {
        this.loadedGoods = loadedGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public HarborService getHarborService() {
        return harborService;
    }

    public void setHarborService(HarborService harborService) {
        this.harborService = harborService;
    }

}
