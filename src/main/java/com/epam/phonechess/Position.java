package com.epam.phonechess;

import lombok.Data;

import static com.epam.phonechess.Field.MATRIX;
import static com.epam.phonechess.Field.MAX_X;
import static com.epam.phonechess.Field.MAX_Y;

@Data
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Position numberToPosition(int number) {
        for (int y = 0; y <= MAX_Y; y++) {
            for (int x = 0; x <= MAX_X; x++) {
                if (number == MATRIX[y][x]) {
                    return new Position(x, y);
                }
            }
        }
        return null;
    }

    static int positionToNumber(Position position) {
        return MATRIX[position.y][position.x];
    }
}
