package org.example;


import java.util.List;

/**
 * https://leetcode.com/problems/snake-in-matrix/description/
 */
public class Main {
    public static void main(String[] args) {
        finalPositionOfSnake(3, List.of( "DOWN","RIGHT", "UP"));
    }

    public static int finalPositionOfSnake(int n, List<String> commands) {
        Coordinate coordinate = new Coordinate(0, 0);
        for (int i = 0; i < commands.size(); i++) {
            coordinate = nextPositionOfSnake(coordinate, commands.get(i));
        }

        return coordinate.y() * n + coordinate.x();
    }

    private static Coordinate nextPositionOfSnake(Coordinate coordinate, String command) {
        if (command.equals("UP")) {
            return new Coordinate(coordinate.x(), coordinate.y() - 1);
        } else if (command.equals("DOWN")) {
            return new Coordinate(coordinate.x(), coordinate.y() + 1);
        } else if (command.equals("LEFT")) {
            return new Coordinate(coordinate.x() - 1, coordinate.y());
        } else if (command.equals("RIGHT")) {
            return new Coordinate(coordinate.x() + 1, coordinate.y());
        }
        throw new IllegalArgumentException();
    }

}

record Coordinate(int x, int y) {
}