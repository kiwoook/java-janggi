package janggi.domain.piece;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.List;

public class Guard implements PieceBehavior {

    @Override
    public String toName() {
        return "사";
    }

    @Override
    public List<Route> generateMovePosition(Side side, Position position) {
        return List.of();
    }

}
