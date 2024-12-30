package com.epam.phonechess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.phonechess.Field.isPositionValid;

public class PieceMoves {
    private PieceMoves() {}

    public static List<Position> nextKnightMoves(Position start) {
        int x = start.getX();
        int y = start.getY();
        Position p1 = new Position(x + 2, y + 1);
        Position p2 = new Position(x + 2, y - 1);
        Position p3 = new Position(x - 2, y + 1);
        Position p4 = new Position(x - 2, y - 1);
        Position p5 = new Position(x + 1, y + 2);
        Position p6 = new Position(x + 1, y - 2);
        Position p7 = new Position(x - 1, y + 2);
        Position p8 = new Position(x - 1, y - 2);

        ArrayList<Position> nextPositions = new ArrayList<>(
                Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8));
        nextPositions.removeIf(nextPosition -> !isPositionValid(nextPosition));
        return nextPositions;
    }

    public static List<Position> nextBishopSteps(Position p) {
        return new ArrayList<>();
    }

    public static List<Position> nextRookSteps(Position p) {
        return new ArrayList<>();
    }

    public static List<Position> nextQueenSteps(Position p) {
        return new ArrayList<>();
    }

    public static List<Position> nextKingSteps(Position p) {
        return new ArrayList<>();
    }

    public static List<Position> nextPawnSteps(Position start) {
        int x = start.getX();
        int y = start.getY();
        Position p1 = new Position(x + 1, y);
        Position p2 = new Position(x - 1, y);
        Position p3 = new Position(x, y + 1);
        Position p4 = new Position(x, y - 1);

        ArrayList<Position> nextPositions = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
        nextPositions.removeIf(nextPosition -> !isPositionValid(nextPosition));
        return nextPositions;
    }
}
