package newRacingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGame {

    private Cars cars;
    private int tryTimes;

    RacingCarGame(String[] carNames, int tryTimes) {
        if (tryTimes < 0) {
            throw new IllegalArgumentException("올바른 수를 입력하세요.");
        }
        this.cars = setPlayCars(carNames);
        this.tryTimes = tryTimes;
    }

    private Cars setPlayCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(new Name(name)));
        }
        return new Cars(carList);
    }

    public void move() {
        cars.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGame that = (RacingCarGame) o;
        return tryTimes == that.tryTimes && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryTimes);
    }
}
