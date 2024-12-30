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
            case KING -> ChessSteps::nextKingSteps;
            case QUEEN -> ChessSteps::nextQueenSteps;
            case ROOK -> ChessSteps::nextRookSteps;
            case BISHOP -> ChessSteps::nextBishopSteps;
            case KNIGHT -> ChessSteps::nextKnightSteps;
            case PAWN -> ChessSteps::nextPawnSteps;
        };

        addNextPositions(startNode, fn);
        addNextDigit("", startNode);
        return phones.stream().sorted().toList();
    }

    void addNextPositions(Node node, Function<Position, List<Position>> nextStepsFn) {
        if (node.depth > 6) {
            node.setChildren(null);
            return;
        }
        List<Position> nextPositions = nextStepsFn.apply(node.getPosition());
        for (Position nextPosition : nextPositions) {
            Node nextNode = new Node(nextPosition, node.depth + 1);
            node.children.add(nextNode);
            addNextPositions(nextNode, nextStepsFn);
        }
    }

    private void addNextDigit(String prefix, Node node) {
        String currentPhone = prefix + getDigit(node);
        if (node.getChildren() == null) {
            phones.add(currentPhone);
        } else {
            for (Node n : node.getChildren()) {
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
