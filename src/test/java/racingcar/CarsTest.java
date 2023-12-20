package racingcar;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

public class CarsTest {
    @DisplayName("한 라운드 시행 후 결과 구하기")
    @Test
    void getResultOfOneRound() {
        String[] names = {"pobi", "yen", "red", "joy"};
        Integer[] value = {5, 4, 3, 7};
        Cars cars = new Cars(names);
        for (int idx = 0; idx < 4; idx++) {
            cars.getCars().get(idx).moveForward(value[idx]);
        }

        LinkedHashMap<String, Integer> result = cars.getResult();

        assertThat(result).containsExactly(entry("pobi", 1), entry("yen", 1), entry("red", 0), entry("joy", 1));


    }

    @DisplayName("단독 우승자 구하기")
    @Test
    void getSoleWinner() {
        String[] names = {"pobi", "yen", "red", "joy"};
        Cars cars = new Cars(names);
        cars.getCars().get(1).moveForward(5);

        List<String> winner = cars.getWinners();

        assertThat(winner).containsExactly("yen");
    }

    @DisplayName("공동 우승자 구하기")
    @Test
    void getCowinner() {
        String[] names = {"pobi", "yen", "red", "joy"};
        Cars cars = new Cars(names);
        cars.getCars().get(1).moveForward(5);
        cars.getCars().get(2).moveForward(5);

        List<String> winner = cars.getWinners();

        assertThat(winner).containsExactly("yen", "red");
    }

}
