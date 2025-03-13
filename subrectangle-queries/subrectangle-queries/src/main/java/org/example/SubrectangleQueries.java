package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SubrectangleQueries {

    private final int[][] rectangle;

    public static void main(String[] args) {

    }

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
          for (int row = row1; row <= row2; row++) {
              for (int col = col1; col <= col2; col++) {
                  rectangle[row][col] = newValue;
              }
          }
    }

    public int getValue(int row, int col) {
       return rectangle[row][col];
    }

}