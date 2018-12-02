package com.epam.training;

import com.epam.training.models.Harbor;
import com.epam.training.models.Ship;
import com.epam.training.services.HarborService;

public class Runner {

    public static void main(String[] args){
        Harbor harbor = new Harbor(2, 500, 200);
        HarborService harborService = new HarborService(harbor);
        Ship ship1 = new Ship("Caravella", 100, 0, harborService);
        Ship ship2 = new Ship("Brig", 50, 25, harborService);
        Ship ship3 = new Ship("Fregat", 300, 0, harborService);
        Ship ship4 = new Ship("Fregat2", 501, 501, harborService);
        Thread thread1 = new Thread(ship1);
        Thread thread2 = new Thread(ship2);
        Thread thread3 = new Thread(ship3);
        Thread thread4 = new Thread(ship4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(ship4.getLoadedGoods());
    }
}
