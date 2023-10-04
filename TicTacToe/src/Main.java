// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        InitializeGame game = new InitializeGame();
        game.initializeGame();
        System.out.println("Game Winner is :" + game.startGame() );
    }
}