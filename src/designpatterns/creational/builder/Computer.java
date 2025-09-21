package designpatterns.creational.builder;

public class Computer {

    // required params
    private String HDD;
    private String RAM;

    //optional params
    private boolean graphicsCardEnabled;
    private boolean bluetoothEnabled;

    // create private constructor
    private Computer(ComputerBuilder builder){
        this.HDD=builder.HDD;
        this.RAM=builder.RAM;
        this.graphicsCardEnabled=builder.graphicsCardEnabled;
        this.bluetoothEnabled=builder.bluetoothEnabled;
    }

    //create only getter methods
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return graphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "HDD='" + HDD + '\'' +
                ", RAM='" + RAM + '\'' +
                ", graphicsCardEnabled=" + graphicsCardEnabled +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    //Builder class
    public static class ComputerBuilder{

        // required params
        private String HDD;
        private String RAM;

        //optional params
        private boolean graphicsCardEnabled;
        private boolean bluetoothEnabled;

        public ComputerBuilder(String hdd, String ram) {
            this.HDD =hdd;
            this.RAM=ram;
        }

        // These setters are for optional params and it's not void but returning this
        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            this.graphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        //create build method returning main obj
        public Computer build(){
            return new Computer(this);
        }
    }

}
