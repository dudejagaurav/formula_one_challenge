package com.agoda;

import java.util.Comparator;

/**
 * Created by Gaurav on 14/09/17.
 */
public class CarComaprator implements Comparator<Car> {
    /**
     *
     * @param car1
     * @param car2
     * @return
     */
    @Override
    public int compare(Car car1, Car car2) {

        double car1Distance = car1.getTotalDistanceTobeTravel();
        double car2Distance = car2.getTotalDistanceTobeTravel();
        //making -ve to get the last car as 1st element
        return -(int) (car1Distance - car2Distance);
    }
}
