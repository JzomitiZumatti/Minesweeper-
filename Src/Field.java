import java.util.Random;
public class Field {
    private final int SIZE = 9;
    static int numberOfMines;
    //private String[][] arr = new String[SIZE][SIZE];
    private char[][] arr = new char[SIZE][SIZE];

    public Field(int numberOfMines) {
        this.numberOfMines = numberOfMines;
        initializeField();
        placeMines();
        calculateNumbers();
    }

    public void initializeField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //arr[i][j].equals(".");
                arr[i][j] = '.';
            }
        }
    }

    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numberOfMines) {
            int row = random.nextInt(SIZE);
            int col = random.nextInt(SIZE);
//            if (!arr[row][col].equals("X")) {
//                arr[row][col] = "X";
//                minesPlaced++;
//            }
            if (arr[row][col] != 'X') {
                arr[row][col] = 'X';
                minesPlaced++;
            }
        }
    }

    public void calculateNumbers() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
//                if (!arr[i][j].equals("X")) {
//                    int count = countAdjacentMines(i, j);
//                    if (count > 0) {
//                        arr[i][j] = String.valueOf(count);
//                    }
//                }
                if (arr[i][j] != 'X') {
                    int count = countAdjacentMines(i, j);
                    if (count > 0) {
                        arr[i][j] = String.valueOf(count).charAt(0);
                    }
                }
            }
        }
    }

    public int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
//                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && arr[newRow][newCol].equals("X")) {
//                    count++;
//                }
                if (newRow >= 0 && newRow < SIZE && newCol >= 0 && newCol < SIZE && arr[newRow][newCol] == 'X') {
                    count++;
                }
            }
        }
        return count;
    }

    public void displayField() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}