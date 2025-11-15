package interview.litmus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomatedParking {

    static int[][] parkingSlots = new int[3][3];

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("MH12KN9993",0,0));
        cars.add(new Car("MH12XX9810",0,0));
        cars.add(new Car("MH14GR9993",0,0));

        cars.add(new Car("MH12KN9993",0,0));
        cars.add(new Car("MH12XX9810",0,0));
        cars.add(new Car("MH14GR9993",0,0));

        cars.add(new Car("MH12KN9993",0,0));
        cars.add(new Car("MH12XX9810",0,0));
        cars.add(new Car("MH14GR9993",0,0));

        for (Car car : cars){
            System.out.println("Car come :::"+car);
            Map<Integer, Integer>  reserverdParking = getParking();

            if(reserverdParking!=null) {
                Map.Entry<Integer, Integer> entry = reserverdParking.entrySet().iterator().next();
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                car.setFloor(key);
                car.setSlot(value);
                System.out.println("Car parked :::" + car);
            }
        }

        printParking();
        releaseParking(cars.get(1));
        printParking();

        Map<Integer, Integer>  reserverdParking2  = getParking();
        if(reserverdParking2!=null) {
            Map.Entry<Integer, Integer> entry2 = reserverdParking2.entrySet().iterator().next();
            Integer key = entry2.getKey();
            Integer value = entry2.getValue();
            System.out.println("Car come :::");
            System.out.println("Car parked :::" + new Car("MH12345", key, value));
            printParking();
        }

      //  Map<Integer, Integer>  reserverdParking3  = getParking();

    }

    private static Map<Integer, Integer> getParking() {

        Map<Integer,Integer> allocatedParking = new HashMap<>();

        for(int i=0 ; i< parkingSlots.length; i++){

            for (int j=0; j < parkingSlots[i].length ; j++){
                if(parkingSlots[i][j]==0){
                    parkingSlots[i][j]=1;
                    allocatedParking.put(i,j);
                    return allocatedParking;
                }

            }
        }
        System.out.print("******* Car Parking Full **********");
        return null;
    }

    public static void releaseParking(Car car){
        System.out.println("Car leave parking :::"+car);
        parkingSlots[car.getFloor()][car.getSlot()] = 0;
    }

    public static void printParking(){
        // Print in 5x5 format
        System.out.println("5x5 Matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(parkingSlots[i][j] + "\t");
            }
            System.out.println(); // New line after each row
        }
    }

}

class Car {
    private String number;
    private int floor;
    private int slot;

    public Car(String number, int floor, int slot) {
        this.number = number;
        this.floor = floor;
        this.slot = slot;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", floor=" + floor +
                ", slot=" + slot +
                '}';
    }
}