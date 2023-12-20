package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class RaceTest {

    @DisplayName("잘못된 형식의 시도 횟수를 갖는 경주 생성 시 예외 반환")
    @ValueSource(strings = {"-1", "0", "asdf"})
    @ParameterizedTest
    void createInvalidRoundRace(String round) {
        String[] names = {"pobi", "yen"};

        assertThatThrownBy(() -> new Race(names, round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 시도 횟수를 갖는 경주 생성")
    @ValueSource(strings = {"2", "15", "30"})
    @ParameterizedTest
    void createValidRoundRace(String round) {
        String[] names = {"pobi", "yen"};

        assertThat(new Race(names, round)).isInstanceOf(Race.class);
    }

    @DisplayName("경주 끝")
    @Test
    void finishRace() {
        String[] names = {"pobi", "yen"};
        String time = "2";
        Race race = new Race(names, time);
        for (int idx = 0; idx < 2; idx++) {
            race.runRound();
        }
        boolean result = race.isRunning();

        assertThat(result).isFalse();
    }

    @DisplayName("경주 남은 경우 확인")
    @Test
    void continueRace() {
        String[] names = {"pobi", "yen"};
        String time = "2";
        Race race = new Race(names, time);
        for (int idx = 0; idx < 1; idx++) {
            race.runRound();
        }
        boolean result = race.isRunning();

        assertThat(result).isTrue();
    }
//    @Test
//    void 한_라운드_실행_후_결과_만들기() {
//        String[] names = {"pobi", "yen"};
//        List<Car> cars = new ArrayList<>();
//        for (String name : names) {
//            cars.add(new Car(name));
//        }
//        cars.get(0).moveFoward(5);
//        String result = race.getResult();
//
//        assertThat(result).isEqualTo("pobi : -\nyen : --\n");
//    }
//
//    @Test
//    void 단독_우승자_구하기() {
//        String[] names = {"pobi", "yen"};
//        int idx = 1;
//        List<Car> cars = new ArrayList<>();
//        for (String name : names) {
//            cars.add(new Car(name, idx++));
//        }
//        Race race = new Race(cars, 3);
//        String winner = race.getWinners();
//
//        assertThat(winner).isEqualTo("yen");
//    }
//
//    @Test
//    void 공동_우승자_구하기() {
//        String[] names = {"pobi", "yen"};
//        int idx = 1;
//        List<Car> cars = new ArrayList<>();
//        for (String name : names) {
//            cars.add(new Car(name, idx));
//        }
//        Race race = new Race(cars, 3);
//        String winners = race.getWinners();
//
//        assertThat(winners).isEqualTo("pobi, yen");
//    }
}
