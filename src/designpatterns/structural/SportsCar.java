package designpatterns.structural;

import java.util.logging.Logger;

public class SportsCar extends CarDecorator {

    public static final Logger logger = Logger.getLogger(SportsCar.class.getName());

    public SportsCar(Car c){
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        logger.info("Adding Sport Car feature to Car");
    }
}
