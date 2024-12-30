package com.epam.phonechess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.epam.phonechess.ChessPiece.KNIGHT;
import static com.epam.phonechess.Node.getDigit;
import static com.epam.phonechess.Position.numberToPosition;

public class Solution {

    List<String> phones = new ArrayList<>();

    List<String> getPhones(int startNum, ChessPiece piece) {
        Position startPosition = numberToPosition(startNum);
        Node startNode = new Node(startPosition, 0);

        Function<Position, List<Position>> fn = switch (piece) {
            case KING -> PieceMoves::nextKingSteps;
            case QUEEN -> PieceMoves::nextQueenSteps;
            case ROOK -> PieceMoves::nextRookSteps;
            case BISHOP -> PieceMoves::nextBishopSteps;
            case KNIGHT -> PieceMoves::nextKnightMoves;
            case PAWN -> PieceMoves::nextPawnSteps;
        };

        addNextPositions(startNode, fn);
        addNextDigit("", startNode);
        return phones.stream().sorted().toList();
    }

    void addNextPositions(Node node, Function<Position, List<Position>> nextStepsFn) {
        if (node.depth > 6) {
            node.setNextSteps(null);
            return;
        }
        List<Position> nextPositions = nextStepsFn.apply(node.getPosition());
        for (Position nextPosition : nextPositions) {
            Node nextNode = new Node(nextPosition, node.depth + 1);
            node.nextSteps.add(nextNode);
            addNextPositions(nextNode, nextStepsFn);
        }
    }

    private void addNextDigit(String prefix, Node node) {
        String currentPhone = prefix + getDigit(node);
        if (node.getNextSteps() == null) {
            phones.add(currentPhone);
        } else {
            for (Node n : node.getNextSteps()) {
                addNextDigit(currentPhone, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> phones = solution.getPhones(2, KNIGHT);
        System.out.println(phones);

//        List<String> phones = solution.getPhones(2, PAWN);
//        System.out.println(phones);
    }
}
