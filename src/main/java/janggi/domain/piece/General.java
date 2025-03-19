package janggi.domain.piece;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.List;

public class General implements PieceBehavior {

    @Override
    public String toName() {
        return "궁";
    }

    @Override
    public List<Route> generateMovePosition(Side side, Position position) {
        return List.of();
    }

}
