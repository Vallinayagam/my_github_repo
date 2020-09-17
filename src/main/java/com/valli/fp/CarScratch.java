package com.valli.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This class does not have state in it. Its SOLE purpose is to define behaviour only.
 */
class PassengerCountOrder implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPassengers().size() - o2.getPassengers().size();
    }
}


/**
 * The concept of passing behaviour to a function via passing an object is not something new.  This is called
 * COMMAND Pattern (Read documentation further), which has been documented in Gof4 DP book.
 * Command Pattern finds heavy usage in functional programming paradigm
 */
interface CarCriterion {
    boolean test(Car c);
}

public class CarScratch {
    public static void showAll(List<Car> cars){
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------");
    }

    public static List<Car> getCarsByCriterion(Iterable<Car> input, CarCriterion criterion) {
        List<Car> output = new ArrayList<>();
        for (Car car : input) {
            if(criterion.test(car)){
                output.add(car);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
            Car.withGasColorPassengers(6, "Red", "Fred", "Jim", "Sheila"),
            Car.withGasColorPassengers(3, "Octarine", "Rincewind", "Ridicully"),
            Car.withGasColorPassengers(9, "Black", "Weatherwax", "Magrat"),
            Car.withGasColorPassengers(7, "Green", "Valentine", "Gilligan", "Anne", "Dr. Mahmoud"),
            Car.withGasColorPassengers(6, "Red", "Ender", "Hyrum", "Locke", "Bonzo")
        );


        showAll(cars);

        showAll(getCarsByCriterion(cars, Car.getRedCarCriterion()));

        showAll(getCarsByCriterion(cars, new Car.GasLevelCriterion(6)));

        showAll(cars);

//        showAll(getCarsByGasLevel(cars, 4));

//        cars.sort(new PassengerCountOrder());
//        showAll(cars);
    }
}
