package com.epam.training.services;

import com.epam.training.models.Harbor;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HarborService {
    private static Logger logger = Logger.getLogger(HarborService.class);
    private Harbor harbor;
    private Lock lock = new ReentrantLock();
    private Semaphore semaphore;

    public HarborService(Harbor harbor){
        if (harbor != null){
            this.harbor = harbor;
            this.setSemaphore(new Semaphore(harbor.getFreeWharfs(), true));
        } else{
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        }
    }

    public HarborService(){}

    public void releaseShip()throws NullPointerException{
        harbor.setFreeWharfs(harbor.getFreeWharfs()+1);
        logger.info(new StringBuilder(Thread.currentThread().getName()).append(" released! ")
                .append("Available Semaphore permits now: ").append(semaphore.availablePermits()));
    }

    public void acquireShip()throws NullPointerException{
        harbor.setFreeWharfs(harbor.getFreeWharfs()-1);
        logger.info(new StringBuilder(Thread.currentThread().getName()).append(" : got the permit! ")
                .append("Free wharfs : ").append(harbor.getFreeWharfs()));
    }

    public int load(int shipCapacity){
        lock.lock();
        int loadedGoods = 0;
        try {
            Thread.sleep(200);
            logger.info(new StringBuilder(Thread.currentThread().getName()).append(" is loading!"));
            if(harbor.getStorageLoadedGoods()-shipCapacity>=0){
                harbor.setStorageLoadedGoods(harbor.getStorageLoadedGoods()- shipCapacity);
                loadedGoods = shipCapacity;
            } else if(harbor.getStorageLoadedGoods()>0){
                loadedGoods = harbor.getStorageLoadedGoods();
                harbor.setStorageLoadedGoods(0);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted!");
        } catch (NullPointerException e) {
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        } finally {
            logger.info(new StringBuilder(Thread.currentThread().getName()).append(" loaded!"));
            lock.unlock();
        }
        return loadedGoods;
    }

    public int unload(int shipLoadedGoods){
        lock.lock();
        int unloadedGoods = 0;
        try {
            Thread.sleep(200);
            logger.info(new StringBuilder(Thread.currentThread().getName()).append(" is unloading!"));
            if (harbor.getStorageLoadedGoods() + shipLoadedGoods <= harbor.getStorageCapacity()) {
                harbor.setStorageLoadedGoods(harbor.getStorageLoadedGoods() + shipLoadedGoods);
                unloadedGoods = shipLoadedGoods;
            } else if (harbor.getStorageLoadedGoods() < harbor.getStorageCapacity()) {
                unloadedGoods = harbor.getStorageCapacity() - harbor.getStorageLoadedGoods();
                harbor.setStorageLoadedGoods(harbor.getStorageCapacity());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted!");
        } catch (NullPointerException e) {
            logger.error("\"Sorry, You've got a NullPointerException ...\"");
        } finally {
            logger.info(new StringBuilder(Thread.currentThread().getName()).append(" unloaded!"));
            lock.unlock();
        }
        return unloadedGoods;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
