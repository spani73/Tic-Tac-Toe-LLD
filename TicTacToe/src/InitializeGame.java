import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class InitializeGame {
    Board board;
    Deque<Player> players;


    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1" , crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2" , noughtsPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){
            Player playerTurn = players.removeFirst();

            board.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);


            boolean pieceAdded = board.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if(!pieceAdded){
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow , inputColumn ,playerTurn.playingPiece.type );
            if(winner){
                return playerTurn.name;
            }

        }

        return  "tie";
    }
    private boolean isThereWinner(int row , int col , PieceType type){
         boolean rowMatch = true;
         boolean columnMatch= true;
         boolean diagonalMatch = true;
         boolean antiDiagonalMatch = true;

         for(int i = 0 ; i < board.size ; i++){
             if(board.board[row][i] == null || board.board[row][i].type != type){
                 rowMatch = false;
             }
         }

        for(int i = 0 ; i < board.size ; i++){
            if(board.board[i][col] == null || board.board[i][col].type != type){
                columnMatch = false;
            }
        }


        for(int i = 0 ; i < board.size ; i++){
            if(board.board[i][i] == null || board.board[i][i].type != type){
                diagonalMatch = false;
            }
        }

        for(int i=0, j=board.size-1; i<board.size;i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].type != type) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
