package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    static public final String MARK = "-";

    final private List<Car> cars;
    final private int totalRound;
    private int currentRound;


    public Race(String[] names, String round) {
        this.cars = new ArrayList<>();
        for (String name : names) {
            this.cars.add(new Car(name));
        }
        checkRound(round);
        this.totalRound = Integer.parseInt(round);
        this.currentRound = 0;
    }

    private void checkRound(String round) {
        if (!isValidRound(round)) {
            throw new IllegalArgumentException("Invalid Argument");
        }
    }

    private boolean isValidRound(String round) {
        return round.matches("[1-9]\\d*");
    }

    public boolean isRunning() {
        return this.currentRound < this.totalRound;
    }

    public void runRound() {
        for (Car car : cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
        }
        this.currentRound++;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();

        for (Car car : cars) {
            result.append(String.format("%s : %s\n", car.getName(), MARK.repeat(car.getNumberOfMove())));
        }
        return result.toString();
    }

    public String getWinners() {
        StringBuilder winners = new StringBuilder();
        int maximumMove = Collections.max(cars).getNumberOfMove();

        for (Car car : cars) {
            if (car.getNumberOfMove() == maximumMove) {
                winners.append(", ");
                winners.append(car.getName());
            }
        }
        return winners.toString().replaceFirst(", ", "");
    }
}
