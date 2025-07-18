package designpatterns.creational.singleton;

import designpatterns.creational.factory.TestFactory;

import java.util.logging.Logger;

public class TestBillPugh {

    private static final Logger logger = Logger.getLogger(TestFactory.class.getName());

    public static void main(String[] args) {
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        BillPughSingleton instance2 = BillPughSingleton.getInstance();

        logger.info("Instance 1"+instance1.hashCode());
        logger.info("Instance 2"+instance2.hashCode());

    }
}
