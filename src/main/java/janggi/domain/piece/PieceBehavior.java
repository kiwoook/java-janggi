package janggi.domain.piece;

import janggi.domain.Position;
import janggi.domain.Route;
import java.util.List;

public interface PieceBehavior {

    String toName();

    /**
     * 현재 위치에서 움직일 수 있는 Position을 전달한다.
     **/

    List<Route> generateMovePosition(Side side, Position position);
}
