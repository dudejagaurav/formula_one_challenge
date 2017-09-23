package com.agoda;

/**
 * Created by Gaurav on 23/09/17.
 */
public class CarUtil {
    /**
     *
     * @param teamNo
     * @param trackLen
     * @return
     * @throws InvalidRaceException
     */
    public static Car createCar(int teamNo, int trackLen) throws InvalidRaceException {
        if (teamNo < 1) {
            throw new InvalidRaceException("Team no shoul be greater than 0");
        }
        Car car = new Car();
        car.setTeamName(String.valueOf(teamNo));
        car.setAcceleration(getAcceleration(teamNo));
        car.setTopSpeed(getTopSpeed(teamNo));
        car.setTotalDistanceTobeTravel(getDistanceTobeTraveled(teamNo, trackLen));
        return car;
    }

    /**
     *
     * @param teamNo
     * @param trackLen
     * @return
     */
    private static double getDistanceTobeTraveled(int teamNo, int trackLen) {
        return trackLen + 200d * (teamNo - 1);
    }

    /**
     *
     * @param teamNo
     * @return
     */
    //USING Precision in double as it will fail in test case precision
    private static double getTopSpeed(int teamNo) {
        return ((150 + 10 * teamNo) * 1000.0) / (60.0 * 60.0);
    }

    /**
     *
     * @param teamNo
     * @return
     */
    private static double getAcceleration(int teamNo) {
        return 2 * teamNo;
    }


}
