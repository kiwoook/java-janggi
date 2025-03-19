package janggi.domain.piece;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Soldier implements PieceBehavior {

    private static final List<List<Vector>> VECTORS_LIST = List.of(List.of(new Vector(1, 0)),
            List.of(new Vector(0, -1)),
            List.of(new Vector(0, 1)));

    @Override
    public String toName() {
        return "병";
    }

//    public Set<Position> generateMovePosition(Board board, Side side, Position position) {
//        Set<Position> result = new HashSet<>();
//
//        for (Vector vector : VECTORS) {
//            position.calculate(vector.side(side))
//                    .ifPresent(movePosition -> addPosition(board, side, movePosition, result)
//                    );
//        }
//
//        return result;
//    }

    @Override
    public List<Route> generateMovePosition(Side side, Position position) {
        List<Route> routes = new ArrayList<>();
        for (List<Vector> vectors : VECTORS_LIST) {
            // new Route 생성을 위한 Positions
            List<Position> positions = new ArrayList<>();
            for (Vector vector : vectors) {
                Vector newVector = vector.side(side);
                Optional<Position> newPosition = position.calculate(newVector);
                newPosition.ifPresent(positions::add);
            }

            if (positions.isEmpty()) {
                continue;
            }
            routes.add(new Route(positions));
        }
        return routes;
    }

//    private void addPosition(Board board, Side side, Position movePosition, Set<Position> result) {
//        if (!board.hasPosition(movePosition) || !board.isSameSide(side, movePosition)) {
//            result.add(movePosition);
//        }
//    }
}
