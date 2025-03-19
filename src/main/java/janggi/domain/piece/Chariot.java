package janggi.domain.piece;

import janggi.domain.Board;
import janggi.domain.Position;
import janggi.domain.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Chariot implements PieceBehavior {

    private static final List<Vector> VECTORS = List.of(
            new Vector(1, 0),
            new Vector(0, -1),
            new Vector(0, 1),
            new Vector(-1, 0));

    @Override
    public String toName() {
        return "차";
    }

    public List<Route> generateMovePosition(Side side, Position position) {
        List<Route> routes = new ArrayList<>();
        for (Vector vector : VECTORS) {
            List<Position> route = new ArrayList<>();
            position.calculate(vector)
                    .ifPresent(movePosition ->
                            dfs(route, movePosition, vector, side));

            routes.add(new Route(route));
        }

        return routes;
    }

    public void dfs(List<Position> route, Position currentPosition, Vector vector, Side side) {

        route.add(currentPosition);

        Optional<Position> calculate = currentPosition.calculate(vector);
        if (calculate.isEmpty()) {
            return;
        }

        dfs(route, calculate.get(), vector, side);
    }

    private void addPositionIfNotSameSide(Set<Position> result, Board board, Position currentPosition, Side side) {
        if (board.isSameSide(side, currentPosition)) {
            return;
        }
        result.add(currentPosition);
    }
}
