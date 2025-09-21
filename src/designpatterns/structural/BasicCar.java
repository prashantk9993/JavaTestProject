package designpatterns.structural;

import java.util.logging.Logger;

public class BasicCar implements Car{

    public static final Logger logger = Logger.getLogger(Car.class.getName());

    @Override
    public void assemble() {
        logger.info("Building Basic Car...");
    }

}
