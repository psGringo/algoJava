package org.example;


/**
 * https://leetcode.com/problems/path-crossing/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isPathCrossing(String path) {
        // Use a set to track visited points
        HashSet<String> visited = new HashSet<>();
        int x = 0, y = 0;

        // Add the starting point to the set
        visited.add(x + "," + y);

        // Traverse the path
        for (char direction : path.toCharArray()) {
            if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            }

            // Check if the new position is already visited
            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true; // Path crosses itself
            }

            // Mark the current position as visited
            visited.add(currentPos);
        }

        return false; // Path does not cross
    }
}