package stops;

import interfaces.Attractions;
import interfaces.BusStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import places.Louvre;

import java.util.concurrent.Phaser;

public class Paris implements BusStop, Runnable {
    private Phaser phaser;
    private Attractions louvre;

    final Logger logger = LoggerFactory.getLogger(Paris.class);

    public Paris(Phaser phaser) {
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {
        logger.info("Париж тут будут действия с очередями и прочее");

        phaser.arriveAndDeregister();
    }
}
