package stops;

import interfaces.BusStop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Phaser;

public class FinishPoint implements BusStop, Runnable {
    private Phaser phaser;

    public FinishPoint(Phaser phaser) {
        this.phaser = phaser;

        phaser.register();
    }

    final Logger logger = LoggerFactory.getLogger(FinishPoint.class);
    @Override
    public void run() {
        logger.info("Точка прибытия тут будут действия с очередями и прочее");

        phaser.arriveAndDeregister();
    }
}
