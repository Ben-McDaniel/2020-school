public class BattleshipGrid {
    char[][] grid = new char[9][9];   

    public void shotAt(Position pos,boolean hit,char initial){
        //set position coord on grid to inital
        if(hit){
            grid[pos.rowIndex()][pos.columnIndex()] = initial;
        } else{
            grid[pos.rowIndex()][pos.columnIndex()] = 'M';
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
        if(grid[pos.rowIndex()][pos.columnIndex()] == 'M'){
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
}
