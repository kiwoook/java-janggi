package janggi.domain.piece;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.List;

public class Horse implements PieceBehavior {

    @Override
    public String toName() {
        return "마";
    }

    @Override
    public List<Route> generateMovePosition(Side side, Position position) {
        return List.of();
    }

}
