package janggi.domain;

import janggi.domain.piece.Side;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Route {

    private final List<Position> route;

    public Route(List<Position> positions) {
        this.route = Collections.unmodifiableList(positions);
    }

    public boolean isAvailablePositions(Board board, Side side) {
        for (int i = 0; i < route.size() - 1; i++) {
            if (board.hasPosition(route.get(i))) {
                return false;
            }
        }
        Position finalPosition = getFinalPosition();

        if (board.hasPosition(finalPosition)) {
            return !board.isSameSide(side, finalPosition);
        }

        return true;
    }

    public Position getFinalPosition() {
        if (route.isEmpty()) {
            throw new IllegalArgumentException("경로가 존재하지 않습니다.");
        }
        return route.getLast();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(route);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Route route1 = (Route) o;
        return Objects.equals(route, route1.route);
    }

    @Override
    public String toString() {
        return "Route{" +
                "route=" + route +
                '}';
    }
}
