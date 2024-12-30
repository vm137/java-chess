package com.epam.phonechess;

public class Field {
    public static int MAX_X = 2; // 0,1,2
    public static int MAX_Y = 3; // 0,1,2,3

    // matrix[4][3]
    protected static final int[][] MATRIX =
            new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};

    public static boolean isPositionValid(Position position) {
        int x = position.getX();
        int y = position.getY();
        if (x < 0 || x > MAX_X || y < 0 || y > MAX_Y || MATRIX[y][x] == -1) {
            return false;
        }
        return true;
    }
}
