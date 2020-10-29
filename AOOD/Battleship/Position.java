public class Position{
    private int column;
    private char row;
    final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    public Position(int col, char row){
        column = col;
        this.row = row;
    }

    public Position(int col, int row){
        column = col;
        this.row = alphabet[row];
    }

    public char row(){
        return row;
    }

    public int column(){
        return column;
    } 

    public int rowIndex(){
        for(int i = 0; i < 10; i++){
            if (alphabet[i] == row){
                return i;
            }
        }
        return -1;
    }

    public int columnIndex(){
        return column;
    }

    public String toString(){
        return (String) (rowIndex() + "-" + column);
    }
}