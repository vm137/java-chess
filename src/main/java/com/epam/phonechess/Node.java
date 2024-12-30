package com.epam.phonechess;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.epam.phonechess.Position.positionToNumber;

@Data
public class Node {
    Position position;
    List<Node> nextSteps = new ArrayList<>();
    int depth;

    public Node(Position position, int depth) {
        this.position = position;
        this.depth = depth;
    }

    public static String getDigit(Node node) {
        return String.valueOf(positionToNumber(node.getPosition()));
    }
}
