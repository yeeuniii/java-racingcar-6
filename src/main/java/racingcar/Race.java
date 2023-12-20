package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

public class Race {
    final private Cars cars;
    final private int totalRound;
    private int currentRound;


    public Race(String[] names, String round) {
        this.cars = new Cars(names);
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
        cars.run();
        this.currentRound++;
    }

    public LinkedHashMap<String, Integer> getResultOfRound() {
        return cars.getResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
