package stops;

import interfaces.BusStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import places.Restaurant;

import java.util.concurrent.Phaser;

public class Rome implements BusStop, Runnable {
    private Phaser phaser;
    private Restaurant restaurant;

    final Logger logger = LoggerFactory.getLogger(Rome.class);

    public Rome(Phaser phaser) {
        this.phaser = phaser;




        phaser.register();
    }

    @Override
    public void run() {
        logger.info("Рим тут будут действия с очередями и прочее");

        phaser.arriveAndDeregister();
    }
}
