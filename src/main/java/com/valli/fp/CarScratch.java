package com.valli.fp;

import java.time.LocalDate;
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


public class CarScratch {



    public static <E> void showAll(List<E> cars){
        for (E c : cars) {
            System.out.println(c);
        }
        System.out.println("--------------------------------------------------------");
    }

    public static <E> List<E> getByCriterion(Iterable<E> input, Criterion<E> criterion) {
        List<E> output = new ArrayList<>();
        for (E e : input) {
            if(criterion.test(e)){
                output.add(e);
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



//        showAll(getByCriterion(cars, Car.getRedCarCriterion()));
//
//        showAll(getByCriterion(cars, Car.getGasLevelCriterion(6)));
//
//        showAll(getByCriterion(cars, Car.isCarInColor("Red", "Black")));

//        showAll(cars);
//
//        cars.sort(Car.getCarGasComparator());
//
//        showAll(cars);
//
//        showAll(getByCriterion(cars, Car.getFourPassengerCars()));
//        showAll(getByCriterion(cars, c -> c.getPassengers().size() == 2));
//
//
//        boolean b = ((Criterion<Car>)(c -> c.getPassengers().size() > 2)).test(Car.withGasColorPassengers(0, "Red"));
//
//        List<String> colors = Arrays.asList("LightCoral", "pink", "Orange", "Gold", "plum", "Blue", "limegreen");
//        showAll(colors);
//        showAll(getByCriterion(colors, s -> s.length() > 4));
//        showAll(getByCriterion(colors, s -> Character.isUpperCase(s.charAt(0))));
//
//        LocalDate ld = LocalDate.now();
//        List<LocalDate> dates = Arrays.asList(ld, ld.plusDays(1), ld.plusDays(7), ld.minusDays(1), ld.minusDays(6));
//        showAll(getByCriterion(dates, dt -> dt.isAfter(ld)));

        Criterion<Car> level7 = Car.getGasLevelCriterion(7);
        showAll(getByCriterion(cars, level7));

        Criterion<Car> notLevel7 = level7.negate();
        showAll(getByCriterion(cars, notLevel7));

        Criterion<Car> isRed = Car.isCarInColor("Red");
        Criterion<Car> fourPassengers = Car.getFourPassengerCars();
        Criterion<Car> redFourPassengers = isRed.and(fourPassengers);
        showAll(getByCriterion(cars, redFourPassengers));

        Criterion<Car> isBlack = Car.isCarInColor("Black");
        Criterion<Car> blackOrFourPassengers = isBlack.or(fourPassengers);
        showAll(getByCriterion(cars, blackOrFourPassengers));
    }
}
