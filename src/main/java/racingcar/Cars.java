package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Cars {
    final private List<Car> cars;

    Cars(String[] names) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
    }

    public void run() {
        for (Car car : this.cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
        }
    }

    final public LinkedHashMap<String, Integer> getResult() {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        for (Car car : this.cars) {
            result.put(car.getName(), car.getNumberOfMove());
        }
        return result;
    }

    final public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maximumMove = Collections.max(cars).getNumberOfMove();

        for (Car car : this.cars) {
            if (car.getNumberOfMove() == maximumMove) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    final public List<Car> getCars() {
        return this.cars;
    }
}
