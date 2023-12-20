package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("유효한 이름의 자동차 생성")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @ParameterizedTest
    void createValidNameCar(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("유효하지 않은 이름의 자동차 생성 시 에러 반환")
    @ValueSource(strings = {"", "object"})
    @ParameterizedTest
    void createInvalidNmaeCar(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("전진하는 경우")
    @Test
    void moveForward() {
        Car car = new Car("yen");
        car.moveForward(4);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("전진 안 하는 경우")
    @Test
    void notMoveForward() {
        Car car = new Car("yen");
        car.moveForward(3);
        int result = car.getNumberOfMove();

        assertThat(result).isEqualTo(0);
    }
}
