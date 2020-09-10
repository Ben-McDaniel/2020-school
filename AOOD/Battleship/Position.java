public class Position{
    private int column;
    private char row;

    public Position(int col, char row){
        column = col;
        this.row = row;
    }

    public char row(){
        return row;
    }

    public int column(){
        return column;
    } 

    public String toString(){
        return (String) (row + "-" + column);
    }
}