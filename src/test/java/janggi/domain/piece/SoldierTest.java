package janggi.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SoldierTest {

    private static Stream<Arguments> moveableArguments() {
        return Stream.of(
                Arguments.of(Position.of(7, 3), Side.HAN,

                        List.of(List.of(Position.of(7, 2)), List.of(Position.of(7, 4)), List.of(Position.of(8, 3)))),
                Arguments.of(Position.of(7, 1), Side.HAN,
                        List.of(List.of(Position.of(8, 1)), List.of(Position.of(7, 2)))),
                Arguments.of(Position.of(7, 1), Side.CHO,
                        List.of(List.of(Position.of(6, 1)), List.of(Position.of(7, 2)))),
                Arguments.of(Position.of(1, 1), Side.CHO, List.of(List.of(Position.of(1, 2))))
        );
    }

    @DisplayName("좌표를 입력하면 이동 가능한 좌표들을 반환한다.")
    @ParameterizedTest
    @MethodSource("moveableArguments")
    void test1(Position startingPosition, Side side, List<List<Position>> routes) {
        // given
        List<Route> expected = routes.stream()
                .map(Route::new)
                .toList();
        Soldier soldier = new Soldier();

        // when
        List<Route> actual = soldier.generateMovePosition(side, startingPosition);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

}
