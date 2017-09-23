package com.agoda;

/**
 * Created by Gaurav on 13/09/17.
 */
public class Car {
    /**
     * in s
     */
    private double timeSpentOnTrack;
    /**
     * in m/s
     */
    private double topSpeed;
    /**
     * in m/s²
     */
    private double acceleration;

    private double handlingFactor = 0.8;
    private double currentSpeed = 0.0;
    private double totalDistanceTobeTravel = 0;
    private boolean isNitroAvailable = true;
    private String teamName;


    public double getTimeSpentOnTrack() {
        return timeSpentOnTrack;
    }

    public Car setTimeSpentOnTrack(double timeSpentOnTrack) {
        this.timeSpentOnTrack = timeSpentOnTrack;
        return this;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public Car setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
        return this;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public Car setAcceleration(double acceleration) {
        this.acceleration = acceleration;
        return this;
    }

    public double getHandlingFactor() {
        return handlingFactor;
    }

    public Car setHandlingFactor(double handlingFactor) {
        this.handlingFactor = handlingFactor;
        return this;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Car setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        return this;
    }

    public double getTotalDistanceTobeTravel() {
        return totalDistanceTobeTravel;
    }

    public Car setTotalDistanceTobeTravel(double totalDistanceTobeTravel) {
        this.totalDistanceTobeTravel = totalDistanceTobeTravel;
        return this;
    }

    public boolean isNitroAvailable() {
        return isNitroAvailable;
    }

    public Car setIsNitroAvailable(boolean isNitroAvailable) {
        this.isNitroAvailable = isNitroAvailable;
        return this;
    }

    public boolean isFinished() {
        return totalDistanceTobeTravel <= 0;
    }

    public void applyHf() {
        this.currentSpeed = handlingFactor * currentSpeed;
    }

    /**
     * apply nitro to car
     */
    public void applyNitro() {
        if (isFinished()) {
            return;
        }
        if (isNitroAvailable) {
            double boostedSpeed = this.currentSpeed * 2;
            this.currentSpeed = boostedSpeed > topSpeed ? topSpeed : boostedSpeed;
            this.isNitroAvailable = false;
        }
    }

    /**
     * //if the object has a constant acceleration, its average acceleration is the exact same value. Average acceleration, measured in units of distance per time-squared
     * // as accesment is done after 2 second there is boost in speed as car acceleration is constant
     *
     * @param time: run for time second
     * @throws CarNoLongerExist
     */
    public void run(int time) throws CarNoLongerExist {
        if (this.isFinished()) {
            throw new CarNoLongerExist("Race finish for car"+ this.getTeamName());
        }
        double distanceTraveled = this.getCurrentSpeed() + this.getAcceleration() * time * time / 2;

        this.setTotalDistanceTobeTravel(this.getTotalDistanceTobeTravel() - distanceTraveled);
        //multiplying by 2 as car speed boost every 2 seconds

        double speed = this.getCurrentSpeed() + this.getAcceleration() * 2;
        if (speed > this.getTopSpeed()) {
            speed = this.getTopSpeed();
        }
        this.setCurrentSpeed(speed);
        this.setTimeSpentOnTrack(this.getTimeSpentOnTrack() + 2);
    }

    public String getTeamName() {
        return teamName;
    }

    public Car setTeamName(String teamName) {
        this.teamName = teamName;
        return this;
    }

    @Override
    public int hashCode() {
        //team name is unique
        return System.identityHashCode(teamName);
    }
}
