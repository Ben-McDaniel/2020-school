import java.util.Arrays;

public class BattleshipGrid {
    char[][] grid = new char[9][9];   
    final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    
    public BattleshipGrid(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                grid[i][j] = ' ';
            }
        }
    }

    public void shotAt(Position pos,boolean hit,char initial){
        //set position coord on grid to inital
        if(hit){
            grid[pos.rowIndex()][pos.columnIndex()] = initial;
        } else{
            grid[pos.rowIndex()][pos.columnIndex()] = 'X';
        }
        
    }

    public boolean hit(Position pos){
        //This method returns true if the position has been shot at and is a hit, false otherwise
        if(grid[pos.rowIndex()][pos.columnIndex()] == 'A' || grid[pos.rowIndex()][pos.columnIndex()] == 'B' || grid[pos.rowIndex()][pos.columnIndex()] == 'C' || grid[pos.rowIndex()][pos.columnIndex()] == 'S'){
            return true;
        } 
        return false;
    }

    public boolean miss(Position pos){
        //This method returns true if the position has been shot at and is a miss, false otherwise
        if(grid[pos.rowIndex()][pos.columnIndex()] == 'X'){
            return true;
        }
        return false;
    }

    public boolean empty(Position pos){
        //This method returns true if the position has not been shot at
        if(miss(pos) == false && hit(pos) == false){
            return true;
        }
        return false;
    }

    public char boatInitial(Position pos){
        //This method should only be called if the position has been shot at and is a hit. It returns the initial of the boat that has been hit
        return grid[pos.rowIndex()][pos.columnIndex()];
    }

    public void viewGrid(){
        System.out.println("  1 2  3  4  5  6  7  8  9");
        for(int i = 0; i < grid.length; i++){
            System.out.println(alphabet[i] + Arrays.toString(grid[i]));
        }
    }
}
