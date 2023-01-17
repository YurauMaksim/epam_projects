package beans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Tourist implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(Tourist.class);
    private String name;
    private int photoCounter = 0;
    private boolean isInTravel = false;
    private CyclicBarrier BARRIER;

    public Tourist(String name, CyclicBarrier barrier) {
        this.name = name;
        this.BARRIER = barrier;

    }

    public String getName() {
        return name;
    }

    public void setPhotoCounter(int photoCounter) {
        this.photoCounter = photoCounter;
    }

    public void setInTravel(boolean inTravel) {
        isInTravel = inTravel;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "name='" + name + '\'' +
                ", photoCounter=" + photoCounter +
                ", isInTravel=" + isInTravel +
                '}';
    }


    @Override
    public void run() {
        System.out.println("Tourist " + name  +  " came to the point ");

        try {
            BARRIER.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Tourist  " + name  +  "  continues motion ");

    }
}
