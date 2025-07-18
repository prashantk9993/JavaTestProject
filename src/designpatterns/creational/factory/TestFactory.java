package designpatterns.creational.factory;

import java.util.logging.Logger;

public class TestFactory {

    private static final Logger logger = Logger.getLogger(TestFactory.class.getName());

    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC","2 GB","500 GB","2.4 GHZ");
        Computer server = ComputerFactory.getComputer("SERVER","32 GB","5 TB","2.9 GHZ");

        logger.info("Factory PC config.."+pc);
        logger.info("Factory Server Config..."+server);
    }
}

