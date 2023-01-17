package stops;

import interfaces.Attractions;
import interfaces.BusStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import places.Beach;

import java.util.concurrent.Phaser;


public class Spain implements BusStop, Runnable {
    private Phaser phaser;
    private Attractions beach;

    final Logger logger = LoggerFactory.getLogger(Spain.class);

    public Spain(Phaser phaser) {
        this.phaser = phaser;




        phaser.register();
    }

    @Override
    public void run() {
        logger.info("Испания тут будут действия с очередями и прочее");

        phaser.arriveAndDeregister();
    }
}
