package com.agoda;

import java.util.*;

/**
 * Created by Gaurav on 13/09/17.
 */
public class Main {

    private Comparator<? super Car> carComparator = new CarComaprator();

    public static void main(String[] args) throws InvalidRaceException {
        Main main = new Main();

        int noOfCar = 50;
        /**
         * trackLength in meter
         */
        int trackLength = 40;
        main.startRace(noOfCar, trackLength);

    }

    /**
     * @param noOfCar
     * @param trackLength
     */
    public void startRace(int noOfCar, int trackLength) throws InvalidRaceException {
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= noOfCar; i++) {
            cars.add(CarUtil.createCar(i, trackLength));
        }

        //untill there are cars on track
        while (!cars.isEmpty()) {

            Iterator<Car> carsOnTrack = cars.iterator();
            while (carsOnTrack.hasNext()) {
                Car car = carsOnTrack.next();
                try {
                    //Run car for 2 second
                    car.run(2);
                } catch (CarNoLongerExist carNoLongerExist) {
                    //remove car from track
                    System.out.println(car.getTeamName() + " : " + car.getTimeSpentOnTrack());
                    carsOnTrack.remove();

                }
            }
            // after running car for 2 seconds do accesment of remaining cars
            doAssement(cars);

            //we are applying nitros after 2 second run
            //WHen cars list size is 0 means no car on track
            if (cars.isEmpty()) {
                cars.sort(carComparator);
                Car lastCarInRace = cars.get(0);
                lastCarInRace.applyNitro();
            }
        }


    }

    //TODO update complexity of inner for:for Loop

    /**
     * @param cars
     */
    private void doAssement(List<Car> cars) {
        if (cars.size() < 2) {
            //1 car can't be use handling factor
            return;
        }

        Set<Car> hfQualifiedTeams = new HashSet<>();

        for (int i = 0; i < cars.size(); i++) {
            Car car1 = cars.get(i);
            for (int j = 0; j < cars.size(); j++) {
                Car car2 = cars.get(j);
                if (car1.getTotalDistanceTobeTravel() - car2.getTotalDistanceTobeTravel() <= 10) {
                    //Don't do Hf here as it will give error in next stage
                    hfQualifiedTeams.add(car1);
                    hfQualifiedTeams.add(car2);
                }
            }
        }
        hfQualifiedTeams.forEach(Car::applyHf);
    }


}
