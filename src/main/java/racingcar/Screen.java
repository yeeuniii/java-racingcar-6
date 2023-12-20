package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;

public class Screen {
    static public final String MARK = "-";

    static public String[] askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    static public String askRacingTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    static public void displayResultMessage() {
        System.out.println("\n실행 결과");
    }

    static public void displayResultOfRound(LinkedHashMap<String, Integer> result) {
        for (String name : result.keySet()) {
            int movement = result.get(name);
            System.out.printf("%s : %s\n", name, MARK.repeat(movement));
        }
        System.out.println();
    }

    static public void displayWinners(List<String> winners) {
        ListIterator<String> names = winners.listIterator();

        System.out.print("최종 우승자 : ");
        while (names.nextIndex() + 1 < winners.size()) {
            System.out.printf("%s, ", names.next());
        }
        System.out.println(names.next());
    }
}
