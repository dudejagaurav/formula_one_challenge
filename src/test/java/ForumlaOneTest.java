import com.agoda.Car;
import com.agoda.CarNoLongerExist;
import com.agoda.CarUtil;
import com.agoda.InvalidRaceException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Gaurav on 23/09/17.
 */
public class ForumlaOneTest {


    private double delta = 0.1;

    /**
     * check whether team is valid
     */
    @Test
    public void invalidTeamOrTrack() {
        try {
            CarUtil.createCar(1, 0);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof InvalidRaceException);
        }
        try {
            CarUtil.createCar(-1, -1);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof InvalidRaceException);
        }
        try {
            CarUtil.createCar(0, 1);
        } catch (Exception e) {
            Assert.assertTrue(e instanceof InvalidRaceException);
        }
    }

    /**
     * @throws InvalidRaceException
     */
    @Test
    public void speedTest() throws InvalidRaceException {
        Car car = CarUtil.createCar(1, 200);
        Assert.assertEquals(car.getTopSpeed(), (150 + 10.0 * 1) * 1000.0 / (60.0 * 60.0), delta);

    }

    /**
     * @throws InvalidRaceException
     */
    @Test
    public void accelrationTest() throws InvalidRaceException, CarNoLongerExist {
        Car car = CarUtil.createCar(6, 200);
        Assert.assertEquals(car.getAcceleration(), 2 * 6, delta);
        car.run(2);
        double tempSpeed = car.getCurrentSpeed();
        car.run(2);
        Assert.assertEquals(tempSpeed + car.getAcceleration() * 2, car.getCurrentSpeed(), delta);
    }

    /**
     * @throws InvalidRaceException
     */
    @Test
    public void initialDistanceTest() throws InvalidRaceException {
        Car car = CarUtil.createCar(1, 200);
        Assert.assertEquals(car.getTotalDistanceTobeTravel(),  200 * (2 - 1), delta);
    }

    /**
     * @throws InvalidRaceException
     */
    @Test
    public void nitroTest() throws InvalidRaceException, CarNoLongerExist {
        Car car = CarUtil.createCar(9, 200);
        Assert.assertTrue(car.isNitroAvailable());
        car.run(2);
        //if apply nitro without running speed will be 0 even after nitro
        car.applyNitro();
        Assert.assertFalse(car.isNitroAvailable());
        double boostedSpeed = car.getCurrentSpeed() * 2 > car.getTopSpeed() ? car.getTopSpeed() : car.getCurrentSpeed() * 2;
        car.run(2);
        Assert.assertEquals(boostedSpeed, car.getCurrentSpeed(), delta);


    }

    /**
     * @throws InvalidRaceException
     */
    @Test
    public void applyHfWhenOutOfRace() throws InvalidRaceException {
        //Track length 0 means car completed the race
        Car car = CarUtil.createCar(1, 0);

        double tempSpeed = car.getCurrentSpeed();
        car.applyHf();
        Assert.assertEquals(tempSpeed, car.getCurrentSpeed(), delta);
    }

    /**
     * Nitro double the speed check whether if alredy top speed does it boost
     *
     * @throws InvalidRaceException
     */
    @Test
    public void attainMaxSpeedAndApplyNitro() throws InvalidRaceException, CarNoLongerExist {
        Car car = CarUtil.createCar(1, 200);
        while (car.getCurrentSpeed() * 2 < car.getTopSpeed()) {
            car.run(2);
        }
        car.applyNitro();
        Assert.assertEquals(car.getTopSpeed(), car.getCurrentSpeed(), delta);
        car.run(2);
        //if run car again speed must be same
        Assert.assertEquals(car.getTopSpeed(), car.getCurrentSpeed(), delta);
    }

    /**
     * Test When Hf is applied car speed is updated
     *
     * @throws InvalidRaceException
     */
    @Test
    public void testHf() throws InvalidRaceException, CarNoLongerExist {
        Car car = CarUtil.createCar(1, 700);
        car.run(2);
        car.run(2);
        car.run(2);
        car.run(2);
        double tempSpeed = car.getCurrentSpeed();
        car.applyHf();
        //half speed
        Assert.assertEquals(tempSpeed * car.getHandlingFactor(), car.getCurrentSpeed(), delta);
    }


}
