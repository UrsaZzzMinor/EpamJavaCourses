package com.epam.training.models;

public class Harbor {
    private int freeWharfs;
    private int storageCapacity;
    private int storageLoadedGoods;


    public Harbor(int freeWharfs, int storageCapacity, int storageLoadedGoods){
        this.freeWharfs = freeWharfs;
        this.storageCapacity = storageCapacity;
        this.storageLoadedGoods = storageLoadedGoods;
    }

    public Harbor(){}

    public int getFreeWharfs() {
        return freeWharfs;
    }

    public void setFreeWharfs(int freeWharfs) {
        this.freeWharfs = freeWharfs;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public int getStorageLoadedGoods() {
        return storageLoadedGoods;
    }

    public void setStorageLoadedGoods(int storageLoadedGoods) {
        this.storageLoadedGoods = storageLoadedGoods;
    }

}
