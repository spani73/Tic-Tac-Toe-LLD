import java.util.ArrayList;
import java.util.List;

class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}
public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row , int column , PlayingPiece piece){
        if(board[row][column] != null){
            return false;
        }
        board[row][column] = piece;
        return true;
    }

    public List<Pair<Integer , Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<Pair<Integer,Integer>>();
        for(int i=0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(board[i][j] == null){
                    Pair<Integer , Integer> rowColumn = new Pair<>(i,j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }
    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].type.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
