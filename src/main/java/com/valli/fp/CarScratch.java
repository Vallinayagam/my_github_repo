package com.valli.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarScratch {
    public static void showAll(List<Car> cars){
        for (Car c : cars) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------");
    }

    public static List<Car> getRedCars(List<Car> input) {
        List<Car> output = new ArrayList<>();
        for (Car car : input) {
            if( "Red".equals(car.getColor()) ){
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

        showAll(getRedCars(cars));

        showAll(cars);
    }
}
