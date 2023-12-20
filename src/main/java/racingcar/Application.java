package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race(Screen.askCarNames(), Screen.askRacingTime());

        Screen.displayResultMessage();
        while (race.isRunning()) {
            race.runRound();
            Screen.displayResult(race.getResult());
        }
        Screen.displayWinners(race.getWinners());
    }
}
