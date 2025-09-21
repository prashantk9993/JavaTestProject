package designpatterns.structural;

import java.util.logging.Logger;

public class LuxuryCar extends CarDecorator {

    public static final Logger logger = Logger.getLogger(LuxuryCar.class.getName());

    public LuxuryCar(Car c){
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        logger.info("Adding Luxury Car feature to Car");
    }
}
