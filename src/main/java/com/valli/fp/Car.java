package com.valli.fp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {
    private final int gasLevel;
    private final String color;
    private final List<String> passengers;
    private final List<String> trunkContents;

    public Car(int gasLevel, String color, List<String> passengers, List<String> trunkContents) {
        this.gasLevel = gasLevel;
        this.color = color;
        this.passengers = passengers;
        this.trunkContents = trunkContents;
    }

    /**
     * Use Factory methods to create objects - Named Static Factory
     * With the release of Java 8, almost all new APIs uses Static Factory to create objects
     * instead of public constructors, except Exception
     * @return
     */
    public static Car withGasColorPassengers(int gas, String color, String... passengers) {
        //Using unmodifiable list to enable immutable data for functional programming
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Car(gas, color, p, null);
    }

    public static Car withGasColorPassengersAndTrunk(int gas, String color, String... passengers) {
        //Using unmodifiable list to enable immutable data for functional programming
        List<String> p = Collections.unmodifiableList(Arrays.asList(passengers));
        return new Car(gas, color, p, Arrays.asList("jack", "wrench", "spare wheel"));
    }

    public int getGasLevel() {
        return gasLevel;
    }

    public String getColor() {
        return color;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public List<String> getTrunkContents() {
        return trunkContents;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gasLevel=" + gasLevel +
                ", color='" + color + '\'' +
                ", passengers=" + passengers +
                (trunkContents != null ? ", trunkContents=" + trunkContents : " no trunk ") +
                '}';
    }

    public static CarCriterion getRedCarCriterion() {
//        return new RedCarCriterion();
        return RED_CAR_CRITERION;
    }
    private static final CarCriterion RED_CAR_CRITERION = (Car c) -> {
            return c.color.equals("Red"); //since RedCarCriterion is nestedClass, it can access private variables now
    };

    /**
     * This factory cannot be singleton,as the input threshold might differ on different invocations
     */
    public static CarCriterion getGasLevelCriterion(int threshold) {
        return new GasLevelCriterion(threshold);
    }
    /**
     * this criterion has State along with behaviour. But the Primary reason is it carries the behaviour
     */
    private static class GasLevelCriterion implements CarCriterion {
        private int threshold;

        public GasLevelCriterion(int threshold) {
            this.threshold = threshold;
        }

        @Override
        public boolean test(Car c) {
            return c.gasLevel >= threshold; //since gasLevel is nestedClass, it can access private variables now
        }
    }

    public static Comparator<Car> getCarGasComparator(){
        return CAR_GAS_COMPARATOR;
    }
    private static final Comparator<Car> CAR_GAS_COMPARATOR = new CarGasComparator();
    private static class CarGasComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o1.gasLevel - o2.gasLevel;
        }
    }

}
