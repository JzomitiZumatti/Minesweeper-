import java.util.Scanner;

public class Minesweeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many mines do you want on the field? > ");
        Field.numberOfMines = scanner.nextInt();
        Field newField = new Field(Field.numberOfMines);
        newField.displayField();
    }
}