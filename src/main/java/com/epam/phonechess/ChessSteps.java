package com.epam.phonechess;

import java.util.ArrayList;
import java.util.List;

import static com.epam.phonechess.Field.isPositionValid;

public class ChessSteps {
    private ChessSteps() {}

    public static List<Position> nextKnightSteps(Position start) {
        Position p1 = new Position(start.getX() + 2, start.getY() + 1);
        Position p2 = new Position(start.getX() + 2, start.getY() - 1);
        Position p3 = new Position(start.getX() - 2, start.getY() + 1);
        Position p4 = new Position(start.getX() - 2, start.getY() - 1);
        Position p5 = new Position(start.getX() + 1, start.getY() + 2);
        Position p6 = new Position(start.getX() - 1, start.getY() - 2);
        Position p7 = new Position(start.getX() + 1, start.getY() + 2);
        Position p8 = new Position(start.getX() - 1, start.getY() - 2);

        List<Position> nextPositions = new ArrayList<>();
        if (isPositionValid(p1)) {nextPositions.add(p1);}
        if (isPositionValid(p2)) {nextPositions.add(p2);}
        if (isPositionValid(p3)) {nextPositions.add(p3);}
        if (isPositionValid(p4)) {nextPositions.add(p4);}
        if (isPositionValid(p5)) {nextPositions.add(p5);}
        if (isPositionValid(p6)) {nextPositions.add(p6);}
        if (isPositionValid(p7)) {nextPositions.add(p7);}
        if (isPositionValid(p8)) {nextPositions.add(p8);}

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
        ArrayList<Position> nextPositions = new ArrayList<>();
        Position p1 = new Position(start.getX() + 1, start.getY());
        if (isPositionValid(p1)) {nextPositions.add(p1);}
        Position p2 = new Position(start.getX() - 1, start.getY());
        if (isPositionValid(p2)) {nextPositions.add(p2);}
        Position p3 = new Position(start.getX(), start.getY() + 1);
        if (isPositionValid(p3)) {nextPositions.add(p3);}
        Position p4 = new Position(start.getX(), start.getY() - 1);
        if (isPositionValid(p4)) {nextPositions.add(p4);}
        return nextPositions;
    }
}
