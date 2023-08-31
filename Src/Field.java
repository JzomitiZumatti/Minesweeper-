import java.util.Random;

public class Field {
    Random random = new Random();
    private final int SIZE = 9;
    private int numberOfMines;

    private final char[][] arr = new char[SIZE][SIZE];

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public char[][] createBattleField() {
        int counter = 0;
        int numbOfMines = getNumberOfMines();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = '.';
            }
        }
        for (int i = 0; i < numbOfMines; i++) {
            int tempA = random.nextInt(9);
            int tempB = random.nextInt(9);
            if (arr[tempA][tempB] != 'X' && counter < getNumberOfMines()) {
                arr[tempA][tempB] = 'X';
                counter++;
            } else {
                numbOfMines += 1;
            }
        }
        return arr;
    }

    public void showBattleField() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
