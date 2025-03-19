package janggi.domain.piece;

import janggi.domain.Board;
import janggi.domain.Position;
import janggi.domain.Route;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Elephant implements PieceBehavior {

    @Override
    public String toName() {
        return "상";
    }

    @Override
    public List<Route> generateMovePosition(Side side, Position position) {
        return List.of();
    }

}
